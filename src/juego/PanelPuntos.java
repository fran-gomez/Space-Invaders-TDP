package juego;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelPuntos extends JPanel {

	private int puntos;
	private int nivel;
	private JLabel label;

	public PanelPuntos() {
		super();
		puntos = 0;
		nivel = 0;

		setOpaque(false);
		setLayout(new FlowLayout());
		setBounds(0, 0, 400, 20);

		label = new JLabel();
		label.setForeground(Color.white);

		this.setLayout(new FlowLayout());
		this.add(label);
		
		actualizar();
	}
	
	public void setPuntos(int p) {
		this.puntos = p;
		actualizar();
	}

	public void sumarPuntos(int p) {
		puntos += p;
		actualizar();
	}

	public void setNivel(int p) {
		this.nivel = p;
	}

	public void sumarNivel() {
		nivel++;
		actualizar();
	}
	
	private void actualizar() {
		label.setText(String.format("Puntos: %d\t Nivel: %d \t (P)ause, (R)esume, (E)xit", puntos, nivel));
	}
}
