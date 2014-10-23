package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

/**
 * Représente un vecteur 4 (sous forme ponctuelle)
 * utile des nombres flottants
 */
class Vertex {
	float x,y,z,w;
	
	/**
	 * Crée un nouveau vecteur suivant les coordonées données et dont w sera 1
	 * @param x
	 * @param y
	 * @param z
	 */
	public Vertex(float x, float y, float z) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = 1;
	}
	
	/**
	 * Crée un nouveau vecteur suivant les coordonées données
	 * @param x
	 * @param y
	 * @param z
	 * @param w
	 */
	public Vertex(float x, float y, float z, float w) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.w = w;
	}
	
	/**
	 * Transforme un vecteur selon une matrice de transformation et un vecteur de translation
	 * @param transform Matrice de transformation
	 * @param translate Vecteur de translation
	 * @return Vecteur résultant de l'opération : Vecteur Actuel * Matrice + Vecteur translation
	 */
	public Vertex applyTransfrom(Matrice4 transform, Vertex translate) {
		float tx = 0, ty = 0, tz = 0, tw = 0; 
		
		// TRANSFORM FIRST
		// Operation : vector(x,y,z,w) * matrix(16) = vector(tx, ty, tz, tw)
		for(int i = 0; i < 4; i++)
			tx += (transform.Vertices[i] * x);
		for(int i = 4; i < 8; i++)
			ty += (transform.Vertices[i] * y);
		for(int i = 8; i < 12; i++)
			tz += (transform.Vertices[i] * z);		
		for(int i = 12; i < 16; i++)
			tz += (transform.Vertices[i] * w);		
		
		// TRANSLATE THEN
		if(translate != null) {
			tx += translate.x;
			ty += translate.y;
			tz += translate.z;
			tw += translate.w;
		}
		
		// RETURN TRANSFORMED VECTOR
		return new Vertex(tx, ty, tz, tw);
	}
	
	/**
	 * Dessine un point
	 */
	public void draw() {
		GL11.glVertex3f(x,y,z);
	}
}