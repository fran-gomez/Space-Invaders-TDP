package Inteligencias;

import java.awt.Rectangle;

import naves.NaveAliada;
import naves.NaveEnemiga;
import utilidades.Constantes;

public class InteligenciaKamikaze extends Inteligencia {

	private static InteligenciaKamikaze intel;
	private static Inteligencia intelAux;
	private static NaveAliada jugador;
	private static NaveEnemiga actualMoviendose;

	private InteligenciaKamikaze() {
		super();
		intel = null;
		intelAux = InteligenciaDefecto.getInstance();
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);
		Rectangle rec = nave.getRectangle();

		// Si no hay ninguna moviendose, empezar a mover esta, si no hacer el movimiento
		// defecto
		if (actualMoviendose == null || !actualMoviendose.estaVivo()) {
			actualMoviendose = nave;
		}

		if (actualMoviendose == nave) {

			int newX = (int) rec.getX(), newY = (int) (rec.getY() + Constantes.NAVE_ALEATORIA_VELOCIDAD);

			if (jugador.getRectangle().getX() - rec.getX() > 0) {
				// El jugador está a la derecha
				newX += Constantes.NAVE_ALEATORIA_VELOCIDAD;
			} else {
				// El jugador está a la izquierda
				newX -= Constantes.NAVE_ALEATORIA_VELOCIDAD;
			}

			nave.cambiarUbicacion(newX, newY);
		} else {
			intelAux.actualizarPosicion(nave);
		}
	}

	public static InteligenciaKamikaze getInstance(NaveAliada j) {
		if (intel == null) {
			jugador = j;
			intel = new InteligenciaKamikaze();
		}
		return intel;
	}

}
