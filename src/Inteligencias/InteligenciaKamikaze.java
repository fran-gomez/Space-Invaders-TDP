package Inteligencias;

import naves.NaveEnemiga;

public class InteligenciaKamikaze extends Inteligencia {

	private static InteligenciaKamikaze intel;

	private InteligenciaKamikaze() {
		intel = null;
	}

	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		// TODO
	}

	public static InteligenciaKamikaze getInstance() {
		if (intel == null) {
			intel = new InteligenciaKamikaze();
		}
		return intel;
	}

}
