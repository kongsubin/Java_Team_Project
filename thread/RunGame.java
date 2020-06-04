package thread;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
// import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JPanel;

import basic.Basic;
import basic.Monster;
import main.Main;
import main.Main_Frame;
import panel.Game;
import panel.Missile;
import panel.Start;

@SuppressWarnings("serial")
public class RunGame extends JFrame implements Runnable, KeyListener {
	private Thread th;
	private JPanel game;
	private Main_Frame win;
	private Basic user;
	private JLabel[] status = new JLabel[3]; // score board (Hp, score, time)
	private int score = 0; // test variable
	private int time = 0; // test variable
	private boolean repeat = true;
	private int cnt = 0;
	private long seed = System.currentTimeMillis();
	private Random rand = new Random(seed);
	private int ran;

	private boolean KeyUp = false;
	private boolean KeyDown = false;
	private boolean KeyLeft = false;
	private boolean KeyRight = false;
	private boolean KeySpace = false;

	private ArrayList<Missile> Aplus_List = new ArrayList<>();
	private ArrayList<Missile> Cplus_List = new ArrayList<>();
	private ArrayList<Missile> Dplus_List = new ArrayList<>();
	private ArrayList<Missile> Fplus_List = new ArrayList<>();

	private Missile AInfo;
	private Missile BInfo;
	private Missile CInfo;
	private Missile DInfo;
	private Missile FInfo;

	private Image random;
	private Image Aplus = new ImageIcon(Start.class.getResource("../image/a_30.png")).getImage();
	private Image Bplus = new ImageIcon(Start.class.getResource("../image/b_30.png")).getImage();
	private Image Cplus = new ImageIcon(Start.class.getResource("../image/c_30.png")).getImage();
	private Image Dplus = new ImageIcon(Start.class.getResource("../image/d_35.png")).getImage();
	private Image Fplus = new ImageIcon(Start.class.getResource("../image/f_40.png")).getImage();

	private ArrayList<Monster> Mon_List = new ArrayList<>();
	private Monster mon;
	private Image mon1 = new ImageIcon(Game.class.getResource("../Image/monster1.png")).getImage();
	private Image mon2 = new ImageIcon(Game.class.getResource("../Image/monster2.png")).getImage();
	private Image mon3 = new ImageIcon(Game.class.getResource("../Image/monster3.png")).getImage();
	private Image temp;

	@SuppressWarnings("unused")
	private Graphics pan;

	public RunGame(Main_Frame win, JPanel game, Basic p, JLabel[] status) {
		this.win = win;
		this.user = p;
		this.game = game;

		for (int i = 0; i < 3; i++) {
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
				MonsterProcess();
				// Enemy_MissileProcess();
				// Draw_Enemy_Missile(pan);
				user.setLocation(user.getX(), user.getY());
				// Enemy_MissileProcess();
				Thread.sleep(20);
				cnt++;
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
		if (KeyUp == true) {
			System.out.println("up");
			user.setY(user.getY() - 5);
		}
		if (KeyDown == true) {
			System.out.println("down");
			user.setY(user.getY() + 5);
		}
		if (KeyLeft == true) {
			System.out.println("left");
			user.setX(user.getX() - 5);
		}
		if (KeyRight == true) {
			System.out.println("right");
			user.setX(user.getX() + 5);
		}
		if (KeySpace == true) {
			System.out.println("attack");
		}

		if (user.getX() > Main.SCREEN_WIDTH - 80)
			user.setX(Main.SCREEN_WIDTH - 80);
		if (user.getX() < -20)
			user.setX(-20);
		if (user.getY() > Main.SCREEN_HEIGHT - 120)
			user.setY(Main.SCREEN_HEIGHT - 120);
		if (user.getY() < 0)
			user.setY(0);

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
			AInfo = new Missile(user.getX() + 10, user.getY() + 50);
			Aplus_List.add(AInfo);
		}

		for (int i = 0; i < Aplus_List.size(); ++i) {
			AInfo = (Missile) Aplus_List.get(i);
			AInfo.move();
			for (int j = 0; j < Mon_List.size(); ++j) {
				mon = (Monster) (Mon_List.get(j));
				if (Crash(AInfo.getX(), AInfo.getY(), mon, user, 30)) {
					System.out.println(mon.getHp());
					if (mon.getHp() <= 0) {
						mon.setX(-300);
					}
					mon.attack(user.getDamage());
					AInfo.setX(600);
				}
			}

			if (AInfo.x > 550) {
				Aplus_List.remove(i);
			}
		}
	}

