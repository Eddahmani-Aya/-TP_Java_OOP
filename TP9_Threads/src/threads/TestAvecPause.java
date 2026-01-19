package threads;

public class TestAvecPause {
	public static void main(String[] args) {
		Thread A=new Thread(new TacheAvecPause("A",1000));
		Thread B=new Thread(new TacheAvecPause("B",2000));
		Thread C=new Thread(new TacheAvecPause("C",1500));
		A.start();
		B.start();
		try {
			A.join();
			B.join();
			C.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
