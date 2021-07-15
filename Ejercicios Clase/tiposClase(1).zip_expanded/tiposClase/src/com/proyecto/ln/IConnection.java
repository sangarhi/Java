package com.proyecto.ln;

import java.sql.Connection;

public interface IConnection {
	
	Connection connectBBDD(int tipoConexion,String user,String password);

}
