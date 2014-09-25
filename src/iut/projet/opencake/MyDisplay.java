package iut.projet.opencake;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MyDisplay {
	GLApp app;
	
	public void start() {
		app = new GLApp(this);
		
		try {
			Display.setDisplayMode(new DisplayMode(800,600));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}
		
		while (!Display.isCloseRequested()) {
			app.update();
			Display.update();
		}
		
		Display.destroy();
	}
}
