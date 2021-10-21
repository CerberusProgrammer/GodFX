import com.google.gson.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    private TextField fieldPeriodo;
    @FXML
    private TextArea fieldRepresentacion;
    @FXML
    private TextField fieldCultura;
    @FXML
    private ImageView imageDios;
    @FXML
    private TextField fieldNombre;
    @FXML
    private TextField fieldTemplo;
    @FXML
    private TextField fieldCiudad;
    @FXML
    private TextField fieldZona;
    @FXML
    private TabPane tabPane;

    public ListaCircularDoble<Cultura> culturaListaDoble = new ListaCircularDoble<>();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fieldRepresentacion.setWrapText(true);

        try {
            String jsonCultura = readFile("src/Cultura.json");

            JsonParser parser = new JsonParser();
            JsonArray jsonElements = parser.parse(jsonCultura).getAsJsonArray();

            for (JsonElement jsonElement : jsonElements) {
                JsonObject jsonObject = jsonElement.getAsJsonObject();

                String nombre = jsonObject.get("nombre").getAsString();
                String area = jsonObject.get("area").getAsString();
                String ciudad = jsonObject.get("ciudad").getAsString();
                String periodo = jsonObject.get("periodo").getAsString();

                Tab tab = new Tab(nombre);
                ScrollPane scrollPane = new ScrollPane();
                HBox hBox = new HBox();
                hBox.setPadding(new Insets(10));
                hBox.setSpacing(10);

                JsonArray jsonArray = jsonObject.get("dioses").getAsJsonArray();

                ListaCircular<Dios> listaCircular = new ListaCircular<>();

                for (JsonElement jsonElement1 : jsonArray) {
                    JsonObject jsonDioses = jsonElement1.getAsJsonObject();

                    ImageView imageView = new ImageView(jsonDioses.get("imageView").getAsString());
                    imageView.setFitWidth(200);
                    imageView.setFitHeight(150);
                    imageView.setStyle("-fx-effect: dropshadow(three-pass-box, rgba(0,0,0,0.8), 10, 0,0,0); " +
                            "-fx-background-radius: 5;");

                    hBox.getChildren().add(imageView);

                    listaCircular.insertaFinal(new Dios(
                            jsonDioses.get("nombre").getAsString(),
                            jsonDioses.get("representacion").getAsString(),
                            jsonDioses.get("templo").getAsString()
                    ));

                    imageView.setId(listaCircular.getUltimo().getNombre());
                    Tooltip tooltip = new Tooltip(listaCircular.getUltimo().getNombre());
                    Tooltip.install(imageView, tooltip);

                    imageView.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                        fieldNombre.setText(jsonDioses.get("nombre").getAsString());
                        fieldRepresentacion.setText(jsonDioses.get("representacion").getAsString());
                        fieldTemplo.setText(jsonDioses.get("templo").getAsString());

                        fieldCultura.setText(jsonObject.get("nombre").getAsString());
                        fieldCiudad.setText(jsonObject.get("ciudad").getAsString());
                        fieldZona.setText(jsonObject.get("area").getAsString());
                        fieldPeriodo.setText(jsonObject.get("periodo").getAsString());

                        imageDios.setImage(new Image(jsonDioses.get("imageView").getAsString()));
                    });
                }

                scrollPane.setContent(hBox);
                tab.setContent(scrollPane);
                tabPane.getTabs().add(tab);

                culturaListaDoble.insertaFinal(new Cultura(
                        nombre,
                        area,
                        ciudad,
                        periodo,
                        listaCircular
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    String readFile(String file) throws IOException {
        String text;
        StringBuilder content = new StringBuilder();

        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        while ((text = bufferedReader.readLine()) != null)
            content.append(text);

        bufferedReader.close();
        return content.toString();
    }
}