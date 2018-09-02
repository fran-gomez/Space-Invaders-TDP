package juego;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {

	protected Grilla g;
	protected JPanel panelPuntos;
	
	protected long puntos;
	protected Tiempo tiempo;
	
	public Tablero(int dificultad) {
		g = new Grilla(dificultad);
		panelPuntos = nuevoPanelPuntos();
		
		this.setLayout(new FlowLayout());
		
		this.add(g);
		this.add(panelPuntos);
	}
	
	private JPanel nuevoPanelPuntos() {
		
		JPanel nuevo = new JPanel();
		
		nuevo.setLayout(new BoxLayout(nuevo, BoxLayout.Y_AXIS));
		
		// Agregar los visores de informacion
		nuevo.add(new JLabel("Puntos:" + puntos));
		nuevo.add(new JLabel("Tiempo: " + tiempo));
		
		// Agregar los botones de control
		nuevo.add(new JButton("Pausa"));
		nuevo.add(new JButton("Guardar"));
		nuevo.add(new JButton("Reiniciar"));
		
		return nuevo;
	}
}
