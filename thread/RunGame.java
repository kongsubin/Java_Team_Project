package thread;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.JLabel;

import basic.Basic;
import main.Main;
import main.Main_Frame;
import panel.Missile;
import panel.Start;

@SuppressWarnings("serial")
public class RunGame extends JFrame implements Runnable, KeyListener{
	private Thread th; 
	private Main_Frame win;
	private Basic p ;
	private JLabel[] status = new JLabel[3]; // score board ( Hp, score, time)
	private int score = 0; // test variable
	private int time = 0; // test variable
	private boolean repeat = true;
	private boolean KeyUp = false;
	private boolean KeyDown = false;
	private boolean KeyLeft = false;
	private boolean KeyRight = false;
	private boolean KeySpace = false;
	

	private ArrayList<Missile> Aplus_List = new ArrayList<>();
	private Missile AInfo; 
	private Image Aplus = new ImageIcon(Start.class.getResource("../image/a_30.png")).getImage();
	
	@SuppressWarnings("unused")
	private Graphics pan;
	
	

	public RunGame(Main_Frame win, Basic p, JLabel[] status){
			this.win = win;
			this.p = p;
			
			for(int i = 0; i < 3; i++) {
				this.status[i] = status[i]; // store in board
			}
			
			win.addKeyListener(this);
			win.setFocusable(true);
			
			pan = win.getGraphics();
			
			th = new Thread(this); 
			th.start(); 
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread create!");
		try { 
			while (repeat) { 
				show_status();
				KeyProcess();
				MissileProcess();
				p.setLocation(p.getX(),p.getY());
				//p.repaint();
				Thread.sleep(20); 
			}
		} catch (Exception e) {
		}
	}
	
	public void kill() {
		System.out.println("thread kill!");
//		th.interrupt();
		repeat = false;
	}
	
	private void KeyProcess() {
		// TODO Auto-generated method stub
		if(KeyUp == true)  {
			System.out.println("up");
			p.setY(p.getY() - 5) ; 
		}
		if(KeyDown == true) {
			System.out.println("down");
			p.setY(p.getY() + 5) ; 
		}
		if(KeyLeft == true)  {
			System.out.println("left");
			p.setX(p.getX() - 5) ; 
		}
		if(KeyRight == true) {
			System.out.println("right");
			p.setX(p.getX() + 5) ;
		}
		if(KeySpace == true) {
			System.out.println("attack");
		}
		
		if(p.getX()>Main.SCREEN_WIDTH - 80) p.setX(Main.SCREEN_WIDTH - 80) ; 
		if(p.getX() < -20) p.setX(-20) ; 
		if(p.getY()>Main.SCREEN_HEIGHT - 120) p.setY(Main.SCREEN_HEIGHT - 120) ; 
		if(p.getY() < 0) p.setY(0) ; 
		
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
	
	
	public void MissileProcess() {
		if (KeySpace) {
			AInfo = new Missile(p.getX()+ 10, p.getY()+ 50 );
			Aplus_List.add(AInfo);
		}

		for (int i = 0; i < Aplus_List.size(); ++i) {
			AInfo = (Missile) Aplus_List.get(i);
			AInfo.move();
			if (AInfo.x > 550) {
				Aplus_List.remove(i);
			}
		}
	}

	public void Draw_Missile(Graphics pan){
		for (int i = 0 ; i < Aplus_List.size()  ; ++i){
			AInfo = (Missile) (Aplus_List.get(i)); 
			System.out.println(AInfo.x + "  "+AInfo.y);
			pan.drawImage(Aplus, AInfo.x, AInfo.y, win); 
		}
	}
	
	public void show_status() {
		
		status[0].setText("HP : "+p.getHp());
		if(p.getHp() <= 100) {
			status[0].setForeground(Color.RED);
		}
		status[1].setText("Score : " + score);
		status[2].setText("Time : " + time);
		/*for(int i = 0; i < 3; i++) {
			board[i].setLocation(450,0+20*i);
		}*/
		score += 1;
		time += 1;
		System.out.println(score+" "+time);
		
	}
	
	
 	

	
	
	
}	

