package panel;
import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.FlowLayout ;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JDialog ;

@SuppressWarnings("serial")
class sDialog extends JDialog{
	private JButton ok ;
	private JButton no ;
	
	public sDialog(JFrame win, String title)
	{
		super(win, title) ;
		setLayout(new FlowLayout()) ;
		ok = new JButton("OK") ;
		no = new JButton("NO") ;
		add(ok) ;
		add(no) ;
		setSize(200, 100) ;
		setLocationRelativeTo(win);

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false) ; // reset record
			}
		}) ;

		no.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				setVisible(false) ; // reset record
			}
		}) ;
	}
}
		
			
