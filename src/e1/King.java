package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * La clase King se trata del rey, que hereda de la clase Ficha
 */
public class King extends Ficha {
	
	/**
	 * Constructor, que en fucion del color crea un rey u otro
	 * @param t
	 * @param color
	 * @param c
	 */
	public King(Tablero t,Ficha.Color color, Coordenada c) {
		this.t=t;
		this.posicion=c;
		if(color==Ficha.Color.BLACK)
			this.shape=Ficha.Shape.Black_King;
		else
			this.shape=Ficha.Shape.White_King;
		
		t.getCelda(c).setFicha(this);
	}

	/**
	 * Aqui almaceno las posibles coordenadas que tiene el rey
	 */
	@Override
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {
		
		this.nextMovements = new LinkedHashSet<Coordenada>();
		
		Coordenada c;
		
		// up
		c =posicion.up();
		addCoordenada(c);		
		//down	
		c=posicion.down();
		addCoordenada(c);
		//left
		c=posicion.left();
		addCoordenada(c);
		//right
		c=posicion.right();
		addCoordenada(c);
		// upLeft
		c=posicion.upLeft();
		addCoordenada(c);
		// upRight
		c=posicion.upRight();
		addCoordenada(c);
		// downLeft
		c=posicion.downLeft();
		addCoordenada(c);
		// downRight
		c=posicion.downRight();
		addCoordenada(c);
		

		return nextMovements;
			

		
	}



}