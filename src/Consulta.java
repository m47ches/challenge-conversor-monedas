import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Consulta {
    public String consultaDeCambio (String origen, String objetivo) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        double monto = 0.0;
        boolean entradaValida = false;
        while (!entradaValida){
            try {
                System.out.println("¿Cuál es el monto que usted desea convertir?");
                monto = lectura.nextDouble();
                entradaValida = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrada no válida, ingrese un monto adecuado.");
                lectura.next();
            }
        }

        URI direccion = URI.create("https://v6.exchangerate-api.com/v6/b71f783f0fef1119b1908af4/pair/"+
                origen + "/" + objetivo + "/" + monto);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(direccion)
                .build();

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        var json = response.body();
        JsonElement jsonElemento = JsonParser.parseString(json);
        JsonObject jsonObjeto = jsonElemento.getAsJsonObject();
        return jsonObjeto.get("conversion_result").getAsString();
    }
}
