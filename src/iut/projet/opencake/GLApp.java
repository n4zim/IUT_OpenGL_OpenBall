package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	float rotation = 0.0f;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		//GL11.glOrtho(0, 800, 0, 600, 1, -1);
		//GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	public void update() {
		//rotation += 0.001f;
		rotation = 0.05f;
		System.out.println(rotation);
		//if(rotation > 1) rotation = 0;
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		
		GL11.glRotatef(rotation, .0f, 1.0f, .0f);
		GL11.glRotatef(0.01f, .1f, .0f, 0);
		
		GL11.glBegin(GL11.GL_POLYGON);
		
		GL11.glColor3f( .0f, .0f, 1.0f );
		GL11.glVertex3f(-0.5f, -0.5f, -0.5f);
		GL11.glColor3f( .0f, 1.0f, .0f );
		GL11.glVertex3f(-0.5f, 0.5f, -0.5f);
		GL11.glColor3f( 1.0f, .0f, .0f );
		GL11.glVertex3f(0.5f, 0.5f, -0.5f);
		GL11.glColor3f( 1.0f, 1.0f, .0f );
		GL11.glVertex3f(0.5f, -0.5f, -0.5f);
		
		GL11.glEnd();
		
		
	}
}
