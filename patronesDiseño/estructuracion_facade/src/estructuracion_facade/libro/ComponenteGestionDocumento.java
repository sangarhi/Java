package estructuracion_facade.libro;

public class ComponenteGestionDocumento implements GestionDocumento  
{  
  
    public String documento(int indice)  
    {  
        return "Documento n�mero " + indice;  
    }  
}