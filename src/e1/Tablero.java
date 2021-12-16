package e1;

import java.util.ArrayList;
import java.util.LinkedHashSet;
/**
 * 
 * @author César
 *	esta es la clase tablero, donde esta gran parte de la mecanica del juego
 *	@version 1.0
 */
public class Tablero {

	Celda[][] t;
	ArrayList<Ficha> negras;
	ArrayList<Ficha> blancas;
	public Ficha reyNegro;
	public Ficha reyBlanco;
	/**
	 * esto es el constructor de tablero, un array de dos dimensiones de celdas
	 */
	public Tablero() {
		this.t = new Celda[8][8];
		for (int i = 0; i < t.length; i++) {
			for (int j = 0; j < t[0].length; j++) {
				t[i][j] = new Celda();
			}

		}
		// fichas negras
		/**
		 * creamos un constructor de fichas negras, y añadimos el rey en una variable aparte para
		 * el funcionamiento del juego
		 */
		negras = new ArrayList<Ficha>();
		negras.add(new Rook(this, Ficha.Color.BLACK, new Coordenada(7, 'A')));
		negras.add(new Rook(this, Ficha.Color.BLACK, new Coordenada(7, 'H')));
		negras.add(new Horse(this, Ficha.Color.BLACK, new Coordenada(7, 'B')));
		negras.add(new Horse(this, Ficha.Color.BLACK, new Coordenada(7, 'G')));
		negras.add(new Bishop(this, Ficha.Color.BLACK, new Coordenada(7, 'C')));
		negras.add(new Bishop(this, Ficha.Color.BLACK, new Coordenada(7, 'F')));
		negras.add(new Queen(this, Ficha.Color.BLACK, new Coordenada(7, 'D')));
		reyNegro = new King(this, Ficha.Color.BLACK, new Coordenada(7, 'E'));
		negras.add(reyNegro);
		for (int i = 0; i < 8; i++) {
			negras.add(new Pawn(this, Ficha.Color.BLACK, new Coordenada(6, (char) ('A' + i))));
		}

		// fichas blancas
		/**
		 * creamos un constructor de fichas blancas, y añadimos el rey en una variable aparte para
		 * el funcionamiento del juego
		 */
		blancas = new ArrayList<Ficha>();
		blancas.add(new Rook(this, Ficha.Color.WHITE, new Coordenada(0, 'A')));
		blancas.add(new Rook(this, Ficha.Color.WHITE, new Coordenada(0, 'H')));
		blancas.add(new Horse(this, Ficha.Color.WHITE, new Coordenada(0, 'B')));
		blancas.add(new Horse(this, Ficha.Color.WHITE, new Coordenada(0, 'G')));
		blancas.add(new Bishop(this, Ficha.Color.WHITE, new Coordenada(0, 'C')));
		blancas.add(new Bishop(this, Ficha.Color.WHITE, new Coordenada(0, 'F')));
		blancas.add(new Queen(this, Ficha.Color.WHITE, new Coordenada(0, 'D')));
		reyBlanco = new King(this, Ficha.Color.WHITE, new Coordenada(0, 'E'));
		blancas.add(reyBlanco);
		for (int i = 0; i < 8; i++) {
			blancas.add(new Pawn(this, Ficha.Color.WHITE, new Coordenada(1, (char) ('A' + i))));
		}

	}
	/**
	 * toString del tablero
	 * @return
	 */
	public String tablero() {
		String salida = "";
		salida += "     A   B   C   D   E   F   G   H" + "\n";
		salida += "   ╔═══╤═══╤═══╤═══╤═══╤═══╤═══╤═══╗" + "\n";
		salida += " 7 ║ " + t[7][0] + " | " + t[7][1] + " | " + t[7][2] + " | " + t[7][3] + " | " + t[7][4] + " | "
				+ t[7][5] + " | " + t[7][6] + " | " + t[7][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 6 ║ " + t[6][0] + " | " + t[6][1] + " | " + t[6][2] + " | " + t[6][3] + " | " + t[6][4] + " | "
				+ t[6][5] + " | " + t[6][6] + " | " + t[6][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 5 ║ " + t[5][0] + " | " + t[5][1] + " | " + t[5][2] + " | " + t[5][3] + " | " + t[5][4] + " | "
				+ t[5][5] + " | " + t[5][6] + " | " + t[5][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 4 ║ " + t[4][0] + " | " + t[4][1] + " | " + t[4][2] + " | " + t[4][3] + " | " + t[4][4] + " | "
				+ t[4][5] + " | " + t[4][6] + " | " + t[4][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 3 ║ " + t[3][0] + " | " + t[3][1] + " | " + t[3][2] + " | " + t[3][3] + " | " + t[3][4] + " | "
				+ t[3][5] + " | " + t[3][6] + " | " + t[3][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 2 ║ " + t[2][0] + " | " + t[2][1] + " | " + t[2][2] + " | " + t[2][3] + " | " + t[2][4] + " | "
				+ t[2][5] + " | " + t[2][6] + " | " + t[2][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 1 ║ " + t[1][0] + " | " + t[1][1] + " | " + t[1][2] + " | " + t[1][3] + " | " + t[1][4] + " | "
				+ t[1][5] + " | " + t[1][6] + " | " + t[1][7] + " ║" + "\n";
		salida += "   ╟───┼───┼───┼───┼───┼───┼───┼───╢" + "\n";
		salida += " 0 ║ " + t[0][0] + " | " + t[0][1] + " | " + t[0][2] + " | " + t[0][3] + " | " + t[0][4] + " | "
				+ t[0][5] + " | " + t[0][6] + " | " + t[0][7] + " ║" + "\n";
		salida += "   ╚═══╧═══╧═══╧═══╧═══╧═══╧═══╧═══╝" + "\n";
		salida += "     A   B   C   D   E   F   G   H" + "\n";
		return salida;

	}
	/**
	 * metodo para obtener la celda que queramos, pasandoles las coordenadas del tablero
	 * @param c
	 * @return
	 */
	public Celda getCelda(Coordenada c) {
		return t[c.getNumero()][c.getLetra() - 'A'];
	}
	/**
	 * metodo para saber si la coordenada que queremos esta o no dentro del tablero
	 * @param c
	 * @return
	 */
	public boolean estaDentro(Coordenada c) {
		if (c.getNumero() < 0 || c.getNumero() > 7)
			return false;
		else if (c.getLetra() < 'A' || c.getLetra() > 'H')
			return false;
		else
			return true;
	}
	/**
	 * metodo para eliminar las fichas cuando nos las comemos
	 * @param f
	 */
	public void eliminarFicha(Ficha f) {
		if (f.getColor() == Ficha.Color.WHITE)
			blancas.remove(f);
		else
			negras.remove(f);
	}
	/**
	 *  metodo para saber de quien es el jaque
	 * @return
	 */
	public boolean hayJaque() {
		return hayJaque(Ficha.Color.WHITE) || hayJaque(Ficha.Color.BLACK);
	}
	/**
	 * metodo para saber si hay jaque
	 * @param color
	 * @return
	 */
	public boolean hayJaque(Ficha.Color color) {

		LinkedHashSet<Coordenada> jaque = new LinkedHashSet<Coordenada>();

		switch (color) {
		case WHITE:
			for (Ficha f : blancas) {
				jaque.addAll(f.posiblesCoordenadas());
			}
			return jaque.contains(reyNegro.getCoordenada());
		case BLACK:
			for (Ficha f : negras) {
				jaque.addAll(f.posiblesCoordenadas());
			}
			return jaque.contains(reyBlanco.getCoordenada());

		default:
			return false;
		}

	}
	/**
	 * metodo para saber si el rey negro existe
	 * @return
	 */
	public int contarReyNegro() {
		int cantidad = 0;
		for (Ficha f : negras)
			if (f instanceof King)
				cantidad++;
		return cantidad;
	}
	/**
	 * metodo para saber si el rey blanco existe
	 * @return
	 */
	public int contarReyBlanco() {
		int cantidad = 0;
		for (Ficha f : blancas)
			if (f instanceof King)
				cantidad++;
		return cantidad;
	}
}
