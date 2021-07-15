import com.javabasico.base.practicas.Calculadora;

public class TestCalculadora {

	public static void main(String[] args) {
		//Inicializamos dos variables de tipo entero
		int numero1 =  1234;
		int numero2 = 2;
		
		//Invocamos a los métodos estáticos de la calculadora
		Calculadora.suma(numero1, numero2);
		Calculadora.resta(numero1, numero2);
		Calculadora.multiplicacion(numero1, numero2);
		Calculadora.division(numero1, numero2);
		
		//Invocar al método no estático para que realice la suma de lo  números

		Calculadora suma = new Calculadora();
		Integer num1 =  1234;
		Integer num2 = 2;
		suma.suma(num1, num2);
	}

}
