package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * clase abstracta ficha que va a ser el padre de todas las fichas creadas a posteriori
 */
public abstract class Ficha {
	/**
	 * aqui almaceno todos las formas y colores de todas las fichas posibles
	 *
	 */
	public static enum Shape {
		White_Queen("\u2655", Color.WHITE), Black_King("\u265a", Color.BLACK), Black_Horse("\u265e", Color.BLACK),
		White_Pawn("\u2659", Color.WHITE), Black_Pawn("\u265f", Color.BLACK), Black_Queen("\u265b", Color.BLACK),
		White_Rook("\u2656", Color.WHITE), Black_Rook("\u265c", Color.BLACK), White_King("\u2654", Color.WHITE),
		White_Horse("\u2658", Color.WHITE), White_Bishop("\u2657", Color.WHITE), Black_Bishop("\u265d", Color.BLACK);
		/**
		 * Todas las fichas tienen una forma y un color
		 */
		protected String forma;
		protected Color color;

		Shape(String forma, Color color) {
			this.forma = forma;
			this.color = color;
		}
		/**
		 * getter del color
		 * @return
		 */
		public Color getColor() {
			return color;
		}
		/**
		 * toString
		 *@override 
		 */
		public String toString() {
			return forma;
		}
	}

	protected Shape shape;
	protected Tablero t;
	protected Coordenada posicion;
	LinkedHashSet<Coordenada> nextMovements;
	/**
	 * constructor, vacio al ser clase abstracta
	 */
	public Ficha() {

	}
	/**
	 * 
	 * tipos de colores, blancas o negras
	 * 
	 *
	 */
	public static enum Color {
		WHITE, BLACK
	}
	/**
	 * toString de ficha
	 * @override
	 */
	@Override
	public String toString() {
		return "" + shape;
	}
	/**
	 * getter de color
	 * @return
	 */
	public Color getColor() {
		return this.shape.getColor();
	}
	/**
	 * getter de coordenada
	 * @return
	 */
	public Coordenada getCoordenada() {
		return this.posicion;
	}
	/**
	 * metodo para comprobar que la coordenada cumple los requisitos para añadirla 
	 * a los movimientos posibles
	 * @param c
	 */
	public void addCoordenada(Coordenada c) {

		if (t.estaDentro(c) && t.getCelda(c).getFicha() == null)
			this.nextMovements.add(c);
		else if (t.estaDentro(c) && t.getCelda(c).getFicha() != null
				&& t.getCelda(c).getFicha().getColor() != this.getColor())
			this.nextMovements.add(c);
	}
	/**
	 * linked hash set almacenando todas las posibles coordenadas para desplazar la ficha
	 * @return
	 */
	public abstract LinkedHashSet<Coordenada> posiblesCoordenadas();

	// BISHOP
	/**
	 * posibles coordenadas del alfil para la creacion de la reina
	 * @return
	 */
	protected LinkedHashSet<Coordenada> posiblesCoordenadasBS() {

		LinkedHashSet<Coordenada> nextMovements = new LinkedHashSet<Coordenada>();

		Coordenada c = posicion.upLeft();

		// upLeft
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.upLeft();

		}
		if (t.estaDentro(c))
			addCoordenada(c);
		// upRight
		c = posicion.upRight();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.upRight();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		// downLeft
		c = posicion.downLeft();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.downLeft();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		// downRight
		c = posicion.downRight();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.downRight();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		return nextMovements;
	}

	// TORRE
	/**
	 * posibles coordenadas de la torre para la creacion de la reina
	 * @return
	 */
	protected LinkedHashSet<Coordenada> posiblesCoordenadasRK() {

		LinkedHashSet<Coordenada> nextMovements = new LinkedHashSet<Coordenada>();

		Coordenada c = posicion.up();

		// up
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.up();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		// down
		c = posicion.down();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.down();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		// left
		c = posicion.left();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.left();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		// right
		c = posicion.right();
		while (t.estaDentro(c) && t.getCelda(c).getFicha() == null) {
			addCoordenada(c);
			c = c.right();

		}
		if (t.estaDentro(c))
			addCoordenada(c);

		return nextMovements;
	}
	/**
	 * metodo para mover las fichas
	 * @param next
	 * @return
	 */
	public boolean mover(Coordenada next) {

		posiblesCoordenadas();

		if (nextMovements.contains(next)) {
			if (t.getCelda(next).getFicha() != null) {
				t.eliminarFicha(t.getCelda(next).getFicha());
			}
			t.getCelda(posicion).setFicha(null);
			t.getCelda(next).setFicha(this);
			posicion = next;
			return true;
		} else {
			System.out.println("La coordenada no esta entre los posibles movimientos.");
			return false;
		}

	}

}
