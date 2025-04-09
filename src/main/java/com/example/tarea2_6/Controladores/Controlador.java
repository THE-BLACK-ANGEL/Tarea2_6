package com.example.tarea2_6.Controladores;

import com.example.tarea2_6.Modelos.Tiempo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;

public class Controlador {

    @FXML
    private ImageView imagenClima;
    @FXML
    private TextField tfCiudad = new TextField();
    @FXML
    private Button botonBuscar = new Button();
    @FXML
    private TextField tfCiudad2 = new TextField();
    @FXML
    private TextField tfGrados = new TextField();
    @FXML
    private TextField tfClima = new TextField();
    @FXML
    private TextField tfPrecipitacion = new TextField();

    public void inicializacion() {
        botonBuscar.setOnAction(e -> buscar());
    }

    public void buscar() {
        String ciudad = tfCiudad.getText();
        if (ciudad.isEmpty()) {
            System.out.println("Por favor, ingrese una ciudad.");
            return;
        }

        new Thread(() -> {
            try {
                String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + ciudad + "&appid=1ad2bbf92bdc538283789ba8f8fb4a7e&units=metric";
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
                    Tiempo tiempo = new Tiempo();
                    tiempo.setCiudad(jsonResponse.getString("name"));
                    tiempo.setGrados(String.valueOf(jsonResponse.getJSONObject("main").getDouble("temp")));
                    tiempo.setClima(jsonResponse.getJSONArray("weather").getJSONObject(0).getString("main"));
                    tiempo.setPrecipitacion(jsonResponse.has("rain") ? String.valueOf(jsonResponse.getJSONObject("rain").optDouble("1h",0.0)) : "0");

                    javafx.application.Platform.runLater(() -> {

                        tfCiudad2.setText(tiempo.getCiudad());
                        tfGrados.setText(String.valueOf(tiempo.getGrados()));
                        switch (tiempo.getClima()){
                            case "Rain" ->{tfClima.setText("lluvia");}
                            case "Snow" -> {tfClima.setText("nieve");}
                            case "Drizzle" -> {tfClima.setText("lluvia ligera");}
                            case "ThunderStorm" -> {tfClima.setText("tormenta");}
                            case "Atmosphere" -> {tfClima.setText("niebla");}
                            case "Clouds" -> {tfClima.setText("nublado");}
                            case "Clear" -> {tfClima.setText("despejado");}
                        }
                        tfPrecipitacion.setText(tiempo.getPrecipitacion());

                        switch (tiempo.getClima()){
                            case "Rain" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\lluvia.png"));}
                            case "Snow" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\nieve.png"));}
                            case "Drizzle" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\lluvia.png"));}
                            case "ThunderStorm" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\tormenta.png"));}
                            case "Atmosphere" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\niebla.png"));}
                            case "Clouds" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\nublado.png"));}
                            case "Clear" ->{imagenClima.setImage(new Image("C:\\Users\\angel\\IdeaProjects\\Tarea2_6\\src\\main\\resources\\com\\example\\tarea2_6\\com.example.tarea2_6.imagenes\\soleado.png"));}
                        }
                    });
                } else {
                    System.out.println("Error en la conexión: " + codigo);
                }
            } catch (Exception e) {
                System.out.println("Error en la llamada: " + e.getMessage());
            }
        }).start();
    }

}