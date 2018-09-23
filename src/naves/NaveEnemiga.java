package naves;

import java.util.Random;

import Inteligencias.Inteligencia;
import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import disparos.FabricaDisparos;
import juego.GameObject;
import juego.Nave;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public abstract class NaveEnemiga extends Nave {

	protected Inteligencia inteligencia;
	protected PowerUp powerUp;

	public NaveEnemiga(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Inteligencia inteligencia, FabricaDisparos fab) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, fab);
		this.inteligencia = inteligencia;
	}

	@Override
	public void mover() {
		inteligencia.actualizarPosicion(this);

		// DISPARO RANDOM
		Random rnd = new Random();
		if (rnd.nextInt(100) == 0) {
			disparar();
		}
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	@Override
	public void colision(NaveAliada na) {
		na.recibirDano(state.getDmg());
	}

	@Override
	public void colision(DisparoSimple disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(DisparoTriple disparo) {
		disparo.eliminar();
	}
	
	@Override
	public void colision(DisparoPenetrante disparo) {
	}
	
	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}
	
	@Override
	public abstract NaveEnemiga clone();

}
