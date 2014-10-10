package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	Cube cube = new Cube();
	Plane plane = new Plane();
	float rotation = 0.0f;
	float a = -1f;
	int factor = 1;
	Sphere sphere;
	int nbLignes = 50;
	int nbPointsParLigne = 30;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
		sphere = new Sphere();
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);		// Init de la 3D
		GL11.glMatrixMode(GL11.GL_PROJECTION);	// Projection orthogonale
		GL11.glLoadIdentity();					// Charge une matrice vierge
		//GL11.glEnable( GL11.GL_POINT_SMOOTH ); // affichage des points
		//GL11.glPointSize( 10 );
		GL11.glEnable( GL11.GL_BLEND );			// enable blending...
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA ); // for alpha colors
	}
	
	public void update() {
		rotation = 0.60f; // rotation quantity
		nbLignes = 60;
		nbPointsParLigne = 80;
		sphere.MrSphere(nbLignes, nbPointsParLigne); // generates the sphere
	
		GL11.glRotatef(rotation, .05f, .3f, 0.9f); // rotation
	    GL11.glClearColor( 1.0f, 1.0f, 1.0f, 1.0f ); // white background
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT); // Screen clear			
		
		sphere.Draw();
	}
}
