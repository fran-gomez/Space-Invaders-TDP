package juego;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JComponent;
import javax.swing.KeyStroke;

import naves.NaveAliada;

public class JugadorThread extends Thread {

	private final float TIEMPO_ENTRE_DISPAROS = 250; //En Milésimas de segundo
	
	private int movement; // FLAG de movimiento
	private int tiempoPausa;
	private boolean ejecutar;
	private NaveAliada jugador;
	private long ultTiempoDisparo;

	public JugadorThread(NaveAliada j) {
		this.tiempoPausa = 20;
		this.jugador = j;
		ejecutar = true;
		ultTiempoDisparo = System.currentTimeMillis();
		movement = NaveAliada.STOPDER;

		setListener();
	}

	@Override
	public void run() {
		while (ejecutar) {

			jugador.mover(movement);

			try {
				Thread.sleep(tiempoPausa);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (jugador.getVida() <= 0)
				ejecutar = false;
		}
	}

	public void pausar() {
		ejecutar = false;
	}

	public void reiniciar() {
		ejecutar = true;
	}

	private class PlayerMovementAction extends AbstractAction {
		private int d;

		public PlayerMovementAction(int d) {
			this.d = d;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (!(movement == NaveAliada.DERECHA && d == NaveAliada.STOPIZQ)
					&& !(movement == NaveAliada.IZQUIERDA && d == NaveAliada.STOPDER)) {
				movement = d;
			}
		}

	}

	private class DisparoAction extends AbstractAction {
		@Override
		public void actionPerformed(ActionEvent e) {
			if(System.currentTimeMillis() - ultTiempoDisparo >= TIEMPO_ENTRE_DISPAROS) {
				jugador.disparar();
				ultTiempoDisparo = System.currentTimeMillis();
			}
		}

	}

	private void setListener() {
		InputMap inputMap = jugador.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
		ActionMap actionMap = jugador.getActionMap();

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, false), "mover derecha");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0, true), "mover parar derecha"); // soltó la tecla der
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, false), "mover izquierda");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0, true), "mover parar izquierda"); // soltó la tecla izq
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0, false), "disparo");
		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_SPACE, 0, false), "disparo");

		actionMap.put("mover derecha", new PlayerMovementAction(NaveAliada.DERECHA));
		actionMap.put("mover parar derecha", new PlayerMovementAction(NaveAliada.STOPDER));
		actionMap.put("mover parar izquierda", new PlayerMovementAction(NaveAliada.STOPIZQ));
		actionMap.put("mover izquierda", new PlayerMovementAction(NaveAliada.IZQUIERDA));
		actionMap.put("disparo", new DisparoAction());
	}
}
