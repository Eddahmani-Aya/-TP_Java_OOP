package threads;

public class TacheAvecPause implements Runnable {
	
	public String nom;
	public int duree;
	
	public TacheAvecPause(String nom, int duree) {
		this.duree=duree;
		this.nom=nom;
		}
	@Override
	public void run() {
		System.out.println(nom+" -> Debut");
		
		 try {
			 Thread.sleep(duree);
		 } catch (InterruptedException e) {
			 e.printStackTrace();
		 }
		 System.out.println(nom+" -> Fin");
	}

}
