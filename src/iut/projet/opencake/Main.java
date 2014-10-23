package iut.projet.opencake;

/**
 * Classe principale
 */
public class Main {
	/**
	 * La fenêtre openGl
	 */
	MyDisplay display;
	
	/**
	 * Lancer l'application
	 */
	public void start() {
		display = new MyDisplay();
		display.start();
	}
	
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

}
