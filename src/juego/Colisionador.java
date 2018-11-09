package juego;

import java.util.List;

public class Colisionador {

	private List<GameObject> objetos, toAdd;

	public Colisionador(List<GameObject> objetos, List<GameObject> toAdd) {
		this.objetos = objetos;
		this.toAdd = toAdd;
	}

	public int colisionar() {
		int puntaje = 0;

		GameObject obj1, obj2;
		for (int i = 0; i < objetos.size(); i++) {
			obj1 = objetos.get(i);

			for (int j = i + 1; j < objetos.size(); j++) {
				obj2 = objetos.get(j);

				if (intersects(obj1, obj2)) {
					obj1.colision(obj2);
					obj2.colision(obj1);
				}

				if (!obj2.estaVivo()) {
					obj2.eliminar();
					objetos.remove(obj2);
					puntaje += obj2.getPuntos();
				}

			}

			if (!obj1.estaVivo()) {
				obj1.eliminar();
				objetos.remove(obj1);
				puntaje += obj1.getPuntos();
			}
		}
		
		objetos.addAll(toAdd);
		toAdd.clear();
		return puntaje;
	}

	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}
}
