package e1;

public class Coordenada {
	protected int numero;
	protected char letra;
	/**
	 * constructor de coordenada
	 * @param numero
	 * @param letra
	 */
	public Coordenada(int numero,char letra) {
		
		this.numero=numero;
		this.letra=letra;
	}
	/**
	 * getLetra de la coordenada
	 * @return
	 */
	public char getLetra() {
		return letra;
	}
	/**
	 * setLetra de la coordenada
	 * @param letra
	 */
	public void setLetra(char letra) {
		this.letra = letra;
	}
	/**
	 * getNumero de la coordenada
	 * @return
	 */
	public int getNumero() {
		return numero;
	}
	/**
	 * setNumero de la coordenada
	 * @param numero
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
	/**
	 * metodo toString de coordenada
	 */
	@Override
	public String toString() {
		return "(" + numero + "," + letra + ")";
	}
	/**
	 * movimiento de la ficha hacia arriba
	 * @return
	 */
	public Coordenada up() {
		return new Coordenada(numero+1,letra);
	}
	/**
	 * movimiento de la ficha hacia abajo
	 * @return
	 */
	public Coordenada down() {
		return new Coordenada(numero-1,letra);
	}
	/**
	 * movimiento de la ficha hacia la derecha
	 * @return
	 */
	public Coordenada right() {
		return new Coordenada(numero,(char)(this.letra+1));
	}
	/**
	 * movimiento de la ficha hacia la izquierda
	 * @return
	 */
	public Coordenada left() {
		return new Coordenada(numero,(char)(this.letra-1));
	}
	/**
	 * movimiento de la ficha hacia la abajoizquierda
	 * @return
	 */
	public Coordenada upLeft() {
		return up().left();
	}
	/**
	 * movimiento de la ficha hacia arribaderecha
	 * @return
	 */
	public Coordenada upRight() {
		return up().right();
	}
	/**
	 * movimiento de la ficha hacia la abajoderecha
	 * @return
	 */
	public Coordenada downRight() {
		return down().right();
	}
	/**
	 * movimiento de la ficha hacia la abajoizquierda
	 * @return
	 */
	public Coordenada downLeft() {
		return down().left();
	}
	/**
	 * explico al programa que es un equals para mi programa
	 */
	public boolean equals(Object o) {
		boolean contiene;
		
		Coordenada c = (Coordenada) o;
		if(numero == c.getNumero() && letra == c.getLetra())
			contiene=true;
		else
			contiene=false;
		return contiene;
	}
	/**
	 * hashCode
	 */
	public int hashCode() {
		return this.toString().hashCode();
	}

}
