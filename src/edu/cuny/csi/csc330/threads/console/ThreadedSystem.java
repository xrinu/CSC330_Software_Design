package edu.cuny.csi.csc330.threads.console;

public class ThreadedSystem {
	
	private Runnable console ; 
	private Runnable emailChecker ; 
	

	public ThreadedSystem() {
		init();
	}
	
	private void init() {
		console = new Console(); 
		emailChecker = new EMailChecker(); 
		
	}

	public void go() {
		System.out.println("Starting Working Threads");
		Thread t1 = new Thread(console);
		Thread t2 = new Thread(emailChecker);
		
		t1.start();
		t2.start();
		
		System.out.printf("Running %d active threads%n", Thread.activeCount());
		
	}


	public static void main(String[] args) {
		ThreadedSystem system = new ThreadedSystem(); 
		system.go();
		
		System.out.println("After go()\n");
		
	}
	
	
}
