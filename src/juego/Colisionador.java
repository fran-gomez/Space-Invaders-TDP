package juego;

import java.util.List;

public class Colisionador {

	protected List<GameObject> objetos, toAdd;

	public Colisionador(List<GameObject> objetos, List<GameObject> toAdd) {
		this.objetos = objetos;
		this.toAdd = toAdd;
	}

	public void colisionar() {

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
				}
				
				if (!obj1.estaVivo()) {
					obj1.eliminar();
					objetos.remove(obj1);
					break; // TODO EXTREMA CHANCHADA CAMBIAR ESTO
				}
			}
		}

		objetos.addAll(toAdd);
		toAdd.clear();
	}

	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}
}
