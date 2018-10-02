package controlador;

import disparos.DisparoEnemigo;
import disparos.DisparoPenetrante;
import disparos.DisparoSimple;
import disparos.DisparoTriple;
import juego.GameObject;
import naves.NaveAliada;
import naves.NaveEnemiga;
import obstaculos.Obstaculo;
import power_ups.PowerUp;

public abstract class Visitor {

	public abstract void colision(NaveEnemiga naveEnemiga);

	public abstract void colision(NaveAliada naveAliada);

	public abstract void colision(Obstaculo obs);

	public abstract void colision(PowerUp powerUp);

	public abstract void colision(DisparoPenetrante disparo);

	public abstract void colision(DisparoEnemigo disparo);

	public abstract void colision(DisparoSimple disparo);

	public abstract void colision(DisparoTriple disparo);

	public abstract void colision(GameObject obs);

}
