package Inteligencias;

import java.awt.Rectangle;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaAleatoria extends Inteligencia {

	private static InteligenciaAleatoria intelAleatoria;

	private Random rnd;

	private InteligenciaAleatoria() {
		intelAleatoria = null;
		rnd = new Random();
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		// TODO
		Rectangle rec = nave.getRectangle();
		int newX = (int) rec.getLocation().getX(), newY = (int) rec.getLocation().getY();
		int valorX = 0, valorY = 0;
		switch (rnd.nextInt(6)) {
		case 0:
		case 1:
		case 2: // Baja
			valorX = 0;
			valorY = 2;
			break;
		case 3: // Sube
			valorX = 0;
			valorY = -1;
			break;
		case 4: // Izquierda
			valorX = -1;
			valorY = 0;
			break;
		case 5: // Derecha
			valorX = 1;
			valorY = 0;
			break;
		}

		newX += valorX * Constantes.NAVE_ALEATORIA_VELOCIDAD;
		newY += valorY * Constantes.NAVE_ALEATORIA_VELOCIDAD;

		rec.setLocation(newX, newY);
		nave.setBounds(rec);
	}

	public static InteligenciaAleatoria getInstance() {
		if (intelAleatoria == null) {
			intelAleatoria = new InteligenciaAleatoria();
		}
		return intelAleatoria;
	}

}
