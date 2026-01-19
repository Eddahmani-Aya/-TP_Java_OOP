package threads;

public class TestRunnable {

	public static void main(String[] args) {
		TacheRunnable r=new TacheRunnable("DSI");
		
		Thread t1=new Thread(r);
		Thread t2=new Thread(r);
		t1.start();
		t2.start();
		Thread t3=new Thread(new TacheRunnable("DAI"));
		Thread t4=new Thread(new TacheRunnable("SE"));
		t3.start();
		t4.start();

	}

}
