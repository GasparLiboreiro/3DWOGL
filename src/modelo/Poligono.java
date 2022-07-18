package modelo;

import java.awt.Color;

public class Poligono implements Cloneable{
	public Vector3[] vertices = {null, null, null};
	public ColorCl c;
	public Poligono(Vector3 v0, Vector3 v1, Vector3 v2, ColorCl c) {
		vertices[0] = v0;
		vertices[1] = v1;
		vertices[2] = v2;
		this.c=c;
	}
	@Override
	public Poligono clone() {
	Poligono p=null;
	try {
		p=(Poligono) super.clone();
		p.vertices=this.vertices.clone();
		p.vertices[0]=this.vertices[0].clone();
		p.vertices[1]=this.vertices[1].clone();
		p.vertices[2]=this.vertices[2].clone();
		if(c==null) 
			p.c=null;
		else
			p.c=this.c.clone();
		
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return p;
	}
	
	
	
}
 