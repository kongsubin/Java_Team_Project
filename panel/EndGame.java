package panel;
import java.awt.Color;
import java.awt.Font;
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

import main.Main_Frame;

@SuppressWarnings("serial")
public class EndGame extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private Clip clip ;
	private JLabel scoreText;
	private int score = 0;
	
	private Image endBackground ;
	
	public EndGame(Main_Frame win, int score, String type){
			this.win = win ;
			this.score = score;
			setLayout(null) ;
			
			String path = Start.class.getResource("").getPath();
			if(type.equals("HP")) {
				endBackground = new ImageIcon(Start.class.getResource("../image/dead2_image.jpg")).getImage() ;
				File music = new File(path + "bgm/dead_bgm.wav") ;
				Play(music , true) ;
			}
			else if(type.equals("TIME")) {
				endBackground = new ImageIcon(Start.class.getResource("../image/end_image.jpg")).getImage() ;
				File music = new File(path + "bgm/end_bgm.wav") ;
				Play(music , true) ;
			}

			scoreText = new JLabel("Your Score is " + score); 
			System.out.println(score);
			scoreText.setSize(300,100);
			scoreText.setLocation(160,150);
			scoreText.setForeground(Color.WHITE);
			Font f = new Font("Serif", Font.BOLD+Font.ITALIC, 28);
			scoreText.setFont(f);
			add(scoreText);
			
			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;

			jButton.addActionListener(new MyActionListener()) ;
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(endBackground, 0, 0, win) ;
		setOpaque(false) ;
		super.paintComponent(g);
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
				clip.stop() ;
				win.start = new Start(win) ;
				win.change("Start") ;
			}
	}
}	
