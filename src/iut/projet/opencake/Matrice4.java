package iut.projet.opencake;

import java.nio.FloatBuffer;

import org.lwjgl.BufferUtils;

import com.sun.corba.se.impl.ior.ByteBuffer;

public class Matrice4 {
	private float vertices[] = new float[16];
	
	public Matrice4() {
		Identitee();
	}
	
	public FloatBuffer GetMatrix() {
		FloatBuffer vVertices = BufferUtils.createFloatBuffer(16*4);
		vVertices.put(vertices);
		vVertices.rewind();
		
		return vVertices;
	}
	
	public void Identitee() {
		for(int i = 0; i < 16; i++) {
			vertices[i] = 0;
			if(i%5 == 0)
				vertices[i] = 1;
		}
	}
	
	public void Translation(float x, float y, float z) {
		
	}
	
	public void Echelle(float x, float y, float z) {
		float w = 1;
		// opération : matrice actuelle * vecteur (x,y,z)

		for(int i = 0; i < 4; i++) {
			vertices[i] = vertices[i]*x;
		}
		for(int i = 4; i < 8; i++) {
			vertices[i] = vertices[i]*y;
		}
		for(int i = 8; i < 12; i++) {
			vertices[i] = vertices[i]*z;
		}
	}
	
	public String ToString() {
		String str = "matrice : \n";
		for(int i = 0; i < 16; i++) {
			str += vertices[i] +  " ";
			if((i+1)%4 == 0)
				str += "\n";
		}
		
		return str;
	}
}
