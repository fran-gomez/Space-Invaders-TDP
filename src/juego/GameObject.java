package juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;
import utilidades.FormateadorDeImagen;

public abstract class GameObject extends JPanel {

	protected ObjectState state;

	protected Rectangle rec;
	protected ImageIcon visual;
	protected BarraVida vidaLabel;
	protected Component cuerpo;
	protected Agregable mapa;
	protected int puntos;

	public static final int BARRA_VIDA_HEIGHT = 3;
	
	public GameObject(int x, int y, int vida, int durabilidad, Agregable mapa) {

		this.mapa = mapa;
		this.rec = createRectangle(x, y);
		this.visual = null;
		this.state = new ObjectState(vida, durabilidad);

		this.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); 

		rec.setLocation((int) (rec.getX() - rec.getWidth() / 2), (int) (rec.getY() - rec.getHeight() / 2));

		this.setBounds((int) rec.getX(), (int) rec.getY(), (int) rec.getWidth(),
				(int) rec.getHeight() + BARRA_VIDA_HEIGHT + 5);
		
		// Añadimos 5 para que quepa la barra de vida
		state = new ObjectState(vida, durabilidad);
		setImage();
	}
	
	public int getPuntos() {
		return puntos;
	}

	protected void setImage() {
		this.setOpaque(false);

		this.vidaLabel = new BarraVida(state.getVida());
		this.cuerpo = new JLabel();

		// Rectángulo de vida
		vidaLabel.setSize((int) rec.getWidth(), BARRA_VIDA_HEIGHT + 5); // +5 para el padding
		vidaLabel.setPreferredSize(new Dimension((int) rec.getWidth(), BARRA_VIDA_HEIGHT + 5));

		// rectángulo de imagen
		cuerpo.setSize((int) rec.getWidth(), (int) rec.getHeight());
		cuerpo.setPreferredSize(new Dimension((int) rec.getWidth(), (int) rec.getHeight()));

		this.add(vidaLabel);
		visual = getGrafico();
		if (visual != null) {
			((JLabel) cuerpo).setIcon(FormateadorDeImagen.formatearImagen(visual, (int)rec.getWidth(), (int)rec.getHeight()));
			this.add(cuerpo);
		}
	}
	
	public int getVidaTotal() {
		return vidaLabel.getVidaTotal();
	}

	public void eliminar() {
		this.setVida(0);
		this.setVisible(false);
	}

	public abstract void mover();

	public abstract ImageIcon getGrafico();

	/**
	 * Retorna un rectángulo con la posicion indicada y el ancho y alto de la imagen
	 * del gameObject
	 * 
	 * @param x posicion X
	 * @param y posicion Y
	 * @return Rectángulo de dimensiones correspondientes
	 */
	protected abstract Rectangle createRectangle(int x, int y);

	public abstract void colision(NaveEnemiga naveEnemiga);

	public abstract void colision(NaveAliada naveAliada);

	public abstract void colision(Obstaculo obs);

	public abstract void colision(PowerUp powerUp);

	public abstract void colision(DisparoPenetrante disparo);

	public abstract void colision(DisparoEnemigo disparo);

	public abstract void colision(DisparoSimple disparo);

	public abstract void colision(DisparoTriple disparo);

	public abstract void colision(GameObject obs);

	public int getVida() {
		return state.vida;
	}

	public void setVida(int vida) {
		this.state.vida = vida;
		vidaLabel.setVida(vida);
	}

	public int getDurabilidad() {
		return state.durabilidad;
	}

	public void setDurabilidad(int durabilidad) {
		this.state.durabilidad = durabilidad;
	}

	public Rectangle getRectangle() {
		return rec;
	}

	public void setRec(Rectangle rec) {
		this.rec = rec;
	}

	public ImageIcon getVisual() {
		return visual;
	}

	public void setVisual(ImageIcon visual) {
		this.visual = visual;
	}

	@Override
	public String toString() {
		return "" + this.state.vida;
	}

	public boolean estaVivo() {
		return this.state.vida > 0;
	}

	
	public void cambiarUbicacion(float x, float y) {
		this.setLocation((int)x, (int)y);
		rec.setLocation((int) x, (int) y);
	}

}
