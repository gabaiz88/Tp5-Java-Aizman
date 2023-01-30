package EJ3;

import java.util.Arrays;

public class Rubro {

	final static int TOTAL_MESES = 12;
	private String nombre;
	private double[] gastoPorMes;
	private int[] contadorOpeaciones;
	
	public Rubro(String nombre) {
		this.nombre = nombre;
		this.contadorOpeaciones = new int[TOTAL_MESES];
		this.gastoPorMes = new double[TOTAL_MESES];
		inicializador(contadorOpeaciones);
		inicializador(gastoPorMes);
	}
	
	private void inicializador(double[] gastoPorMes2) {
		for (int i = 0; i < gastoPorMes2.length; i++) {
			gastoPorMes2[i] = 0;
		}
	}

	private void inicializador(int[] contadorOpeaciones2) {
		for (int i = 0; i < contadorOpeaciones2.length; i++) {
			contadorOpeaciones2[i] = 0;
		}
	}
	
	public void agregarGasto(Mes mes, double importe) {
		for (int i = 0; i < this.gastoPorMes.length; i++) {
			if(mes.ordinal() == i) {
				this.gastoPorMes[i] += importe;
				this.contadorOpeaciones[i]++;
			}
		}
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public double getTotalGastos(Mes mes) {
		return this.gastoPorMes[mes.ordinal()];
	}
	
	protected double getGastoPorMes (int mes) {
		return this.gastoPorMes[mes];
	}
	
	protected double getTotalAcumuladoPorRubro() {
		double total = 0;
		for (int i = 0; i < this.gastoPorMes.length; i++) {
			total += this.gastoPorMes[i];
		}
		return total;
	}

	@Override
	public String toString() {
		return "Rubro [nombre=" + nombre +"]";
	}

	protected int[] getContadorOpeaciones() {
		return contadorOpeaciones;
	}
	
	

	
}
