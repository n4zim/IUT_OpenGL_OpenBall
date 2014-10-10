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
