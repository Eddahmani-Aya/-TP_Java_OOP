package threads;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		AfficheurThread t1=new AfficheurThread("DSI");
		AfficheurThread t2=new AfficheurThread("SE");
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println("Terminee");
		
		
	}
}
