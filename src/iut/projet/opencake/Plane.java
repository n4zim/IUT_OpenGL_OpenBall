package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

/**
 * Objet : plan
 * non utilisé
 */
public class Plane {
	float x,y,z,w,h;
	
	public Plane(float x, float y, float z, float w, float h) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
		this.h = h;
	}
	
	public void draw() {
        GL11.glBegin(GL11.GL_POLYGON);
	        GL11.glColor3f(1, 1, 1);
	        GL11.glVertex3f(x, y, z);
	        GL11.glVertex3f(x, y, z+w);
	        GL11.glVertex3f(x+w, y, z+h);
	        GL11.glVertex3f(x+h, y, z);
	    GL11.glEnd();
	}
}
