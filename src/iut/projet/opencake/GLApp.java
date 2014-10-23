package iut.projet.opencake;

import java.awt.Color;
import java.awt.Font;

import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.GLU;

import sun.font.TrueTypeFont;

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
	float echelleSphere = 2.5f;
	
	Cube cube = new Cube();
	
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
        GLU.gluPerspective(70.0f, 1, 0.01f, 100.0f); 	// crée une perspective
        GL11.glMatrixMode(GL11.GL_MODELVIEW);			// retour au mode d'édition de modèle
       GL11.glEnable(GL11.GL_DEPTH_TEST);
        // Position initiale de la sphère
        sphere.translationVector.x = 0f;
        sphere.translationVector.y = 0f;
        sphere.translationVector.z = -6f;
	}
	
	/**
	 * Cycle de vie
	 * Se charge de la mise à jour graphique de l'app 
	 */
	
	float r = 0;
	boolean activerModeDeplacement = false;
	public void update() {
        sphere.translationVector.z = -6f;
		// Clear screen
		GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

		// Regénération de la sphère
        sphere.MrSphere(nbLignes, nbPointsParLigne);
        
        // Création de la matrice de transformation
        matSphere = new Matrice4();
        matSphere.Echelle(echelleSphere, echelleSphere, echelleSphere); // applique une transformation d'échelle
        
        Matrice4 matRot = new Matrice4();
        if(activerModeDeplacement) matRot.Rotation(r);
        
        matSphere.multiplyBy(matRot);
        
        // Fait chuter la sphère
        	sphere.fall();
        
        // Dessin de la sphère, on lui donne matSphere pour qu'il y applique les transformations
        sphere.draw(matSphere);
        
        r += 0.01f;
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
	
	public void setModeDeplacement(boolean b) {
		activerModeDeplacement = b;
	}
	
	public boolean getModeDeplacement() {
		return activerModeDeplacement;
	}
}