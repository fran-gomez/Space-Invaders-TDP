package juego;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controlador.JugadorThread;
import controlador.MainThread;

public class Tablero extends JPanel {

	protected Mapa g;
	protected PanelPuntos panelPuntos;

	protected long puntos;
	protected MainThread mainThread;
	protected JugadorThread jugadorThread;

	public Tablero(int dificultad) {
		g = new Mapa(dificultad);

		mainThread = new MainThread(g);
		jugadorThread = new JugadorThread(g.obtenerJugador());
		
		panelPuntos = new PanelPuntos();
		
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(panelPuntos);
		this.add(g);
	}

	public void startThreads() {
		// Iniciar loop
		mainThread.start();
		jugadorThread.start();
	}
}