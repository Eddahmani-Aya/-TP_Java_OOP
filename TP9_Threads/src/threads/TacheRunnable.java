package threads;

public class TacheRunnable implements Runnable {

	private String nom;
	 public TacheRunnable(String nom) {
	 this.nom=nom;
	}
	public void run() {
		 for(int i=0;i<3;i++){
			 System.out.println("["+nom+"] ->"+i);
	
			 try {
				 Thread.sleep((long)(Math.random()*1000));
			 } catch (InterruptedException e) {
				 e.printStackTrace();
			 }
		 }
		 System.out.println(nom+" terminé");
	}
}
