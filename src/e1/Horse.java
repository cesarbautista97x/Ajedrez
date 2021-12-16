package e1;

import java.util.LinkedHashSet;

/**
 * 
 * @author César
 * @version 1.0
 * La clase Horse se trata del caballo, que hereda de la clase Ficha
 */
public class Horse extends Ficha {
	public Horse(Tablero t, Ficha.Color color, Coordenada c) {
		
		/**
		 * Constructor, que en fucion del color crea un caballo u otro
		 * @param t
		 * @param color
		 * @param c
		 */
		this.t = t;
		this.posicion = c;
		if (color == Ficha.Color.BLACK)
			this.shape = Ficha.Shape.Black_Horse;
		else
			this.shape = Ficha.Shape.White_Horse;

		t.getCelda(c).setFicha(this);
	}
	/**
	 * Aqui almaceno las posibles coordenadas que tiene el caballo 
	 */
	@Override
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {

		this.nextMovements = new LinkedHashSet<Coordenada>();

		Coordenada c;

		// up.upRight
		if (t.estaDentro(posicion.up().upRight())) {
			c = posicion.up().upRight();
			addCoordenada(c);
		}
		// up.upLeft
		c = posicion.up().upLeft();
		addCoordenada(c);
		// left.upLeft
		c = posicion.left().upLeft();
		addCoordenada(c);
		// left.downRight
		c = posicion.left().downRight();
		addCoordenada(c);
		// down.downLeft
		c = posicion.down().downLeft();
		addCoordenada(c);
		// down.downRight
		c = posicion.down().downRight();
		addCoordenada(c);
		// right.righUp
		c = posicion.right().upRight();
		addCoordenada(c);
		// right.rightdown
		c = posicion.right().downRight();
		addCoordenada(c);

		return nextMovements;

	}

}