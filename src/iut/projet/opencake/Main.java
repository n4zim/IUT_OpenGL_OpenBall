package iut.projet.opencake;

public class Main {
	MyDisplay display;
	
	public void start() {
		display = new MyDisplay();
		display.start();
	}
	
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}

}
