import java.awt.event.ActionEvent ;
import java.awt.event.ActionListener ;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class Record extends JPanel{
	private JButton jButton ;
	private Main_Frame win ;
	private JLabel label;
	private manage_data manage = new manage_data();
	private String[] line = new String[10];
	private JLabel[] scores = new JLabel[10];
	private int rankings;

	public Record(Main_Frame win){
			this.win = win ;
			setLayout(null) ;

			jButton = new JButton("Back") ;
			jButton.setSize(50, 20) ;
			jButton.setLocation(490, 450) ;
			add(jButton) ;
			
			label = new JLabel("Ranking         Grade       Score");
			label.setSize(200,10);
			label.setLocation(175,0);
			add(label);
			

			jButton.addActionListener(new MyActionListener()) ;
	}
	
	public void show_record() { // 기록 보여주기
		int i;
		
		for(i = 0; i < rankings; i++) { // 예전 기록들을 지워줌 (변화가 생겼을 경우 적용이 안되기 때문에 지웠다가 다시 그려줌)
			remove(scores[i]);
		}
		line = manage.get_score();
		for(i = 0; i < line.length; i++) { // 세로운 기록들을 표시
			System.out.println(line[i]);
			scores[i] = new JLabel(line[i]);
			scores[i].setSize(200,10);
			scores[i].setLocation(175,20+i*20);
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
