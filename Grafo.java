import java.util.*;

public class Grafo {

    public ListaEnlazada obtenerVecinos(String edificio) {
        switch (edificio) {
            case "Edificio A":
                ListaEnlazada a = new ListaEnlazada();
                a.Agregar("Edificio B", 10, false);
                return a;
            case "Edificio B":
                ListaEnlazada b = new ListaEnlazada();
                b.Agregar("Edificio A", 10, false);
                b.Agregar("Edificio C", 26, false);
                b.Agregar("Cafeteria Verde", 115, true);
                return b;
            case "Edificio C":
                ListaEnlazada c = new ListaEnlazada();
                c.Agregar("Edificio B", 26, false);
                c.Agregar("Porteria 1", 67, false);
                c.Agregar("Cafeteria Verde", 110, true);
                c.Agregar("Edificio D", 141, true);
                return c;
            case "Cafeteria Verde":
                ListaEnlazada cafV = new ListaEnlazada();
                cafV.Agregar("Edificio B", 115, true);
                cafV.Agregar("Edificio C", 110, true);
                cafV.Agregar("Edificio D", 130, true);
                return cafV;
            case "Porteria 1":
                ListaEnlazada p1 = new ListaEnlazada();
                p1.Agregar("Edificio C", 67, false);
                p1.Agregar("Edificio D", 179, true);
                p1.Agregar("Edificio E", 236, false);
                p1.Agregar("Edificio F", 187, false);
                p1.Agregar("Edificio J", 90, false);
                return p1;
            case "Edificio J":
                ListaEnlazada j = new ListaEnlazada();
                j.Agregar("Porteria 1", 90, false);
                j.Agregar("Edificio F", 78, false);
                j.Agregar("Edificio G", 96, false);
                return j;
            case "Edificio G":
                ListaEnlazada g = new ListaEnlazada();
                g.Agregar("Edificio J", 96, false);
                g.Agregar("Edificio F", 42, false);
                g.Agregar("Edificio H", 52, false);
                g.Agregar("Edificio E", 35, false);
                return g;
            case "Edificio F":
                ListaEnlazada f = new ListaEnlazada();
                f.Agregar("Edificio J", 78, false);
                f.Agregar("Edificio G", 42, false);
                f.Agregar("Edificio E", 10, false);
                f.Agregar("Edificio H", 20, false);
                return f;
            case "Edificio H":
                ListaEnlazada h = new ListaEnlazada();
                h.Agregar("Edificio G", 52, false);
                h.Agregar("Edificio F", 20, false);
                h.Agregar("Edificio E", 11, false);
                h.Agregar("Edificio I", 197, true);
                h.Agregar("Cafeteria casi L", 200, false);
                return h;
            case "Edificio E":
                ListaEnlazada e = new ListaEnlazada();
                e.Agregar("Porteria 1", 236, false);
                e.Agregar("Edificio F", 10, false);
                e.Agregar("Edificio H", 11, false);
                e.Agregar("Edificio D", 64, true);
                e.Agregar("Edificio I", 95, true);
                return e;
            case "Edificio D":
                ListaEnlazada d = new ListaEnlazada();
                d.Agregar("Edificio C", 141, true);
                d.Agregar("Cafeteria Verde", 130, true);
                d.Agregar("Porteria 1", 179, true);
                d.Agregar("Edificio E", 64, true);
                d.Agregar("Edificio I", 126, true);
                d.Agregar("Porteria 2", 212, true);
                d.Agregar("Edificio K", 216, true);
                return d;
            case "Porteria 2":
                ListaEnlazada p2 = new ListaEnlazada();
                p2.Agregar("Edificio D", 212, true);
                p2.Agregar("Edificio I", 230, true);
                p2.Agregar("Edificio K", 315, true);
                return p2;
            case "Edificio I":
                ListaEnlazada i = new ListaEnlazada();
                i.Agregar("Porteria 2", 230, true);
                i.Agregar("Edificio D", 126, true);
                i.Agregar("Edificio E", 95, true);
                i.Agregar("Edificio H", 197, true);
                i.Agregar("Cafeteria casi L", 50, true);
                i.Agregar("Edificio L", 84, false);
                i.Agregar("Edificio K", 161, true);
                return i;
            case "Cafeteria casi L":
                ListaEnlazada cafL = new ListaEnlazada();
                cafL.Agregar("Edificio I", 50, true);
                cafL.Agregar("Edificio H", 200, false);
                cafL.Agregar("Edificio L", 36, false);
                return cafL;
            case "Edificio L":
                ListaEnlazada l = new ListaEnlazada();
                l.Agregar("Cafeteria casi L", 36, false);
                l.Agregar("Edificio I", 84, false);
                l.Agregar("Edificio K", 212, false);
                return l;
            case "Edificio K":
                ListaEnlazada k = new ListaEnlazada();
                k.Agregar("Edificio L", 212, false);
                k.Agregar("Edificio I", 161, true);
                k.Agregar("Edificio D", 216, true);
                k.Agregar("Porteria 2", 315, true);
                return k;
            default:
                return new ListaEnlazada();
        }
    }

