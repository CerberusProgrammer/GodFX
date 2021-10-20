public class ListaCircular<T> {

    private Nodo<T> inicio;
    private Nodo<T> ultimo;
    private int size;

    public ListaCircular() {
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
        } else{
            nodo.setSig(inicio);
            inicio = nodo;
            ultimo.setSig(inicio);
        }
        this.size++;
    }

    public void insertaFinal(T dato){
        Nodo<T> nodo = new Nodo<>();
        nodo.setInfo(dato);

        if (inicio == null) {
            inicio = ultimo = nodo;
            nodo.setSig(inicio);
        } else {
            nodo.setSig(inicio);
            ultimo.setSig(nodo);
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
                Nodo<T> r = inicio;

                while (r.getSig() != ultimo)
                    r = r.getSig();

                ultimo = r;
                ultimo.setSig(inicio);
            }
        }
        size--;

        return nodo.getInfo();
    }

    public T getInicio() {
        return inicio.getInfo();
    }

    public T getUltimo() {
        return ultimo.getInfo();
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
