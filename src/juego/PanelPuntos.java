package juego;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

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
		setBounds(0, 0, 200, 20);

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
		label.setText(String.format("Puntos: %d\t Nivel: %d", puntos, nivel));
	}
}
