package Inteligencias;

import java.awt.*;

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

		// Altura del juego - altura del powerup - barra de vida
		if (rec.y == Constantes.MAP_HEIGHT - rec.getHeight() - 8) {
			contador--;
			if (contador == 0) {
				powerUp.eliminar();
			}

		} else {
		    // Controlo que el powerup este entre la altura del mapa - la altura del powerup - la velocidad - la barra de vida
            // y la altura del mapa - la altura del powerup - barra de vida
		    if (rec.y > Constantes.MAP_HEIGHT - rec.getHeight() - 13 && rec.y <= Constantes.MAP_HEIGHT - rec.getHeight() - 8) {
		        // Le sumo lo que falta para que llegue a la altura del mapa - la altura del powerup - la barra de vida
                newY += Constantes.MAP_HEIGHT - rec.getHeight() - rec.y - 8;
            } else {
                newY += 5;
            }

            powerUp.cambiarUbicacion(rec.x, newY);
		}
	}
}
