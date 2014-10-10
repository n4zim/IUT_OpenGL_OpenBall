package iut.projet.opencake;

import java.util.Vector;

public class Sphere {
	Vector<Vertex> points = new Vector<Vertex>();
	
	public void MrSphere(int subSeg, int subPi) {
		points = new Vector<Vertex>();
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
}
