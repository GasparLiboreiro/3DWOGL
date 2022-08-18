package vista;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JPanel;

import modelo.Arista2;
import modelo.ColorCl;
import modelo.Cubo;
import modelo.Objeto;
import modelo.Poligono;
import modelo.Vector2;
import modelo.Vector3;

public class PanelJuego extends JPanel{
	
	private Vector3 pos = 			new Vector3(0,0,0); //donde spawneas
	private Vector3 inclinacion =	new Vector3(0,0,0);
	public double velocidad = 0.2;
	
	
	public ArrayList<Objeto> escena = new ArrayList<Objeto>();
	public double D1 = 3;
	
	public void addX(double cantidad) {
		pos.x+=cantidad;
	}
	public void addY(double cantidad) {
		pos.y+=cantidad;
	}
	public void addZ(double cantidad) {
		pos.z+=cantidad;
	}
	
	public PanelJuego() {
		//escena.add(new Cubo(new Vector3(0,0,0), new Vector3(0.1,0.1,0.1), new Vector3(0,0,0), null));
		escena.add(new Cubo(new Vector3(0,0,4), new Vector3(1,1,1), new Vector3(0,0,0), null));//new ColorCl(50,200,200)
		
		

		/*
		for(double x=-10; x<11; x++) {
			for(double y=-10; y<11; y++) {
				escena.add(new Cubo(new Vector3(1.5*x, 1.5*y, 0), new Vector3(1,1,1), new Vector3(x/20,0,y/20), null));
			}
		}
		*/
		
		
		
		/*
		double aumento=0.1, radio=10;
		
		for(double x=1; x<1/aumento; x++) {
			for(double y=0; y<2/aumento; y++) {
				ColorCl color = null;
					
				escena.add(new Cubo(new Vector3(Math.cos(aumento*y*Math.PI)*Math.sin(aumento*x*Math.PI)*radio,
						Math.cos(aumento*x*Math.PI)*radio,
						Math.sin(aumento*y*Math.PI)*Math.sin(aumento*x*Math.PI)*radio)
						
						, new Vector3(1,1,1), new Vector3(0,0,0), color));
			}
		}
		escena.add(new Cubo(new Vector3(Math.cos(0)*Math.sin(0)*radio,
				Math.cos(0)*radio,
				Math.sin(0)*Math.sin(0)*radio)
				, new Vector3(1,1,1), new Vector3(0,0,0),null));

		escena.add(new Cubo(new Vector3(Math.cos(0)*Math.sin(0)*radio,
				Math.cos(1 * Math.PI)*radio,
				Math.sin(0)*Math.sin(0)*radio)
				, new Vector3(1,1,1), new Vector3(0,0,0),null));
		*/
		/*
		double aumentox=0.05, aumentoy=0.1, r1=20, r2=5;
		for(double x=0; x<2/aumentox; x++) {
			for(double y=0; y<2/aumentoy; y++) {
				escena.add(new Cubo(new Vector3(
						
						Math.cos(aumentox*x*3.1415926535)*(r1-Math.cos(aumentoy*y*3.1415926535)*r2),
						Math.sin(aumentoy*y*3.1415926535)*r2,
						Math.sin(aumentox*x*3.1415926535)*(r1-Math.cos(aumentoy*y*3.1415926535)*r2) ), 
						
						new Vector3(1,1,1), new Vector3(0,0,0), null));
			}
		}*/
		/*
		for(double x=2; x<7; x++) {
			double cambio = 1/x;
			escena.add(newEsfera(new Vector3(x*4,0,0), new Vector3(1,1,1), new Vector3(0,0,0), 2, cambio, new ColorCl((int)((255/7)*x),(int)((255/7)*(7-x)),(int)((255/7)*x))));
		}*/

		// escena.add(newEsfera(new Vector3(0,0,0), new Vector3(1,1,1), new Vector3(0,0,0), 5, 0.1, null));//new ColorCl(255,255,255)

		// escena.add(this.newNoSe(new Vector3(0,0,0), null, null, 40, 40, null));
		// escena.add(this.newNoSe(new Vector3(0,10,0), null, null, 40, 40, new ColorCl(0,100,255)));
		
		/*pos=new Vector3(0,5,-23);
		escena.add(this.newEsferaTest(new Vector3(-10,0,40), null, new Vector3(-0.25,-0.25,0.5), 10, 0.04, new ColorCl(200,150,0))); //new ColorCl(200,150,0)
		escena.add(this.newNoSe(new Vector3(0,10,0), null, null, 40, 40, new ColorCl(0,100,255)));								//new ColorCl(0,100,255)
		escena.add(this.newNoSe(new Vector3(0,-10,0), null, new Vector3(-0.5,0,0), 100, 40, new ColorCl(100,100,100)));				//new ColorCl(100,100,100)
		*/
		
	}
	
	
	private Objeto newEsfera(Vector3 pos, Vector3 tam, Vector3 inclinacion, double radio, double aumento, ColorCl c) {
		Objeto esfera = new Objeto(pos,tam,inclinacion);
		ArrayList<ArrayList<Vector3>> vertices = new ArrayList<ArrayList<Vector3>>();
		ArrayList<Vector3> linea = new ArrayList<Vector3>();
		for(double x=1; x<1/aumento; x++) {
			linea.clear();
			for(double y=0; y<2/aumento; y++) {
				linea.add(new Vector3(Math.cos(aumento*y*3.1415926535879)*Math.sin(aumento*x*3.1415926535879)*radio,
						Math.cos(aumento*x*3.1415926535879)*radio,
						Math.sin(aumento*y*3.1415926535879)*Math.sin(aumento*x*3.1415926535879)*radio));
			}
			vertices.add((ArrayList<Vector3>) linea.clone());
		}
		
		for(int x=0; x<(vertices.size())-1; x++) {
			for(int y=0; y<(vertices.get(x).size())-1; y++) {
				esfera.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x).get(y+1), vertices.get(x+1).get(y+1), c));
				esfera.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x+1).get(y), vertices.get(x+1).get(y+1), c));
			}
		}
		for(int x=0; x<(vertices.size())-1; x++) {
			esfera.poligonos.add(new Poligono(vertices.get(x).get(linea.size()-1), vertices.get(x+1).get(linea.size()-1), vertices.get(x+1).get(0), c));
			esfera.poligonos.add(new Poligono(vertices.get(x).get(linea.size()-1), vertices.get(x).get(0), vertices.get(x+1).get(0), c));
		}
		for(int x=0; x<(linea.size())-1; x++) {
			esfera.poligonos.add(new Poligono(vertices.get(0).get(x), vertices.get(0).get(x+1), 
					new Vector3(Math.cos(0)*Math.sin(0)*radio,Math.cos(0)*radio,Math.sin(0)*Math.sin(0)*radio), c));
			esfera.poligonos.add(new Poligono(vertices.get((vertices.size())-1).get(x), vertices.get((vertices.size())-1).get(x+1), 
					new Vector3(Math.cos(Math.PI)*Math.sin(Math.PI)*radio,Math.cos(Math.PI)*radio,Math.sin(Math.PI)*Math.sin(Math.PI)*radio), c));
		}
		return esfera;
	}
	
	private Objeto newEsferaTest(Vector3 pos, Vector3 tam, Vector3 inclinacion, double radio, double aumento, ColorCl c) {
		Objeto esfera = new Objeto(pos,tam,inclinacion);
		ColorCl copia = c;
		ArrayList<ArrayList<Vector3>> vertices = new ArrayList<ArrayList<Vector3>>();
		ArrayList<Vector3> linea = new ArrayList<Vector3>();
		for(double x=1; x<1/aumento; x++) {
			linea.clear();
			for(double y=0; y<2/aumento; y++) {
				linea.add(new Vector3(Math.cos(aumento*y*3.1415926535879)*Math.sin(aumento*x*3.1415926535879)*(radio + Math.sin(((y/(2/aumento)*16)*Math.PI))/2),
						Math.cos(aumento*x*3.1415926535879)*(radio + Math.sin(((y/(2/aumento)*16)*Math.PI))/2),
						Math.sin(aumento*y*3.1415926535879)*Math.sin(aumento*x*3.1415926535879)*(radio + Math.sin(((y/(2/aumento)*16)*Math.PI))/2)));
			}
			vertices.add((ArrayList<Vector3>) linea.clone());
		}
		
		for(int x=0; x<(vertices.size())-1; x++) {
			for(int y=0; y<(vertices.get(x).size())-1; y++) {
				ColorCl color = null;
				if(c!=null) {
					color = new ColorCl((int)(c.getRed()*((double)(x)/(vertices.size()-1))), (int)(c.getGreen()*((double)(x)/(vertices.size()-1))), (int)(c.getBlue()*((double)(x)/(vertices.size()-1))));
				}
				esfera.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x).get(y+1), vertices.get(x+1).get(y+1), color));
				esfera.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x+1).get(y), vertices.get(x+1).get(y+1), color));
			}
		}
		c=copia;
		for(int x=0; x<(vertices.size())-1; x++) {
			ColorCl color = null;
			if(c!=null) {
				color = new ColorCl((int)(c.getRed()*((double)(x)/(vertices.size()-1))), (int)(c.getGreen()*((double)(x)/(vertices.size()-1))), (int)(c.getBlue()*((double)(x)/(vertices.size()-1))));
			}
			esfera.poligonos.add(new Poligono(vertices.get(x).get(linea.size()-1), vertices.get(x+1).get(linea.size()-1), vertices.get(x+1).get(0), color));
			esfera.poligonos.add(new Poligono(vertices.get(x).get(linea.size()-1), vertices.get(x).get(0), vertices.get(x+1).get(0), color));
		}
		for(int x=0; x<(linea.size()); x++) {
			ColorCl color = null;
			if(c!=null)
				color = new ColorCl(0,0,0);
			if(x<(linea.size()-1)) {
				esfera.poligonos.add(new Poligono(vertices.get(0).get(x), vertices.get(0).get(x+1), 
						new Vector3(Math.cos(0)*Math.sin(0)*radio,Math.cos(0)*radio,Math.sin(0)*Math.sin(0)*radio), color));
				esfera.poligonos.add(new Poligono(vertices.get((vertices.size())-1).get(x), vertices.get((vertices.size())-1).get(x+1), 
						new Vector3(Math.cos(Math.PI)*Math.sin(Math.PI)*radio,Math.cos(Math.PI)*radio,Math.sin(Math.PI)*Math.sin(Math.PI)*radio), c));
			}
			else {
				esfera.poligonos.add(new Poligono(vertices.get(0).get(vertices.get(0).size()-1), vertices.get(0).get(0), 
						new Vector3(Math.cos(0)*Math.sin(0)*radio,Math.cos(0)*radio,Math.sin(0)*Math.sin(0)*radio), color));
				esfera.poligonos.add(new Poligono(vertices.get((vertices.size())-1).get(vertices.get((vertices.size())-1).size()-1), vertices.get((vertices.size())-1).get(0), 
						new Vector3(Math.cos(Math.PI)*Math.sin(Math.PI)*radio,Math.cos(Math.PI)*radio,Math.sin(Math.PI)*Math.sin(Math.PI)*radio), c));
			}
		}
		return esfera;
	}
	
	private Objeto newNoSe(Vector3 pos, Vector3 tam, Vector3 inclinacion, int anch, int alt, ColorCl c) {
		Objeto out = new Objeto(pos,tam,inclinacion);

		ArrayList<ArrayList<Vector3>> vertices = new ArrayList<ArrayList<Vector3>>();
		ArrayList<Vector3> linea = new ArrayList<Vector3>();
		for(double x=0; x<alt; x++) {
			linea.clear();
			for(double y=0; y<anch; y++) {
				linea.add(new Vector3(
						x-alt/2,
						Math.sin(((x+(y/2))/10)*Math.PI), //
						y-anch/2));
			}
			vertices.add((ArrayList<Vector3>) linea.clone());
		}
		for(int x=0; x<vertices.size()-1; x++) {
			for(int y=0; y<(vertices.get(x).size())-1; y++) {
				ColorCl color = null;
				if(c!=null) 
					color=new ColorCl((int)(c.getRed()*((double)(x)/vertices.size())), (int)(c.getGreen()*((double)(x)/vertices.size())), (int)(c.getBlue()*((double)(x)/vertices.size())));
				out.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x).get(y+1), vertices.get(x+1).get(y+1), color));
				out.poligonos.add(new Poligono(vertices.get(x).get(y), vertices.get(x+1).get(y), vertices.get(x+1).get(y+1), color));
			}
		}
		return out;
	}
	
	
	
	private double inclinacion2D(double y, double x) {
		double inclinacion=0;
	//	System.out.println("input x:"+x+" y:"+y);
		if(x!=0) {
			inclinacion = Math.atan(y / x);
			
			if(x<0)
				inclinacion+=Math.PI;
		}
		else if(y>0)
			inclinacion = 0.5 * Math.PI;
		else if(y<=0)
			inclinacion = 1.5 * Math.PI;
		
		
		return inclinacion;
	}
	
	
	
	private Poligono poligonoEnPantalla(Poligono poligono, Objeto obj) {
		Poligono out = poligono.clone();
		double angFinal, distancia;
		for(int x=0; x<3; x++) {
			angFinal=inclinacion2D(out.vertices[x].z, out.vertices[x].x)  +  obj.getInclinacion().x * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].x,2) + Math.pow(out.vertices[x].z,2));
			out.vertices[x].x=Math.cos(angFinal)*distancia;
			out.vertices[x].z=Math.sin(angFinal)*distancia;
			
			// rotacion Y (y ; z)

			angFinal=inclinacion2D(out.vertices[x].y, out.vertices[x].z)  +  obj.getInclinacion().y * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].z,2) + Math.pow(out.vertices[x].y,2));
			out.vertices[x].z=Math.cos(angFinal)*distancia;
			out.vertices[x].y=Math.sin(angFinal)*distancia;
			

			// rotacion Z (y ; x)

			angFinal=inclinacion2D(out.vertices[x].y, out.vertices[x].x)  +  obj.getInclinacion().z * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].x,2) + Math.pow(out.vertices[x].y,2));
			out.vertices[x].x=Math.cos(angFinal)*distancia;
			out.vertices[x].y=Math.sin(angFinal)*distancia;

			out.vertices[x].x+=obj.getPosicion().x;
			out.vertices[x].y+=obj.getPosicion().y;
			out.vertices[x].z+=obj.getPosicion().z;
			
			out.vertices[x].x-=this.pos.x;      //muevo el vertice para que 0;0;0 equivalga la posicion de la camara, para poder rotar apropiadamente
			out.vertices[x].y-=this.pos.y;      // esto es para poder rotar el mundo al rededor tuyo
			out.vertices[x].z-=this.pos.z;      // al terminar, deveria sumar al resultado mi posicion para que vuelva a la normalidad, no lo hago ya que para mostrarlo tengo que hacerlo de nuevo
			
			
			// rotacion respecto cam
			// rotacion X (x ; z)
			angFinal=inclinacion2D(out.vertices[x].z, out.vertices[x].x)  +  this.inclinacion.x * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].x,2) + Math.pow(out.vertices[x].z,2));
			out.vertices[x].x=Math.cos(angFinal)*distancia;
			out.vertices[x].z=Math.sin(angFinal)*distancia;
			
			// rotacion Y (y ; z)

			angFinal=inclinacion2D(out.vertices[x].y, out.vertices[x].z)  +  this.inclinacion.y * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].z,2) + Math.pow(out.vertices[x].y,2));
			out.vertices[x].z=Math.cos(angFinal)*distancia;
			out.vertices[x].y=Math.sin(angFinal)*distancia;
			

			// rotacion Z (y ; x)

			angFinal=inclinacion2D(out.vertices[x].y, out.vertices[x].x)  +  this.inclinacion.z * Math.PI;
			distancia=Math.sqrt(Math.pow(out.vertices[x].x,2) + Math.pow(out.vertices[x].y,2));
			out.vertices[x].x=Math.cos(angFinal)*distancia;
			out.vertices[x].y=Math.sin(angFinal)*distancia;
			
