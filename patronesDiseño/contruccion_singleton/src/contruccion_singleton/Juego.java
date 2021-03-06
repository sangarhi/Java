package contruccion_singleton;

public class Juego {
	
	private static Juego instancia;
	
	private int numJugadores;
	private String nombre;

	public Juego() {
		super();
	}

	public Juego(int numJugadores) {
		super();
		this.numJugadores = numJugadores;
	}
	
	public Juego(int numJugadores, String nombre) {
		super();
		this.numJugadores = numJugadores;
		this.nombre = nombre;
	}
	
	public static Juego getJuego() {
		if (instancia  == null) {
			instancia = new Juego();
		}
		return instancia;
	}
	
	public static Juego getJuego(int numJugadores, String nombre) {
		if (instancia  == null) {
			instancia = new Juego(numJugadores, nombre);
		}
		return instancia;
	}

	public int getNumJugadores() {
		return numJugadores;
	}

	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
	

}
