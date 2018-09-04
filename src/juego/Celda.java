package juego;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import utilidades.Punto;

public class Celda extends JLabel {

	public static final int ALTO_CELDA = 50;
	public static final int ANCHO_CELDA = 50;

	protected GameObject obj;
	protected Punto punto;

	public Celda(Punto punto) {
		this.setPreferredSize(new Dimension(ALTO_CELDA,ANCHO_CELDA));
		this.setBorder(new LineBorder(Color.BLACK));
		this.punto = punto;
		this.obj = null;
	}

	public void setObject(GameObject o) {
		this.obj = o;
		if (o != null) {
			this.setText(o.getName());
		} else {
			this.setText("");
		}
	}

	public GameObject mover() {
		if (obj != null) {
			obj.actualizarPosicion();
		}
		return obj;
	}

	public GameObject getObject() {
		return obj;
	}

	public Punto getPunto() {
		return punto;
	}

	public boolean isEmpty() {
		return obj == null;
	}

}