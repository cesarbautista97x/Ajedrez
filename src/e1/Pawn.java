package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * La clase Pawn se trata del peon, que hereda de la clase Ficha
 */
 class Pawn extends Ficha {
	public Pawn(Tablero t, Ficha.Color color, Coordenada c) {
		/**
		 * Constructor, que en fucion del color crea un peon u otro
		 * @param t
		 * @param color
		 * @param c
		 */
		this.t = t;
		this.posicion = c;
		if (color == Ficha.Color.BLACK)
			this.shape = Ficha.Shape.Black_Pawn;
		else
			this.shape = Ficha.Shape.White_Pawn;

		t.getCelda(c).setFicha(this);
	}

	/**
	 * Aqui almaceno las posibles coordenadas que tiene el peon
	 */
	@Override
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {

		this.nextMovements = new LinkedHashSet<Coordenada>();

		Coordenada c;
		
		// peones blancos
		
		if(shape.getColor() == Color.WHITE) {
			
			c = this.posicion;
			// default
			if (t.getCelda(posicion.up()).getFicha() == null) {
				c = posicion.up();
				addCoordenada(c);
			}
			// salida
			if (posicion.getNumero() == 1) {
				if (t.getCelda(posicion.up()).getFicha() == null && t.getCelda(posicion.up().up()).getFicha() == null) {
					c = posicion.up();
					addCoordenada(c);
					c = posicion.up().up();
					addCoordenada(c);
				}
			}

			// comer izquierda
			if (t.estaDentro(posicion.upLeft())) {
				if (t.getCelda(posicion.upLeft()).getFicha() != null) {
					c = posicion.upLeft();
					addCoordenada(c);
				}
			}
			// comer derecha
			if (t.estaDentro(posicion.upRight())) {
				if (t.getCelda(posicion.upRight()).getFicha() != null) {
					c = posicion.upRight();
					addCoordenada(c);
				}
			}
		}
		
		// peones negros
		if(shape.getColor() == Color.BLACK) {
			
			c = this.posicion;
			// default
			if (t.getCelda(posicion.down()).getFicha() == null) {
				c = posicion.down();
				addCoordenada(c);
			}
			// salida 
			if (posicion.getNumero() == 6) {
				if (t.getCelda(posicion.down()).getFicha() == null && t.getCelda(posicion.down().down()).getFicha() == null) {
					c = posicion.down();
					addCoordenada(c);
					c = posicion.down().down();
					addCoordenada(c);
				}
			}

			// comer izquierda
			if (t.estaDentro(posicion.downLeft())) {
				if (t.getCelda(posicion.downLeft()).getFicha() != null) {
					c = posicion.downLeft();
					addCoordenada(c);
				}
			}
			// comer derecha
			if (t.estaDentro(posicion.downRight())) {
				if (t.getCelda(posicion.downRight()).getFicha() != null) {
					c = posicion.downRight();
					addCoordenada(c);
				}
			}
		}

		
		return nextMovements;

	}

	public boolean mover(Coordenada next) {

		posiblesCoordenadas();

		System.out.println(nextMovements);

		if (nextMovements.contains(next)) {
			if (t.getCelda(next).getFicha() != null) {
				t.eliminarFicha(t.getCelda(next).getFicha());
			}
			t.getCelda(posicion).setFicha(null);
			t.getCelda(next).setFicha(this);
			posicion = next;
			
			//coronar peones blancos
			if (posicion.getNumero() == 7 && shape.getColor()==Color.WHITE) {
				t.blancas.remove(this);
				t.blancas.add(new Queen(t, Ficha.Color.WHITE, posicion));
			}
			//coronar peones negros
			if (posicion.getNumero() == 0 && shape.getColor()==Color.BLACK) {
				t.negras.remove(this);
				t.negras.add(new Queen(t, Ficha.Color.BLACK, posicion));
			}
			return true;
		} else {
			System.out.println("La coordenada no esta entre los posibles movimientos.");
			return false;
		}

	}

}
