package juego;

import javax.swing.JLabel;

public class Celda extends JLabel {

	protected GameObject obj;

	public GameObject getObject() {
		return obj;
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
