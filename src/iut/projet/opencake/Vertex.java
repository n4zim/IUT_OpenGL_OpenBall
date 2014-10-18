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
	
	public Vertex applyTransfrom(Matrice4 transform, Vertex translate) {
		float tx = 0, ty = 0, tz = 0; 
		
		// TRANSFORM FIRST
		// Operation : vector(x,y,z) * matrix(16) = vector(tx, ty, tz)
		for(int i = 0; i < 4; i++)
			tx += (transform.Vertices[i] * x);
		for(int i = 4; i < 8; i++)
			ty += (transform.Vertices[i] * y);
		for(int i = 8; i < 12; i++)
			tz += (transform.Vertices[i] * z);		
		
		// TRANSLATE THEN
		if(translate != null) {
			tx += translate.x;
			ty += translate.y;
			tz += translate.z;
		}
		
		// RETURN TRANSFORMED VECTOR
		return new Vertex(tx, ty, tz);
	}
	
	public void draw() {
		GL11.glVertex3f(x,y,z);
	}
}