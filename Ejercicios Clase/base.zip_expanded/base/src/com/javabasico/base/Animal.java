//Declaraci�n de paquete. Define estructura dentro del proyecto o funcionalidad de la clase
package com.javabasico.base;


//Declaraci�n de importaciones
//Paquete importado por defecto java.lang.*
import java.util.Date;
//import java.util.*; Redundante, innecesario

/*Comentario de multiples lineas
 * las palabras public y casa  son palabras reservadas o Keywords
 * El nombre de la clase debe tener notaci�n camello may�scula: NombreDeMiClase
 * El nombre de la clase debe coincidir  con el nombre del fichero java.
 * Usualmente la relaci�n entre fichero y clases es declarar una clase por fichero, 
 * pero puede haber m�s declaradas, al menos una.
 * La Clase es la defici�n de un objeto. 
 * Un Objeto es tal cuando se reserva memoria para �l.
 * Todo objeto JAVA extiende de Object.
 * Estructura de la clase:
 * - Atributos
 * - Constructores
 * - Metodos de acceso � m�todos de negocio
 * 
 */
public class Animal {
	
	//Comentario de linea unica
	//Atributos Caracter�sticas de la clase �Que soy?
	
	int patas; //tipos primitivos: short, int, float, double, boolean, byte, char. Tienen siempre un valor por defecto 
	public Boolean acuatico; //Tipo Java: Integer, Float, Double, Boolean. Su valor por defecto es null 
	private String clase; //tipos propios String: caso especial de objeto
	protected String familia; //modificadores de acceso: private,protected, public y si no se indica se indica el de por defecto
	Date fechaNacimiento; //Tipos referencia
	
	//Notas: Inicializar = Declarar + Asignar. 
	
	
	//Constructores
	
	//Son m�todos especiales, que cuando se les invoca mediante "new" realizan la reserva en memoria 
	//construyendo los objetos con la definici�n dada de la clase
	//Deben tener el mismo nombre que la clase (notaci�n camello minuscula)
	//No retornan nada, porque de lo �nico que se deben de encargar es de la reserva en memoria 
	//o en casos excepcionales de alguna inicializaci�n de variables
	
	//Constructor por defecto
	
	//Si no se declara ning�n constructor este m�todo va a estar disponible por defecto
	//Si se declaro alg�n constructor, hay que declararlo para tenerlo disponible. 
	public Animal() {
	}


	//Constructor usando atributos
	public Animal(int patas, Boolean acuatico, String clase, String familia, Date fechaNacimiento) {
		this.patas = patas;
		this.acuatico = acuatico;
		this.clase = clase;
		this.familia = familia;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	//Nota: this Invoca a la propia instancia del objeto (a si mismo)
	
	//M�todos de la clase. �Que hago? 
	//Se nombran con notaci�n camello min�scula: nombreDeMiMetodo
	//Suelen ser verbos porque indican acciones u operaciones
	//Pueden devolver o no (palabra reservada void) un objeto o tipo primmitivo.
	public void nacer() {
		System.out.println("He nacido");
	}
	//Pueden tener un n�mero indeterminado de par�metros o no tenerlos
	//Los par�metros siempre van a indicar su  tipo de objeto y su nombre
	public String vivir(Integer dias) {
		String sVivo="Vivo";
		System.out.println(sVivo + dias);
		return sVivo;
	}
	public void morir() {
		System.out.println("Muero");
		
	}

	
	//M�todos de acceso � getter/setter: Son los m�todos de acceso a los atributos de la clase
	
	public int getPatas() {
		return patas;
	}


	public void setPatas(int patas) {
		this.patas = patas;
	}


	public Boolean getAcuatico() {
		return acuatico;
	}


	public void setAcuatico(Boolean acuatico) {
		this.acuatico = acuatico;
	}


	public String getClase() {
		return clase;
	}


	public void setClase(String clase) {
		this.clase = clase;
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
	
	
	//C�digo de instancia del objeto. Cuando se genere el objeto, este c�digo se ejecutar�
	{ //Declaraci�n de instancia de objeto
		System.out.println("Estoy instanciado");
	}

	//Metodo toString
	@Override
	public String toString() {
		return "Animal [patas=" + patas + ", acuatico=" + acuatico + ", clase=" + clase + ", familia=" + familia
				+ ", fechaNacimiento=" + fechaNacimiento + "]";
	}	
	

	
	
}
