package modelo;

import java.awt.Color;
import java.awt.color.ColorSpace;

public class ColorCl extends Color implements Cloneable {

	public ColorCl(ColorSpace cspace, float[] components, float alpha) {
		super(cspace, components, alpha);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(float r, float g, float b, float a) {
		super(r, g, b, a);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(float r, float g, float b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(int rgba, boolean hasalpha) {
		super(rgba, hasalpha);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(int r, int g, int b, int a) {
		super(r, g, b, a);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(int r, int g, int b) {
		super(r, g, b);
		// TODO Auto-generated constructor stub
	}

	public ColorCl(int rgb) {
		super(rgb);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected ColorCl clone(){
	ColorCl c=null;
	try {
		c=(ColorCl) super.clone();
	} catch (CloneNotSupportedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		return c;
	}

	
}
