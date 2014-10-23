package iut.projet.opencake;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Gère la boucle de vie de l'application et ouvre les fenêtres
 */
public class MyDisplay {
	/**
	 * Handle sur l'application
	 */
	GLApp app;
	
	/**
	 * Démarrage
	 */
	public void start() {
		app = new GLApp(this);
		
		// Réglage des propriétées et création de la fenêtre
		try {
			Display.setTitle("OpenBall");
			Display.setDisplayMode(new DisplayMode(800,800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Création et affichage de la fenêtre de paramètres
		SettingWindow w = new SettingWindow(app);
		w.setVisible(true);
		
		// Init OpenGl
		app.start();
		
		// Boucle de vie
		while (!Display.isCloseRequested()) {
			app.update();		// mise à jour de la simulation
			Display.update();	// mise à jour graphique
			Display.sync(60);	// limite à 60 images par seconde
		}
		
		// Fin de vie du programme, desctruction des objets
		w.dispose();
		Display.destroy();
	}
}
