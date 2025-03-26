package com.example.tarea2_6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicacion extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Aplicacion.class.getResource("Vista.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 640, 480);
        scene.getStylesheets().add(Aplicacion.class.getResource("Estilo.css").toExternalForm());
        stage.setTitle("Programa para el uso de API publica");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();}
}