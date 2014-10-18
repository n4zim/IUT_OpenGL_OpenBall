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
	int nbPointsParLigne = 40;
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
		GL11.glOrtho( -2.0, 2, -2, 2.0, 10.0, -10.0 );
		GL11.glEnable( GL11.GL_BLEND );			// enable blending...
		GL11.glEnable(GL11.GL_LIGHTING);
		GL11.glEnable(GL11.GL_COLOR_MATERIAL);
		GL11.glBlendFunc( GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA ); // for alpha colors
	}
	
	int c = 1;
	int fa = 1;
	public void update() {

		GL11.glEnable(GL11.GL_LIGHT0);
		GL11.glColorMaterial( GL11.GL_FRONT_AND_BACK, GL11.GL_AMBIENT_AND_DIFFUSE);
		
		rotation = 0.60f; // rotation quantity
		c = c + 1*fa;
		nbLignes = c/5;
		
		if(c > 400) fa = -3;
		if(c < 60) { fa = 1; c = 60; }
		if(c < 150 && fa == -3) fa = -2;

		nbPointsParLigne = c/5;
		sphere.MrSphere(nbLignes, nbPointsParLigne); // generates the sphere
		
		GL11.glMatrixMode( GL11.GL_MODELVIEW );
		//GL11.glLoadIdentity();
		//GL11.glTranslatef(0, 0, 0);
		
		//GL11.glRotatef(rotation, .05f, .3f, .9f); // rotation
	    GL11.glClearColor( 1.0f, 1.0f, 1.0f, 1.0f ); // white background
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT); // Screen clear	

		float whiteSpecularLight[] = {1.0f, 1.0f, 1.0f};
		float blackAmbientLight[] = {0.0f, 0.0f, 0.0f};
		float whiteDiffuseLight[] = {1.0f, 1.0f, 1.0f}; 
		
		GL11.glLightf(GL11.GL_LIGHT0, GL11.GL_SPECULAR, 0.5f);
		GL11.glLightf(GL11.GL_LIGHT0, GL11.GL_AMBIENT, 0.5f);
		GL11.glLightf(GL11.GL_LIGHT0, GL11.GL_DIFFUSE, 0.5f);

		matSphere.Identitee();
		float f = (float)Math.sin((float)(frame++)/60) + 0.5f;
		matSphere.Echelle(f, f, f);
		
		System.out.println("-- MAT --");
		
		Matrice4 rot = new Matrice4(); 
		System.out.println(rot.toString());
		//rot.Rotation(f, 0f, 0.5f);
		System.out.println(matSphere.toString());
		
		
		matSphere.multiplyBy(rot);
		
		float a = (float)Math.cos(-2f+(float)(frame++)/100) - 0.5f;
		
		sphere.translationVector = new Vertex(a, 0, a);
		sphere.draw(matSphere);
		

		float s = (float)Math.sin((float)(frame++)/100) + 0.5f;
		s *= 20;
		
		GL11.glBegin(GL11.GL_POLYGON);
			GL11.glColor3f(0, 0, 0);
			GL11.glVertex3f(0, 0, 0);
			GL11.glVertex3f(0, 0, s);
			GL11.glVertex3f(s, 0, s);
			GL11.glVertex3f(s, 0, 0);
		GL11.glEnd();
	}
}
