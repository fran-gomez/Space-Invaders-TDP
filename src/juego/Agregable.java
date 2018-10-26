package juego;

import java.util.List;

public interface Agregable {

	public void addToObjects(GameObject o);

	public List<GameObject> getGameObjects();
}
