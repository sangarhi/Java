package ejemploPrRapido.negocio;

import ejemploPrRapido.data.Empleado;
import ejemploPrRapido.negocio.exceptions.NegocioException;
import ejemploPrRapido.negocio.interfaces.IService;
import ejemploPrRapido.negocio.management.GesDepartamento;
import ejemploPrRapido.negocio.management.GesEmpleado;
import ejemploPrRapido.negocio.management.interfaces.IServEmpleadosDepartamento;
import ejemploPrRapido.negocio.management.interfaces.IServNomina;

public class ServImpl implements IService {
	GesEmpleado gesEmpleado;
	GesDepartamento  gesDepartamento;
	IServNomina servNomina;
	IServEmpleadosDepartamento servEmpleadosDepartamento;
	
	/* (non-Javadoc)
	 * @see ejemploPrRapido.negocio.IService#dameEmpleado(int)
	 */
	@Override
	public Empleado dameEmpleado(int idEmpleado) throws NegocioException{
		Empleado empleado = null;
		
		gesEmpleado = new GesEmpleado();
		empleado = gesEmpleado.getEmpleado(idEmpleado);
		
		return empleado;
	}

}
