package power_ups;

import java.awt.Rectangle;

import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import disparos.FabricaTriple;
import juego.Agregable;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import utilidades.Constantes;

public class SantaClaus extends PowerUp {

	public SantaClaus(int x, int y, int vida, Agregable mapa) {
		super(x, y, vida, mapa);
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.LENTEDEAMPLIFICACION_WIDTH, Constantes.LENTEDEAMPLIFICACION_HEIGHT);
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/santaClaus.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
	}

	@Override
	public void colision(NaveAliada na) {
		eliminar();
		na.setArma(new FabricaTriple(mapa));

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

}
