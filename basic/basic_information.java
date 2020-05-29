package basic;

import java.awt.Point;
import java.util.*;
public class basic_information {
	private static int hp = 100;
	private static final int attack_d=5;//attack demage
	private static final double attack_s=5.0;
	private static int x=0;
	private static int y=0;
	
	boolean KeyUp = false;
	boolean KeyDown = false;
	boolean KeyLeft = false;
	boolean KeyRight = false;
	boolean KeySpace = false;
	
	public void init(int x,int y) {//기본적인 세팅(basic setting)
		this.x = 100;
		this.y = 100;	
		
	}
	public void KeyProcess(){

		if(KeyUp == true)  y -= 5;
		if(KeyDown == true) y += 5;
		if(KeyLeft == true)  x -= 5;
		if(KeyRight == true) x += 5;
		   
		}
	 public int attack(int hp) {//hp감소
		 
	        
	 
	           this.hp = this.hp - 5;
	 
	           return this.hp;
	 
	            
	 
	    }

	
	
	
	

}
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