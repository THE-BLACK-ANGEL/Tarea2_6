package com.example.tarea2_6.Controladores;

import com.example.tarea2_6.ApiService.ApiService;
import com.example.tarea2_6.Modelos.Tiempo;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
            Tiempo tiempo = ApiService.cargarTiempo(ciudad);

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
        }).start();
    }

}