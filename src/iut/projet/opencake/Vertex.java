package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

class Vertex {
	float x,y,z;
	
	public Vertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void draw() {
		GL11.glVertex3f(x,y,z);
	}
}