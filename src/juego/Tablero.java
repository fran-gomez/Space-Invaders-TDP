package juego;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {

	protected Mapa g;
	protected JPanel panelPuntos;
	
	protected long puntos;
	protected Tiempo tiempo;
	
	public Tablero(int dificultad) {
		g = new Mapa(dificultad);
		
		tiempo = new Tiempo();
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
	

	private class BotonIniciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class BotonGuardar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	private class BotonReinciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

}
