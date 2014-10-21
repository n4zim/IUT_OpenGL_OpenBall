package iut.projet.opencake;

import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

public class MyDisplay {
	GLApp app;
	
	public void start() {
		app = new GLApp(this);
		
		try {
			Display.setTitle("The Magic OpenBall - OpenCake Engine");
			Display.setDisplayMode(new DisplayMode(800,800));
			Display.create();
		} catch (LWJGLException e) {
			e.printStackTrace();
			System.exit(0);
		}

		Window w = new Window(app);
		w.setVisible(true);
		
		app.start();
		
		while (!Display.isCloseRequested()) {
			app.update();
			Display.update();
			Display.sync(60);
		}
		
		w.dispose();
		Display.destroy();
	}
}
