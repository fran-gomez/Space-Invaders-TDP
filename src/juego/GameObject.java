package juego;

import javax.swing.JLabel;
import utilidades.Punto;

public abstract class GameObject extends JLabel {
	private int vida, durabilidad;
	private Punto pos;
}
