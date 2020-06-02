package basic;

import main.Main_Frame;

public class Monster extends Basic {
	private int speed ;
	
	public void init(int x, int y, int hp, int damage, Main_Frame win, int speed) {//(basic setting)
		super.init(x, y, hp, damage, win) ;
		this.speed = speed ;
	}
	
	public int getSpeed() { return this.speed ; }
}
