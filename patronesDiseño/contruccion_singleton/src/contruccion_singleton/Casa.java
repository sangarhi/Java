package contruccion_singleton;

/**
 * 
 * @author Sandra
 * 
 * Para generar un Singleton, tener una ?nica instancia para todo el sistema ( o aplicativo)
 * se tienen que realizar las siguientes modificaciones:
 * - TODOS LOS CONSTRUCTORES TIENEN QUE SER PRIVADOS
 * - IMPLEMENTAR UNA VARIABLE PRIVADA EST?TICA QUE SERA UNA INSTANCIA DE LA CLASE, que sea del tipo de la clase
 * - EXISTA AL MENOS UN M?TODO EST?TICO P?BLICO que nos devuelva la instancia de la clase
 *   y que dentro, si la variable est?tica privada vale null invoque a un constructor para que almacene una instancia de la clase
 *
 */
public class Casa {
	
	//Variable est?tica que almacena la instancia. Se hace est?tica para que el m?todo est?tico pueda acceder a ella
	private static Casa instancia; //tiene que tener referencia a la propia clase
	
	private int numHabitaciones;
	private int numBa?os;
	
	// Constructores privados
	private Casa() {
		super();
	}

	private Casa(int numHabitaciones, int numBa?os) {
		super();
		this.numHabitaciones = numHabitaciones;
		this.numBa?os = numBa?os;
	}
	
	// M?TODO EST?TICO  que va a devolver una instancia. Desde un m?todo est?tico s?lo puedes acceder a variables que sean est?ticas
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

	public int getNumBa?os() {
		return numBa?os;
	}

	public void setNumBa?os(int numBa?os) {
		this.numBa?os = numBa?os;
	}
	
	
	
	

}
