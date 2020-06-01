package panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import basic.Basic;
import main.Main_Frame;
import thread.RunGame;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable{
	private JButton jButton ;
	private Main_Frame win ;
	private RunGame running;
	private JLabel[] status = new JLabel[3]; // status (hp, score, time);
	private Image background = new ImageIcon(Start.class.getResource("../image/Null_image.jpg")).getImage() ;
	// JPanel p;
	private Clip clip ;
	private Basic user = new Basic() 	{
		Image background = new ImageIcon(Game.class.getResource("../Image/User.png")).getImage();
		public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null) ;	
		} ;
	} ;
	
	private boolean repeat = true;
	
	@SuppressWarnings("unused")
	private Graphics pan;
	private Thread game_th;
	
	public Game(Main_Frame win){
			this.win = win ;
			setLayout(null) ;
			String path = Start.class.getResource("").getPath();

			File music = new File(path + "bgm/game_bgm.wav") ;
			Play(music , true) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;
			jButton.addActionListener(new MyActionListener()) ;
			
			pan = win.getGraphics();
			game_th =  new Thread(this); 
			game_th.start(); 
			
			user.init(0, 200, 1000, 10, win, "../Image/User.png") ;
			user.setBounds(user.getX(), user.getY(), 100, 100);
			add(user) ;
			
			status[0] = new JLabel("Hp : ");
			status[1] = new JLabel("Score : ");
			status[2] = new JLabel("Time : ");
			
			for(int i = 0; i < 3; i++) {
				status[i].setSize(100,15);
				status[i].setLocation(450,0+20*i);
				status[i].setForeground(Color.WHITE);
				add(status[i]);
			}
			
			running = new RunGame(win, user, status);
	}
	
	public void paintComponent(Graphics pan)
	{
		pan.drawImage(background, 0, 0, win) ;
		running.Draw_Missile(pan);
		
		//g.drawImage(background, 0, 0, win) ;
		setOpaque(false) ;
		super.paintComponent(pan);
	}
	
	public void Play(File sound, boolean repeat)
	{
		try
        {
            clip = AudioSystem.getClip() ;
            clip.open(AudioSystem.getAudioInputStream(sound)) ;
            clip.start();
            if(repeat) clip.loop(-1) ; // repeat : true -> loop . false -> stop 
        }
        catch (Exception ex)
        {
        	ex.printStackTrace();	
        }
	}

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					running.kill();
					kill();
					clip.stop();
					win.start = new Start(win) ;
					win.change("Start") ;
			}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try { 
			while (repeat) { 
				repaint();
				Thread.sleep(20); 
			}
		} catch (Exception e) {
		}		
	}
	public void kill() {
		System.out.println("game thread kill!");
		//game_th.interrupt();
		repeat = false;
	}
	
}	
