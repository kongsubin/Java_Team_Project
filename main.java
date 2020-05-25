import javax.swing.* ;
import java.awt.* ;

public class main{
		public static void main(String[] arg){
			Main_Frame win = new Main_Frame() ;
	
			win.setTitle("Game Name") ;
			win.start = new Start(win) ;
			win.game = new Game(win) ;
			win.desc = new Desc(win) ;
			win.record = new Record(win) ;
			win.reset = new Reset(win) ;
			win.quit = new Quit(win) ;
			
			win.add(win.start) ;
			win.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE) ;
			win.setSize(550, 500) ;
			win.setVisible(true) ;
		}
}
