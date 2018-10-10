package controlador;

import java.util.LinkedList;
import java.util.List;

import juego.GameObject;

public class ColisionesThread extends Thread {

	protected List<GameObject> objetos;
	protected List<GameObject> toAdd;
	protected boolean ejecutar;
	
	public ColisionesThread(List<GameObject> obj) {
		this.objetos = obj;
		this.toAdd = new LinkedList<>();
		ejecutar = false;
	}

	public void run() {

		while (ejecutar) {
			// Deteccion de colisiones
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
	
				}
				
				if (!obj1.estaVivo()) {
					obj1.eliminar();
					objetos.remove(obj1);
				}
			}
			// Para evitar el concurrentModificationException
			objetos.addAll(toAdd);
			toAdd.clear();
		}
	}
	
	private boolean intersects(GameObject o1, GameObject o2) {
		return o1.getRectangle().intersects(o2.getRectangle());
	}
}
