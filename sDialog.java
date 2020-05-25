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

class sDialog extends JDialog{
	private JButton ok ;
	private JButton no ;
	private Main_Frame win ;

	public sDialog(JFrame win, String title)
	{
		super(win, title) ;
		setLayout(new FlowLayout()) ;
		ok = new JButton("OK") ;
		no = new JButton("NO") ;
		add(ok) ;
		add(no) ;
		setSize(200, 100) ;

		ok.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				JButton btn = (JButton) e.getSource();
				if(btn.getText().equals("OK")) setVisible(false) ; // reset record
				else setVisible(false) ;
			}
		}) ;
	}
}
		
			
