package basic;

import javax.swing.JPanel;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Basic extends JPanel{
	private int hp = 100 ;
	private int attack_d = 5 ;//attack damage
	// private static final double attack_s = 5.0;
	private int x = 0 ;
	private int y = 0 ;
	@SuppressWarnings("unused")
	private Main_Frame win ;

	public void init(int x, int y, int hp, int damage, Main_Frame win) {//(basic setting)
		this.x = x;
		this.y = y;
		this.hp = hp ;
		this.attack_d = damage ;
		this.win = win ;
	}
	
	public int attack(int damage) { // hp
		this.hp -= damage ;
	 
		return this.hp ; 	 
	}
	
	public int getDamage() { return this.attack_d ; }
	public int getHp() { return this.hp; }
	public int getX() { return this.x ; }
	public int getY() { return this.y ; }
	public void setX(int x) { this.x = x ; }
	public void setY(int y) { this.y = y ; }
	
}