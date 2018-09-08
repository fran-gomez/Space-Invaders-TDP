package juego;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tablero extends JPanel {

	protected Mapa g;
	protected JPanel panelPuntos;

	protected long puntos;
	protected MainThread tiempo;

	public Tablero(int dificultad, JFrame ventana) {
		g = new Mapa(dificultad, ventana);

		tiempo = new MainThread(g);
		panelPuntos = nuevoPanelPuntos();

		this.setLayout(new FlowLayout());
		this.add(g);
		this.add(panelPuntos);
		
		//Iniciar loop
		tiempo.start();
	}

	private JPanel nuevoPanelPuntos() {

		JPanel nuevo = new JPanel();

		nuevo.setLayout(new BoxLayout(nuevo, BoxLayout.Y_AXIS));

		// Agregar los visores de informacion
		nuevo.add(new JLabel("Puntos:" + puntos));
		nuevo.add(new JLabel("Tiempo: " + tiempo));

		// Agregar los botones de control
		JButton botonPausa = new JButton("Pausa");
		JButton botonGuardar = new JButton("Guardar");
		JButton botonReiniciar = new JButton("Reiniciar");

		botonPausa.setFocusable(false);
		botonGuardar.setFocusable(false);
		botonReiniciar.setFocusable(false);
		
		nuevo.add(botonPausa);
		nuevo.add(botonGuardar);
		nuevo.add(botonReiniciar);

		return nuevo;
	}

	private class BotonPausa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
	
	private class BotonIniciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
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
