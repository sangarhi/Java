import org.apache.log4j.Logger;

import com.product.mysqlHRmaven.dao.DepartamentoDAO;
import com.product.mysqlHRmaven.dao.exceptions.DAOException;
import com.product.mysqlHRmaven.dao.interfaces.IDAO;
import com.product.mysqlHRmaven.data.Departamento;

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
