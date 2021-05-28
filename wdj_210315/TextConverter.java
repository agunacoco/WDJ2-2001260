package wdj_210315;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class TextConverter extends JFrame implements ActionListener{
	private JButton convert;
	private JButton cancel;
	private JTextArea textIn;
	private JTextArea textOut;

	public TextConverter() {
		super("텍스트 변환기");
		
		textIn = new JTextArea(10, 14);
		textOut = new JTextArea(10, 14);
		
		textIn.setLineWrap(true);
		textOut.setLineWrap(true);
		textOut.setEditable(false);
		
		JPanel textAreaPanel = new JPanel(new GridLayout(1,2,20,20));
		textAreaPanel.add(textIn);
		textAreaPanel.add(textOut);
		
		convert = new JButton("변환");
		cancel = new JButton("취소");
		convert.addActionListener(this);
		cancel.addActionListener(this);
		
		JPanel btnPanel = new JPanel();
		btnPanel.add(convert);
		btnPanel.add(cancel);
		
		JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
		mainPanel.add(textAreaPanel, BorderLayout.CENTER);
		mainPanel.add(btnPanel, BorderLayout.SOUTH);
		
		this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		this.add(mainPanel);
		this.pack();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == convert) {
			
			String str = textIn.getText();
			String result = toEnglish(str);
			textOut.setText(result);
		}else {
			textOut.setText(" ");
		}
		
	}
	private String toEnglish(String korean) {
		String result = korean;
		result = result.replace("텍스트", "text");
		result = result.replace("영어", "english");
		return result;
	}
	
	public static void main(String[] args) {
		JFrame text = new TextConverter();
		text.setVisible(true);
	}
}