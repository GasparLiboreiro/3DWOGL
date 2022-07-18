package modelo;

import java.awt.Color;
import java.util.ArrayList;

public class Objeto implements Cloneable {
	public ArrayList<Poligono> poligonos = new ArrayList<Poligono>();
//	public ArrayList<Vector3> vertices = new ArrayList<Vector3>();
	private Vector3 posicion, tam, inclinacion;
	

	public Objeto(Vector3 pos, Vector3 tam, Vector3 inclinacion) {
		this.posicion = pos;
		this.tam = tam;
		this.inclinacion = inclinacion;
	
		if (pos == null) {
			this.posicion = new Vector3(0, 0, 0);

		}
		if (tam == null) {
			this.tam = new Vector3(1, 1, 1);

		}
		if (inclinacion == null) {
			this.inclinacion = new Vector3(0, 0, 0);
		}
	}

	public Vector3 getInclinacion() {
		return inclinacion;
	}

	public void setInclinacion(Vector3 inclinacion) {
		this.inclinacion = inclinacion;
	}

	public Vector3 getPosicion() {
		return this.posicion;
	}

	public void setPosicion(Vector3 posicion) {
		this.posicion = posicion;
	}

	public Vector3 getTam() {
		return tam;
	}

	public void setTam(Vector3 tam) {
		this.tam = tam;
	}

	public ArrayList<Poligono> getPoligonos() {
		return poligonos;
	}

	public void addPoligono(Poligono p) {
		this.poligonos.add(p);
	}

	
	@Override
	public Object clone() {
		Objeto o = null;
		try {
			o = (Objeto) super.clone();
			o.inclinacion=this.inclinacion.clone();
			o.posicion=this.posicion.clone();
			o.tam=this.tam.clone();
			o.poligonos=(ArrayList<Poligono>) this.poligonos.clone();
	//		o.vertices=(ArrayList<Vector3>) this.vertices.clone();
			o.poligonos.clear();
			for(int i=0;i<this.poligonos.size();i++)
				o.poligonos.add(this.poligonos.get(i).clone());
	//		o.vertices.clear();
	//		for(int i=0;i<this.vertices.size();i++)
	//			o.vertices.add(this.vertices.get(i).clone());
			
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return o;
	}

}