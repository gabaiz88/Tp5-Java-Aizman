package EJ3;

import java.util.ArrayList;
import java.util.List;

public class GastoAnual {

	final static String IMPORTE_INVALIDO = "El importe es menor a 0";
	private Mes mes; 
	private ArrayList<Rubro> rubros;
	
	public GastoAnual() {
		this.rubros = new ArrayList<>();
	}
	
	public void agregarGasto(Mes mes, String nombreRubro, double importe) {
		Rubro rubro = obtenerRubro(nombreRubro);
		if (importe < 0) {
			throw new IllegalArgumentException(IMPORTE_INVALIDO);
		}
		rubro.agregarGasto(mes, importe);
		System.out.println("Se agrego el gasto de " + importe + " al mes: " + mes);
	}

	private Rubro obtenerRubro (String nombreRubro) {
		Rubro rubro = buscarRubro(nombreRubro);
		if (rubro == null) {
			rubro = new Rubro(nombreRubro);
			this.rubros.add(rubro);
		}
		return rubro;
	}
	
	private Rubro buscarRubro (String nombreRubro) {
		Rubro rubroAdevolver = null;
		int i = 0;
		while(i < this.rubros.size() && rubroAdevolver == null) {
			if (this.rubros.get(i).getNombre().equals(nombreRubro)) {
				rubroAdevolver = this.rubros.get(i);
			}
			else {
				i++;
			}
		}
		return rubroAdevolver;
	}
	
	private double[][] consolidadoDeGastos(){
		double [][] matriz = new double[this.rubros.size()][Mes.cantidadMeses()];		
		for (int i = 0; i < this.rubros.size(); i++) {
			for (int j = 0; j < Mes.cantidadMeses() ; j++) {
				matriz[i][j] = this.rubros.get(i).getGastoPorMes(j);				
				}
			}
		return matriz;
	}
	
	public void informarConsumosPorMes() {
		double [][] matriz = consolidadoDeGastos();
		System.out.print("               ");
		for ( Mes mes : mes.values()) {
			System.out.print(mes.toString()+ "   ");
		}
		System.out.println();
		for (int i = 0; i < matriz.length; i ++) {
			System.out.print(this.rubros.get(i).getNombre() + ":   ");
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print (matriz [i][j] + "      ");
			}
			System.out.println("\n");
		}
	}
	
	public double gastoAcumulado(Mes mes) {
		double gastoAcum = 0;
		for(Rubro rubro : this.rubros) {
			gastoAcum += rubro.getTotalGastos(mes);
		}
		return gastoAcum;
	}
	
	
	public double gastoAcumulado(String nombreRubro) {
		double gastoAcum = 0;
		Rubro rubro = buscarRubro(nombreRubro);
		if (rubro == null) {
			gastoAcum = -1;
		} else {
			gastoAcum = rubro.getTotalAcumuladoPorRubro();
		}
		return gastoAcum;
	}
	
	
	public void agregarRubro(Rubro rubro) {
		this.rubros.add(rubro);
		System.out.println("agregado");
	}
	
	public void listarRubros () {
		for (Rubro r : this.rubros) {
			System.out.println(r.toString());
		}
	}
	
	public void informarPromedioMensualPorRubro() {
		double [][] matriz = consolidadoDeGastos();
		System.out.print("               ");
		for ( Mes mes : mes.values()) {
			System.out.print(mes.toString()+ "   ");
		}
		System.out.println();
		for (int i = 0; i < matriz.length; i ++) {
			System.out.print(this.rubros.get(i).getNombre() + ":   ");
			for (int j = 0; j < matriz[i].length; j++) {
				if (this.rubros.get(i).getContadorOpeaciones()[j] != 0) {
					System.out.print (matriz [i][j] / this.rubros.get(i).getContadorOpeaciones()[j] + "      ");
				} else {
					System.out.print(matriz [i][j] + "      ");
				}
			}
			System.out.println("\n");
		}
	}

	public void informarMesMayorConsumo() {
		double mayorMesGasto = 0;
		Mes mesMayor = null; 
		for (Mes mes : mes.values()) {
			if (gastoAcumulado(mes) > mayorMesGasto) {
				mesMayor = mes;
				mayorMesGasto = gastoAcumulado(mes);
			}
		}
		System.out.println(mesMayor.name() + " " + mayorMesGasto);
	}

}
