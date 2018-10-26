package Inteligencias;

import naves.NaveEnemiga;

public class InteligenciaStop extends Inteligencia {

	private int contador;
	private Inteligencia previa;

	public InteligenciaStop(int contador, NaveEnemiga ne) {
		super();
		this.contador = contador;
		this.previa = ne.obtenerInteligencia();
	}

	@Override
	public void actualizarPosicion(NaveEnemiga ne) {
		contador--;

		if (contador == 0)
			ne.setInteligencia(previa);
	}
}
