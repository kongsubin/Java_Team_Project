package panel;
import java.awt.event.ActionEvent ;
import java.awt.Graphics ;
import java.awt.event.ActionListener ;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Image ;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon ;
import main.Main_Frame;

@SuppressWarnings("serial")
public class Start extends JPanel{
	private JButton GButton ;
	private JButton DButton ;
	private JButton RButton ;
	private JButton SButton ;
	private JButton QButton ;
	private Main_Frame win ;
	private sDialog reset ;
	private qDialog quit ;
	private Image background = new ImageIcon(Start.class.getResource("../image/Main_image.jpg")).getImage() ;
	private Clip clip ;
	
	public Start(Main_Frame win){
			this.win = win ;
			setLayout(null) ;
			String path = Start.class.getResource("").getPath();

			File music = new File(path + "bgm/main_bgm.wav") ;
			Play(music , true) ;
			
			GButton = new JButton("Game Start") ;
			GButton.setSize(150, 20) ;
			GButton.setLocation(200, 240) ;
			add(GButton) ;

			DButton = new JButton("Game Description") ;
			DButton.setSize(150, 20) ;
			DButton.setLocation(200, 280) ;
			add(DButton) ;
			
			RButton = new JButton("Record") ;
			RButton.setSize(150, 20) ;
			RButton.setLocation(200, 320) ;
			add(RButton) ;
			
			SButton = new JButton("Reset") ;
			SButton.setSize(150, 20) ;
			SButton.setLocation(200, 360) ;
			add(SButton) ;
			
			QButton = new JButton("Quit") ;
			QButton.setSize(150, 20) ;
			QButton.setLocation(200, 400) ;
			add(QButton) ;

			GButton.addActionListener(new MyActionListener()) ;
			DButton.addActionListener(new MyActionListener()) ;
			RButton.addActionListener(new MyActionListener()) ;
			SButton.addActionListener(new MyActionListener()) ;
			QButton.addActionListener(new MyActionListener()) ;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, win) ;
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
					JButton btn = (JButton) e.getSource() ;
					if(btn.getText().equals("Game Start")) 
					{
						clip.stop();
						win.game = new Game(win) ;
						win.change("Game"); // 화면을 바꿔주는..
					}
					else if(btn.getText().equals("Game Description")) win.change("Desc") ;
					else if(btn.getText().equals("Record")) {
						win.change("Record") ;
						win.record.show_record(); // show record on screen
					}
					else if(btn.getText().equals("Reset"))
					{
						reset = new sDialog(win, "Reset") ;
						reset.setVisible(true) ;
					}
					else
					{
						quit = new qDialog(win, "Quit") ;
						quit.setVisible(true) ;
					}
			}
	}
}	
