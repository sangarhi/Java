import org.apache.log4j.Logger;

import com.mysqlHR.dao.DepartamentoDAO;
import com.mysqlHR.dao.exceptions.DAOException;
import com.mysqlHR.dao.interfaces.IDAO;
import com.mysqlHR.data.Departamento;

public class App {
	private static final Logger log = Logger.getLogger(App.class);

	public static void main(String[] args) {

		try {
			IDAO<Long, Departamento> dao = new DepartamentoDAO();
			dao.findAll().forEach(x -> log.debug(x));

		} catch (DAOException e) {

			e.printStackTrace();
		}

	}
}
