package panel;
import java.awt.Color;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton;
import javax.swing.JPanel;

import main.Main_Frame;
import thread.RunGame;

@SuppressWarnings("serial")
public class Game extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private RunGame running;
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

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					running.kill();
					win.change("Start") ;
			}
	}
}	
