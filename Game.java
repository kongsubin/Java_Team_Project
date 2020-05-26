import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

class Game extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private RunGame running;

	public Game(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;

			jButton.addActionListener(new MyActionListener()) ;
			running = new RunGame();
	}

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					running.kill();
					win.change("Start") ;
			}
	}
}	
