package ui;
import java.util.Scanner;

import data.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import main.EstructurasDeDatos;

public class Consola {

	Scanner teclado = new Scanner(System.in);
	Random random=new Random();
	
	public Usuario login() { //Pantalla de inicio para iniciar sesion
        
		//System.out.println("Bienvenido: \nDigite su cedula: ");
		String cedula= ""+random.nextInt(60000000);
		//System.out.println("Digite su nombre: ");
		String nombre= stringAleatorio();
		
		if(EstructurasDeDatos.getUsuarios().containsKey(cedula))
			return EstructurasDeDatos.getUsuarios().get(cedula);
		
		Usuario usuario = new Usuario(nombre,cedula);
		EstructurasDeDatos.getUsuarios().put(cedula,usuario);
		//System.out.println("usuario no registrado \nHa sido registrado\n");
		return usuario;
	}
	
	public boolean menu(Usuario comprador) {//Menu para reservar, consultar, modificar o eliminar la reserva
		//System.out.println("Usuario: "+comprador.getNombre()+" \n"+ "Cedula :"+comprador.getCedula()+" \n"
		//		+"Que desea hacer?:\n"
		//		+ "1-Reservar\n"
		//		+ "2-Consultar Reserva\n"
		//		+ "3-Modificar Reserva\n"
		//		+ "4-Borrar Reserva\n"
		//		+ "5-Cerrar Sesion\n");
		
		String opcion = "1" ;
		int numOpcion=1;
		if(esNumero(opcion))
			numOpcion=Integer.parseInt(opcion);
		
		switch(numOpcion) {
			case 1:
				reservar(comprador);
				break;
			case 2:
				consultarReserva(comprador);
				break;
			case 3:
				modificarReserva(comprador);
				break;
			case 4:
				eliminarReserva(comprador);
				break;
			case 5:
				return false;
		}
		return false;
	}
	
	public void consultarReserva(Usuario comprador) {//Muestra todas las reservas en el orden que se compraron
		if(comprador.getReservas().isEmpty())
		{}//System.out.println("\nNo tiene reservas\n");
		else
		{}//comprador.mostrarReservas();
	}
	
	public void modificarReserva(Usuario comprador) {//Elimina la reserva que el usuario decida y permite al usuario reservar de nuevo
		if(comprador.getReservas().isEmpty())
			{}//System.out.println("\nNo tiene reservas\n");
		else {
			//comprador.mostrarReservas();
			//System.out.println("Cual reserva desea modificar: ");
			
			String selectModificar = ""+(random.nextInt(comprador.getReservas().size()) + 1);
			int numModificar=1;
			if(esNumero(selectModificar))
				numModificar=Integer.parseInt(selectModificar);
			
			if(numModificar>comprador.getReservas().size()|| numModificar<=0) 
				comprador.eliminarReserva(0);
			else
				comprador.eliminarReserva(numModificar-1);
			reservar(comprador);
		}

	}
	
	public void eliminarReserva(Usuario comprador) {//Elimina la reserva pedida
		if(comprador.getReservas().isEmpty())
			{}//System.out.println("No tiene reservas\n");
		else {
			//comprador.mostrarReservas();
			//System.out.println("Cual reserva desea eliminar: ");
			

			String selectEliminar = ""+(random.nextInt(comprador.getReservas().size()) + 1);

			int numEliminar=1;
			if(esNumero(selectEliminar))
				numEliminar=Integer.parseInt(selectEliminar);
			
			if(numEliminar>comprador.getReservas().size()||numEliminar<=0)
				comprador.eliminarReserva(0);
			else
				comprador.eliminarReserva(numEliminar-1);
			
			
		}
	}
	
	public void reservar(Usuario usuario) {//Reserva una silla para el usuario
		Dia dia = seleccionarDia();
		Pelicula pelicula = seleccionarPelicula(dia);
		Silla silla = seleccionarSilla(pelicula);
		usuario.addReserva(new Reserva(dia,pelicula,pelicula.getSala(),silla));
		//usuario.mostrarReservas();
	}
		
