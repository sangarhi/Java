import org.apache.log4j.Logger;

import com.oracleHR.dao.DepartamentoDAO;
import com.oracleHR.dao.exceptions.DAOException;
import com.oracleHR.dao.interfaces.IDAO;
import com.oracleHR.data.Departamento;

public class App {

	private static final Logger log = Logger.getLogger(App.class);
	
	public static void main(String[] args) {		
		
		try {
			IDAO<Long, Departamento> dao = new DepartamentoDAO();			
			dao.findAll().forEach(x ->log.debug(x));
			
		} catch (DAOException e) {
			
			e.printStackTrace();
		}

	}

}
