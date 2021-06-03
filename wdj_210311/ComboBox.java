package wdj_210311;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

public class ComboBox extends JFrame implements ActionListener{
	private JLabel label;
	private JComboBox animalList;
	
	public ComboBox() {
		this.setTitle("콤보 박스");
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setSize(500, 400);
		
		String[] animals = {"dog", "lion", "tiger"	};
		animalList = new JComboBox(animals);
		animalList.setSelectedIndex(0);
		animalList.addActionListener(this);
		
		label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		changePicture(animals[animalList.getSelectedIndex()]);
		
		this.add(animalList, BorderLayout.NORTH);
		this.add(label, BorderLayout.CENTER);
		this.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e) {
		String name = (String) animalList.getSelectedItem();
		changePicture(name);
	
	}
	protected void changePicture(String name) {
		ImageIcon icon = new ImageIcon(name + ".gif");
		label.setIcon(icon);
		
		label.setText(null);
		
	}
	public static void main(String[] args) {
		new ComboBox();
	}
}
