package Inteligencias;

import naves.NaveEnemiga;

public class InteligenciaDefecto extends Inteligencia {

private static InteligenciaDefecto intelDefecto;
	
	private InteligenciaDefecto() {
		intelDefecto = null;
	}
	
	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		//TODO
	}
	
	public static InteligenciaDefecto getInstance() {
		if(intelDefecto == null) {
			intelDefecto = new InteligenciaDefecto();
		}
		return intelDefecto;
	}

}
