package e1;
/**
 * @version 1.0
 * @author César
 *	clase celda, que se compone de si tienen o no ficha
 */
public class Celda {

	private Ficha ficha;
	/**
	 * Indico que las celdas estan vacias
	 */
	public Celda() {
		this.ficha = null;
	}
	/**
	 * getter ficha
	 * @return
	 */
	public Ficha getFicha() {
		return ficha;
	}
	/**
	 * setter ficha
	 * @param ficha
	 */
	public void setFicha(Ficha ficha) {
		this.ficha = ficha;
	}
	/**
	 * metodo para comprobar si hay ficha en la celda
	 * @return
	 */
	public boolean hayFicha() {
		if (this.ficha == null)
			return false;
		else
			return true;
	}
	/**
	 * ToString de celda
	 * @override
	 */
	public String toString() {
		String salida;

		if (ficha == null) {
			salida = " ";
		} else
			salida = ficha.toString();

		return salida;
	}

}
