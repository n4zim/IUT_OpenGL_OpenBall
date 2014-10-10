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
	int frame = 0;
	Matrice4 matSphere = new Matrice4();
	
	public GLApp(MyDisplay display) {
		this.display = display; 
		sphere = new Sphere();
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);		// Init de la 3D
		GL11.glMatrixMode(GL11.GL_PROJECTION);	// Projection orthogonale
		GL11.glLoadIdentity();					// Charge une matrice vierge
		//GL11.glOrtho(-2, 2, -2, 2, 0.1f, 100);
		GL11.glOrtho( -5.0, 5, -5, 5.0, 1.0, -1.0 );
		GL11.glEnable( GL11.GL_BLEND );			// enable blending...
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA ); // for alpha colors
		
		
	}
	
	public void update() {
		rotation = 0.60f; // rotation quantity
		nbLignes = 60;
		nbLignes = 2;
		nbPointsParLigne = 80;
		nbPointsParLigne = 10;
		sphere.MrSphere(nbLignes, nbPointsParLigne); // generates the sphere
		
		GL11.glMatrixMode( GL11.GL_MODELVIEW );
		//GL11.glLoadIdentity();
		//GL11.glTranslatef(0, 0, 0);
		
		GL11.glRotatef(rotation, .05f, .3f, .9f); // rotation
	    GL11.glClearColor( 1.0f, 1.0f, 1.0f, 1.0f ); // white background
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT); // Screen clear	
		
		matSphere.Identitee();
		//matSphere.Echelle((float)(frame++)/100, (float)(frame++)/100, 1);
		matSphere.Translation((float)(frame++)/1000, (float)(frame++)/1000, (float)(frame++)/1000);
		System.out.println(matSphere.ToString());
		
		GL11.glTranslatef(.01f, .01f, .0f);
		//GL11.glLoadMatrix(matSphere.GetMatrix());
		sphere.Draw();
		
		//GL11.glLoadIdentity();
		
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glColor3f(0, 0, 0);
			GL11.glVertex3f(0, 0, 0);
			GL11.glVertex3f(0, 0, 1);
			GL11.glVertex3f(1, 0, 1);
			GL11.glVertex3f(1, 0, 0);
		GL11.glEnd();
	}
}
