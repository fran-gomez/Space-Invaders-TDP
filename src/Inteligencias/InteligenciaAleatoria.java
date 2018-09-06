package Inteligencias;

import naves.NaveEnemiga;

public class InteligenciaAleatoria extends Inteligencia {

	private static InteligenciaAleatoria intelAleatoria;
	
	private InteligenciaAleatoria() {
		intelAleatoria = null;
	}
	
	@Override
	public void actualizarPosicion(NaveEnemiga nave) {
		//TODO
	}
	
	public static InteligenciaAleatoria getInstance() {
		if(intelAleatoria == null) {
			intelAleatoria = new InteligenciaAleatoria();
		}
		return intelAleatoria;
	}

}
