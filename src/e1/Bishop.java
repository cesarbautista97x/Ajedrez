package e1;

import java.util.LinkedHashSet;
/**
 * 
 * @author César
 * @version 1.0
 * La clase Bishop se trata del alfil, que hereda de la clase Ficha
 */
public class Bishop extends Ficha {
	
	/**
	 * Constructor, que en fucion del color crea un alfil u otro
	 * @param t
	 * @param color
	 * @param c
	 */
	public Bishop(Tablero t,Ficha.Color color, Coordenada c) {
		this.t=t;
		this.posicion=c;
		if(color==Ficha.Color.BLACK)
			this.shape=Ficha.Shape.Black_Bishop;
		else
			this.shape=Ficha.Shape.White_Bishop;
		
		t.getCelda(c).setFicha(this);
	}
	/**
	 * Aqui almaceno las posibles coordenadas que tiene el alfil
	 */
	public LinkedHashSet<Coordenada> posiblesCoordenadas() {
		this.nextMovements = new LinkedHashSet<Coordenada>();
		
		nextMovements.addAll(posiblesCoordenadasBS());

		return nextMovements;
		
	}




}
