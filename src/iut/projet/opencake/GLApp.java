package iut.projet.opencake;

import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL40;
import org.lwjgl.opengl.GLUConstants;
import org.lwjgl.util.glu.GLU;

public class GLApp {
	MyDisplay display;
	Cube cube = new Cube();
	float rotation = 0.0f;
	float a = -1f;
	int factor = 1;
	Sphere sphere;
	int nbLignes = 50;
	int nbPointsParLigne = 40;
	int frame = 0;
	Matrice4 matSphere = new Matrice4();
	int c = 1;
	int fa = 1;
	
	public GLApp(MyDisplay display) {
		this.display = display; 
		sphere = new Sphere();
	}
	
	public void start() {

        GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GLU.gluPerspective(45.0f, 1, 0.01f, 100.0f);
        //GL11.glOrtho(-10, 10, -10, 10, 0.01f, 100.0f);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
        
        sphere.translationVector.z = -6f;
        sphere.translationVector.y = 5f;
	}
	
	public void update() {
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
        
        
        sphere.MrSphere(nbLignes, nbPointsParLigne);
        sphere.translationVector.z = -9f;
        matSphere = new Matrice4();
        //matSphere.Echelle(2f, 2f, 2f);
                
        sphere.draw(matSphere);
        sphere.fall();
	}
	

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
}
