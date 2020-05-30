package basic;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Basic extends JPanel{
	private int hp = 100 ;
	private int attack_d = 5 ;//attack damage
	// private static final double attack_s = 5.0;
	private int x = 0 ;
	private int y = 0 ;
	private Image bufferi ;
	private Graphics bufferg ;
	private Main_Frame win ;
	private Image charImage ;
	
	/*
	boolean KeyUp = false ;
	boolean KeyDown = false ;
	boolean KeyLeft = false ;
	boolean KeyRight = false ;
	boolean KeySpace = false ;
	*/
	
	public void init(int x, int y, int hp, int damage, Main_Frame win, String path) {//기본적인 세팅(basic setting)
		this.x = x;
		this.y = y;
		this.hp = hp ;
		this.attack_d = damage ;
		this.win = win ;
		charImage = new ImageIcon(Basic.class.getResource(path)).getImage();
	}
	
	/*
	public void KeyProcess() {
		if(KeyUp == true)  y -= 5;
		if(KeyDown == true) y += 5;
		if(KeyLeft == true)  x -= 5;
		if(KeyRight == true) x += 5;
	}
	*/
	
	public int attack(int damage) {//hp감소
		this.hp -= damage ;
	 
		return this.hp ; 	 
	}
	
	public void paint(Graphics g)
	{
		bufferi = createImage(550, 500) ;
		bufferg = bufferi.getGraphics() ;
		bufferg.clearRect(0, 0, 550, 500) ;
		bufferg.drawImage(charImage, x, y, win);
		g.drawImage(bufferi, 0, 0, win); 
		
	}
	
	public int getDamage() { return this.attack_d ; }
	public int getX() { return this.x ; }
	public int getY() { return this.y ; }
	public void setX(int x) { this.x = x ; }
	public void setY(int y) { this.y = y ; }
	public Graphics getG() { return this.bufferg ; }
	
}

/*
class Attack{
	Point pos;
	Attack(int x, int y){
		pos = new  Point(x,y);
	}
	public void move() {
		pos.x+=10;
	}
}

class Enemy{ // 적 위치 파악 및 이동을 위한 클래스
int x;
int y;

Enemy(int x, int y){ // 적좌표를 받아 객체화 시키기 위한 메소드
this.x = x;
this.y = y;
}
public void move(){ // x좌표 -3 만큼 이동 시키는 명령 메소드
x -= 3;
}
}
*/