package iut.projet.opencake;

import java.util.Vector;

import org.lwjgl.opengl.GL11;

/**
 * G�nere, g�re et affiche une sph�re de diam�tre 1.
 */
public class Sphere {
	/**
	 * Liste des points composant la sph�re
	 */
	Vector<Vertex> points = new Vector<Vertex>();
	
	/**
	 * Vecteur de translation
	 */
	Vertex translationVector = new Vertex(0,0,0);
	
	/**
	 * Matrice de transformation
	 */
	Matrice4 transformationMatrix = new Matrice4();
	
	/**
	 * Nombre de divisions verticales
	 */
	int nbPointsParLigne;
	
	/**
	 * Vitesse de chute
	 */
	float fallFactor = 0.01f;
	
	/**
	 * Direction de la chute
	 */
	float fallDirection = 1;

	/**
	 * Vitesse de la simulation
	 */
	float speed = 0.003f;
	
	/**
	 * Repr�sente une simulation du temps, incr�ment� de speed � chaque cycle de vie
	 */
	float t = 0;
	
	/**
	 * Coefficient de la chute, ici �gale � la constante de gravit� terreste
	 */
	float g = 9.81f;
	
	/**
	 * Limite bas de position Y
	 */
	float limiteBas = -3f;
	
	/**
	 * Limite haut de position Y
	 */
	float limiteHaut = 3f;	
	
	/**
	 * G�nere la liste des points d'une sph�re
	 * @param Divisions verticales (segments)
	 * @param Divisions par cercle
	 */
	public void MrSphere(int subSeg, int subPi) {
		// Reset liste de points
		points = new Vector<Vertex>();
		
		nbPointsParLigne = subPi;
		
		// Premi�re boucle : division verticale
		for (int divSeg = 0; divSeg <= subSeg; divSeg++) {
			// Calcule la position actuelle sur le premier cercle ("segment")
			float t = (float) Math.PI * divSeg / subSeg;
			
			// Seconde boucle : divisions horizontales
			for(int divPi = 0; divPi <= subPi; divPi++) {
				// Position actuelle sur le cercle
				float b = ((float)divPi * 2 * (float)Math.PI / (float)subPi);
				
				// Calcul des coordonn�es
				float x = (float) Math.sin(t) * (float) Math.cos(b);
				float y = (float) Math.cos(t);
				float z = (float) Math.sin(t) * (float) Math.sin(b);
				
				// Ajoute le point dans la liste
				points.addElement(new Vertex(x, y, z));
			}
		}
	}
	
	/**
	 * Fait tomber l'objet dans une direction verticale donn�e par fallDirection
	 */
	public void fall() {
		// Simultion du temps
		t += speed;

		// calcul de l'acc�l�ration d'un corps ponctuel
		fallFactor = -(float)1/2 * g * t * t * fallDirection;
		
		// Applique l'acc�leration 
		translationVector.y += fallFactor;
		
		// Limites : quand elles sont atteintes, l'objet chute dans l'autre direction
		
		// Limite de position (bas)
		if(translationVector.y < limiteBas) {
			translationVector.y = limiteBas;
			fallDirection *= -1;
			cancelfall();
		}
		
		// Limite de position (hayt)
		if(translationVector.y > limiteHaut) {
			translationVector.y = limiteHaut;
			fallDirection *= -1;
			cancelfall();
		}
	}
	
	/**
	 * Annule la chute (remet le temps � z�ro pour annuler l'acc�l�ration)
	 */
	public void cancelfall() {
		t = 0f;
	}
	
	/**
	 * Dessine la sph�re en appliquant une matrice de transformation et suivant un vecteur de translation interne � la classe (translationVector)
	 * @param transformMatrix
	 */
	public void draw(Matrice4 transformMatrix) {
		// Dessin de la sph�re
		for(int i = 0; i < points.size() - nbPointsParLigne - 1; i++) {
			GL11.glBegin(GL11.GL_POLYGON); // Begin polygon drawing
			
			// Ordre de dessin
			// 4 --- 1
			// |     |
			// 3 --- 2
			
			// 1, point i
			GL11.glColor3f(1, 0, 0);
			Vertex p = points.get(i);
			Vertex pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);

			// 2, point de la ligne en desssous
			GL11.glColor3f(0, 1, 0);
			p = points.get(i + nbPointsParLigne);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			// 3, point suivant de la ligne en dessous
			GL11.glColor3f(0.1f, 0.1f, 0.8f);
			p = points.get(i + nbPointsParLigne + 1);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			// 4, point suivant de la m�me ligne que i
			GL11.glColor3f(1, 1, 1);
			p = points.get(i + 1);
			pt = p.applyTransfrom(transformMatrix, translationVector);
			GL11.glVertex3f(pt.x, pt.y, pt.z);
			
			GL11.glEnd(); // end polygon
		}
	}
}
