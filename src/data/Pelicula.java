
package data;

import java.time.LocalDate;

public class Pelicula {
    private LocalDate fechaPelicula;
    private String nombrePelicula;
    private Sala sala;
    private String hora;
    

	public Pelicula(String nombrePelicula,int numeroSala,LocalDate fechaPelicula,String hora){
        this.sala = new Sala(numeroSala);
        this.nombrePelicula = nombrePelicula;
        this.fechaPelicula = fechaPelicula;
        this.hora = hora;
    }

    public LocalDate getFechaPelicula() {
        return fechaPelicula;
    }

    public void setFechaPelicula(LocalDate fechaPelicula) {
        this.fechaPelicula = fechaPelicula;
    }

    public String getNombrePelicula() {
        return nombrePelicula;
    }

    public void setNombrePelicula(String nombrePelicula) {
        this.nombrePelicula = nombrePelicula;
    }

    public Sala getSala() {
        return sala;
    }

    public void setSala(Sala sala) {
        this.sala = sala;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
 
    @Override
   	public String toString() {
   		return nombrePelicula+" [Fecha: " + fechaPelicula + ", Sala: " + sala.getNumeroSala()
   				+ ", Hora: " + hora +", Sillas Disponibles: " + sala.sillasDisponibles() + "]";
   	} 
    
}
