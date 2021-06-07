package wdj_210506;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SimpleDictionary extends JPanel implements ActionListener{
	private JTextField inputField = new JTextField(30);
	private JButton searchButton = new JButton("검색");
	private JButton addBtn = new JButton("추가");
	
	private Map<String, String> words  =new HashMap<>();
	
	
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
	
		buildDictionaryFromFile();
	}
	
	private void buildDictionaryFromFile() {
		// Properties는
				// key, value의 타입이 각각 String, String으로 고정된 일종의 맵이다. 
				Properties props = new Properties();
//				props.put("사과", "apple");
				
				// 파일에서 읽어서 props 객체의 <key, value>쌍을 구성할 수 있다.
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
			
			String value = JOptionPane.showInputDialog(this, key, "에 대응 되는 영어 단어를 입력하세요.");
			//반환값으로 텍스트필드에 입력받은 값 반환. 
			if(value.trim().length() == 0) return;
			words.put(key, value);
			JOptionPane.showMessageDialog(this, "[" + value + "]" + "영어 단어가 추가되었습니다.", key, JOptionPane.INFORMATION_MESSAGE);
		}
		inputField.setText("");
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