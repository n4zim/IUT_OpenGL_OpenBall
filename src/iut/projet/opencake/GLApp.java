package iut.projet.opencake;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	//float rotation = 0.0f;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
	}
	
	public void start() {
		/*GL11.glEnable(GL11.GL_DEPTH_TEST);		// Init de la 3D
		GL11.glMatrixMode(GL11.GL_PROJECTION);	// Projection orthogonale
		GL11.glLoadIdentity();			*/		// Charge une matrice vierge
	}
	
	// Création des points du cube
	/*Vertex a = new Vertex(0,0.5f,0);
	Vertex b = new Vertex(0.5f,0.5f,0);
	Vertex c = new Vertex(0.5f,0,0);
	Vertex d = new Vertex(0,0,0);
	Vertex e = new Vertex(0.5f,0,-.5f);
	Vertex f = new Vertex(0,0,-0.5f);
	Vertex g = new Vertex(0,0.5f,-0.5f);
	Vertex h = new Vertex(0.5f,0.5f,-0.5f);*/
	
	// Dessine une face
	/*private void drawFace(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
		GL11.glBegin(GL11.GL_POLYGON);			// Init d'un nouveau polygone
		v1.draw();
		v2.draw();
		v3.draw();
		v4.draw();
		GL11.glEnd();		// Fin du polygone
	}
	*/
	
	 final double PI       = Math.PI;
     final double TWOPI = PI * 2;
     final double PID2       = TWOPI/2;
	
	// Version Nazim
	void CreateSphere(Vertex c, double r, int n) {
	   int i,j;
	   double theta1,theta2,theta3;
	   Vertex e = null, p = null;

	   if (r < 0)
	      r = -r;
	   if (n < 0)
	      n = -n;
	   if (n < 4 || r <= 0) {
	      GL11.glBegin(GL11.GL_POINTS);
	      GL11.glVertex3d(c.x,c.y,c.z);
	      GL11.glEnd();
	      return;
	   }

	   for (j=0;j<n/2;j++) {
	      theta1 = j * TWOPI / n - PID2;
	      theta2 = (j + 1) * TWOPI / n - PID2;

	      GL11.glBegin(GL11.GL_QUAD_STRIP);
	      for (i=0;i<=n;i++) {
	         theta3 = i * TWOPI / n;

	         e.x = Math.cos(theta2) * Math.cos(theta3);
	         e.y = Math.sin(theta2);
	         e.z = Math.cos(theta2) * Math.sin(theta3);
	         p.x = c.x + r * e.x;
	         p.y = c.y + r * e.y;
	         p.z = c.z + r * e.z;

	         GL11.glNormal3d(e.x,e.y,e.z);
	         GL11.glTexCoord2d(i/(double)n,2*(j+1)/(double)n);
	         GL11.glVertex3d(p.x,p.y,p.z);

	         e.x = Math.cos(theta1) * Math.cos(theta3);
	         e.y = Math.sin(theta1);
	         e.z = Math.cos(theta1) * Math.sin(theta3);
	         p.x = c.x + r * e.x;
	         p.y = c.y + r * e.y;
	         p.z = c.z + r * e.z;

	         GL11.glNormal3d(e.x,e.y,e.z);
	         GL11.glTexCoord2d(i/(double)n,2*j/(double)n);
	         GL11.glVertex3d(p.x,p.y,p.z);
	      }
	      GL11.glEnd();
	   }
	}
	
	public void update() {
		
		CreateSphere(new Vertex(0, 0.5f, 0), 20, 3);
		
		/*
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
		*/
	}
}
