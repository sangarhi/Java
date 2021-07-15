//Declaración de paquete. Define estructura dentro del proyecto o funcionalidad de la clase
package com.javabasico.base;


//Declaración de importaciones
//Paquete importado por defecto java.lang.*
import java.util.Date;
//import java.util.*; Redundante, innecesario

/*Comentario de multiples lineas
 * las palabras public y casa  son palabras reservadas o Keywords
 * El nombre de la clase debe tener notación camello mayúscula: NombreDeMiClase
 * El nombre de la clase debe coincidir  con el nombre del fichero java.
 * Usualmente la relación entre fichero y clases es declarar una clase por fichero, 
 * pero puede haber más declaradas, al menos una.
 * La Clase es la defición de un objeto. 
 * Un Objeto es tal cuando se reserva memoria para él.
 * Todo objeto JAVA extiende de Object.
 * Estructura de la clase:
 * - Atributos
 * - Constructores
 * - Metodos de acceso ó métodos de negocio
 * 
 */
public class EjemploClase {
	
	//Comentario de linea unica
	//Atributos Características de la clase ¿Que soy?
	
	int numElementos; //tipos primitivos: short, int, float, double, boolean, byte, char. Tienen siempre un valor por defecto 
	public Boolean mcaActivo; //Tipo Java: Integer, Float, Double, Boolean. Su valor por defecto es null 
	private String nombre; //tipos propios String: caso especial de objeto
	protected String familia; //modificadores de acceso: private,protected, public y si no se indica se indica el de por defecto
	Date fechaNacimiento; //Tipos referencia
	
	//Notas: Inicializar = Declarar + Asignar. 
	
	
	//Constructores
	
	//Son métodos especiales, que cuando se les invoca mediante "new" realizan la reserva en memoria 
	//construyendo los objetos con la definición dada de la clase
	//Deben tener el mismo nombre que la clase (notación camello minuscula)
	//No retornan nada, porque de lo único que se deben de encargar es de la reserva en memoria 
	//o en casos excepcionales de alguna inicialización de variables
	
	//Constructor por defecto
	
	//Si no se declara ningún constructor este método va a estar disponible por defecto
	//Si se declaro algún constructor, hay que declararlo para tenerlo disponible. 
	public EjemploClase() {
	}


	//Constructor usando atributos
	protected EjemploClase(int numElementos, Boolean mcaActivo, String nombre, String familia, Date fechaNacimiento) {
		super();
		this.numElementos = numElementos;
		this.mcaActivo = mcaActivo;
		this.nombre = nombre;
		this.familia = familia;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//Nota: this Invoca a la propia instancia del objeto (a si mismo)
	
	//Métodos de la clase. ¿Que hago? 
	//Se nombran con notación camello minúscula: nombreDeMiMetodo
	//Suelen ser verbos porque indican acciones u operaciones
	//Pueden devolver o no (palabra reservada void) un objeto o tipo primmitivo.
	public void nacer() {
		System.out.println("He nacido");
	}
	


	//Pueden tener un número indeterminado de parámetros o no tenerlos
	//Los parámetros siempre van a indicar su  tipo de objeto y su nombre
	public String vivir(Integer dias) {
		String sVivo="Vivo";
		System.out.println(sVivo + dias);
		return sVivo;
	}
	public void morir() {
		System.out.println("Muero");
		
	}

	
	//Métodos de acceso ó getter/setter: Son los métodos de acceso a los atributos de la clase
	public int getNumElementos() {
		return numElementos;
	}


	public void setNumElementos(int numElementos) {
		this.numElementos = numElementos;
	}


	public Boolean getMcaActivo() {
		return mcaActivo;
	}


	public void setMcaActivo(Boolean mcaActivo) {
		this.mcaActivo = mcaActivo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getFamilia() {
		return familia;
	}


	public void setFamilia(String familia) {
		this.familia = familia;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}	
	
	//Código de instancia del objeto. Cuando se genere el objeto, este código se ejecutará
		{ //Declaración de instancia de objeto
			System.out.println("Estoy instanciado");
		}
		//Metodo toString

		@Override
		public String toString() {
			return "EjemploClase [numElementos=" + numElementos + ", mcaActivo=" + mcaActivo + ", nombre=" + nombre
					+ ", familia=" + familia + ", fechaNacimiento=" + fechaNacimiento + "]";
		}

		
		
	
	
}
