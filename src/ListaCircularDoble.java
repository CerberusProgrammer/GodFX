public class ListaCircularDoble<T> {

    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int size;

    public ListaCircularDoble() {
        this.inicio = null;
        this.ultimo = null;
        this.size = -1;
    }

    public boolean esVacia() {
        return inicio == null;
    }

    public int getSize() {
        return this.size;
    }

    public void insertaInicio(T dato){
        Nodo<T> nodo = new Nodo<>();
        nodo.setInfo(dato);

        if (inicio == null) {
            inicio = ultimo = nodo;
            nodo.setSig(inicio);
            nodo.setAnt(inicio);
        } else{
            nodo.setSig(inicio);
            inicio.setAnt(nodo);
            inicio = nodo;
            ultimo.setSig(inicio);
            nodo.setAnt(ultimo);
        }
        this.size++;
    }

    public void insertaFinal(T dato){
        Nodo<T> nodo = new Nodo<>();
        nodo.setInfo(dato);

        if (inicio == null) {
            inicio = ultimo = nodo;
            nodo.setSig(inicio);
            nodo.setAnt(inicio);
        } else {
            nodo.setSig(inicio);
            inicio.setAnt(nodo);
            ultimo.setSig(nodo);
            nodo.setAnt(ultimo);
            ultimo = nodo;
        }
        size++;
    }

    public T eliminaInicio() {
        Nodo<T> nodo = inicio;

        if (inicio == null)
            return null;
        else {
            if (inicio == ultimo)
                inicio = ultimo = null;
            else {
                ultimo.setSig(inicio.getSig());
                inicio = inicio.getSig();
                inicio.setAnt(ultimo);
            }
        }
        size--;

        return inicio.getInfo();
    }

    public T eliminaFinal() {
        Nodo<T> nodo = ultimo;

        if (inicio == null)
            return null;
        else {
            if (inicio == ultimo)
                inicio = ultimo = null;
            else {
                Nodo<T> r = ultimo.getAnt();
                r.setSig(inicio);
                inicio.setAnt(r);
                ultimo = r;
            }
        }
        size--;

        return nodo.getInfo();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        if (inicio == null)
            return null;
        else {
            Nodo<T> nodo = inicio;

            while (nodo != ultimo) {
                string.append(nodo.getInfo()).append("\n");
                nodo = nodo.getSig();
            }
            string.append(nodo.getInfo());
        }
        return string.toString();
    }
}
