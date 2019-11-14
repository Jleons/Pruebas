
package data;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String cedula;
    private String credito;
    //contrasena
    //cambiar arrayList
    private ArrayList<Reserva> reservas=new ArrayList<>();
    
     
	public Usuario(String nombre, String cedula) {
		this.nombre = nombre;
		this.cedula = cedula;
	}
	
	public void mostrarReservas() {//Muestra todas las reservas del usuario en la consola
		int numReserva=1;
		for(Reserva reserva:reservas) {
			System.out.println(numReserva+" "+reserva.toString());
			numReserva++;
		}
		System.out.println();
	}
	
	public void eliminarReserva(int num) {
		int numeroSilla = reservas.get(num).getSilla().getNumeroSilla();
                reservas.get(num).getSala().liberarSilla(numeroSilla);
		//System.out.printf("\nReservaEliminada :%s \n\n",reservas.get(num).toString());
		reservas.remove(num);
	}

	public void addReserva(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCredito() {
		return credito;
	}

	public void setCredito(String credito) {
		this.credito = credito;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setReservas(ArrayList<Reserva> reservas) {
		this.reservas = reservas;
	}
    
    
}
