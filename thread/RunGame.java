package thread;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import main.Main_Frame;
import panel.Game;

public class RunGame extends JFrame implements Runnable, KeyListener{
	Thread th; 
	Main_Frame win;
	Game game;
	JPanel p;
	int x = 0, y = 0; 
	 
	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;

	public RunGame(Main_Frame win, JPanel p){
			this.win = win;
			this.p = p;
			win.addKeyListener(this);
			win.setFocusable(true);
			th = new Thread(this); 
			th.start(); 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread create!");
		try { 
			while (true) { 
				KeyProcess();
				p.setLocation(x,y);
				repaint();
				Thread.sleep(20); 
			}
		} catch (Exception e) {
		}
	}
	
	public void kill() {
		System.out.println("thread kill!");
		th.interrupt();
	}
	
	private void KeyProcess() {
		// TODO Auto-generated method stub
		if(KeyUp == true)  {
			System.out.println("up");
			y -= 5;
		}
		if(KeyDown == true) {
			System.out.println("down");
			y += 5;
		}
		if(KeyLeft == true)  {
			System.out.println("left");
			x -= 5;
		}
		if(KeyRight == true) {
			System.out.println("right");
			x += 5;
		}
		if(KeySpace == true) {
			System.out.println("attack");
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp = true;
			break;
		case KeyEvent.VK_DOWN:
			KeyDown = true;
			break;
		case KeyEvent.VK_LEFT:
			KeyLeft = true;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = true;
			break;
		case KeyEvent.VK_SPACE:
			KeySpace = true;
			break;
		}

	}
	
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:
			KeyUp = false;
			break;
		case KeyEvent.VK_DOWN:
			KeyDown = false;
			break;
		case KeyEvent.VK_LEFT:
			KeyLeft = false;
			break;
		case KeyEvent.VK_RIGHT:
			KeyRight = false;
			break;
		case KeyEvent.VK_SPACE:
			KeySpace = false;
			break;
		}
	}
	
}	

