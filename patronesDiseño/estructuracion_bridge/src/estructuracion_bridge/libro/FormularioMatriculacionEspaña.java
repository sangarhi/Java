package estructuracion_bridge.libro;

public class FormularioMatriculacionEspaņa extends  
FormularioMatriculacion  
{  
public FormularioMatriculacionEspaņa(FormularioImpl  
  implementacion)   
{ 
  super(implementacion);  
} 

protected boolean controlZona(String matricula)  
{  
  return matricula.length() == 7;  
}  
}
