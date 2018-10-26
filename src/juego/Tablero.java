package juego;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

import controlador.JugadorThread;
import controlador.MainThread;

public class Tablero extends JPanel {

	protected Mapa g;

	protected Juego juego;
	// protected long puntos;
	protected MainThread mainThread;
	protected JugadorThread jugadorThread;

	public Tablero(int dificultad, Juego juego) {
		this.juego = juego;
		g = new Mapa(dificultad, juego);

		mainThread = new MainThread(g);
		jugadorThread = new JugadorThread(g.obtenerJugador());

		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.add(g);
	}

	public void startThreads() {
		mainThread.start();
		jugadorThread.start();
	}

	public void killThreads() {
		jugadorThread.interrupt();
		mainThread.interrupt();
	}
}