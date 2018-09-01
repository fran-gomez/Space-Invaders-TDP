package juego;

import javax.swing.JLabel;

public class Celda extends JLabel {

	protected GameObject obj;
	
	/**
	 * 
	 * @param o
	 */
	public void setObjeto(GameObject o) {
		this.obj = o;
	}
}
