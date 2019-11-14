package data;

public class Reserva {
	private Dia dia;
	private Pelicula pelicula;
	private Sala sala;
	private Silla silla;
	
	public Reserva(Dia dia, Pelicula pelicula, Sala sala, Silla silla) {
		this.dia = dia;
		this.pelicula = pelicula;
		this.sala = sala;
		this.silla = silla;
	}

	public Dia getDia() {
		return dia;
	}
	public void setDia(Dia dia) {
		this.dia = dia;
	}
	public Pelicula getPelicula() {
		return pelicula;
	}
	public void setPelicula(Pelicula pelicula) {
		this.pelicula = pelicula;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public Silla getSilla() {
		return silla;
	}
	public void setSilla(Silla silla) {
		this.silla = silla;
	}

	@Override
	public String toString() {
		return "Reserva [Dia=" + dia.getFechaDia() 
		+ ", Pelicula=" + pelicula.getNombrePelicula()  
		+ ", Hora=" + pelicula.getHora() 
		+ ", Sala=" + sala.getNumeroSala() 
		+ ", Silla=" + silla.getNumeroSilla() + "]";
	}
	
}













