package juego;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Random;

import naves.NaveEnemiga;
import utilidades.Constantes;

public abstract class GeneradorEnemigos {
	protected NaveEnemiga muchos, algunos1, algunos2, algunos3, pocos;
	protected Random rnd;
	protected Mapa map;

	protected List<NaveEnemiga> listaEnemigos;
	protected Map<NaveEnemiga, Integer> mapeoCantMinima;

	public GeneradorEnemigos(Mapa map) {
		this.map = map;
		rnd = new Random();
	}

	public void generarNavesEnemigas() {
		listaEnemigos = new LinkedList<NaveEnemiga>();

		poblarLista();

		NaveEnemiga enemigo = null;
		int x, y;
		int areaAliensH = Constantes.MAP_HEIGHT / 3;
		int areaAliensW = Constantes.MAP_WIDTH;
		int cuadradoAlienW = areaAliensW / Constantes.ENEMIGOS_X_FILA;
		int cuadradoAlienH = areaAliensH / Constantes.CANT_FILAS_ENEMIGOS;

		int i = 0;
		for (int f = 0; f < Constantes.CANT_FILAS_ENEMIGOS; f++) {
			for (int c = 0; c < Constantes.ENEMIGOS_X_FILA; c++) {
				x = c * cuadradoAlienW + cuadradoAlienW / 2;
				y = f * cuadradoAlienH + cuadradoAlienH / 2;
				enemigo = listaEnemigos.get(i++); //TODO Hacer shuffle
				enemigo.cambiarUbicacion(x, y);
				map.addToObjects(enemigo);
			}
		}
	}

	private void poblarLista() {
		// Generar los minimos
		NaveEnemiga enemigo = null;
		for (Entry<NaveEnemiga, Integer> e : mapeoCantMinima.entrySet()) {
			// Generamos la cantidad minima de este tipo
			for (int i = 0; i < e.getValue(); i++) {
				listaEnemigos.add(e.getKey().clone());
			}
		}

		// Generacion del resto, aleatoriedad
		int cantidadTotalEnemigos = Constantes.CANT_FILAS_ENEMIGOS * Constantes.ENEMIGOS_X_FILA;
		for (int i = listaEnemigos.size(); i < cantidadTotalEnemigos; i++) {
			enemigo = naveAleatoria();
			listaEnemigos.add(enemigo);
		}

		Collections.shuffle(listaEnemigos);
	}

	private NaveEnemiga naveAleatoria() {

		NaveEnemiga n;
		int rand = rnd.nextInt(7);

		// TODO Corregir todos los parametros de creacion
		switch (rand) {
		case 0:
			n = pocos.clone();
			break;
		case 1:
			n = algunos1.clone();
			break;
		case 2:
			n = algunos2.clone();
			break;
		case 3:
			n = algunos3.clone();
			break;
		default:
			n = muchos.clone();
			break;
		}

		return n;
	}
}
