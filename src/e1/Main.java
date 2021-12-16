package e1;
/**
 * @author César
 * @version 1.0
 * 
 */
import java.util.Scanner;

import e1.Ficha.Color;
/**
 * @version 1.0
 * @author César
 *	este es el main, donde esta la mecanica del juego
 *	puedes jugar mientras los dos reyes sigan vivos
 *	solo puedes mover ficha si es tu turno, si la coordenada que elige tiene ficha y si el movimiento que quieres hacer 
 * con dicha ficha esta dentro del tablero y de sus posibles movimientos
 */
public class Main {
	public static void main(String[] args) {

		Tablero t = new Tablero();
		Scanner sc = new Scanner(System.in);

		Ficha.Color turno = Ficha.Color.WHITE;

		String coor = "";

		int numero = 0;
		int numeroaux = 0;
		char letra = ' ';
		char letraaux = ' ';

		Coordenada origen = new Coordenada(numero, letra);
		Coordenada destino = new Coordenada(numero, letra);

		welcome();
		do {
			if (t.hayJaque())
				System.out.println("CUIDADO!! ESTAS EN JAQUE!!!!!!");
			System.out.println(t.tablero());
			System.out.println("Es el turno de: " + turno);
			System.out.println("Dame primero el numero de la ficha que quieras mover y segundo la letra ");
			coor = sc.nextLine();
			if (coor.length() == 2) {
				numeroaux = coor.charAt(0) - '0';
				letraaux = (coor.toUpperCase().charAt(1));
				if (numeroaux >= 0 && numeroaux <= 7)
					numero = numeroaux;
				if (letraaux >= 'A' && letraaux <= 'H')
					letra = letraaux;
				else
					System.out.println(
							"Introduce bien los valores, por favor (Numero del 0 al 7 y letra de la A a la H)");
			} else
				System.out.println("Introduce bien los valores, por favor (Numero del 0 al 7 y letra de la A a la H)");

			origen = new Coordenada(numero, letra);
			if (t.estaDentro(origen)) {
				if (t.getCelda(origen).getFicha() != null) {
					if (t.getCelda(origen).getFicha().getColor() == turno) {
						System.out.println(t.getCelda(origen).getFicha().posiblesCoordenadas().toString());
						System.out.println("La ficha que has elegido tiene los posibles siguientes movimientos ");
						System.out.println("Donde quieres mover la ficha?");
						coor = sc.nextLine();
						if (coor.length() == 2) {
							numeroaux = coor.charAt(0) - '0';
							letraaux = (coor.toUpperCase().charAt(1));
							if (numeroaux >= 0 && numeroaux <= 7)
								numero = numeroaux;
							if (letraaux >= 'A' && letraaux <= 'H')
								letra = letraaux;
							else
								System.out.println(
										"Introduce bien los valores, por favor (Numero del 0 al 7 y letra de la A a la H)");
						} else
							System.out.println(
									"Introduce bien los valores, por favor (Numero del 0 al 7 y letra de la A a la H)");
						destino = new Coordenada(numero, letra);
						if (t.getCelda(origen).getFicha().mover(destino) == true)
							turno = Ficha.Color.values()[(turno.ordinal() + 1) % 2];
						;
					} else
						System.out.println("Elige una ficha de tu color, pillo");
				} else
					System.out.println("No hay nada por aqui... dime una coordenada con ficha");
			} else
				System.out.println("La coordenada no esta dentro del tablero");
		} while (t.contarReyBlanco() > 0 && t.contarReyNegro() > 0);

		if (t.contarReyBlanco() == 1)
			System.out.println("GANAN LAS NEGRAS, BLACK POWER!");
		else
			System.out.println("GANAN LAS BLANCAS, WHITE POWER!");

	}
	
	
	/**
	 * metodo de bienvenida al juego
	 */
	public static void welcome() {
		System.out.println("	---------------");
		System.out.println("	---------------");
		System.out.println("	-----CHESS-----");
		System.out.println("	---------------");
		System.out.println("	------BY-------");
		System.out.println("	-----CESAR-----");
		System.out.println("	----BAUTISTA---");
		System.out.println("	-----GARCIA----");
		System.out.println("	---------------");
		System.out.println("	------DAW------");
		System.out.println("	---2019/2020---");
		System.out.println("	---------------");
		System.out.println("	---------------");
		System.out.println();
		System.out.println("Bienvenido al ajedrez, por favor mueve ficha.");
		System.out.println("Blancas, situadas en la parte inferior del tablero, mueven primero");
		System.out.println("Suerte!!");
	}

}
