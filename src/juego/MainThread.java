package juego;

public class MainThread extends Thread {

	private Mapa mapa;
	private int tiempoPausa;

	public MainThread(Mapa m) {
		this.mapa = m;
		this.tiempoPausa = 16;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(tiempoPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			mapa.gameLoop();
		}
	}
}
