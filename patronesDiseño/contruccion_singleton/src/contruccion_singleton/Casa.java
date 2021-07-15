package contruccion_singleton;

/**
 * 
 * @author Sandra
 * 
 * Para generar un Singleton, tener una única instancia para todo el sistema ( o aplicativo)
 * se tienen que realizar las siguientes modificaciones:
 * - TODOS LOS CONSTRUCTORES TIENEN QUE SER PRIVADOS
 * - IMPLEMENTAR UNA VARIABLE PRIVADA ESTÁTICA QUE SERA UNA INSTANCIA DE LA CLASE, que sea del tipo de la clase
 * - EXISTA AL MENOS UN MÉTODO ESTÁTICO PÚBLICO que nos devuelva la instancia de la clase
 *   y que dentro, si la variable estática privada vale null invoque a un constructor para que almacene una instancia de la clase
 *
 */
public class Casa {
	
	//Variable estática que almacena la instancia. Se hace estática para que el método estático pueda acceder a ella
	private static Casa instancia; //tiene que tener referencia a la propia clase
	
	private int numHabitaciones;
	private int numBaños;
	
	// Constructores privados
	private Casa() {
		super();
	}

	private Casa(int numHabitaciones, int numBaños) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.numBaños = numBaños;
	}
	
	// MÉTODO ESTÁTICO  que va a devolver una instancia. Desde un método estático sólo puedes acceder a variables que sean estáticas
	public static Casa getCasa() {
		if (instancia == null) instancia = new Casa();
		return instancia;
	}

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public int getNumBaños() {
		return numBaños;
	}

	public void setNumBaños(int numBaños) {
		this.numBaños = numBaños;
	}
	
	
	
	

}
