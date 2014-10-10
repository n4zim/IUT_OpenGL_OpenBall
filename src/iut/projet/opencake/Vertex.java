package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

class Vertex {
	float x,y,z,w;
	
	public Vertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 1;
	}
	
	public Vertex ApplyMatrix(Matrice4 a) {
		float tx = 0, ty = 0, tz = 0; 

		for(int i = 0; i < 4; i++)
			tx += (a.Vertices[i] * x);
		for(int i = 4; i < 8; i++)
			ty += (a.Vertices[i] * y);
		for(int i = 8; i < 12; i++)
			tz += (a.Vertices[i] * z);		
		
		return new Vertex(tx, ty, tz);
	}
	
	public void draw() {
		GL11.glVertex3f(x,y,z);
	}
}