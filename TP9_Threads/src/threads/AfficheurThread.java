package threads;

public class AfficheurThread extends Thread {
	public AfficheurThread(String nom) {
		super(nom);
		}
	public void run() {
		for(int i=0;i<5;i++){
			System.out.println("["+getName()+"] ->"+i);
			try {
				sleep((long)(Math.random()*500));
			} catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
			System.out.println(getName()+" terminé");
	}

}
