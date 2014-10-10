package iut.projet.opencake;

public class Matrice4 {
	public float Vertices[] = new float[16];
	
	public Matrice4() {
		Identitee();
	}
	
	public void Identitee() {
		for(int i = 0; i < 16; i++) {
			Vertices[i] = 0;
			if(i%5 == 0)
				Vertices[i] = 1;
		}
	}
	
    public void Translation(float x, float y, float z) {
        Vertices[3] = x;
        Vertices[7] = y;
        Vertices[11] = z;
    }
    
    public void Echelle(float x, float y, float z) {
        float w = 1;
        // matrice actuelle * vecteur (x,y,z)

        for(int i = 0; i < 4; i++) {
        	Vertices[i] = Vertices[i]*x;
        }
        for(int i = 4; i < 8; i++) {
        	Vertices[i] = Vertices[i]*y;
        }
        for(int i = 8; i < 12; i++) {
        	Vertices[i] = Vertices[i]*z;
        }
        
    }

	public String ToString() {
		String str = "matrice : \n";
		for(int i = 0; i < 16; i++) {
			str += Vertices[i] +  " ";
			if((i+1)%4 == 0)
				str += "\n";
		}
		
		return str;
	}
}