	public void Enemy_MissileProcess() { // Enemy Missile Process
		for (int i = 0; i < Mon_List.size(); i++) {
			switch (Mon_List.get(i).getDamage() / 10) {
			case 3:
				FInfo = new Missile(Mon_List.get(i).getX() - 10, Mon_List.get(i).getY() + 30);
				Fplus_List.add(FInfo);

				/*
				 * for (int j = 0; j < Fplus_List.size(); ++j) { FInfo = (Missile)
				 * Fplus_List.get(j); FInfo.enemy_move(Mon_List.get(j).getSpeed()); if (FInfo.x
				 * < -20) { Fplus_List.remove(j); }
				 * 
				 * }
				 */
				break;

			case 2:
				DInfo = new Missile(Mon_List.get(i).getX() - 10, Mon_List.get(i).getY() + 30);
				Dplus_List.add(DInfo);

				/*
				 * for (int j = 0; j < Dplus_List.size(); ++j) { DInfo = (Missile)
				 * Dplus_List.get(j); //DInfo.enemy_move(Mon_List.get(j).getSpeed()); if
				 * (DInfo.x < -20) { Dplus_List.remove(j); } }
				 */
				break;
			case 1:
				CInfo = new Missile(Mon_List.get(i).getX() - 10, Mon_List.get(i).getY() + 30);
				Cplus_List.add(CInfo);

				/*
				 * for (int j = 0; j < Cplus_List.size(); ++j) { CInfo = (Missile)
				 * Cplus_List.get(j); //CInfo.enemy_move(Mon_List.get(j).getSpeed()); if
				 * (CInfo.x < -20) { Cplus_List.remove(j); } }
				 */

				break;
			}
		}

	}

	public void Draw_Missile(Graphics pan) {
		for (int i = 0; i < Aplus_List.size(); ++i) {
			AInfo = (Missile) (Aplus_List.get(i));
			// System.out.println(AInfo.x + " "+AInfo.y);
			pan.drawImage(Aplus, AInfo.x, AInfo.y, win);
		}
	}

	public void Draw_Enemy_Missile(Graphics pan) { // Draw Enemy's Missile

		for (int i = 0; i < Mon_List.size(); i++) {
			switch (Mon_List.get(i).getDamage() / 10) {
			case 3:
				// System.out.println("F�̻��� �׸���");
				for (int j = 0; j < Fplus_List.size(); ++j) {
					FInfo = (Missile) (Fplus_List.get(j));
					pan.drawImage(Fplus, FInfo.x, FInfo.y, win);
					FInfo.enemy_move(Mon_List.get(i).getSpeed());
					if (FInfo.x < -20) {
						Fplus_List.remove(j);
					}
					// System.out.println(AInfo.x + " "+AInfo.y);

				}
				break;
			case 2:
				// System.out.println("D�̻��� �׸���");
				for (int j = 0; j < Dplus_List.size(); ++j) {
					DInfo = (Missile) (Dplus_List.get(j));
					pan.drawImage(Dplus, DInfo.x, DInfo.y, win);
					DInfo.enemy_move(Mon_List.get(i).getSpeed());
					// System.out.println(Mon_List.get(j).getSpeed());;
					if (DInfo.x < -20) {
						Dplus_List.remove(j);
					}
					// System.out.println(AInfo.x + " "+AInfo.y);
				}
				break;
			case 1:
				// System.out.println("C�̻��� �׸���");
				for (int j = 0; j < Cplus_List.size(); ++j) {
					CInfo = (Missile) (Cplus_List.get(j));
					pan.drawImage(Cplus, CInfo.x, CInfo.y, win);
					CInfo.enemy_move(Mon_List.get(i).getSpeed());
					// System.out.println(Mon_List.get(j).getSpeed());
					if (CInfo.x < -20) {
						Cplus_List.remove(j);
					}
					// System.out.println(AInfo.x + " "+AInfo.y);
				}
				break;
			}
		}
	}

