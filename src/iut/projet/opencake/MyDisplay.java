package iut.projet.opencake;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * G�re la boucle de vie de l'application et ouvre les fen�tres
 */
public class MyDisplay {
	/**
	 * Handle sur l'application
	 */
	GLApp app;
	
	/**
	 * D�marrage
	 */
	public void start() {
		app = new GLApp(this);
		
		// R�glage des propri�t�es et cr�ation de la fen�tre
		try {
			Display.setTitle("OpenBall");
			Display.setDisplayMode(new DisplayMode(800,800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		// Cr�ation et affichage de la fen�tre de param�tres
		SettingWindow w = new SettingWindow(app);
		w.setVisible(true);
		
		// Init OpenGl
		app.start();
		
		// Boucle de vie
		while (!Display.isCloseRequested()) {
			app.update();		// mise � jour de la simulation
			Display.update();	// mise � jour graphique
			Display.sync(60);	// limite � 60 images par seconde
		}
		
		// Fin de vie du programme, desctruction des objets
		w.dispose();
		Display.destroy();
	}
}
