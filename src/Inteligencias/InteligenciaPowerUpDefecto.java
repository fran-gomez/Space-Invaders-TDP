package Inteligencias;

import java.awt.Rectangle;

import power_ups.PowerUp;
import utilidades.Constantes;

public class InteligenciaPowerUpDefecto extends Inteligencia {

	private int contador;

	public InteligenciaPowerUpDefecto() {
		contador = 100;
	}

	public void actualizarPosicion(PowerUp powerUp) {
		Rectangle rec = powerUp.getRectangle();

		float newY = rec.y;
		if (rec.y >= Constantes.MAP_HEIGHT - rec.getHeight()) {
			contador--;
			if (contador == 0) {
				powerUp.eliminar();
			}

		} else {
			newY += 5;
			powerUp.cambiarUbicacion(rec.x, newY);
		}
	}

}