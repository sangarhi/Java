package contruccion_singleton;

public class Test {

	public static void main(String[] args) {

		/*String nombre = "clase";
		Singleton clase = Singleton.getSingletonInstance(nombre); // Para crear una instancia
		
		System.out.println(clase);
		
		Singleton clase2 = Singleton.getSingletonInstance(nombre);*/
		
		Casa casa1 = Casa.getCasa();
		int numHabitaciones = 3;
		int numBa?os = 2;
		
		Casa casa2 = Casa.getCasa();
		
		System.out.println(casa1);
		System.out.println(casa2); // Son el mismo objeto, as? que si cambias algo en una, afectar? a la otra porque tienen lo mismo
		
		casa1.setNumBa?os(1);
		System.out.println("N?mero de ba?os: " + casa2.getNumBa?os());
		
		Juego juego1 = Juego.getJuego();
		System.out.println(juego1);
		
		
		

	}

}
