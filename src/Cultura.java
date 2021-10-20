public class Cultura {

    private String nombre;
    private String area;
    private String ciudad;
    private String periodo;
    private ListaCircular<Dios> dioses;

    public Cultura(String nombre, String area, String ciudad, String periodo) {
        this.nombre = nombre;
        this.area = area;
        this.ciudad = ciudad;
        this.periodo = periodo;
    }

    public Cultura(String nombre, String area, String ciudad, String periodo, ListaCircular<Dios> dioses) {
        this.nombre = nombre;
        this.area = area;
        this.ciudad = ciudad;
        this.periodo = periodo;
        this.dioses = dioses;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }

    public ListaCircular<Dios> getDioses() {
        return dioses;
    }

    public void setDioses(ListaCircular<Dios> dioses) {
        this.dioses = dioses;
    }

    @Override
    public String toString() {
        return "Cultura{" +
                "nombre='" + nombre + '\'' +
                ", area='" + area + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", periodo='" + periodo + '\'' +
                ", dioses=" + dioses +
                '}';
    }
}