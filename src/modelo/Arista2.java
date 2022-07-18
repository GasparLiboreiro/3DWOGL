package modelo;

public class Arista2 {
	public Vector2[] vertices = {null,null};
	
	public Arista2(Vector2 v1, Vector2 v2) {
		vertices[0]=v1;
		vertices[1]=v2;
	}
	
	public double getHeight() {
		return Math.abs(vertices[1].y-vertices[0].y);
	}
	public double getWidth() {
		return Math.abs(vertices[1].x-vertices[0].x);
	}
	
	public Vector2 top() {
		Vector2 ret=vertices[1];
		if(vertices[0].y<vertices[1].y)
			ret=vertices[0];
		return ret;
	}
	public Vector2 bott() {
		Vector2 ret=vertices[1];
		if(vertices[0].y>vertices[1].y)
			ret=vertices[0];
		return ret;
	}
}
