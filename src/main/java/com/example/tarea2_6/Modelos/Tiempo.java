package com.example.tarea2_6.Modelos;

import javafx.beans.property.SimpleStringProperty;

public class Tiempo {
        private SimpleStringProperty ciudad ;
        private SimpleStringProperty grados ;
        private SimpleStringProperty clima ;
        private SimpleStringProperty precipitacion ;

    public Tiempo() {
        ciudad = new SimpleStringProperty();
        grados = new SimpleStringProperty();
        clima = new SimpleStringProperty();
        precipitacion = new SimpleStringProperty();
    }

    public String getCiudad() {
        return ciudad.get();
    }

    public SimpleStringProperty ciudadProperty() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad.set(ciudad);
    }

    public String getGrados() {
        return grados.get();
    }

    public SimpleStringProperty gradosProperty() {
        return grados;
    }

    public void setGrados(String grados) {
        this.grados.set(grados);
    }

    public String getClima() {
        return clima.get();
    }

    public SimpleStringProperty climaProperty() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima.set(clima);
    }

    public String getPrecipitacion() {
        return precipitacion.get();
    }

    public SimpleStringProperty precipitacionProperty() {
        return precipitacion;
    }

    public void setPrecipitacion(String precipitacion) {
        this.precipitacion.set(precipitacion);
    }
}
