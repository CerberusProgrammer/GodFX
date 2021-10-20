import javafx.scene.image.ImageView;

public class Dios {

    private String nombre;
    private String representacion;
    private String templo;
    private ImageView imageView;

    public Dios(String nombre, String representacion, String templo) {
        this.nombre = nombre;
        this.representacion = representacion;
        this.templo = templo;
    }

    public Dios(String nombre, String representacion, String templo, ImageView imageView) {
        this.nombre = nombre;
        this.representacion = representacion;
        this.templo = templo;
        this.imageView = imageView;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRepresentacion() {
        return representacion;
    }

    public void setRepresentacion(String representacion) {
        this.representacion = representacion;
    }

    public String getTemplo() {
        return templo;
    }

    public void setTemplo(String templo) {
        this.templo = templo;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }

    @Override
    public String toString() {
        return "Dios{" +
                "nombre='" + nombre + '\'' +
                ", representacion='" + representacion + '\'' +
                ", templo='" + templo + '\'' +
                ", imageView=" + imageView +
                '}';
    }
}