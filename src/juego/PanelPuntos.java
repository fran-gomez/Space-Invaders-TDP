package juego;

import java.awt.FlowLayout;

import javax.swing.JLabel;

public class PanelPuntos extends JLabel {

	private int puntos;
	private JLabel labelPuntos;
	private JLabel labelNivel;
	private JLabel labelTiempo;
	
	public PanelPuntos() {
		super();
		puntos = 0;
		
		labelPuntos = new JLabel(puntos+"");
		labelNivel  = new JLabel("1");
		labelTiempo = new JLabel("00:00:00");
		
		this.setLayout(new FlowLayout());
		this.add(labelPuntos);
		this.add(labelNivel);
		this.add(labelTiempo);
	}
}
