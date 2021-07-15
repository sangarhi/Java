package com.proyecto.ln;

import java.util.List;

public interface ICrud<E,K> {

	//Todos los m�todos son abstract (no  tienen implementaci�n de c�digo)
	//Por ahora todos los m�todos de una interfaz van a ser p�blicos. (AHORA ESTO ES MENTIRA)

	//Notacion de genericos
	// se puede utilizar cualquier letra, pero se como buena pr�ctica
	// E - Elemento
	// T - Tipo (Clase o una Interfaz)
	// K - Clave (identificadores o claves de elementos de Collections - HasHMap, HashTree)
	// V - Valor (valores de elementos de Collections - HahsMap, HashTree)
	// N - Number, cualquier valor num�rico
	
		public abstract List<E> selectAll();

		public  E selectById(K id);

		abstract int insert(E element);

		void update(E element);

		int delete(K id);
}
