package panel;

public class M_Missile extends Missile{
	private int speed ;
	
	
	public M_Missile(int x, int y, int speed) {
		super(x, y) ;
		this.speed = speed ;
		//s TODO Auto-generated constructor stub
	}
	

	public void move() { 
		this.setX(this.getX() - speed);
	}

	public int getSpeed() { return this.speed ; } ;

}
