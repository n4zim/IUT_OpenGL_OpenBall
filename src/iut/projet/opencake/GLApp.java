package iut.projet.opencake;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GLUConstants;
import org.lwjgl.util.glu.GLU;

/**
 * Décrit l'application
 */
public class GLApp {
	/**
	 * Handle sur la fenêtre
	 */
	MyDisplay display;
	
	/**
	 * Objet : sphère
	 */
	Sphere sphere;
	
	/**
	 * Nombre de divisions verticales
	 */
	int nbLignes = 50;
	
	/**
	 * Nombre de subdivisions de cercle
	 */
	int nbPointsParLigne = 40;
	
	/**
	 * Matrice de transformation de la sphère
	 */
	Matrice4 matSphere = new Matrice4();
	
	/**
	 * Échelle de la sphère
	 */
	float echelleSphere = 1.0f;
	
	/**
	 * Initialise l'application en créant une nouvelle sphère
	 * @param display
	 */
	public GLApp(MyDisplay display) {
		this.display = display; 
		sphere = new Sphere();
	}
	
	/**
	 * Initialisation du contexte OpenGL
	 */
	public void start() {
        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f); 		// couleur de fond
        GL11.glMatrixMode(GL11.GL_PROJECTION); 			// mode d'édition de la projection
        GLU.gluPerspective(45.0f, 1, 0.01f, 100.0f); 	// crée une perspective
        GL11.glMatrixMode(GL11.GL_MODELVIEW);			// retour au mode d'édition de modèle
        
        // Position initiale de la sphère
        sphere.translationVector.z = -6f;
        sphere.translationVector.y = 5f;
        sphere.translationVector.z = -9f;
	}
	
	/**
	 * Cycle de vie
	 * Se charge de la mise à jour graphique de l'app 
	 */
	public void update() {
		// Clear screen
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        
		// Regénération de la sphère
        sphere.MrSphere(nbLignes, nbPointsParLigne);
        
        // Création de la matrice de transformation
        matSphere = new Matrice4();
        matSphere.Echelle(echelleSphere, echelleSphere, echelleSphere); // applique une transformation d'échelle

        // Fait chuter la sphère
        sphere.fall();
        
        // Dessin de la sphère, on lui donne matSphere pour qu'il y applique les transformations
        sphere.draw(matSphere);
	}
	
	/* GETTERS ET SETTERS */
	
	public Float getBottomWall() {
		return sphere.limiteBas;
	}
	
	public void setBottomWall(Float v) {
		sphere.limiteBas = v;
	}
	
	public Float getTopWall() {
		return sphere.limiteHaut;
	}
	
	public void setTopWall(Float v) {
		sphere.limiteHaut = v;
	}

	public Float getAnimSpeed() {
		return sphere.speed;
	}
	
	public void setAnimSpeed(Float s) {
		sphere.speed = s;
	}
	
	public Integer getNbLignes() {
		return nbLignes;
	}
	
	public void setNbLignes(Integer n) {
		nbLignes = n;
	}
	
	public Integer getNbPointsParLigne() {
		return nbPointsParLigne;
	}
	
	public void setNbPointsParLigne(Integer n) {
		nbPointsParLigne = n;
	}
	
	public void setEchelle(Float f) {
		echelleSphere = f;
	}
	
	public Float getEchelle() {
		return echelleSphere;
	}
}