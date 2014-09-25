package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	
	public GLApp(MyDisplay display) {
		this.display = display;  
	}
	
	public void update() {
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		
	}
}
