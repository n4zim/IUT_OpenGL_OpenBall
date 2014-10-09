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
		
		int nbLignes = 2;
		int nbPointsParLigne = 3;
		sphere.MrSphere(nbLignes, nbPointsParLigne);
	
		GL11.glRotatef(rotation, .05f, .2f, 0.8f);
	    GL11.glClearColor( 1.0f, 1.0f, 1.0f, 1.0f );
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);	// Clear de l'écran
			

		for(int i = 0; i < sphere.points.size() - nbPointsParLigne - 1; i++) {
			GL11.glColor3f(- 1*i, 0.8f*(1-i), 0.531f*i );
			
			GL11.glBegin(GL11.GL_POLYGON);

			GL11.glColor3f(1,0,0);
			Vertex p = sphere.points.get(i);
			GL11.glVertex3f(p.x, p.y, p.z);

			GL11.glColor3f(0,1,0);
			p = sphere.points.get(i + nbPointsParLigne);
			GL11.glVertex3f(p.x, p.y, p.z);

			GL11.glColor3f(0,0,1);
			p = sphere.points.get(i + nbPointsParLigne + 1);
			GL11.glVertex3f(p.x, p.y, p.z);

			GL11.glColor3f(1,0,1);
			p = sphere.points.get(i + 1);
			GL11.glVertex3f(p.x, p.y, p.z);
			
			GL11.glEnd();
			
			/*i++;
			GL11.glVertex3f(sphere.points.get(i).x, sphere.points.get(i).y, sphere.points.get(i).z);
			i++;
			GL11.glVertex3f(sphere.points.get(i).x, sphere.points.get(i).y, sphere.points.get(i).z);
			i++;*/
			//GL11.glVertex3f(sphere.points[i].x, sphere.points[i].y, sphere.points[i].z);
			
		}
		
/*
		GL11.glBegin(GL11.GL_POINTS);
		GL11.glColor3f( 0.95f, 0.207f, 0.031f );
		for (Vertex pt : sphere.points) {
			GL11.glVertex3f(pt.x, pt.y, pt.z);
		}
		GL11.glEnd();*/
		
		//cube.draw();
		//plane.draw();
	}
}
