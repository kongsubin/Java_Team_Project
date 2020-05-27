import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Start extends JPanel{
	private JButton GButton ;
	private JButton DButton ;
	private JButton RButton ;
	private JButton SButton ;
	private JButton QButton ;
	private JLabel GName ;
	private Main_Frame win ;
	private sDialog reset ;
	private qDialog quit ;

	public Start(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			GName = new JLabel("Game Name") ;
			GName.setBounds(235, 50, 150, 20) ;
			add(GName) ;

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

	class MyActionListener implements ActionListener{
			public void actionPerformed(ActionEvent e){
					JButton btn = (JButton) e.getSource() ;
					if(btn.getText().equals("Game Start")) 
					{
						win.game = new Game(win) ;
						win.change("Game"); // 화면을 바꿔주는..
					}
					else if(btn.getText().equals("Game Description")) win.change("Desc") ;
					else if(btn.getText().equals("Record")) win.change("Record") ;
					else if(btn.getText().equals("Reset"))
					{
						reset = new sDialog(win, "Testing reset") ;
						reset.setVisible(true) ;
					}
					else
					{
						quit = new qDialog(win, "Testing quit") ;
						quit.setVisible(true) ;
					}
			}
	}
}	
