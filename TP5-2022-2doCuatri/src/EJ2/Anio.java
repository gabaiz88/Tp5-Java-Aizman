package EJ2;

public class Anio {

	public Mes mes;
	private int[] diasDeMeses = {31,28,31,30,31,30,31,31,30,31,30,31};
	
	
	public Anio() {
	}

	
	public String getNombreDelMes(int numeroMes) {
		String nombreMes = null;
		
		for (Mes mes : this.mes.values()) {
			if(mes.ordinal() + 1 == numeroMes) {
				nombreMes = mes.name();
			}
		}
		return nombreMes;
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