    private final String[] nodosTotales = {
        "Edificio A", "Edificio B", "Edificio C", "Edificio D", 
        "Edificio E", "Edificio F", "Edificio G", "Edificio H", 
        "Edificio I", "Edificio J", "Edificio K", "Edificio L", 
        "Cafeteria Verde", "Cafeteria casi L", "Porteria 1", "Porteria 2"
    };

    private int obtenerIndice(String nombre) {
        for (int i = 0; i < nodosTotales.length; i++) {
            if (nodosTotales[i].equals(nombre)) return i;
        }
        return -1;
    }

    public String calcularRuta(String origen, String destino, boolean evitarEscaleras, String edificioCerrado) {
        
        if (origen.equals(edificioCerrado) || destino.equals(edificioCerrado)) {
            return "Error: El edificio de origen o destino se encuentra temporalmente CERRADO por mantenimiento.";
        }

        int n = nodosTotales.length;
        int[] distancias = new int[n];
        boolean[] visitados = new boolean[n];
        int[] antecesores = new int[n];

        Arrays.fill(distancias, 999999);
        Arrays.fill(antecesores, -1);

        int idxOrigen = obtenerIndice(origen);
        int idxDestino = obtenerIndice(destino);

        if (idxOrigen == -1 || idxDestino == -1) return "Origen o destino inválido.";

        distancias[idxOrigen] = 0;

        for (int i = 0; i < n; i++) {
            int minDist = 999999;
            int u = -1;

            for (int j = 0; j < n; j++) {
                if (!visitados[j] && distancias[j] < minDist) {
                    minDist = distancias[j];
                    u = j;
                }
            }

            if (u == -1 || minDist == 999999) break;
            visitados[u] = true;

            if (u == idxDestino) break;

            String edificioActual = nodosTotales[u];
            ListaEnlazada vecinos = obtenerVecinos(edificioActual);
            Nodo temp = vecinos.getCabeza();

            while (temp != null) {
                String vecinoDestino = temp.getDestino();

                if (vecinoDestino.equals(edificioCerrado)) {
                    temp = temp.getSiguiente();
                    continue;
                }

                if (evitarEscaleras && temp.isTieneEscaleras()) {
                    temp = temp.getSiguiente();
                    continue;
                }

                int v = obtenerIndice(vecinoDestino);
                if (v != -1) {
                    int peso = temp.getPasos();
                    if (!visitados[v] && distancias[u] + peso < distancias[v]) {
                        distancias[v] = distancias[u] + peso;
                        antecesores[v] = u;
                    }
                }
                temp = temp.getSiguiente();
            }
        }

        if (distancias[idxDestino] == 999999) {
            return "No se encontró ruta disponible (el cierre temporal bloquea el paso o no hay camino alternativo).";
        }

        List<String> camino = new ArrayList<>();
        int actual = idxDestino;
        while (actual != -1) {
            camino.add(0, nodosTotales[actual]);
            actual = antecesores[actual];
        }

        return "--- RUTA ÓPTIMA (CIERRE: " + edificioCerrado + ") ---\n\n" +
               "Camino: " + String.join(" -> ", camino) + "\n\n" +
               "Total de pasos: " + distancias[idxDestino];
    }
}