	public Dia seleccionarDia() {//Permite al usuario seleccionar un dia de la lista de dias
		int numDia= 1;
		
		//Verifica que haya algun dia con sillas disponibles, y si estan todos llenos crea un nuevo dia
		boolean diasCompletos=true;
		for(Dia dia:EstructurasDeDatos.getDias())
			if(!dia.diaCompleto())
				diasCompletos=false;
		if (diasCompletos)
			EstructurasDeDatos.addDia();
		
		//for(Dia dia:EstructurasDeDatos.getDias()) {
		//	if(dia.diaCompleto())
		//		System.out.println(numDia+"- "+dia.getFechaDia()+" TODO VENDIDO");
		//	else
		//		System.out.println(numDia+"- "+dia.getFechaDia());
    	//	numDia++;
    	//}
		
		//Pide al usuario un numero de dia, si el usuario no ingresa un numero se selecciona el dia 1
		//System.out.println("Seleccione el dia: ");
		String numSelectDia = ""+(random.nextInt(EstructurasDeDatos.getDias().size())+1);
		int selectDia=1;
		if(esNumero(numSelectDia))
			selectDia=Integer.parseInt(numSelectDia);
		
		//Si el numero dado sobrepasa el ultimo dia disponible o es menor a 0, devuelve el primer dia disponible
		if(selectDia>EstructurasDeDatos.getDias().size()||selectDia<=0) {
			for(Dia dia:EstructurasDeDatos.getDias())
				if(!dia.diaCompleto())
					return dia;
		}
		
		//Si el dia seleccionado no tiene sillas disponibles, devuelve el primer dia disponible
		if(EstructurasDeDatos.getDias().get(selectDia-1).diaCompleto()) {
			for(Dia dia:EstructurasDeDatos.getDias())
				if(!dia.diaCompleto())
					return dia;
		}
		
		return EstructurasDeDatos.getDias().get(selectDia-1);
		
	}

	public Pelicula seleccionarPelicula(Dia dia) {//Permite al usuario seleccionar la funcion de entre las peliculas del dia
		//dia.mostrarPeliculas();
		//System.out.println("Seleccione la función: ");
		
		String selectPelicula = ""+(random.nextInt(dia.getPeliculas().length)+1);
		int numPelicula=1;
		if(esNumero(selectPelicula))
			numPelicula=Integer.parseInt(selectPelicula);
			
		if(numPelicula>dia.getPeliculas().length||numPelicula<=0)
			return dia.funcionDisponible();
		
		if(dia.getPeliculas()[numPelicula-1].getSala().estaLlena())
			return dia.funcionDisponible();
		
		return dia.getPeliculas()[numPelicula - 1];
		
	}
	
	public Silla seleccionarSilla(Pelicula pelicula) {//Muestra al usuario la sala de la pelicula y permite seleccionar una silla
		//pelicula.getSala().mostrarSala();
		//System.out.println("Seleccione una silla disponible: ");
		String numSilla= ""+(random.nextInt(pelicula.getSala().getCapacidad()) + 1);
		int silla =1;
		if(esNumero(numSilla))
			silla=Integer.parseInt(numSilla);
		if(silla > pelicula.getSala().getCapacidad() || pelicula.getSala().getSillas()[silla-1].isOcupada()||silla<=0)
			return pelicula.getSala().sillaDisponible();
		return pelicula.getSala().ocuparSilla(silla-1);
	}
	
	public boolean esNumero(String numero){//Verifica si el string dado se puede convertir a entero
	    try{
	        Integer.parseInt(numero);
	        return true;
	    }catch(NumberFormatException e){
	        return false;
	    }
	}
	
	public String stringAleatorio() {
		String minus="abcdefghijklmnopqrstuvwxyz";
		String mayus=minus.toUpperCase();
		String alphabet = minus+mayus;
		
		int length = random.nextInt(15) + 1;
		String palabra ="";
		
		for(int i=0;i<length;i++) {
			char letra=alphabet.charAt(random.nextInt(26));
			palabra+=letra;
		}
		
		return palabra;
	}
	
}
