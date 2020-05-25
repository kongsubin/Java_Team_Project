import javax.swing.* ;

class Main_Frame extends JFrame{
	public Start start = null ;
	public Game game = null ;
	public Desc desc = null ;
	public Record record = null ;
	public Reset reset = null ;
	public Quit quit = null ;

	public void change(String PName)
	{
		if(PName.equals("Start"))
		{
			getContentPane().removeAll() ;
			getContentPane().add(start) ;
			revalidate() ;
			repaint() ;
		}
		else if(PName.equals("Game"))
		{
			getContentPane().removeAll() ;
			getContentPane().add(game) ;
			revalidate() ;
			repaint() ;
		}
		else if(PName.equals("Desc"))
		{
			getContentPane().removeAll() ;
			getContentPane().add(desc) ;
			revalidate() ;
			repaint() ;
		}
		else if(PName.equals("Record"))
		{
			getContentPane().removeAll() ;
			getContentPane().add(record) ;
			revalidate() ;
			repaint() ;
		}
		else if(PName.equals("Reset"))
		{
			getContentPane().removeAll() ;
			getContentPane().add(reset) ;
			revalidate() ;
			repaint() ;
		}
		else
		{
			getContentPane().removeAll() ;
			getContentPane().add(quit) ;
			revalidate() ;
			repaint() ;
		}
	}
}
