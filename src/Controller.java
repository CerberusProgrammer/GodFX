import com.google.gson.*;
import javafx.fxml.Initializable;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public ListaDoble<Cultura> culturaListaDoble = new ListaDoble<>();
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
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

                JsonArray jsonArray = jsonObject.get("dioses").getAsJsonArray();
                ListaDoble<Dios> diosList = new ListaDoble<>();

                for (JsonElement jsonElement1 : jsonArray) {
                    JsonObject jsonDioses = jsonElement1.getAsJsonObject();

                    diosList.insertaFin(new Dios(
                            jsonDioses.get("nombre").getAsString(),
                            jsonDioses.get("representacion").getAsString(),
                            jsonDioses.get("templo").getAsString()
                    ));
                }

                culturaListaDoble.insertaFin(new Cultura(
                        nombre,
                        area,
                        ciudad,
                        periodo,
                        diosList
                ));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}