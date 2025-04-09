package com.example.tarea2_6.ApiService;

import com.example.tarea2_6.Modelos.Tiempo;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiService {
    private static Tiempo tiempo = new Tiempo();
    public static Tiempo cargarTiempo(String nombreTiempo) {
        try {
            String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + nombreTiempo + "&appid=1ad2bbf92bdc538283789ba8f8fb4a7e&units=metric";
            URL url = new URL(apiUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int codigo = conn.getResponseCode();
            if (codigo == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                StringBuilder respuesta = new StringBuilder();
                String linea;
                while ((linea = reader.readLine()) != null) {
                    respuesta.append(linea);
                }
                reader.close();

                JSONObject jsonResponse = new JSONObject(respuesta.toString());

                tiempo.setCiudad(jsonResponse.getString("name"));
                tiempo.setGrados(String.valueOf(jsonResponse.getJSONObject("main").getDouble("temp")));
                tiempo.setClima(jsonResponse.getJSONArray("weather").getJSONObject(0).getString("main"));
                tiempo.setPrecipitacion(jsonResponse.has("rain") ? String.valueOf(jsonResponse.getJSONObject("rain").optDouble("1h", 0.0)) : "0");

            } else {
                System.out.println("Error en la conexión: " + codigo);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return tiempo;
    }
}