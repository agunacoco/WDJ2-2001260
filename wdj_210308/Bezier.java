package wdj_210308;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Bezier extends JPanel implements ActionListener{
	private JTextField f1, f2, f3;
	private double a = 1.0, b = -5.0, c = 6.0;
	
	public Bezier() {
		f1 = new JTextField("1.0", 10);
		f2 = new JTextField("-5.0", 10);
		f3 = new JTextField("6.0", 10);
		
		this.add(f1);
		this.add(f2);
		this.add(f3);
		
		JButton button = new JButton("DRAW");
		this.add(button);
		button.addActionListener(this);
	
	}
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2.drawLine(100, 200, 500, 200);
		g2.drawLine(300, 0, 300, 400);
		
		g2.setPaint(Color.red);
		System.out.println("!a:"+ a+ " b"+ b+ " c"+ c);
		for(int i = -20;i <20; i++) {
			int x =i;
			int y = (int) (a * x * x -b * x + c);
			g2.fillOval(200+x-2,200-(y-2), 4, 4);
		}
	}
	public void actionPerformed(ActionEvent arg0) {
		
		a = Double.parseDouble(f1.getText());
		b = Double.parseDouble(f2.getText());
		c = Double.parseDouble(f3.getText());
		System.out.println("a:"+ a+ " b"+ b+ " c"+ c);
		repaint();
	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.add(new Bezier());
		f.setSize(600, 400);
		f.setVisible(true);
	}
}
