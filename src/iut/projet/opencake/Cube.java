package iut.projet.opencake;

import java.awt.List;
import java.util.Vector;

import org.lwjgl.opengl.GL11;

public class Cube {
	// Création des points du cube
	Vertex points[] = {
			new Vertex(0,0.5f,0),
			new Vertex(0.5f,0.5f,0),
			new Vertex(0.5f,0,0),
			new Vertex(0,0,0),
			new Vertex(0.5f,0,-.5f),
			new Vertex(0,0,-0.5f),
			new Vertex(0,0.5f,-0.5f),
			new Vertex(0.5f,0.5f,-0.5f)
	};
	
	Face faces[] = {
		new Face(points[0], points[1], points[2], points[3]),	
		new Face(points[0], points[6], points[5], points[3]),
		new Face(points[3], points[2], points[4], points[5]),
		new Face(points[0], points[1], points[7], points[6]),
		new Face(points[6], points[7], points[4], points[5]),
		new Face(points[2], points[4], points[7], points[1])
	};
	
	public Cube() {
	}

	public class Face {
		Vector<Vertex> points = new Vector<Vertex>();
		
		public Face(Vertex v1, Vertex v2, Vertex v3, Vertex v4) {
			points.add(v1);
			points.add(v2);
			points.add(v3);
			points.add(v4);
		}
		
		public void draw() {
			GL11.glBegin(GL11.GL_POLYGON);			// Init d'un nouveau polygone
			for(int i = 0; i < points.size(); i++) {
				points.get(i).draw();
			}
			GL11.glEnd();		// Fin du polygone
		}
	}
	
	public void draw() {
		GL11.glColor3f(0.8f, 0.1f, 0);
		for(int i = 0; i < faces.length; i++) {
			GL11.glColor3f(0.9f*i/faces.length, 0.5f, 0);
			faces[i].draw();
		}
	}
}
