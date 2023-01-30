package EJ2;
public class Test {

	public static void main(String[] args) {
		
		
		Anio anio = new Anio();
		System.out.println(anio.getNombreDelMes(5));
		
		System.out.println(anio.getNombreDelMes(7));
		System.out.println(anio.getNombreDelMes(10));
		System.out.println(anio.getNombreDelMes(12));
		System.out.println(anio.getNombreDelMes(1));

		System.out.println();
		System.out.println(anio.diasTranscurridos(5));
		System.out.println(anio.diasTranscurridos(7));
		System.out.println(anio.diasTranscurridos(9));
		System.out.println(anio.diasTranscurridos(10));
		

	}
}
