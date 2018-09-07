package juego;

public class Tiempo extends Thread {
	
	private Mapa mapa;
	private int tiempoPausa;

	public Tiempo(Mapa m) {
		this.mapa = m;
		this.tiempoPausa = 300;
	}

	public void run() {
		while (true) {
			try {
				Thread.sleep(tiempoPausa);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
			mapa.gameLoop();
		}
	}
}
