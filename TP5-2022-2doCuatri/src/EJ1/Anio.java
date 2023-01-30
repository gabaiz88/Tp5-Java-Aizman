package EJ1;

public class Anio {

	private String[] mesesDelAnio = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", 
			"Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
	private int[] diasDeMeses = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	public Anio() {

	}

	public String getNombreDelMes(int numeroMes) {
		return mesesDelAnio[numeroMes-1];
	}
	
	public int diasTranscurridos(int numeroMes) {
		int dias = 0;
		int i;
		for(i = numeroMes-1; i >= 1; i--) {
			dias += this.diasDeMeses[i];
		}
		return dias;
	}
	
}
