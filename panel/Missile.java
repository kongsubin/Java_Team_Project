package panel;

public class Missile {
	private int x ;
	private int y ;

	public Missile(int x, int y) {
		this.x = x;
		this.y = y;//
	}

	public void move() {
		x += 30;
	}

	public void enemy_move(int speed) { // enemy's missile move
		x -= speed ;
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
}