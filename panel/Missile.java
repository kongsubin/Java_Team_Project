package panel;


public class Missile {
	public int x;
	public int y; // 편의상 변수 명 변경

	public Missile(int x, int y) {
		this.x = x;
		this.y = y;// 편의상 변수명 변경
	}

	public void move() {
		x += 30;
	}
	
}