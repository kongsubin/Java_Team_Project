package basic;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Monster extends Basic {
	private int speed ;
	boolean checking = false;
	public void init(int x, int y, int hp, int damage, Main_Frame win, int speed) {//(basic setting)
		super.init(x, y, hp, damage, win) ;
		this.speed = speed ;
	}
	
	public int getSpeed() { return this.speed ; }
	public boolean getChecking() { return this.checking ; }
	public void setChecking(boolean c) { this.checking = c ; }
}
