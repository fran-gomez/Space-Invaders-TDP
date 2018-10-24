package naves;

import java.awt.Rectangle;
import javax.swing.ImageIcon;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import disparos.FabricaDisparos;
import disparos.FabricaSimple;
import juego.Agregable;
import juego.GameObject;
import juego.NaveState;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.Constantes;

public final class NaveAliada extends Nave {

	public static final int DERECHA = 1, IZQUIERDA = -1, STOPDER = 2, STOPIZQ = -2;
	private String imagenRuta;
	private RecibidorDano recibidorDano;

	public NaveAliada(int x, int y, int lvl, Agregable mapa) {
		this(x, y, 0, 0, 0, 0, 0, mapa);
		setearEstadisticas(lvl);
		imagenRuta = "src/resources/planetExpressRight.png";
	}

	public NaveAliada(int x, int y, int vida, int durabilidad, int alcance, int dmg, int velocidad,
			Agregable mapa) {
		super(x, y, vida, durabilidad, alcance, dmg, velocidad, mapa);
		recibidorDano = new RecibidorDanoNoEscudado(this);
		arma = new FabricaSimple(mapa);
	}

	public void setRecibidorDano(RecibidorDano recibidorDano) {
		this.recibidorDano = recibidorDano;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVE_ALIADA_WIDTH, Constantes.NAVE_ALIADA_HEIGHT);
	}

	@Override
	public void aplicarPowerUp(PowerUp p) {
		p.colision(this);
	}

	@Override
	public String getName() {
		return "Aliado";
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return new ImageIcon("src/resources/planetExpressRight.png");
	}

	@Override
	public void colision(NaveEnemiga naveEnemiga) {
		recibidorDano.recibirDano(naveEnemiga);
	}

	@Override
	public void colision(PowerUp powerUp) {
		powerUp.colision(this);
	}

	@Override
	public void colision(GameObject obs) {
		obs.colision(this);
	}

	public void setArma(FabricaDisparos d) {
		this.arma = d;
	}
	
	public void mover(int d) { // Ignoramos STOPIZQ Y STOPDER pues se dejan de mover
		int nuevoX = (int) rec.getLocation().getX();
		switch (d) {
		case DERECHA:
			if (rec.getLocation().getX() < Constantes.MAP_WIDTH - Constantes.NAVE_ALIADA_WIDTH)
				nuevoX += Constantes.NAVE_ALIADA_VELOCIDAD;
			//imagenRuta = "src/resources/planetExpressRight.png";
			break;
		case IZQUIERDA:
			if (rec.getLocation().getX() > 0)
				nuevoX -= Constantes.NAVE_ALIADA_VELOCIDAD;
			//imagenRuta = "rc/resources/planetExpressLeft.png";
			break;
		}

		//setImage();
		rec.setLocation(nuevoX, (int) rec.getY());
		this.setLocation((int) rec.getX(), (int) rec.getY());
		repaint();
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
		disparo.eliminar();
	}

	@Override
	public void colision(NaveAliada naveAliada) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(Obstaculo obs) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoSimple disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	public void colision(DisparoTriple disparo) {
		// TODO Auto-generated method stub
	}

	@Override
	protected void setearEstadisticas(int lvl) {
		int vida = Constantes.NAVE_ALIADA_VIDA + lvl;
		int durabilidad = Constantes.NAVE_ALIADA_DURABILIDAD + lvl;
		int alcance = Constantes.NAVE_ALIADA_ALCANCE + lvl;
		int dmg = Constantes.NAVE_ALIADA_DANIO + lvl;
		int velocidad = Constantes.NAVE_ALIADA_VELOCIDAD + (lvl / 2);
		this.state = new NaveState(vida, durabilidad, alcance, dmg, velocidad);
	}

}
