package iut.projet.opencake;

/**
 * Représente une matrice
 */
public class Matrice4 {
	// Tableau de valeurs
	public float Vertices[] = new float[16];
	
	/**
	 * Construit une matrice identitée par déafaut
	 */
	public Matrice4() {
		Identitee();
	}
	
	/**
	 * Construction de la matrice identité : 
	 *	1	0	0	0
	 *	0	1	0	0
	 *	0	0	1	0
	 *	0	0	0	1
	 */
	public void Identitee() {
		for(int i = 0; i < 16; i++) {
			Vertices[i] = 0;
			if(i%5 == 0)
				Vertices[i] = 1;
		}
	}
	
	/**
	 * Applique une rotation
	 * (ne fonctionne pas)
	 * @param a roll
	 * @param b pitch
	 * @param c yaw
	 */
    public void Rotation(float a, float b, float c) {
    	/*	0	1	2	3
    	 * 	4	5	6	7
    	 * 	8	9	10	11
    	 * 	12	13	14	15
    	 */    	
    	
    	// mat rotation =  mat Roll * mat Pitch *  mat Yaw
    	
    	Matrice4 rotatationMatrix = new Matrice4();
    	Matrice4 rx = new Matrice4();

    	rx.Vertices[5] = (float) (Math.cos(a));
    	rx.Vertices[6] = (float) (-Math.sin(a));

    	rx.Vertices[9] = (float) (Math.sin(a));
    	rx.Vertices[10] = (float) (Math.cos(a));

    	rotatationMatrix.multiplyBy(rx);
    	
    	Matrice4 ry = new Matrice4();
    	ry.Vertices[0] = (float) (Math.cos(b));
    	ry.Vertices[2] = (float) (Math.sin(b));

    	ry.Vertices[8] = (float) (-Math.sin(b));
    	ry.Vertices[10] = (float) (Math.cos(b));
    	
    	rotatationMatrix.multiplyBy(ry);

    	Matrice4 rz = new Matrice4();
    	rz.Vertices[0] = (float) (Math.cos(c));
    	rz.Vertices[1] = (float) (-Math.sin(c));

    	rz.Vertices[4] = (float) (Math.sin(c));
    	rz.Vertices[5] = (float) (Math.cos(c));
    	
    	rotatationMatrix.multiplyBy(rz);
    	
    	Vertices = rotatationMatrix.Vertices;
    }
    
    /**
     * Applique une transformation d'échelle :
     * Matrice * Vecteur d'échelle
     * @param x
     * @param y
     * @param z
     */
    public void Echelle(float x, float y, float z) {       
        multiplyByVector(new Vertex(x, y, z));
    }
    
    /**
     * Retourne le numéro d'une case de la matrice
     * @param i
     * @param j
     * @return
     */
    public static int index(int i, int j) {
    	// numéro de case : 4 * num ligne + num colonne
    	return 4 * j + i;
    }
    
    /**
     * Multiplie la matrice par un vecteur
     * @param vector
     */
    public void multiplyByVector(Vertex vector) {
        for(int i = 0; i < 4; i++) {
        	Vertices[i] = Vertices[i]*vector.x;
        }
        for(int i = 4; i < 8; i++) {
        	Vertices[i] = Vertices[i]*vector.y;
        }
        for(int i = 8; i < 12; i++) {
        	Vertices[i] = Vertices[i]*vector.z;
        }
        for(int i = 12; i < 16; i++) {
        	Vertices[i] = Vertices[i]*vector.w;
        }
    }
    
    /**
     * Multiplie la matrice par une autre
     * @param matriceB
     */
    public void multiplyBy(Matrice4 matriceB) {
    	// Transcription algorithmique d'une multiplicatino de matrices carrées 
    	// C[i,j] = E (n; k=1) { a[i,k] * b[k, j] }
    	// avec ici une taille de matrice fixe (4,4)
    	
    	Matrice4 matriceC = new Matrice4();
    	
    	for(int i = 0; i < 4; i++) {
    		for(int j = 0; j < 4; j++) {
    			float cij = 0;
    			for(int k = 0; k < 4; k++) {
    				cij += this.Vertices[Matrice4.index(i, j)] * matriceB.Vertices[Matrice4.index(k, j)];
    			}

    			matriceC.Vertices[Matrice4.index(i, j)] = cij;
    		}
    	}
    	
    	this.Vertices = matriceC.Vertices;
    }
    
    /**
     * Retourne un string représentant la matrice
     */
	public String toString() {
		String str = "matrice : \n";
		for(int i = 0; i < 16; i++) {
			str += Vertices[i] +  " ";
			if((i+1)%4 == 0)
				str += "\n";
		}
		
		return str;
	}
}
