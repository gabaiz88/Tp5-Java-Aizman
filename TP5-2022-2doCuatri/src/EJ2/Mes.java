package EJ2;

public enum Mes {
	ENERO(1), FEBERO(2), MARZO(3), ABRIL(4), MAYO(5), JUNIO(6), JULIO(7), AGOSTO(8), SEPTIEMBRE(9), OCTUBRE(10), NOVIEMBRE(11), DICIEMBRE(12);
	
	public int numeroMes;

	Mes (int numeroMes) { 
		this.numeroMes = numeroMes;
	}

	
	protected int getNumeroMes() {
		return numeroMes;
	}
}
