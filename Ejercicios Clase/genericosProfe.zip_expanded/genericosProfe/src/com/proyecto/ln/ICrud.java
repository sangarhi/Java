package com.proyecto.ln;

import java.util.List;

public interface ICrud<E,K> {

	//Todos los métodos son abstract (no  tienen implementación de código)
	//Por ahora todos los métodos de una interfaz van a ser públicos. (AHORA ESTO ES MENTIRA)

	//Notacion de genericos
	// se puede utilizar cualquier letra, pero se como buena práctica
	// E - Elemento
	// T - Tipo (Clase o una Interfaz)
	// K - Clave (identificadores o claves de elementos de Collections - HasHMap, HashTree)
	// V - Valor (valores de elementos de Collections - HahsMap, HashTree)
	// N - Number, cualquier valor numérico
	
		public abstract List<E> selectAll();

		public  E selectById(K id);

		abstract int insert(E element);

		void update(E element);

		int delete(K id);
}
