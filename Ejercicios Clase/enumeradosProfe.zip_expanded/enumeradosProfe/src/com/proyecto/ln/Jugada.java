package com.proyecto.ln;

import com.proyecto.comun.Movimientos;

public class Jugada {

	int posicionHorizontal = 50; // posicion mitad pantalla
	int posicionVertical = 50;// posicion mitad pantalla

	public void mover(Movimientos movimiento) {

		switch (movimiento) {
		case ARRIBA: {
			posicionVertical++;
			break;
		}
		case ABAJO: {
			posicionVertical--;
			break;
		}
		case DERECHA: {
			posicionHorizontal++;
			break;
		}
		case IZQUIERDA: {
			posicionHorizontal--;
			break;
		}

		}

	}

	@Override
	public String toString() {
		return "Jugada [posicionHorizontal=" + posicionHorizontal + ", posicionVertical=" + posicionVertical + "]";
	}
	

}
