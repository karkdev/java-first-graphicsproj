//required import statements
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

@SuppressWarnings("serial")
//TODO: Change the name of the class from AnimationShell to the name of your class
public class MainGame extends JPanel {

	//TODO: set the initial width and height of your image
	private static final int WIDTH = 700;
	private static final int HEIGHT = 700;

	//required global variables
	private BufferedImage image;
	private Graphics g;
	private Timer timer;
	private Mole m;
	private Mole m2;
	private Mole m3;
	private Hammer h;
	private int[] xPos = {10,230,450};
	private int[] yPos = {70,300,550};
	private int timeElapsed = 0;
	private int score;
	private int gameTime = 30000;
	private Mole badM;
	private class MouseMotion implements MouseMotionListener {
		public void mouseDragged(MouseEvent e) {
			e.getX();	
			e.getY();
		}

		public void mouseMoved(MouseEvent e) {
			int x = e.getX();	
			int y = e.getY();
			h.setX(x);
			h.setY(y);
		
			
				
			
		}
}

	
	private class Mouse implements MouseListener {
		public void mouseClicked(MouseEvent e) { }
		
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			int xC = e.getX();
			int yC = e.getY();
			
			
			// mole 1
			if((xC >= m.getX() && xC <= m.getX() + m.getSize()) && (yC >= m.getY() && yC <= m.getY()+m.getSize())) {
				
				m.setX(xPos[(int) (Math.random() * xPos.length)]);
				m.setY(yPos[(int) (Math.random() * xPos.length)]);
				
				score++;
			}
			
			// mole 2
			if((xC >= m2.getX() && xC <= m2.getX() + m2.getSize()) && (yC >= m2.getY() && yC <= m2.getY()+m2.getSize())) {
				
				m2.setX(xPos[(int) (Math.random() * xPos.length)]);
				m2.setY(yPos[(int) (Math.random() * xPos.length)]);
				
				score++;
			}
			
			// mole 3
			if((xC >= m3.getX() && xC <= m3.getX() + m3.getSize()) && (yC >= m3.getY() && yC <= m3.getY()+m3.getSize())) {
				
				m3.setX(xPos[(int) (Math.random() * xPos.length)]);
				m3.setY(yPos[(int) (Math.random() * xPos.length)]);
				
				score++;
			}
			
			// bad mole
			if((xC >= badM.getX() && xC <= badM.getX() + badM.getSize()) && (yC >= badM.getY() && yC <= badM.getY()+ badM.getSize())) {
				
				badM.setX(xPos[(int) (Math.random() * xPos.length)]);
				badM.setY(yPos[(int) (Math.random() * xPos.length)]);
				
				score-= 5;
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
			
		}
		
	}

	//Constructor required by BufferedImage
	public MainGame() {
		//set up Buffered Image and Graphics objects
		image =  new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
		g = image.getGraphics();

		m = new Mole(10,70,100,"Mole.png");
		m2 = new Mole(230,300,100,"Mole.png");
		m3 = new Mole(450,70,100,"Mole.png");
		badM = new Mole(10,550,100,"BadMole.png");
		h = new Hammer(550,70,110,"Hammer.png");
		
		
	
		//set up and start the Timer
		timer = new Timer(10, new TimerListener());
		timer.start();
		
		addMouseMotionListener(new MouseMotion());
		addMouseListener(new Mouse());

	}
	
	//TimerListener class that is called repeatedly by the timer
	private class TimerListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			
			gameTime -=10;
			
			timeElapsed += 10;
			
			
			if (timeElapsed == 1000) {
				//hide current mole
				//unhide another random mole
				int x1 = xPos[(int)(Math.random() * xPos.length)];
				int y1 = yPos[(int)(Math.random() * yPos.length)];
				m.setX(x1);
				m.setY(y1);

				
				int x2 = xPos[(int)(Math.random() * xPos.length)];
				int y2 = yPos[(int)(Math.random() * yPos.length)];

				while (x2 == x1 && y2 == y1) {
				    x2 = xPos[(int)(Math.random() * xPos.length)];
				    y2 = yPos[(int)(Math.random() * yPos.length)];
				}

				m2.setX(x2);
				m2.setY(y2);

			
				int x3 = xPos[(int)(Math.random() * xPos.length)];
				int y3 = yPos[(int)(Math.random() * yPos.length)];

				while ((x3 == x1 && y3 == y1) || (x3 == x2 && y3 == y2)) {
				    x3 = xPos[(int)(Math.random() * xPos.length)];
				    y3 = yPos[(int)(Math.random() * yPos.length)];
				}

				m3.setX(x3);
				m3.setY(y3);
				
				
				int x4 = xPos[(int)(Math.random() * xPos.length)];
				int y4 = yPos[(int)(Math.random() * yPos.length)];

				while ((x4 == x1 && y4 == y1) || (x4 == x2 && y4 == y2) || (x4 == x3 && y4 == y3)) {
				    x4 = xPos[(int)(Math.random() * xPos.length)];
				    y4 = yPos[(int)(Math.random() * yPos.length)];
				}

				badM.setX(x4);
				badM.setY(y4);

				timeElapsed = 0;
				
				
			}
			
			if(gameTime <= 0) {
				timer.stop();
				
			}
			
			g.setColor(Color.green);
			g.fillRect(0,0,WIDTH,HEIGHT);
			g.setColor(Color.black);
			g.fillOval(10, 70, 100, 100);
			g.fillOval(230, 70, 100, 100);
			g.fillOval(450, 70, 100, 100);
			g.fillOval(10, 300, 100, 100);
			g.fillOval(230, 300, 100, 100);
			g.fillOval(450, 300, 100, 100);
			g.fillOval(10, 550, 100, 100);
			g.fillOval(230, 550, 100, 100);
			g.fillOval(450, 550, 100, 100);
			m.draw(g);
			m2.draw(g);
			m3.draw(g);
			badM.draw(g);;
			g.setFont(new Font("Kartika", Font.BOLD,30));
			g.setColor(Color.black);
			g.drawString("Score: " + getScore(), 500,40);
			g.drawString("Time: " + gameTime/1000, 50, 40);
			if(gameTime <= 0) {
				g.drawString("Game Over!",200,40);
			}
			
			h.draw(g);
			repaint(); //leave this alone, it MUST  be the last thing in this method
		}
		
	}

	//do not modify this
	public void paintComponent(Graphics g) {
		g.drawImage(image, 0, 0, getWidth(), getHeight(), null);
	}

	//main method with standard graphics code
	public static void main(String[] args) {
		JFrame frame = new JFrame("Animation Shell");
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation(0, 0);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setContentPane(new MainGame()); //TODO: Change this to the name of your class!
		frame.setVisible(true);
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}


