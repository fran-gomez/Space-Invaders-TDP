package naves;

public class RecibidorDanoNoEscudado extends RecibidorDano{

	public RecibidorDanoNoEscudado(NaveAliada na) {
		super(na);
	}

	@Override
	public void recibirDano(NaveEnemiga na) {
		System.out.println("recibio daño");
		jugador.recibirDano(na.getDmg());
	}

}
