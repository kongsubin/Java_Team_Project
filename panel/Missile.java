package panel;

public class Missile {
	private int x ;
	private int y ;

	public Missile(int x, int y) {
		this.x = x;
		this.y = y;//
	}

	public void move() {
		this.x += 30;
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