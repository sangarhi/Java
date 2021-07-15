package ejemploPrRapido.negocio.interfaces;

import ejemploPrRapido.data.Empleado;
import ejemploPrRapido.negocio.exceptions.NegocioException;

public interface IService {

	Empleado dameEmpleado(int idEmpleado) throws NegocioException;

}