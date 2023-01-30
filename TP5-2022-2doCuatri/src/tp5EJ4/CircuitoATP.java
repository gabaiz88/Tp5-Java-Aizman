package tp5EJ4;

import java.util.ArrayList;

public class CircuitoATP {
	private String[] jugadores;
	private String[] torneos;
	private int[][] resultados;

	public CircuitoATP() {
		this.cargarData();
	}
	public void cargarData() {
		this.jugadores = new String[] { "Pella","Del Potro","Schwartzman","Mayer","Delbonis"};
		this.torneos = new String[] { "Australia", "USOpen", "RolandGarros", "Wimbledon","Shangai"};
		this.resultados = new int[][] {	{1,3,4,1,3},
										{3,2,3,4,1},
										{2,1,5,5,2},
										{4,5,1,2,5},
										{5,4,2,3,4}};			
	}
	
	
	public ArrayList<Jugador> procesarInfo() {
		ArrayList<Jugador> jugadors = new ArrayList<>();
		Jugador jugador;
		//procesarMatriz();
		System.out.println("Resultado final campeonato");
		for (int i = 0; i < this.jugadores.length; i++) {
			jugador = instanciarJugadores(jugadores[i]);
			for (int j = 0; j < this.torneos.length; j++) {
				jugador.procesarResultado(resultados[i][j]);
			}
			jugadors.add(jugador);
		}
		return jugadors;
	}

	public void mostrarArray() {
		ArrayList<Jugador> jugadors = new ArrayList<>();
		jugadors = procesarInfo();
		for (Jugador j : jugadors) {
			System.out.println(j.toString());
		}
	}

	private Jugador instanciarJugadores(String nombre) {
		return new Jugador(nombre);
	}

	public void procesarMatriz() {
		for (int i = 0; i < this.resultados.length; i++) {
			for (int j = 0; j < this.resultados[i].length; j++) {
				System.out.print (resultados [i][j] + "  ");
			}
			System.out.println();
		}

	}

	public String procesarTorneosJugador(String jugador) {
		String competencias = "";
		int posJ = buscoJugador(jugador);
		if (posJ != -1) {
			competencias += jugador + ": ";
			for (int i = 0; i < this.torneos.length; i++) {
				competencias += this.torneos[i] +  ":" + this.resultados[posJ][i] + " ";
			}
		}
		return competencias;
	}

	public String obtenerResultadoJugador(String jugador, String torneo) {
		int posJ = buscoJugador(jugador);
		int posT = buscoTorneo(torneo);
		String resultado = "";
		if (posJ != -1 && posT != -1) {
			resultado += "Resultado de " + this.jugadores[posJ] + " en " + this.torneos[posT] + ":" + 
					this.resultados[posJ][posT];
		}
		return resultado; 

	}

	private int buscoJugador(String jugador) {
		int posJugador = -1;
		int i = 0;
		while (i < this.jugadores.length && posJugador == -1) {
			if (this.jugadores[i].equals(jugador)) {
				posJugador = i;
			} else {
				i++;
			}
		}
		return posJugador;
	}


	private int buscoTorneo(String torneo) {
		int posTorneo = -1;
		int i = 0;
		while (i < this.torneos.length && posTorneo == -1) {
			if (this.torneos[i] == torneo) {
				posTorneo = i;
			} else {
				i++;
			}
		}
		return posTorneo;
	}
	public int procesarPeorPosTorneoJugador(String jugador) {
		int posJ = buscoJugador(jugador);
		int resultado = -1;
		int peorResultado = 0;
		for (int i = 0; i < this.torneos.length; i++) {
			if (this.resultados[posJ][i] > peorResultado) {
				peorResultado = this.resultados[posJ][i];
			}
		}
		return resultado = peorResultado;		
	}
	
	public String imprimirPeorPosJugador(String jugador) {
		int r = procesarPeorPosTorneoJugador(jugador);
		String resultado;
		resultado = "Peor Resultado de " + jugador + " en el año: " + r; 
		
		return resultado;
	}
}
