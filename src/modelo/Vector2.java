package modelo;

public class Vector2 {
	public double x, y;
	
	public Vector2(double x, double y) {
		this.x=x;
		this.y=y;
	}
	
	public double distancia(Vector2 pos) {
		return Math.sqrt((pos.x-this.x)*(pos.x-this.x) + (pos.y-this.y)*(pos.y-this.y));
	}
}
