
package data;

public class Silla {
    private int precio,numeroSala,numeroSilla;
    private boolean ocupada;
    
    public Silla(int numeroSala,int numSilla){
        this.numeroSala = numeroSala;
        this.ocupada = false;
        if(numSilla>70){
           this.precio=20000; 
        }else{
            this.precio=10000;
        }
        this.numeroSilla = numSilla;
    }

    public boolean isOcupada() {
        return ocupada;
    }

    public void setOcupada(boolean ocupada) {
        this.ocupada = ocupada;
    }
    
    public int getPrecio() {
        return precio;
    }

    public int getNumeroSala() {
        return numeroSala;
    }

	public int getNumeroSilla() {
		return numeroSilla;
	}

	public void setNumeroSilla(int numeroSilla) {
		this.numeroSilla = numeroSilla;
	}
    
    
}
