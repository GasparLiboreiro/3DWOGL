package modelo;


import java.util.ArrayList;

public class Cubo extends Objeto{ 	
	
	public Cubo(Vector3 pos, Vector3 tam, Vector3 inc, ColorCl c) {
		super(pos, tam, inc);
		int[] array = {0, 0, 0};
		ArrayList<Vector3> vertices = new ArrayList<Vector3>();
		for(int x = 0; x < 8; x++) {               // Math.pow(2, array.length) x < 8     2*2*2 = 8
			
			vertices.add(new Vector3(tam.x*array[0]-tam.x/2, tam.y*array[1]-tam.y/2, tam.z*array[2]-tam.z/2));
			
			
			int l = array.length - 1;                                              // 2 = n-1   "n" siendo la cantidad de bits a usar
			boolean stop;
			do {
				stop=true;
				if(l>=0) {
					if(array[l] == 0) {
						array[l] = 1;
					}
					else {
						array[l] = 0;
						stop=false;
						l--;
					}
				}
				else {
					array[0] = 0;
					array[1] = 0;
					array[2] = 0;
				}
			} while(!stop);
		}
		/*
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(1), vertices.get(2), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(1), vertices.get(2), vertices.get(3), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(2), vertices.get(6), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(6), vertices.get(7), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(5), vertices.get(7), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(1), vertices.get(3), vertices.get(5), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(1), vertices.get(5), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(4), vertices.get(5), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(4), vertices.get(5), vertices.get(7), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(4), vertices.get(6), vertices.get(7), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(2), vertices.get(4), vertices.get(6), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(2), vertices.get(4), new ColorCl((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255))));
		*/
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(1), vertices.get(2), c));
		super.addPoligono(new Poligono(vertices.get(1), vertices.get(2), vertices.get(3), c));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(2), vertices.get(6), c));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(6), vertices.get(7), c));
		super.addPoligono(new Poligono(vertices.get(3), vertices.get(5), vertices.get(7), c));
		super.addPoligono(new Poligono(vertices.get(1), vertices.get(3), vertices.get(5), c));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(1), vertices.get(5), c));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(4), vertices.get(5), c));
		super.addPoligono(new Poligono(vertices.get(4), vertices.get(5), vertices.get(7), c));
		super.addPoligono(new Poligono(vertices.get(4), vertices.get(6), vertices.get(7), c));
		super.addPoligono(new Poligono(vertices.get(2), vertices.get(4), vertices.get(6), c));
		super.addPoligono(new Poligono(vertices.get(0), vertices.get(2), vertices.get(4), c));
		
	}
	
}
