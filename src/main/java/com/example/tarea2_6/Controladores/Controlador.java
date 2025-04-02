package com.example.tarea2_6.Controladores;

import com.example.tarea2_6.Modelos.Tiempo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controlador {

    @FXML
    private TextField tfCiudad = new TextField();
    @FXML
    private Button botonBuscar = new Button();
    @FXML
    private TableView<Tiempo> tablaTiempo;
    @FXML
    private TableColumn<Tiempo, String> colCiudad;
    @FXML
    private TableColumn<Tiempo, String> colGrados;
    @FXML
    private TableColumn<Tiempo, String> colClima;
    @FXML
    private TableColumn<Tiempo, String> colPrecipitacion;

    private ObservableList<Tiempo> datos = FXCollections.observableArrayList();

    public void inicializacion()
    {
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colGrados.setCellValueFactory(new PropertyValueFactory<>("grados"));
        colClima.setCellValueFactory(new PropertyValueFactory<>("clima"));
        colPrecipitacion.setCellValueFactory(new PropertyValueFactory<>("precipitacion"));
        tablaTiempo.setItems(datos);
        botonBuscar.setOnAction( e -> buscar());

    }
    public void buscar (){

        System.out.println(tfCiudad.getText());

    }

}