/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.time.LocalDate;


public class Dia {
	
    private static long diaAuxiliar = 0;
    private int numeroFunciones = 15;
    private LocalDate fechaDia = LocalDate.now().plusDays(diaAuxiliar);
    private Pelicula[] peliculas = new Pelicula[numeroFunciones];
    private String[] nombresPeliculas= {"Avengers","Avatar","Titanic","Godzilla","toy Story"};
    private String[] horarios = {"9:00","11:00","12:00","14:00","16:00","19:00"};
    
    public Dia(){
    	//Llena el array de peliculas del dia al construirlo
        for (int i = 0; i < peliculas.length; i++) {
            peliculas[i] = new Pelicula(nombresPeliculas[(i%5)],(i%10 + 1),fechaDia,horarios[i%6]);
        }
        diaAuxiliar++;//Se usa para que al crear un dia nuevo, sea el siguiente al ultimo creado
    }
     
    public void mostrarPeliculas() { //Muestra las peliculas en la consola en lista
    	int numFuncion=1;
    	for(Pelicula pelicula:peliculas) {
    		if(pelicula.getSala().estaLlena())
    			System.out.println(numFuncion+"- "+pelicula.getNombrePelicula()+" "+pelicula.getHora() +" NO DISPONIBLE");
    		else
    			System.out.println(numFuncion+"- "+pelicula.toString());
    		numFuncion++;
    	}
    }
    
    public Pelicula funcionDisponible() { //Devuelve la primer pelicula que tenga sillas disponibles
    	for (Pelicula pelicula:peliculas) {
    		if(!pelicula.getSala().estaLlena())
    			return pelicula;
    	}
    	return null;
    }
    
    public boolean diaCompleto(){ //Verifica si todas las peliculas del dia tienen las salas llenas
    	for(Pelicula pelicula:peliculas) {
    		if(!pelicula.getSala().estaLlena())
    			return false;
    	}
    	return true;
    }
    
    public static long getDiaAuxiliar() {
        return diaAuxiliar;
    }

    public static void setDiaAuxiliar(long diaAuxiliar) {
        Dia.diaAuxiliar = diaAuxiliar;
    }

    public int getNumeroFunciones() {
        return numeroFunciones;
    }

    public void setNumeroFunciones(int numeroFunciones) {
        this.numeroFunciones = numeroFunciones;
    }

    public LocalDate getFechaDia() {
        return fechaDia;
    }

    public void setFechaDia(LocalDate fechaDia) {
        this.fechaDia = fechaDia;
    }

    public Pelicula[] getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(Pelicula[] peliculas) {
        this.peliculas = peliculas;
    }

    public String[] getNombresPeliculas() {
        return nombresPeliculas;
    }

    public void setNombresPeliculas(String[] nombresPeliculas) {
        this.nombresPeliculas = nombresPeliculas;
    }

    public String[] getHorarios() {
        return horarios;
    }

    public void setHorarios(String[] horarios) {
        this.horarios = horarios;
    }
    
    
    
}
