package threads;

public class Compteur {
	public int valeur=0;
	public synchronized void increment()
	{
		valeur++;
	}
	public int getValeur() {
		return valeur;
	}
	
}
