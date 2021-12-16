package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * La clase Pawn se trata de la reina, que hereda de la clase Ficha
 */

public class Queen extends Ficha {
	/**
	 * Constructor, que en fucion del color crea una reina u otra
	 * @param t
	 * @param color
	 * @param c
	 */
	public Queen(Tablero t,Ficha.Color color, Coordenada c) {
		this.t=t;
		this.posicion=c;
		if(color==Ficha.Color.BLACK)
			this.shape=Ficha.Shape.Black_Queen;
		else
			this.shape=Ficha.Shape.White_Queen;
		
		t.getCelda(c).setFicha(this);
	}
	/**
	 * Aqui almaceno las posibles coordenadas que tiene la reina
	 */
	@Override
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {
		
		this.nextMovements = new LinkedHashSet<Coordenada>();
		
		nextMovements.addAll(posiblesCoordenadasRK());
		nextMovements.addAll(posiblesCoordenadasBS());


		return nextMovements;
	}

}
