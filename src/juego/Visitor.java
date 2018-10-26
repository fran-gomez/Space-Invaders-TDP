package juego;

import disparos.Disparo;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public interface Visitor {
	public void visitar(NaveEnemiga n);

	public void visitar(NaveAliada n);

	public void visitar(Obstaculo o);

	public void visitar(PowerUp p);

	public void visitar(Disparo d);
}
