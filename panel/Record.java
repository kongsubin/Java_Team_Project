package panel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.Main_Frame;
import manage.manage_data;

@SuppressWarnings("serial")
public class Record extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private JLabel label;
	private manage_data manage = new manage_data();
	private String[] line = new String[10];
	private JLabel[] scores = new JLabel[10];
	private int rankings;
	private Image background = new ImageIcon(Start.class.getResource("../image/Null_image.jpg")).getImage() ;
	
	public Record(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;
			
			label = new JLabel("Ranking         Grade       Score");
			label.setSize(200,10);
			label.setLocation(175,50);
			label.setForeground(Color.WHITE);
			add(label);
			

			jButton.addActionListener(new MyActionListener()) ;
	}
	
	public void paintComponent(Graphics g)
	{
		g.drawImage(background, 0, 0, win) ;
		setOpaque(false) ;
		super.paintComponent(g);
	}

	public void show_record() { // show record on screen
		int i;
		
		for(i = 0; i < rankings; i++) { // delete rankings on screen before rewrite
			remove(scores[i]);
		}
		line = manage.print_score();
		for(i = 0; i < line.length; i++) { // show ranking newly on screen
			System.out.println(line[i]);
			scores[i] = new JLabel(line[i]);
			scores[i].setSize(200,10);
			scores[i].setLocation(175,20+i*20);
			scores[i].setForeground(Color.WHITE);
			add(scores[i]);
		}
		rankings = i;
	}
	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					win.change("Start") ;
			}
	}
}	
