import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import java.awt.FlowLayout ;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JDialog ;

class qDialog extends JDialog{
	private JButton ok ;
	private JButton no ;
	
	public qDialog(JFrame win, String title)
	{
		super(win, title) ;
		setLayout(new FlowLayout()) ;
		ok = new JButton("OK") ;
		no = new JButton("NO") ;
		add(ok) ;
		add(no) ;
		setSize(200, 100) ;
		setLocationRelativeTo(win);

		ok.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false) ;
				System.exit(0) ;
			}
		});

		no.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				setVisible(false) ;
			}
		});
	}
}
		
			
