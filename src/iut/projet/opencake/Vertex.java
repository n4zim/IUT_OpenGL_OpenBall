package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

class Vertex {
	double x;
	double y;
	double z;
	public Vertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public void draw() {
		GL11.glVertex3d(x,y,z);
	}
}