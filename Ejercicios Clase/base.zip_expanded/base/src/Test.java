import java.util.Date;

import com.javabasico.base.Animal;
/**
 * Clase para realizar pruebas con la clase Animal
 * @author MARIA
 * @version 1.0
 * @see Animal
 */
public class Test {
	//Declaramos una variable de tipo Animal, se tiene que IMPORTAR ya que no est� en el mismo paquete
	private Animal animal;
	Date fecNacimiento;
	int contador=0;

	//Metodo especial es el punto de acceso de la JVM.
	//Se puede incluir en cualquier  clase, pero no se puede invocar, solo lo invoca la m�quina virtual
	public static void main(String[] args) {
		Test test = new Test();
		test.animal = new Animal();
		test.fecNacimiento = test.animal.getFechaNacimiento();
		
		//Se invoca directamente al m�todo toString que tienen todos los objetos JAVA
		System.out.println(test.animal);
		System.out.println("Contador:"+test.contador);
		int contador = test.contador;
		System.out.println("Contador sumado:"+test.sumar(contador));
		test.destruir();	
		
	}
	/**
	 * M�todo que suma
	 * @param contador
	 * @return valor final de la suma del contador con la variable local de m�todo i
	 */
	public int sumar(int contador){
		int i = 2;
		return contador+i;
		
	}
	/**
	 * M�todo de destrucci�n
	 * @throws Throwable 
	 */
	public void destruir() {
		System.out.println("Me apago....");
		try {
			this.finalize();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	{//Declaraci�n de instancia de objeto
		int cuenta =0;
		System.out.println("Inicio el Test");
		System.out.println("Cuenta:"+cuenta);
		contador=contador+1;
	}

}
