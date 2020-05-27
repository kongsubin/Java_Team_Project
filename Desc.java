import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Desc extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;

	public Desc(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;

			jButton.addActionListener(new MyActionListener()) ;
	}

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					win.change("Start") ;
			}
	}
}	
