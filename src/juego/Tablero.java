package juego;

import java.awt.FlowLayout;
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
	protected MainThread mainThread;
	protected JugadorThread jugadorThread;

	public Tablero(int dificultad) {
		g = new Mapa(dificultad);

		mainThread = new MainThread(g);
		jugadorThread = new JugadorThread(g.obtenerJugador());
		panelPuntos = nuevoPanelPuntos();

		this.setLayout(new FlowLayout());
		this.add(g);
		this.add(panelPuntos);

		// Iniciar loop
		mainThread.start();
		jugadorThread.start();
	}

	private JPanel nuevoPanelPuntos() {

		JPanel nuevo = new JPanel();
		nuevo.setLayout(new BoxLayout(nuevo, BoxLayout.Y_AXIS));

		// Agregar los visores de informacion
		nuevo.add(new JLabel("Puntos:" + puntos));
		nuevo.add(new JLabel("Tiempo: " + mainThread));
		nuevo.add(new JLabel("Vida: " + g.obtenerJugador())); // TODO hay que ir actualizandolo

		// Agregar los botones de control
		JButton botonPausa = new JButton("Pausa");
		botonPausa.setFocusable(false);
		botonPausa.addActionListener(new BotonPausa());
		nuevo.add(botonPausa);

		JButton botonGuardar = new JButton("Guardar");
		botonGuardar.setFocusable(false);
		botonGuardar.addActionListener(new BotonGuardar());
		nuevo.add(botonGuardar);

		JButton botonReiniciar = new JButton("Reiniciar");
		botonReiniciar.setFocusable(false);
		botonReiniciar.addActionListener(new BotonReiniciar());
		nuevo.add(botonReiniciar);

		return nuevo;
	}

	private class BotonPausa implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton boton = (JButton) arg0.getSource();

			mainThread.pausar();
			boton.setText("Reanudar");
			boton.addActionListener(new BotonReanudar());
			System.out.println("Pausado");

			boton.removeActionListener(this);
		}

	}

	private class BotonReanudar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			JButton boton = (JButton) arg0.getSource();

			mainThread.reiniciar();
			boton.setText("Pausa");
			boton.addActionListener(new BotonPausa());
			System.out.println("Reinciado");

			boton.removeActionListener(this);
		}

	}

	private class BotonGuardar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			for (GameObject go : g.objetos)
				; // guardo cada go en un archivo de texto

		}

	}

	private class BotonReiniciar implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {

			mainThread.interrupt();
			g = new Mapa(2);
			mainThread = new MainThread(g);

		}

	}

}