	public void show_status() {

		status[0].setText("HP : " + user.getHp());
		if (user.getHp() <= 100) {
			status[0].setForeground(Color.RED);
		}
		status[1].setText("Score : " + score);
		status[2].setText("Time : " + time);
		/*
		 * for(int i = 0; i < 3; i++) { board[i].setLocation(450,0+20*i); }
		 */
		score += 1;
		time += 1;
		// System.out.println(score+" "+time);
	}

	public Image GetImage() //
	{
		ran = rand.nextInt(50) + 1;
		if (rand.nextInt(50) + 1 < ran)
			return mon2;
		else if (rand.nextInt(50) + 1 > ran)
			return mon3;
		return mon1;

	}

	public void MonsterProcess() {
		for (int i = 0; i < Mon_List.size(); ++i) {
			mon = (Monster) (Mon_List.get(i));
			mon.setX(mon.getX() - 2 - mon.getSpeed());
			// System.out.println(mon.getX()+" "+mon.getY());
			mon.setLocation(mon.getX(), mon.getY());
			if (Crash(mon.getX(), mon.getY(), user, mon, 80)) {
				user.attack(mon.getDamage());
			}
			if (mon.getX() < -200)
				Mon_List.remove(i);
		}

		if (cnt % 300 == 0) {
			System.out.println("Make a monster!");

			temp = GetImage();
			mon = new Monster() {
				public void paint(Graphics g) {
					g.drawImage(temp, 0, 0, null);
				};
			};
			mon.init(650, 80, 10, rand.nextInt(30) + 10, win, rand.nextInt(3) + 1);
			mon.setBounds(mon.getX(), mon.getY(), 90, 90);
			game.add(mon);
			Mon_List.add(mon);

			temp = GetImage();
			mon = new Monster() {
				public void paint(Graphics g) {
					g.drawImage(temp, 0, 0, null);
				};
			};
			mon.init(650, 180, 10, rand.nextInt(30) + 10, win, rand.nextInt(3) + 1);
			mon.setBounds(mon.getX(), mon.getY(), 90, 90);
			game.add(mon);
			Mon_List.add(mon);

			temp = GetImage();
			mon = new Monster() {
				public void paint(Graphics g) {
					g.drawImage(temp, 0, 0, null);
				};
			};
			mon.init(650, 280, 10, rand.nextInt(30) + 10, win, rand.nextInt(3) + 1);
			mon.setBounds(mon.getX(), mon.getY(), 90, 90);
			game.add(mon);
			Mon_List.add(mon);

			temp = GetImage();
			mon = new Monster() {
				public void paint(Graphics g) {
					g.drawImage(temp, 0, 0, null);
				};
			};
			mon.init(650, 380, 10, rand.nextInt(30) + 10, win, rand.nextInt(3) + 1);
			mon.setBounds(mon.getX(), mon.getY(), 90, 90);
			game.add(mon);
			Mon_List.add(mon);

			Enemy_MissileProcess(); // call Enemy's Missile Process
		}

	}

//	// 미사일, 객체(몬스터, 유저) 
	private boolean Crash(int GradeX, int GradeY, Basic character, Basic attackChar, int range) {
		if (MatchingPoint(GradeX, GradeY, character.getX(), character.getY(), 30, 90))
			return true;
		else if (MatchingPoint(GradeX + range, GradeY, character.getX(), character.getY(), 30, 90))
			return true;
		else if (MatchingPoint(GradeX, GradeY + range, character.getX(), character.getY(), 30, 90))
			return true;
		else if (MatchingPoint(GradeX + range, GradeY + range, character.getX(), character.getY(), 30, 90))
			return true;
		else
			return false;
	}

	private boolean MatchingPoint(int msPointX, int msPointY, int charPointX, int charPointY, int msLen, int charLen) {
		if ((charPointX < msPointX && msPointX < charPointX + charLen)
				&& (charPointY < msPointY && msPointY < charPointY + charLen))
			return true;
		return false;
	}

}
