package panel;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main_Frame;

@SuppressWarnings("serial")
public class Desc extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private Image background = new ImageIcon(Start.class.getResource("../image/Null_image.jpg")).getImage() ;
	
	public Desc(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;

			jButton.addActionListener(new MyActionListener()) ;
	}

	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, win) ;
		setOpaque(false) ;
		super.paintComponent(g);
	}
	
	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					win.change("Start") ;
			}
	}
}	
