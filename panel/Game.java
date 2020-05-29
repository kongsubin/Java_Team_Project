package panel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main_Frame;
import thread.RunGame;

@SuppressWarnings("serial")
public class Game extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private RunGame running;
	private Image background = new ImageIcon(Start.class.getResource("../image/Null_image.jpg")).getImage() ;
	JPanel p;
	int x = 0, y = 0;

	public Game(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;
			jButton.addActionListener(new MyActionListener()) ;
			
			p = new JPanel();
			p.setBounds(100, 100, 50, 50);
			p.setBackground(Color.RED);
			add(p);
			
			running = new RunGame(win, p);
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, win) ;
		setOpaque(false) ;
		super.paintComponent(g);
	}

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					running.kill();
					win.change("Start") ;
			}
	}
}	
