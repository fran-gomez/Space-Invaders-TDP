package Inteligencias;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaDefecto extends Inteligencia {

	private static InteligenciaDefecto intelDefecto;

	private static boolean movDer, movAbajo;
	private static HashMap<NaveEnemiga, Boolean> mapMover;

	private InteligenciaDefecto() {
		super();
		intelDefecto = null;
		movDer = true;
		new Random();
		mapMover = new HashMap<NaveEnemiga, Boolean>();
		movAbajo = false;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();
		int newX = rec.x, newY = rec.y;
		if (movDer) {
			if (movAbajo && mapMover.get(nave) != null) {
				movAbajo = false;
				mapMover = new HashMap<NaveEnemiga, Boolean>();
			}
			if (rec.getX() <= Constantes.MAP_WIDTH - Constantes.DEFAULT_SIZE) { // Se puede seguir moviendo a la derecha
				newX = rec.x + Constantes.NAVE_ALEATORIA_VELOCIDAD;
			} else {
				movDer = false;
			}
			if (movAbajo) {
				newY = rec.y + Constantes.NAVE_ALEATORIA_VELOCIDAD*3;
				mapMover.put(nave, true);
			}
		} else {
			if (rec.getX() >= 0) { // Se puede seguir moviendo a la izquierda
				newX = rec.x - Constantes.NAVE_ALEATORIA_VELOCIDAD;
			} else {
				movDer = true;
				movAbajo = true;
			}
		}

		nave.cambiarUbicacion(newX, newY);
	}

	public static InteligenciaDefecto getInstance() {
		if (intelDefecto == null) {
			intelDefecto = new InteligenciaDefecto();
		}
		return intelDefecto;
	}

}
