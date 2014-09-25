package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	float rotation = 0.0f;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);		// Init de la 3D
		GL11.glMatrixMode(GL11.GL_PROJECTION);	// Projection orthogonale
		GL11.glLoadIdentity();					// Charge une matrice vierge
	}
	
	// Création des points du cube
	Vertex a = new Vertex(0,0.5f,0);
	Vertex b = new Vertex(0.5f,0.5f,0);
	Vertex c = new Vertex(0.5f,0,0);
	Vertex d = new Vertex(0,0,0);
	Vertex e = new Vertex(0.5f,0,-.5f);
	Vertex f = new Vertex(0,0,-0.5f);
	Vertex g = new Vertex(0,0.5f,-0.5f);
	Vertex h = new Vertex(0.5f,0.5f,-0.5f);
	
	// Dessine une face
	private void drawFace(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
		GL11.glBegin(GL11.GL_POLYGON);			// Init d'un nouveau polygone
		v1.draw();
		v2.draw();
		v3.draw();
		v4.draw();
		GL11.glEnd();		// Fin du polygone
	}
	
	public void update() {
		rotation = 0.30f;	// Fixe la vitesse de rotation
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);	// Clear de l'écran
		
		GL11.glRotatef(rotation, .1f, .5f, 0);	// Active la rotation (quantité, x, y, z)
			
		// Face 1
		GL11.glColor3f( .0f, .0f, 1.0f );	// Couleur du prochain point désiné (RVB)
		drawFace(a,b,c,d);					// Dessine la face
		
		// Face 2
		GL11.glColor3f( 1.0f, .0f, 1.0f );
		drawFace(a,g,f,d);
		
		// Face 3
		GL11.glColor3f( .0f, 1.0f, 1.0f );
		drawFace(a,b,h,g);
		
		// Face 4
		GL11.glColor3f( .0f, 1.0f, 1.0f );
		drawFace(d,c,e,f);
		
		// Face 5
		GL11.glColor3f( 1.0f, .0f, .0f );
		drawFace(g,h,e,f);
		
		// Face 6
		GL11.glColor3f( 1.0f, 1.0f, 1.0f );
		drawFace(c,e,h,b);
	}
}
