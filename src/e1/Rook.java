package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * La clase Pawn se trata de la torre, que hereda de la clase Ficha
 */
 class Rook extends Ficha {
	public Rook(Tablero t, Ficha.Color color, Coordenada c) {
		/**
		 * Constructor, que en fucion del color crea una torre u otra
		 * @param t
		 * @param color
		 * @param c
		 */
		this.t = t;
		this.posicion = c;
		if (color == Ficha.Color.BLACK)
			this.shape = Ficha.Shape.Black_Rook;
		else
			this.shape = Ficha.Shape.White_Rook;

		t.getCelda(c).setFicha(this);
	}

	/**
	 * Aqui almaceno las posibles coordenadas que tiene la torre
	 */
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {
		this.nextMovements = new LinkedHashSet<Coordenada>();
		
		nextMovements.addAll(posiblesCoordenadasRK());

		return nextMovements;
		
	}
	
//	public boolean moverRK(Coordenada next) {
//		
//	}
	
}
