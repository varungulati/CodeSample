package Singleton;

public class Singleton {
	private static Singleton singleInstance;
	private Singleton() {
		
	}
	public Singleton getInstance() {
		if(singleInstance == null) {
			singleInstance = new Singleton();
		}
		return singleInstance;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
