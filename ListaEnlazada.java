public class ListaEnlazada {
    private Nodo cabeza;

    public void Agregar(String destino, int pasos, boolean tieneEscaleras){
        Nodo nuevo = new Nodo(destino, pasos, tieneEscaleras);
        if(cabeza != null){
            Nodo temp = cabeza;
            while(temp.getSiguiente() != null){
                temp = temp.getSiguiente();                
            }
            temp.setSiguiente(nuevo);
        }else{
            cabeza = nuevo;
        }
    }
    public Nodo getCabeza() {
        return cabeza;
    }

    public void Mostrar(){
        Nodo temp = cabeza;
        while(temp != null){
            System.out.println("  Conecta con [Edificio " + temp.getDestino() + "] | Pasos: " + temp.getPasos() + " | Escaleras: " + temp.isTieneEscaleras());
            temp = temp.getSiguiente();
        }
    }
}
