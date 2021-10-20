public class ListaDoble<T> {

    Nodo<T> inicio;

    public ListaDoble() {
        inicio = null;
    }

    public ListaDoble(Nodo<T> inicio) {
        this.inicio = inicio;
    }

    public void insertaInicio(T dato) {
        Nodo<T> n = new Nodo<>();

        n.setInfo(dato);
        n.setSig(inicio);
        n.setAnt(null);

        if (inicio != null)
            inicio.setAnt(n);

        inicio = n;
    }

    public void insertaFin(T dato) {
        Nodo<T> nodo = new Nodo<>();

        nodo.setInfo(dato);
        nodo.setSig(null);

        if (inicio == null) {
            nodo.setAnt(inicio);
            inicio = nodo;
        } else {
            Nodo<T> r = inicio;

            while (r.getSig() != null)
                r = r.getSig();

            r.setSig(nodo);
            nodo.setAnt(r);
        }
    }

    public T get(int i) {
        Nodo<T> nodo = inicio;
        int x = 0;

        while (x != i) {
            x++;
            nodo = nodo.getSig();
        }

        return nodo.getInfo();
    }

    public T getUltimo() {
        return null;
    }

    public T eliminaInicio() {
        Nodo<T> nodo = inicio;

        if (inicio == null) {
            return null;
        } else {
            if (inicio.getSig() == null) {
                inicio = null;
            } else {
                inicio = inicio.getSig();
                inicio.setAnt(null);
            }
        }

        return nodo.getInfo();
    }

    public T eliminaFinal() {
        Nodo<T> nodo = new Nodo<>();

        if (inicio == null)
            return null;
        else {
            if (inicio.getSig() == null)
                inicio = null;
            else {
                Nodo<T> r = inicio;

                while (r.getSig() != null)
                    r = r.getSig();

                r.getAnt().setSig(null);
                nodo = r;
            }
        }

        return nodo.getInfo();
    }

    public String toString() {
        StringBuilder string = new StringBuilder();

        if (inicio == null)
            return null;
        else {
            Nodo<T> nodo = inicio;

            while (nodo != null) {
                string.append(nodo.getInfo()).append("\n");
                nodo = nodo.getSig();
            }
        }

        return string.toString();
    }
}
