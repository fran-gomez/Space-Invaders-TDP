package Inteligencias;

import java.awt.Rectangle;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;
import utilidades.Vector;

public class InteligenciaAleatoria extends Inteligencia {

	private static InteligenciaAleatoria intelAleatoria;
	private static Map<NaveEnemiga, Vector> mapeoDestinoNave;

	private InteligenciaAleatoria() {
		super();
		intelAleatoria = null;
		rnd = new Random();
		mapeoDestinoNave = new HashMap<NaveEnemiga, Vector>();
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		super.actualizarPosicion(nave);

		Rectangle rec = nave.getRectangle();
		int newX = rec.x, newY = rec.y;

		Vector destino = mapeoDestinoNave.get(nave);
		if (destino == null || Vector.distanceBetween(destino.x(), destino.y(), rec.x, rec.y) < 10) {
			destino = new Vector(rnd.nextInt(Constantes.MAP_WIDTH), rec.y + 100);
			mapeoDestinoNave.put(nave, destino);
		}

		Vector direccion = new Vector(destino.x(), destino.y(), rec.x, rec.y);
		direccion.hacerUnitario();

		newX += Constantes.NAVE_ALEATORIA_VELOCIDAD * direccion.x();
		newY += Constantes.NAVE_ALEATORIA_VELOCIDAD * direccion.y();
		nave.cambiarUbicacion(newX, newY);
	}

	public static InteligenciaAleatoria getInstance() {
		if (intelAleatoria == null) {
			intelAleatoria = new InteligenciaAleatoria();
		}
		return intelAleatoria;
	}

}
