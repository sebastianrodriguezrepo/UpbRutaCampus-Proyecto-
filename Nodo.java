public class Nodo {
    private String destino;          
    private int pasos;               
    private boolean tieneEscaleras;  
    private Nodo siguiente;          

    public Nodo(String destino, int pasos, boolean tieneEscaleras) {
        this.destino = destino;
        this.pasos = pasos;
        this.tieneEscaleras = tieneEscaleras;
        this.siguiente = null;
    }

    public String getDestino() { return destino; }
    public int getPasos() { return pasos; }
    public boolean isTieneEscaleras() { return tieneEscaleras; }
    
    public Nodo getSiguiente() { return siguiente; }
    public void setSiguiente(Nodo siguiente) { this.siguiente = siguiente; }
}
