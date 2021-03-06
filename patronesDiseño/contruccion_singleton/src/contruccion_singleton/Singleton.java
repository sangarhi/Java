package contruccion_singleton;

public class Singleton {
	
	private static Singleton singleton; //aqu? tendr?a valor null, porque es un OBJETO, si fuera un tipo primitivo HABR?A QUE DARLE VALOR (porque es un tipo est?tico)
	private String nombre;
	
	// El constructor es privado, no permite que se genere un constructor por defecto.
    private Singleton(String nombre) {
        this.nombre = nombre;
        System.out.println("Mi nombre es: " + this.nombre);
    }

    public static Singleton getSingletonInstance(String nombre) {
        if (singleton == null){
        	singleton = new Singleton(nombre);
        }
        else{
            System.out.println("No se puede crear el objeto "+ nombre + " porque ya existe un objeto de la clase SoyUnico");
        }
        
        return singleton;
    }

	

}