/*
			out.vertices[x].x+=this.pos.x;          //0;0;0 pasa de ser mi posicion a ser 0;0;0 real
			out.vertices[x].y+=this.pos.y;
			out.vertices[x].z+=this.pos.z;          // comentado porque despues al mostrar se resta mis coords de nuevo
*/
		}
		
		
		
		
		
		return out;
	}
	
	
			
	private void dibujarPoligono(Graphics g, Poligono p) {       // texturas :[
		if(true) {
			if(p.c==null) {
				g.setColor(Color.WHITE);
			}
			else
				g.setColor(p.c);
			
		//	g.setColor(new Color((int)(Math.random()*255), (int)(Math.random()*255), (int)(Math.random()*255)));
			Vector2[] verticesPantalla =  {new Vector2(p.vertices[0].x*(D1/p.vertices[0].z)*200+this.getWidth() /2, p.vertices[0].y*(D1/p.vertices[0].z)*200+this.getHeight()/2), 
									new Vector2(p.vertices[1].x*(D1/p.vertices[1].z)*200+this.getWidth() /2, p.vertices[1].y*(D1/p.vertices[1].z)*200+this.getHeight()/2), 
									new Vector2(p.vertices[2].x*(D1/p.vertices[2].z)*200+this.getWidth() /2, p.vertices[2].y*(D1/p.vertices[2].z)*200+this.getHeight()/2)};
			g.drawLine((int)(verticesPantalla[0].x), (int)(verticesPantalla[0].y), (int)(verticesPantalla[1].x), (int)(verticesPantalla[1].y));
			g.drawLine((int)(verticesPantalla[1].x), (int)(verticesPantalla[1].y), (int)(verticesPantalla[2].x), (int)(verticesPantalla[2].y));
			g.drawLine((int)(verticesPantalla[0].x), (int)(verticesPantalla[0].y), (int)(verticesPantalla[2].x), (int)(verticesPantalla[2].y));

			if((verticesPantalla[0].x<this.getWidth() && verticesPantalla[0].x>0 && verticesPantalla[0].y<this.getHeight() && verticesPantalla[0].y>0 ||
				verticesPantalla[1].x<this.getWidth() && verticesPantalla[1].x>0 && verticesPantalla[1].y<this.getHeight() && verticesPantalla[1].y>0 ||
				verticesPantalla[2].x<this.getWidth() && verticesPantalla[2].x>0 && verticesPantalla[2].y<this.getHeight() && verticesPantalla[2].y>0)&&
				p.c!=null)
			{
				Arista2[] aristas = {
						new Arista2(verticesPantalla[0],verticesPantalla[1]),
						new Arista2(verticesPantalla[1],verticesPantalla[2]),
						new Arista2(verticesPantalla[0],verticesPantalla[2])};
				
				if(aristas[2].getHeight() > aristas[1].getHeight() && aristas[2].getHeight() > aristas[0].getHeight()) {
					Arista2 b = aristas[0];
					aristas[0] = aristas[2];
					aristas[2] = b;
					
				}
				else if(aristas[1].getHeight() > aristas[2].getHeight() && aristas[1].getHeight() > aristas[0].getHeight()) {
					Arista2 b = aristas[0];
					aristas[0] = aristas[1];
					aristas[1] = b;
				}
				
				if(aristas[2].top()==aristas[0].top()) {
					Arista2 b = aristas[1];
					aristas[1] = aristas[2];
					aristas[2] = b;
				}
			
			
				for(int y=0, b=1; y<aristas[0].getHeight(); y++) {
					if(y >= aristas[1].getHeight()) {
						b=2;
					}
	
					double inc = (aristas[b].vertices[0].x - aristas[b].vertices[1].x) / (aristas[b].vertices[0].y - aristas[b].vertices[1].y);
					g.drawLine(
							(int)((y - aristas[1].getHeight()*(b-1)) * inc + aristas[b].top().x), 
							(int)(y+aristas[0].top().y), 
							(int)(y*((aristas[0].vertices[0].x - aristas[0].vertices[1].x) / (aristas[0].vertices[0].y - aristas[0].vertices[1].y)) + aristas[0].top().x), 
							(int)(y+aristas[0].top().y) );
				}
			}
		}
	}
	
	
	
	private void insertionSort(ArrayList<Poligono> lista, ArrayList<Double> valores){
		for(int x=1; x<lista.size(); x++) {
			for(int y=x; valores.get(y)<valores.get(y-1) && y>1; y--) {
				double b = valores.get(y);
				valores.set(y, valores.get(y-1));
				valores.set(y-1, b);
				
				Poligono p = lista.get(y);
				lista.set(y, lista.get(y-1));
				lista.set(y-1, p);
			}
		}
	}
	
	
	
	private void dibujarObjeto(Graphics g, Objeto obj) {
		
		ArrayList<Poligono> poligonos = new ArrayList<Poligono>();
		ArrayList<Double> valores = new ArrayList<Double>();
		
		for(int x=0; x<obj.poligonos.size(); x++) {
			Poligono p = obj.poligonos.get(x)/*poligonoEnPantalla(obj.poligonos.get(x), obj)*/;
			poligonos.add(p);
			valores.add(
					
					-Math.sqrt(
							Math.pow(((p.vertices[0].x + p.vertices[1].x + p.vertices[2].x)/3), 2) + 
							Math.pow(((p.vertices[0].y + p.vertices[1].y + p.vertices[2].y)/3), 2) + 
							Math.pow(((p.vertices[0].z + p.vertices[1].z + p.vertices[2].z)/3), 2)
							)
					);
		}
		insertionSort(poligonos, valores);
		for(int x=0; x<poligonos.size(); x++) {
			if(poligonos.get(x).vertices[0].z>0 && poligonos.get(x).vertices[1].z>0 && poligonos.get(x).vertices[2].z>0) 
				dibujarPoligono(g,poligonos.get(x));
		}
	}
	
	
	
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Color BLANCO = new Color(255,255,255);
		Color NEGRO = new Color(0,0,0);
		
		
		g.setColor(NEGRO);
		for(int x=0; x<this.getWidth(); x++) {
			g.drawLine(x, 0, x, this.getHeight());
		}
		g.setColor(BLANCO);

		Objeto out=new Objeto(null,null,null);
		for(int w=0; w<escena.size(); w++) {
			for(int z=0; z<escena.get(w).poligonos.size(); z++) {
				out.poligonos.add(this.poligonoEnPantalla(escena.get(w).poligonos.get(z), escena.get(w)));
			}
		}
		
		this.dibujarObjeto(g, out);
		 //gg ez
		
		/*
		for(int x=0; x<this.getWidth(); x++) {
			if(x<10) {
				g.setColor(new Color(1*10,4*10,4*10));
			}
			else if(x<20) {
				g.setColor(new Color(1*20,4*20,4*20));
			}
			else if(x<30) {
				g.setColor(new Color(1*30,4*30,4*30));
			}
			else if(x<40) {
				g.setColor(new Color(1*40,4*40,4*40));
			}
			else if(x<50) {
				g.setColor(new Color(1*50,4*50,4*50));
			}
			if(x<50) {
				g.drawLine(x, 0, x, this.getHeight());
			}
		}
		*/
		
		
	}
	
	
	
	
	
	/*      //    V.2
	private void dibujarEscena(Graphics g) {
		ArrayList<Poligono> poligonos = new ArrayList<Poligono>();
		ArrayList<Double> orden = new ArrayList<Double>();
		
		for(int x=0; x<escena.size(); x++) {
			for(int y=0; y<escena.get(x).poligonos.size(); y++) {
				Poligono p = poligonoEnPantalla(escena.get(x).poligonos.get(y), escena.get(x));
				poligonos.add(p);
				orden.add(
						-Math.sqrt(
								Math.pow(((p.vertices[0].x + p.vertices[1].x + p.vertices[2].x)/3), 2) + 
								Math.pow(((p.vertices[0].y + p.vertices[1].y + p.vertices[2].y)/3), 2) + 
								Math.pow(((p.vertices[0].z + p.vertices[1].z + p.vertices[2].z)/3), 2)
								)
						);
			}
		}
		insertionSort(poligonos, orden);
		Iterator<Poligono> i = poligonos.iterator();
		while(i.hasNext()) {
			Poligono p = i.next();
			if(p.vertices[0].z>0 && p.vertices[1].z>0 && p.vertices[2].z>0) 
				dibujarPoligono(g,p);
		}
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		Color BLANCO = new Color(255,255,255);
		Color NEGRO = new Color(0,0,0);
		
		
		g.setColor(NEGRO);
		for(int x=0; x<this.getWidth(); x++) {
			g.drawLine(x, 0, x, this.getHeight());
		}
		g.setColor(BLANCO);


		dibujarEscena(g); //gg ez
		
		/*
		for(int x=0; x<this.getWidth(); x++) {
			if(x<10) {
				g.setColor(new Color(1*10,4*10,4*10));
			}
			else if(x<20) {
				g.setColor(new Color(1*20,4*20,4*20));
			}
			else if(x<30) {
				g.setColor(new Color(1*30,4*30,4*30));
			}
			else if(x<40) {
				g.setColor(new Color(1*40,4*40,4*40));
			}
			else if(x<50) {
				g.setColor(new Color(1*50,4*50,4*50));
			}
			if(x<50) {
				g.drawLine(x, 0, x, this.getHeight());
			}
		}
		
		
		
	}*/
	
	
	
	public void mover(double direccion) {
		Vector2 pos = new Vector2(0,0);
		
		pos.x = Math.cos((this.inclinacion.x+direccion) * Math.PI) * this.velocidad;
		pos.y = Math.sin((this.inclinacion.x+direccion) * Math.PI) * this.velocidad;
		
		this.pos.z+=pos.x;
		this.pos.x+=pos.y;
	}
	
	public Vector3 getInclinacion() {
		return inclinacion;
	}
	public void setInclinacion(Vector3 inclinacion) {
		this.inclinacion = inclinacion;
	}
	public void addInclinacion(Vector3 inclinacion) {
		this.inclinacion.x += inclinacion.x;
		if(this.inclinacion.y + inclinacion.y < 0.5001 && this.inclinacion.y + inclinacion.y > -0.5001)
		this.inclinacion.y += inclinacion.y;
		this.inclinacion.z += inclinacion.z;
	}
	
	public String toString() {
		return "pos:{"+pos.x+"; "+pos.y+"; "+pos.z+"} inc:{"+inclinacion.x+"; "+inclinacion.y+"; "+inclinacion.z+"} V:"+this.velocidad+" D:"+this.D1;
	}
}

