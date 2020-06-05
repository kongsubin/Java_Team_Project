package Timer;


	import java.awt.event.*;
import java.util.Date;
import java.awt.*;
	import javax.swing.*;
	import thread.RunGame;

import com.sun.corba.se.impl.logging.InterceptorsSystemException;


	public class Time {
	     public static long startTime;
	     private final static java.text.SimpleDateFormat timerFormat = new java.text.SimpleDateFormat("mm : ss : SSS");
	     private Thread updater;
	     private boolean isRunning= false;
	     private final Runnable displayUpdater= new Runnable()
	         {
	         public void run()
	             {
	             displayElapsedTime(Time.this.startTime - System.currentTimeMillis());
	         }
	     };
	
	     public void actionPerformed(ActionEvent ae)
	         {
	         if(isRunning)
	             {
	             long elapsed= startTime - System.currentTimeMillis() ;
	             
	             isRunning= false;
	             try
	                 {
	                 updater.join();
	                 // Wait for updater to finish
	             }
	             catch(InterruptedException ie) {}
	             displayElapsedTime(elapsed);
	             // Display the end-result
	         }
	         else
	             {
	             startTime= 1*60*1000+System.currentTimeMillis();
	             isRunning= true;
	            
	             updater.start();
	         }
	     }
	     private void displayElapsedTime(long elapsedTime)
	         {
	    	 //status[2].setText(timerFormat.format(new java.util.Date(elapsedTime)));
			
	     }

	     public void run()
	         {
	         try
	             {
	             while(isRunning)
	                 {
	                 SwingUtilities.invokeAndWait(displayUpdater);
	                 Thread.sleep(50);
	             }
	         }
	         catch(java.lang.reflect.InvocationTargetException ite)
	             {
	             ite.printStackTrace(System.err);
	             // Should never happen!
	         }
	         catch(InterruptedException ie) {}
	         // Ignore and return!
	     }
	     public Time()
	         {

	     }
	    
	       
	     }