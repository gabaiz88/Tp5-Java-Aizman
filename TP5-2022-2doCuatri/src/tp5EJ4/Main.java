package tp5EJ4;

public class Main {

	public static void main(String[] args) {
	
		CircuitoATP circuito = new CircuitoATP();
		circuito.mostrarArray();
		System.out.println(circuito.procesarTorneosJugador("Delbonis"));
		System.out.println(circuito.obtenerResultadoJugador("Schwartzman", "RolandGarros"));
		System.out.println(circuito.imprimirPeorPosJugador("Pella"));
	}

}
