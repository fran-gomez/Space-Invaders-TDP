package juego;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.border.LineBorder;

public class Celda extends JLabel {

	public static final int ALTO_CELDA = 200;
	public static final int ANCHO_CELDA = 200;
	
	protected GameObject obj;
	
	public Celda() {
		this.setSize(ALTO_CELDA, ANCHO_CELDA);
		this.setBorder(new LineBorder(Color.BLACK));
	}
	
	/**
	 * 
	 * @param o
	 */
	public void setObjeto(GameObject o) {
		this.obj = o;
		this.setText(o.getName());
	}

	public void setObject(GameObject obj) {
		this.obj = obj;
	}

	public GameObject mover() {
		if (obj != null) {
			obj.actualizarPosicion();
		}
		return obj;
	}
}
