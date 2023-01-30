package EJ3;

public class Test {

	public static void main(String[] args) {
		
		GastoAnual gasto = new GastoAnual();
		Rubro rubro = new Rubro("Supermercado");
		gasto.agregarRubro(rubro);
		try {
		gasto.agregarGasto(Mes.ABRIL, "Supermercado", 200);
		gasto.agregarGasto(Mes.ABRIL, "Supermercado", 300);
		gasto.agregarGasto(Mes.DICIEMBRE, "Supermercado", 220.5);
		gasto.agregarGasto(Mes.MAYO, "Farmacia", 150);
		gasto.agregarGasto(Mes.ENERO, "Farmacia", 200);
		gasto.agregarGasto(Mes.ENERO, "Farmacia", 700);
		gasto.agregarGasto(Mes.JUNIO, "Verduleria", 130.5);
		gasto.agregarGasto(Mes.JUNIO, "Verduleria", 260);
		gasto.agregarGasto(Mes.ABRIL, "Verduleria", 180);
		gasto.agregarGasto(Mes.FEBRERO, "Verduleria", -100);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		System.out.println(gasto.gastoAcumulado(Mes.ABRIL));
		System.out.println(gasto.gastoAcumulado("Supermercado"));
		System.out.println(gasto.gastoAcumulado("Verduleria"));
		System.out.println();
		gasto.informarConsumosPorMes();
		System.out.println();
		gasto.listarRubros();
		gasto.informarPromedioMensualPorRubro();
		gasto.informarMesMayorConsumo();
	}

}
