package obstaculos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import disparos.Disparo;
import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.BarraVida;
import naves.NaveAliada;
import naves.NaveEnemiga;
import power_ups.PowerUp;
import utilidades.Constantes;

public class NaveErrante extends Obstaculo {

	private JLabel partesObstaculo[][];
	private int ancho, alto;
	private int count;

	public NaveErrante(int x, int y, int vida, int durabilidad, int d) {
		super(x, y, vida, durabilidad, d);
	}

	@Override
	protected void setImage() {
		this.setOpaque(false);

		// Cantidad de bloques
		alto = 4;
		ancho = 4;

		JPanel cuerpoAux = new JPanel();

		// rows & columns
		cuerpoAux.setLayout(new GridLayout(alto, ancho));
		cuerpoAux.setOpaque(false);

		partesObstaculo = new JLabel[ancho][alto];
		count = ancho * alto;
		JLabel parte;
		for (int i = 0; i < alto; i++) {
			for (int j = 0; j < ancho; j++) {
				parte = new JLabel();
				parte.setSize(Constantes.NAVEERRANTE_WIDTH / ancho, Constantes.NAVEERRANTE_HEIGHT / alto);
				parte.setPreferredSize(
						new Dimension(Constantes.NAVEERRANTE_WIDTH / ancho, Constantes.NAVEERRANTE_HEIGHT / alto));
				partesObstaculo[j][i] = parte;
				parte.setOpaque(true);
				parte.setBackground(Color.YELLOW);
				cuerpoAux.add(parte);
			}
		}
		vidaLabel = new BarraVida(10);
		cuerpo = cuerpoAux;
		this.add(cuerpo);
	}

	@Override
	public String getName() {
		return "NaveErrante";
	}

	@Override
	public void mover() {
	}

	@Override
	public ImageIcon getGrafico() {
		return null;
	}

	@Override
	protected Rectangle createRectangle(int x, int y) {
		return new Rectangle(x, y, Constantes.NAVEERRANTE_WIDTH, Constantes.NAVEERRANTE_HEIGHT);
	}

	@Override
	public void colision(NaveAliada naveAliada) {
	}

	@Override
	public void colision(Obstaculo obs) {
	}

	@Override
	public void colision(PowerUp powerUp) {
	}

	@Override
	public void colision(DisparoPenetrante disparo) {
	}

	@Override
	public void colision(DisparoEnemigo disparo) {
		if (daniar((int) disparo.getRectangle().getX())) {
			disparo.eliminar();
		}
	}

	/**
	 * Busca un cuadrado a eliminar con la colision
	 * 
	 * @param x posicion en x del colisionador
	 * @return si encontro un cuadrado que corresponda al objetivo
	 */
	private boolean daniar(int x) {
		int dist = (int) (x - rec.x);
		int pos = (int) (dist / (rec.width / ancho));
		boolean encontro = false;

		while (pos >= ancho)
			pos--;
		while (pos < 0)
			pos++;

		for (int i = 0; i < alto && !encontro; i++) {
			if (partesObstaculo[pos][i].isVisible()) {
				partesObstaculo[pos][i].setVisible(false);
				encontro = true;
			}
		}

		return encontro;
	}

	@Override
	public void colision(NaveEnemiga ne) {
		if (daniar((int) ne.getRectangle().getX()))
			ne.recibirDano(dmg);
	}

	@Override
	public boolean estaVivo() {
		return count > 0;
	}

	@Override
	public void colision(DisparoSimple disparo) {
	}

	@Override
	public void colision(DisparoTriple disparo) {
	}

}
