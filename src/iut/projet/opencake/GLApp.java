package iut.projet.opencake;

import java.util.List;

import org.lwjgl.opengl.GL11;

public class GLApp {
	MyDisplay display;
	float rotation = 0.0f;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
	}
	
	public void start() {
		GL11.glEnable(GL11.GL_DEPTH_TEST);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		//GL11.glOrtho(0, 800, 0, 600, 1, -1);
		//GL11.glMatrixMode(GL11.GL_MODELVIEW);
		//GL11.glRotatef(0.5f, .1f, .0f, 0);
	}
	
	class Vertex {
		float x,y,z;
		public Vertex(float x, float y, float z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		public void draw() {
			GL11.glVertex3f(x,y,z);
		}
	}
	
	Vertex a = new Vertex(0,0.5f,0);
	Vertex b = new Vertex(0.5f,0.5f,0);
	Vertex c = new Vertex(0.5f,0,0);
	Vertex d = new Vertex(0,0,0);
	Vertex e = new Vertex(0.5f,0,-.5f);
	Vertex f = new Vertex(0,0,-0.5f);
	Vertex g = new Vertex(0,0.5f,-0.5f);
	Vertex h = new Vertex(0.5f,0.5f,-0.5f);
	
	private void drawFace(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
		v1.draw();
		v2.draw();
		v3.draw();
		v4.draw();
	}
	
	public void update() {
		//rotation += 0.001f;
		rotation = 0.20f;
		//System.out.println(rotation);
		//if(rotation > 1) rotation = 0;
		
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT|GL11.GL_DEPTH_BUFFER_BIT);
		
		//GL11.glRotatef(rotation, .0f, 1.0f, .0f);
		GL11.glRotatef(0.05f, .1f, .5f, 0);
		
		GL11.glBegin(GL11.GL_POLYGON);
		
		GL11.glColor3f( .0f, .0f, 1.0f );
		drawFace(a,b,c,d);
		GL11.glColor3f( 1.0f, .0f, 1.0f );
		drawFace(a,g,f,d);
		GL11.glColor3f( .0f, 1.0f, 1.0f );
		drawFace(a,b,h,g);
		
		GL11.glColor3f( .0f, 1.0f, 1.0f );
		//drawFace(d,c,e,f);
		GL11.glColor3f( 1.0f, .0f, .0f );
		//drawFace(g,h,e,f);
		GL11.glColor3f( 1.0f, 1.0f, 1.0f );
		//drawFace(c,e,h,b);
		
		
		GL11.glEnd();
		
		
	}
}
