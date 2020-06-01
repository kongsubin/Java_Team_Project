package panel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import basic.Basic;
import main.Main_Frame;
import thread.RunGame;

@SuppressWarnings("serial")
public class Game extends JPanel implements Runnable{
	private JButton jButton ;
	private Main_Frame win ;
	private RunGame running;
	private Image background = new ImageIcon(Start.class.getResource("../image/Null_image.jpg")).getImage() ;
	// JPanel p;
	private Clip clip ;
	private Basic user = new Basic() 	{
		Image background = new ImageIcon(Game.class.getResource("../Image/User.png")).getImage();
		public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null) ;	
		} ;
	} ;
	
	Graphics pan;
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
			running = new RunGame(win, user);
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
			while (true) { 
				repaint();
				Thread.sleep(20); 
			}
		} catch (Exception e) {
		}		
	}
	public void kill() {
		System.out.println("game thread kill!");
		game_th.interrupt();
	}
}	
