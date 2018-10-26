package juego;

import disparos.Disparo;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public class VisitorGanar implements Visitor{

	private boolean hayEnemigos, estaJugador;
	
	public VisitorGanar() {
		hayEnemigos = false;
		estaJugador = false;
	}
	
	public boolean gano() {
		return !hayEnemigos && estaJugador;
	}
	
	@Override
	public void visitar(NaveEnemiga n) {
		hayEnemigos = true;
	}

	@Override
	public void visitar(NaveAliada n) {
		estaJugador = true;
	}

	@Override
	public void visitar(Obstaculo o) {
	}

	@Override
	public void visitar(PowerUp p) {
	}

	@Override
	public void visitar(Disparo d) {
	}

	public void reset() {
		hayEnemigos = false;
		estaJugador = false;
	}

}
