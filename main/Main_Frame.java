package main;
import javax.swing.* ;

import panel.Desc;
import panel.Game;
import panel.Record;
import panel.Start;

@SuppressWarnings("serial")
public class Main_Frame extends JFrame{
	public Start start = null ;
	public Game game = null ;
	public Desc desc = null ;
	public Record record = null ;

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
	}
}
