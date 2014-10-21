package iut.projet.opencake;

import java.util.Vector;

import org.lwjgl.opengl.GL11;

public class Sphere {
	Vector<Vertex> points = new Vector<Vertex>();
	Vertex translationVector = new Vertex(0,0,0);
	Matrice4 transformationMatrix = new Matrice4();
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
	
	float fallFactor = 0.01f;
	float fallDirection = 1; 
	float t = 0;
	float ballWeight = 1;
	boolean fallCanceled = false;
	float g = 9.81f;
	float limiteBas = -3f;
	float limiteHaut = 3f;
	
	public void fall() {
		t += 0.003f;


		// calcul de l'accélération d'un corps ponctuel
		fallFactor = -(float)1/2 * g * t * t * fallDirection;
		translationVector.y += fallFactor;
		
		if(translationVector.y < limiteBas) {
			translationVector.y = limiteBas;
			fallDirection *= -1;
			cancelfall();
		}
		
		if(translationVector.y > limiteHaut) {
			translationVector.y = limiteHaut;
			fallDirection *= -1;
			cancelfall();
		}
		
		if(translationVector.y < limiteHaut / 2 && translationVector.y > limiteBas / 2) {
			fallCanceled = false;			
		}
	}
	
	public void cancelfall() {
		//fallFactor = 0f;
		t = 0f;
		fallCanceled = true;
	}
	
	public void draw(Matrice4 transformMatrix) {
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
			Vertex pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);

			// 2, point de la ligne en desssous
			GL11.glColor3f(0,1,0);
			p = points.get(i + nbPointsParLigne);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			// 3, point suivant de la ligne en dessous
			GL11.glColor3f(0.1f,0.1f,0.8f);
			p = points.get(i + nbPointsParLigne + 1);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			// 4, point suivant de la même ligne que i
			GL11.glColor3f(1,1,1);
			p = points.get(i + 1);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			GL11.glEnd(); // end polygon
		}
	}
}
