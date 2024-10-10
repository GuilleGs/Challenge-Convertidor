package API;

import com.google.gson.Gson;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Consulta {
    public double resultado (double monto,String monedaBase,String monedaConvertir) throws IOException, InterruptedException {
        String direccion = "https://v6.exchangerate-api.com/v6/2889a366112643fab10d96de/pair/"+monedaBase+"/"+monedaConvertir+"/"+monto;

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();
        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());
        String json = response.body();

        Gson gson = new Gson();
        Moneda miMoneda = gson.fromJson(json,Moneda.class);
        return miMoneda.conversion_result();
    }
}
