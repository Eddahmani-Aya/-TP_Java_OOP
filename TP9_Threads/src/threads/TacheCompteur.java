package threads;

public class TacheCompteur extends Thread {
	
	public Compteur c;
	
	public TacheCompteur (Compteur c) {
		this.c=c;
	}
	public void run() {
		for (int i = 0; i <1000; i++) {
			c.increment();
		}
		
	}

}
