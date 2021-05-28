package wdj_210315;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class FileChooserDemo extends JFrame implements ActionListener {
	private JButton openBtn, saveBtn;
	JFileChooser fileChooser;
	
	public FileChooserDemo() {
		this.setTitle("파일 선택기 테스트");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(250, 200);
		fileChooser = new JFileChooser();
		JLabel label = new JLabel("파일 선택기 컴포넌트 테스트입니다.");
		openBtn = new JButton("파일 오픈");
		openBtn.addActionListener(this);
		
		saveBtn = new JButton("파일 저장");
		saveBtn.addActionListener(this);
		
		JPanel panel = new JPanel();
		panel.add(label);
		panel.add(openBtn);
		panel.add(saveBtn);
		
		this.add(panel);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == openBtn) {
			int returnVal = fileChooser.showOpenDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println("open file: " + file.getAbsolutePath());
			}else {
				System.out.println("No file selected");
			}
		} else if(e.getSource() == saveBtn) {
			int returnVal = fileChooser.showSaveDialog(this);
			if(returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fileChooser.getSelectedFile();
				System.out.println("save to " + file.getAbsolutePath());
			} else {
				System.out.println("Save Canceled...");
			}
		}
	}
	public static void main(String[] args) {
		new FileChooserDemo();
	}
}
