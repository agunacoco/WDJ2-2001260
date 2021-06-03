package wdj_210308;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Animation {
	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.add(new MyPanel());
		frame.setTitle("Animaion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 300);
		frame.setVisible(true);
	}
}

class MyPanel extends JPanel implements ActionListener {
	
	private Timer timer;
	private BufferedImage image;
	private final int START_X = 0;
	private final int START_Y = 250;
	private int checkDirection = 0;
	private int x, y;
	
	public MyPanel() {
		this.setBackground(Color.BLACK);
		this.setPreferredSize(new Dimension(500, 300));
		this.setDoubleBuffered(true);
		
		File file = new File("space.png");
		System.out.println(file.getAbsolutePath());
		
		
		try {
			image = ImageIO.read(file);
			// BufferedImage 객체타입을 리턴한다
			// IOException이 발생할 가능성이 있다
			
		} catch(IOException e) {
			e.printStackTrace();
			System.exit(1);
			// IOException이 발생하면 
		}
		
		// awt에서 제공하는 Timer 클래스를 이용해서 시간마다 그려준다
		// awt에서 제공하는것과 util에서 제공하는 타이머가 있다
		
		timer = new Timer(20, this);
		// timer를 구현하기 위해서는 actionListener 인터페이스를 구현하고 있어야 한다
		// actionPerfomed 메소드를 직접 불러준다
		timer.start();
		
		this.x = START_X;
		this.y = START_Y;
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(image, x, y, this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		/*
		 	이미지의 x, y 좌표를 적절히 변경한다
		 */
		
//		x++;
//		y--;
		
		// 프레임 안에서만 이미지가 움직이게 하기
		
		if(x + image.getWidth() >= 500)
		{
			checkDirection = 2;
		}
		
		if(x <= 0)
		{
			checkDirection = 0;
		}
		
		if(y + image.getHeight() >= 300)
		{
			checkDirection = 3;
		}
		
		if(y <= 0)
		{
			checkDirection = 1;
		}
		
		if(checkDirection == 0)
		{
			x++;
			y--;
		}
		else if(checkDirection == 1)
		{
			x++;
			y++;
		}
		else if(checkDirection == 2)
		{
			x--;
			y++;
		}
		else if(checkDirection == 3)
		{
			x--;
			y--;
		}
		
		System.out.println(checkDirection);
		repaint();
	}
	
	
}