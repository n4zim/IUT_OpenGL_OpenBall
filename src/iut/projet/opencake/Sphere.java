package iut.projet.opencake;

import java.util.Vector;

public class Sphere {
	Vector<Vertex> points = new Vector<Vertex>();
	
	public void MrSphere(int subSeg, int subPi) {
		for(float a = 0; a < 1; a += 1/subSeg) {
			System.out.println(a);
		}
	}
	
	public static void main(String[] args) {
		Sphere sphere = new Sphere();
		sphere.MrSphere(5, 10);
	}

}
