package com.proyecto.data;


public class Casa {
 
   //Bloque atributos
    private int numHabitaciones;
    private int numBaños;
    private Integer m2cocina= 15; // Integer m2cocina= new Integer(15);
    private Integer m2;
	private Double alturaTecho=0.0d;//Double alturaTecho = new Double(0.0d);
	private int numVentana;
	private boolean aguaCaliente;
	
	
		
	
	//Bloque de constructores
	public Casa(int numHabitaciones) {
		this.numHabitaciones=numHabitaciones;
		System.out.println("En el constructor");
	}
	
	//Bloque de métodos
	//Getter/Setter
	public int getNumHabitaciones() {
		return this.numHabitaciones;
	}
	public void setNumHabitaciones(int numHabitaciones) {
		this.numHabitaciones=numHabitaciones;
	}
		
	
	public int getNumBaños() {
		return numBaños;
	}

	public void setNumBaños(int numBaños) {
		this.numBaños = numBaños;
	}

	public Integer getM2cocina() {
		return m2cocina;
	}

	public void setM2cocina(Integer m2cocina) {
		this.m2cocina = m2cocina;
	}

	public Integer getM2() {
		return m2;
	}

	public void setM2(Integer m2) {
		this.m2 = m2;
	}

	public Double getAlturaTecho() {
		return alturaTecho;
	}

	public void setAlturaTecho(Double alturaTecho) {
		this.alturaTecho = alturaTecho;
	}

	public int getNumVentana() {
		return numVentana;
	}

	public void setNumVentana(int numVentana) {
		this.numVentana = numVentana;
	}

	public boolean isAguaCaliente() {
		return aguaCaliente;
	}

	public void setAguaCaliente(boolean aguaCaliente) {
		this.aguaCaliente = aguaCaliente;
	}

	// métodos de negocio; comportamiento
	public void dejarPaquete() {
		System.out.println("DejarPaquete");
		
	}
	protected void encedenderCalefaccion() {
		System.out.println("Encender calefaccion");
	}
	private void encenderTV() {
		System.out.println("Encender TV");
	}
	void correrCortinas() {
		System.out.println("Correr cortinas");
		System.out.println("NumHabitaciones:"+numHabitaciones);
		System.out.println("alturaTecho:"+alturaTecho);
		encenderTV();
				
	}
	
	public Integer probarMetodo(int variable,  Double otraVariable, Casa casa) {
		
		System.out.println("variable:"+variable+" otraVariable:"+otraVariable+" casa:"+casa);
		
		int miResultado=15;
		boolean verdad=true;
		numBaños=numBaños+1;
		m2=90;
		m2=m2+10;
		verdad=!verdad;
		
		return miResultado;
	}
	
	{
		int variableInstancia=0;
		numHabitaciones=numHabitaciones+1;
		System.out.println("Codigo instancia:"+variableInstancia+"/"+numHabitaciones);
	}

	
}
