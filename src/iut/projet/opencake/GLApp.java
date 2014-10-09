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
	
	public GLApp(MyDisplay display) {
		this.display = display; 
		

		sphere = new Sphere();
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);		// Init de la 3D
		GL11.glMatrixMode(GL11.GL_PROJECTION);	// Projection orthogonale
		GL11.glLoadIdentity();					// Charge une matrice vierge
		GL11.glEnable( GL11.GL_POINT_SMOOTH );
		GL11.glEnable( GL11.GL_BLEND );
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA );
		GL11.glPointSize( 10 );
	}
	
	public void update() {rotation = 0.60f;
		/*	// Fixe la vitesse de rotation
		a += factor*0.01f;
		
		if(a > 1) {
			a = 1;
			factor = -1;
		}
		
		if(a < -1) {
			a = -1;
			factor = 1;
		}

		//plane.set(-10, a, -10, 10, 10);
		GL11.glRotatef(rotation, .05f, .5f, 0);	// Active la rotation (quantite, x, y, z)
		*/
	
		sphere.MrSphere(100, 400);
	
		GL11.glRotatef(rotation, .05f, .5f, 0);
	    GL11.glClearColor( 1.0f, 1.0f, 1.0f, 1.0f );
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);	// Clear de l'écran
			
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glColor3f( 0.95f, 0.207f, 0.031f );

		for (Vertex pt : sphere.points) {
			GL11.glVertex3f(pt.x, pt.y, pt.z);
		}
		GL11.glEnd();
		
		//cube.draw();
		//plane.draw();
	}
}
