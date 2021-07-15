package constructores;

public class Casa {

	private int numHabitaciones;
	private int numBa�os;

	public Casa() {
		System.out.println("CONSTRUCTOR POR DEFECTO. YO HAGO LA RESERVA DE MEMORIA");
	}
	

	public Casa(int pepe) {
		this();
		System.out.println("Constructor 1 paramatro INT");
		System.out.println("this:" + this);
		System.out.println("Parametro numHabitaciones" + pepe);
		System.out.println("Atributo numHabitaciones" + this.numHabitaciones);
		this.numHabitaciones = pepe;
		System.out.println("Atributo numHabitaciones" + this.numHabitaciones);
	
	}
	public Casa(int mary,int lola) {
		this(lola);
		System.out.println("Estoy en el 2 parametros");
		
		this.numBa�os = mary;
	
	}

	

	public int getNumHabitaciones() {
		return numHabitaciones;
	}

	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones = numHabitaciones;
	}

	public Integer getNumBa�os() {
		return numBa�os;
	}

	public void setNumBa�os(Integer numBa�os) {
		this.numBa�os = numBa�os;
	}
}
