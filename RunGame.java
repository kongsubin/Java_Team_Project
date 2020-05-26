class RunGame implements Runnable{
	Thread th; 

	public RunGame(){
			th = new Thread(this); 
			th.start(); 
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("thread create!");
		try { 
			while (true) { 
				//repaint();
				Thread.sleep(20); 
			}
		} catch (Exception e) {
		}
	}
	public void kill() {
		System.out.println("thread kill!");
		th.interrupt();
	}
	
}	

