public class Nodo <T>{

    T info;
    Nodo<T> ant;
    Nodo<T> sig;

    public Nodo() {
        this.info = null;
        this.ant = null;
        this.sig = null;
    }

    public Nodo(T info, Nodo<T> ant, Nodo<T> sig) {
        this.info = info;
        this.ant = ant;
        this.sig = sig;
    }

    public T getInfo() {
        return info;
    }

    public void setInfo(T info) {
        this.info = info;
    }

    public Nodo<T> getAnt() {
        return ant;
    }

    public void setAnt(Nodo<T> ant) {
        this.ant = ant;
    }

    public Nodo<T> getSig() {
        return sig;
    }

    public void setSig(Nodo<T> sig) {
        this.sig = sig;
    }
}
