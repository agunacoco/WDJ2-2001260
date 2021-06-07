package wdj_210510;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener{
	private JTextField inputField = new JTextField(30);
	private JButton searchButton = new JButton("검색");
	private JButton addBtn = new JButton("추가");

	// Map객체를 단어장 구현으로 사용
	// key는 한글단어, value는 대응되는 영어 단어를 저장한다
	private Map<String, String> words  =new HashMap<>();
	private static final String DIC_FILE_NAME = "dict.props";
	
	
	public SimpleDictionary() {
		this.add(inputField);
		this.add(searchButton);
		this.add(addBtn);
		
		searchButton.addActionListener(this);
		addBtn.addActionListener(this);
		
		
		//GUI에서 사이즈 조절할때 setSize와 setPreferredSize를 사용하는데 
		//Flowlayout에서 setSize로 컴포넌트 크기를 결정할 수 없다.
		//setPreferredSize(); 이 메소드는 Dimension객체를 인자로 받으면서 햐당 컴포넌트의 기본 크기를 경절해준다.
		//이 setPreferredSize()는 FlowLayout에서도 컴포넌트의 크기를 조정할 수 있습니다.
		//Dimension(x,y) 는 폭과 너비설정하는 메소드
		//setSize는 컴포넌트의 크기를 결정하는 메소드.
		this.setPreferredSize(new Dimension(600, 50));
		
		//파일에 key=value 형태로 저장된 엔트리들을 읽어서, words로 구성하기
		//DB에서 레코드를 읽고, 그 레코드를 이용해서 dict 맵을 구성.
		
		buildDictionaryFromDB();
		
		buildDictionaryFromFile();
	}
	private void buildDictionaryFromDB() {
		
				// 1. Database 연결: 먼저 JDBC Driver를 로딩 해야 한다
				// 	  DriverManager(java.sql 패키지에 정의된 클래스)
				//	  Connection con = DriverManager.getConnection();
				//    메서드를 호출해 연결을 establish한다
				//    이 때 연결 정보를 getConnection() 메서드에 전달 해 줘야 한다
				//    연결 정보: DB Server의 URL(IP주소와 port 번호포함), DB사용자의 ID와 암호
				// 2. Connection 객체를 통해 SQL문 실행을 서버에 요청하고 그 결과를 받아 처리한다.
				//    두가지 방법이 있다
				//    정적 SQL문: 프로그래밍 시점에 실행할 SQL문이 결정되고 고정된 경우.
				//    첫번째는 con.createStatement() 메소드 호출을 통해서 반환되는 Statement 객체를 이용하는 방법
				//    두번째는 con.perareStatement() 메서드 호출을 통해 반환되는 PreparedStatement 객체를 이용하는 방법이 있다.
				//    동적 SQL문: 프로그래밍 시점에 실행할 SQL문이 결정되지 않고 계속 변경되는 SQL문
				//    이 예제에서는 PreparedStatement 객체를 이용한다.
				//    서버가 실행 될 준비가 되었다는 의미(문법검사, 정당성 검사, excution plan까지 준비 완료된 단계)
				//    String sql = "select * from dict";
				//    con.perpareStatement(sql);
				//    을 실행하면 해당 sql을 받아서 실행할 준비를 마치고 그 객체를 반환해준다.
				//    PreparedStatement pstmt = con.perpareStatement(sql);
				//    pstmt를 가지고 sql문을 실행한다.
				//    실행 준비가 된 PreparedStatement를 실행 시키는 방법은 크게 두가지가 있다
				//    첫번째 방식
				//    실행할 SQL문이 insert, delete update문인 경우
				//    pstmt.excuteUpdate();를 실행한다 (숫자 값 반환 수행된 행의 개수 반환)
				//    두번째 방식
				//    실행할 SQL문이 select문인 경우
				//    ResultSet rs = pstmt.excuteQuery(); 
				// 3. DB Server와의 연결을 해제한다
				//    con.close();	
				
		
	}
	private void buildDictionaryFromFile() {
		// Properties는
				// key, value의 타입이 각각 String, String으로 고정된 일종의 맵이다. 
				// HashMap과 큰 차이가 없지만, Properties 클래스는 파일 입출력을 지원한다.
				Properties props = new Properties();
//				props.put("사과", "apple");
				
				// 파일에서 읽어서 props 객체의 <key, value>쌍을 구성할 수 있다.
				// 파일을 읽으려면 FileReader를 생성.
			    // FileReader fReader = new FileReader(DIC_FILE_NAME);
			    // props.load(fReader);
				
				try(FileReader fReader = new FileReader(DIC_FILE_NAME)) {
					//load는 메서드의 이름 그대로 파일의 내용을 읽어서 키-값의 형태로 분류해서 맵에 보관.
					props.load(fReader);
				} catch(Exception e) {
					System.out.println(e.getMessage());
				}
				
				//keySet()은 저장된 모든 키 set을 반환한다.
				//key값을 통해서 값을 꺼내기 위해서는 
			    Set<Object> set = props.keySet();
			    for(Object obj: set) {
			    	words.put((String)obj, (String)props.get(obj));
			    }
	}
	
	@Override 
	public void actionPerformed(ActionEvent e) {
		//getText()는 텍스트를 리턴.
		String key = inputField.getText();
		//trim()는 양쪽의 공백을 제거해준다.
		if(key.trim().length() == 0) return;
		
		//e.getSource()는 객체릐 위치값을 가져온다.
		if(e.getSource() == searchButton) {
			//입력된 단어를 추출하여
			//그 단어를 key값으로 가지는 대응되는 맵 엔트리가 있는지 검사 words.get(단어);
			//그 단어에 대응되는 값이 있으면 JOptionPane.showMessageDialog() 메서드를 호출해서 대응되는 값을 보여준다.
			//값이 없으면 (null) //JOptionPane.showMessageDialog() 메서드 호출해서 
			//단어를 찾을 수 없습니다 라고 출력.
			//inputField를 빈 문자열로 설정.
			
			System.out.println("[" + key + "]");
			String value = words.get(key);
			
			//JOptionPane.showMessageDialog()는 단순히 알림창을 띄울 수 있는 함수다.
			if(value != null) {
				//대응되는 단어가 있는 경우
				JOptionPane.showMessageDialog(this, value, key, JOptionPane.INFORMATION_MESSAGE);
			}else {
				//대응되는 단어가 없는 경우 
				JOptionPane.showMessageDialog(this, "단어를 찾을 수 없습니다.", key, JOptionPane.ERROR_MESSAGE);
			}
		}else if(e.getSource() == addBtn) {
			//입력된 단어를 추출
			//JOptionPane.showInputDialog() 메서드를 호출해서 추가할 영어단어를 입력받는다.
			//words.put(입력 필드에 입력된 단어, 	inputDialog에 입력된 단어)
			//DB에 <key, value>의 쌍을 하나이ㅡ 레코드로 저장.
			
			String value = JOptionPane.showInputDialog(this, key, "에 대응 되는 영어 단어를 입력하세요.");
			//String value = JOptionPane 반환값으로 텍스트필드에 입력받은 값 반환. 
			
			if(value.trim().length() == 0) return;
			words.put(key, value);
			//addToDB(key, value);
			addWordToFile(key, value);
			JOptionPane.showMessageDialog(this, "[" + value + "]" + "영어 단어가 추가되었습니다.", key, JOptionPane.INFORMATION_MESSAGE);
		}

	}
	private void addToDB(String key, String value) {
	}

	private void addWordToFile(String key, String value) {
		//텍스트 데이터를 파일에 저장할 때 사용. 문자 단위로 저장하므로 텍스트만 저장가능.
		try(FileWriter fWriter = new FileWriter(DIC_FILE_NAME, true)) {
			// FileWriter의 write는 계속 덮어쓰므로 마지막에 추가된 것만 파일에 남는다.
			// FileWriter로 파일에 입력할때는 끝에 줄바꿈을 넣기 위해 "\r\n"을 꼭 붙여줘야 한다.
			fWriter.write(key + "=" + value + "\n");
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new SimpleDictionary());
		
		frame.setTitle("한영사전");
		frame.setResizable(false);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
	}
	
}
