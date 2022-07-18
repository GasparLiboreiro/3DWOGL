package modelo;

public class Vector3 implements Cloneable {
	public double x, y, z;
	
	public Vector3(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
	}

	@Override
	public Vector3 clone() {
		Vector3 o=null;
		try {
			o=(Vector3) super.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return o;
	}
	
	
	
}
