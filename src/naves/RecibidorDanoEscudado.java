package naves;

public class RecibidorDanoEscudado extends RecibidorDano {

	public RecibidorDanoEscudado(NaveAliada na) {
		super(na);
	}

	@Override
	public void recibirDano(NaveEnemiga na) {
		na.eliminar();
		System.out.println("elimino");
		jugador.setForeground(null);
		jugador.setOpaque(false);
		jugador.setRecibidorDano(new RecibidorDanoNoEscudado(jugador));
	}
}
