/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

public class Sala {
    private int numeroSala;
    private int capacidad = 100;
    private Silla[] sillas = new Silla[capacidad];
    private int llenura = 0;
    private int disponiblePreferencial = 30;
    private int disponibleGeneral = 70;
    
    
    public Sala(int numeroSala){
        this.numeroSala = numeroSala;
        for(int i=0;i<sillas.length;i++){
                sillas[i] = new Silla(this.numeroSala,(i+1));
        }
    }
    
    public void mostrarSala(){//Muestra todas las sillas con su respectivo numero, y si alguna esta ocupada muestra -- 
        for(int i=0;i<sillas.length/10;i++){
            for(int j=0;j<sillas.length/10;j++){
                if(sillas[i*10 + j].isOcupada()){
                    System.out.print(" -- ");
                }else if (i<1&&j<9){
                    System.out.print(" "+0+(j+1)+" ");
                } else{
                    System.out.print(" "+(i*10+(j+1))+" ");
                }
            }
            System.out.println("");
        }
    }
    
    public Silla sillaDisponible(){//Devuelve la primer silla disponible
    	for (Silla silla:sillas) {
    		if(!silla.isOcupada()) {
    			llenura++;
    			silla.setOcupada(true);
    			return silla;
    		}
    	}
    	return null;
    }
    
    public boolean estaLlena() {//Verifica si la sala tiene todas las sillas ocupadas
    	if (llenura<capacidad)
    		return false;
    	return true;
    }
    
    public Silla ocuparSilla(int numeroSilla){
        sillas[numeroSilla].setOcupada(true);
        llenura++;
        if(numeroSilla>70){
            disponiblePreferencial--;
        }else{
            disponibleGeneral--;
        }
        return sillas[numeroSilla];
        
    }
    
    public void liberarSilla(int numeroSilla){
        sillas[numeroSilla-1].setOcupada(false);
        llenura--;
        if(numeroSilla>70){
            disponiblePreferencial++;
        }else{
            disponibleGeneral++;
        }
    }
    
    public int sillasDisponibles() {
    	return capacidad-llenura;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

    public void setNumeroSala(int numeroSala) {
        this.numeroSala = numeroSala;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public Silla[] getSillas() {
        return sillas;
    }

    public void setSillas(Silla[] sillas) {
        this.sillas = sillas;
    }

    public int getLlenura() {
        return llenura;
    }

    public void setLlenura(int llenura) {
        this.llenura = llenura;
    }
    
}
