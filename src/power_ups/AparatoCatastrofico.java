package power_ups;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import disparos.Disparo;
import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.Agregable;
import juego.GameObject;
import juego.Visitor;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class AparatoCatastrofico extends PowerUp implements Visitor{

	private int counter;
	
	public AparatoCatastrofico(int x, int y, int vida, int durabilidad, Agregable mapa) {
		super(x, y, vida, durabilidad, mapa);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.APARATOCATASTROFICO_WIDTH, Constantes.APARATOCATASTROFICO_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/doomsdayDevice.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada na) {
		eliminar();
		counter = 3;
		for(GameObject o: mapa.getGameObjects()) {
			o.aceptar(this);
		}
	}

	@Override
	public void colision(Obstaculo naveEnemiga) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
	}

	@Override
	public void colision(DisparoSimple disparo) {
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}

	@Override
	public void visitar(NaveEnemiga n) {
		if(counter > 0) {
			counter--;
			n.eliminar();
		}
	}

	@Override
	public void visitar(NaveAliada n) {
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

}
