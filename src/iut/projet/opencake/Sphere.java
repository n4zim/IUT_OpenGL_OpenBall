package iut.projet.opencake;

import java.util.Vector;

import org.lwjgl.opengl.GL11;

public class Sphere {
	Vector<Vertex> points = new Vector<Vertex>();
	int nbPointsParLigne;
	
	public void MrSphere(int subSeg, int subPi) {
		points = new Vector<Vertex>();
		nbPointsParLigne = subPi;
		
		for (int divSeg = 0; divSeg <= subSeg; divSeg++) {
			float t = (float) Math.PI * divSeg / subSeg;
			
			for(int divPi = 0; divPi <= subPi; divPi++) {
				float b = ((float)divPi * 2 * (float)Math.PI / (float)subPi);
				float x = (float) Math.sin(t) * (float) Math.cos(b);
				float y = (float) Math.cos(t);
				float z = (float) Math.sin(t) * (float) Math.sin(b);
				
				points.addElement(new Vertex(x, y, z));
			}
		}
	}
	
	public void Draw() {
		// Dessin de la sphère
		for(int i = 0; i < points.size() - nbPointsParLigne - 1; i++) {
			GL11.glBegin(GL11.GL_POLYGON); // Begin polygon drawing
			
			// Drawiwng order :
			// 4 --- 1
			// |     |
			// 3 --- 2
			
			// 1, point i
			GL11.glColor3f(1,0,0);
			Vertex p = points.get(i);
			GL11.glVertex3f(p.x, p.y, p.z);

			// 2, point de la ligne en desssous
			GL11.glColor3f(0,1,0);
			p = points.get(i + nbPointsParLigne);
			GL11.glVertex3f(p.x, p.y, p.z);
			
			// 3, point suivant de la ligne en dessous
			GL11.glColor3f(0,0,1);
			p = points.get(i + nbPointsParLigne + 1);
			GL11.glVertex3f(p.x, p.y, p.z);
			
			// 4, point suivant de la même ligne que i
			GL11.glColor3f(1,0,1);
			p = points.get(i + 1);
			GL11.glVertex3f(p.x, p.y, p.z);
			
			GL11.glEnd(); // end polygon
		}
	}
}
