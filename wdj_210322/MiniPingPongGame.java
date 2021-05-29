package wdj_210322;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MiniPingPongGame extends JPanel implements KeyListener{
	private Ball ball;
	protected Racquet racquet1;
	protected Racquet racquet2;
	protected Score score;
	

	public MiniPingPongGame(){
		ball = new Ball(this, Color.red);
		score = new Score(600,400);
		this.setBackground(Color.BLACK);
		racquet1 = new Racquet(this, 0, 150, Color.blue, 1);
		racquet2 = new Racquet(this, 590, 150, Color.yellow, 2);
		this.setFocusable(true);
		this.addKeyListener(this);
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void keyPressed(KeyEvent e){
		racquet1.keyPressed(e);
		racquet2.keyPressed(e);
	}
	
	@Override
	public void keyReleased(KeyEvent e){
		racquet1.keyReleased(e);
		racquet2.keyReleased(e);
	}
	
	void move(){
		ball.move();
		racquet1.move();
		racquet2.move();
	}
	
	@Override
	public void paint(Graphics g){
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		score.draw(g2d);
		ball.draw(g2d);
		racquet1.draw(g2d);
		racquet2.draw(g2d);
	}
	public static void main(String[] args) {
		JFrame frame = new JFrame("PingPong Gmae");
		frame.setSize(600, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(frame);
		frame.setResizable(false);
		
		MiniPingPongGame game = new MiniPingPongGame();
		frame.add(game);
		frame.setVisible(true);
		while(true) {
			game.move();
			game.repaint();
			try {
				Thread.sleep(10);
			}catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	public class Score{
		private int GAME_WIDTH;
		private int GAME_HEIGHT;
		protected int player1 = 0;
		protected int player2 = 0;
		
		public Score(int gameWidth, int gameHeight) {
			GAME_WIDTH = gameWidth;
			GAME_HEIGHT = gameHeight;
		}
		public void getScore(int player1, int player2) {
			this.player1 = player1;
			this.player2 = player2;
		}
		public void draw(Graphics g) {
			
			g.setColor(Color.white);
			g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 60));
			g.drawLine(GAME_WIDTH/2, 0, GAME_WIDTH/2, GAME_HEIGHT);
			
			g.setColor(Color.gray);
			g.drawString(String.valueOf(player1/10)+String.valueOf(player1%10), GAME_WIDTH/2 - 85, 50);
			g.setColor(Color.PINK);
			g.drawString(String.valueOf(player2/10)+String.valueOf(player2%10), GAME_WIDTH/2 + 20, 50);
		}
	}
	
	class Ball {
		private static final int RADIUS = 20;
		private int x = 0, y = 0, xSpeed = 1, ySpeed = 1;
		private MiniPingPongGame game;
		private Color color;
		
		int player1 = 0, player2 = 0;
		
		public Ball(MiniPingPongGame game, Color color) {
			this.game = game;
			this.color = color;
		}
		
		void move() {
			if (x + xSpeed < 0) {
				xSpeed = 2;
				score.getScore(player1, ++player2);
			}
			if (x + xSpeed > game.getWidth() - 2 * RADIUS) {
				xSpeed = -2;
				score.getScore(++player1, player2);
			}
			if (y + ySpeed < 0) {
				ySpeed = 2;
			}
			if (y + ySpeed > game.getHeight() - 2 * RADIUS) {
				ySpeed = -2;
			}
			if (collision())
				xSpeed = -xSpeed;
			x += xSpeed;
			y += ySpeed;
		}
		
		private boolean collision() {
			return game.racquet1.getBounds().intersects(getBounds())
					||  game.racquet2.getBounds().intersects(getBounds());
		}                   
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillOval(x, y, 2*RADIUS, 2*RADIUS);
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, 2*RADIUS, 2*RADIUS);
		}
		
	}

	class Racquet {
		private static final int WIDTH = 10;
		private static final int HEIGHT = 80;
		private int x = 0, y = 0;
		private int ySpeed = 0;
		private MiniPingPongGame game;
		private Color color;
		int id;
		
		public Racquet(MiniPingPongGame game, int x, int y, Color color, int id) {
			this.game = game;
			this.x = x;
			this.y = y;
			this.color = color;
			this.id = id;
		}
		
		public void move() {
			if( y + ySpeed > 0 && y + ySpeed < game.getHeight() - HEIGHT)
				y += ySpeed;
		}
		
		public void keyReleased(KeyEvent e) {
			ySpeed = 0;
		}
		
		public void draw(Graphics2D g) {
			g.setColor(color);
			g.fillRect(x, y, WIDTH, HEIGHT);
		}

		public void keyPressed(KeyEvent e) {
			if(this.id == 1) {
				if(e.getKeyCode() == KeyEvent.VK_W)
					ySpeed = -3;
				if(e.getKeyCode() == KeyEvent.VK_S)
					ySpeed = 3;
			}else if(this.id == 2){
				if(e.getKeyCode() == KeyEvent.VK_UP)
					ySpeed = -3;
				if(e.getKeyCode() == KeyEvent.VK_DOWN)
					ySpeed = 3;
			}
			
		}
		
		public Rectangle getBounds() {
			return new Rectangle(x, y, WIDTH, HEIGHT);
		}
	}
		
		

}

