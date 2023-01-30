package EJ3;

public enum Mes {
	ENERO, FEBRERO, MARZO, ABRIL, MAYO, JUNIO, JULIO, AGOSTO, SEPTIEMBRE, OCTUBRE, NOVIEMBRE, DICIEMBRE;
	
	private final static int CANT_MESES = 12;
	private static int contadorGastos = 0;
	private static double gastoAcum = 0;
	
	protected static double getGastoAcum() {
		return gastoAcum;
	}

	protected static void setGastoAcum(double gastoAcum) {
		Mes.gastoAcum += gastoAcum;
	}

	public static int cantidadMeses(){
		return CANT_MESES;
	}
	
	public void setContador(int numero) {
		contadorGastos += numero;
	}
	
	public static int getContadorGastos() {
		return contadorGastos;
	}
	
}
