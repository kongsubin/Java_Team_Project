import javax.swing.* ;
import java.awt.* ;

public class main{
	public static final int SCREEN_WIDTH = 550;
	public static final int SCREEN_HEIGHT = 500;
	
		public static void main(String[] arg){
			Main_Frame win = new Main_Frame() ;
	
			win.setTitle("Game Name") ;
			win.start = new Start(win) ;
			//win.game = new Game(win) ;
			win.desc = new Desc(win) ;
			win.record = new Record(win) ;
			// win.reset = new Reset(win) ;
			// win.quit = new Quit(win) ;
			

			win.add(win.start) ;
			win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
			win.setSize(SCREEN_WIDTH, SCREEN_HEIGHT) ;
			win.setResizable(false); // 화면 크기 조절 불가능                 
            win.setLocationRelativeTo(null) ; // 화면이 중간에서 생성되도록!
			win.setVisible(true) ;
		}
}