/*
 		lampara :)
 
		escena.add(new Cubo(new Vector3(-2,0,0), new Vector3(0.2,0.2,0.2), new Vector3(0,0.25,0.25)));
		escena.add(new Cubo(new Vector3(-2,1.375,0), new Vector3(0.5,0.25,0.5), new Vector3(0,0,0)));
		escena.add(new Cubo(new Vector3(-2,0.625,0), new Vector3(0.125,1.25,0.125), new Vector3(0,0,0)));




---------------------------------------------------------------------------------------------------------------------------------------------
															Save algoritmo rotar, mover, rotar
---------------------------------------------------------------------------------------------------------------------------------------------

		double X[] = {obj.poligonos.get(x).vertices[a].x, obj.poligonos.get(x).vertices[b].x};
				double Y[] = {obj.poligonos.get(x).vertices[a].y, obj.poligonos.get(x).vertices[b].y};
				double Z[] = {obj.poligonos.get(x).vertices[a].z, obj.poligonos.get(x).vertices[b].z};
			//	System.out.println("xa:"+X[0]+" ya:"+Y[0]+" za:"+Z[0]+" xb:"+X[1]+" yb:"+Y[1]+" za:"+Z[1]);

				double angFinal, distancia;
				
				for(int m=0; m<2; m++) {
					// rotacion X (x ; z)
					angFinal=inclinacion2D(Z[m], X[m])  +  obj.getInclinacion().x * PI;
					distancia=Math.sqrt(X[m]*X[m] + Z[m]*Z[m]);
					X[m]=Math.cos(angFinal)*distancia;
					Z[m]=Math.sin(angFinal)*distancia;
					
					// rotacion Y (y ; z)

					angFinal=inclinacion2D(Y[m], Z[m])  +  obj.getInclinacion().y * PI;
					distancia=Math.sqrt(Z[m]*Z[m] + Y[m]*Y[m]);
					Z[m]=Math.cos(angFinal)*distancia;
					Y[m]=Math.sin(angFinal)*distancia;
					

					// rotacion Z (y ; x)

					angFinal=inclinacion2D(Y[m], X[m])  +  obj.getInclinacion().z * PI;
					distancia=Math.sqrt(X[m]*X[m] + Y[m]*Y[m]);
					X[m]=Math.cos(angFinal)*distancia;
					Y[m]=Math.sin(angFinal)*distancia;

					X[m]+=obj.getPosicion().x;
					Y[m]+=obj.getPosicion().y;
					Z[m]+=obj.getPosicion().z;
					
					X[m]-=this.pos.x;
					Y[m]-=this.pos.y;
					Z[m]-=this.pos.z;
					
					
					// rotacion respecto cam
					// rotacion X (x ; z)
					angFinal=inclinacion2D(Z[m], X[m])  +  this.inclinacion.x * PI;
					distancia=Math.sqrt(Math.pow(X[m],2) + Math.pow(Z[m],2));
					X[m]=Math.cos(angFinal)*distancia;
					Z[m]=Math.sin(angFinal)*distancia;
					
					// rotacion Y (y ; z)

					angFinal=inclinacion2D(Y[m], Z[m])  +  this.inclinacion.y * PI;
					distancia=Math.sqrt(Math.pow(Z[m],2) + Math.pow(Y[m],2));
					Z[m]=Math.cos(angFinal)*distancia;
					Y[m]=Math.sin(angFinal)*distancia;
					

					// rotacion Z (y ; x)

					angFinal=inclinacion2D(Y[m], X[m])  +  this.inclinacion.z * PI;
					distancia=Math.sqrt(Math.pow(X[m],2) + Math.pow(Y[m],2));
					X[m]=Math.cos(angFinal)*distancia;
					Y[m]=Math.sin(angFinal)*distancia;
					

					X[m]+=this.pos.x;
					Y[m]+=this.pos.y;
					Z[m]+=this.pos.z;
				}


 */
