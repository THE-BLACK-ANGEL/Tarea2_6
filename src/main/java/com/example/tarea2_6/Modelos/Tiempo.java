package com.example.tarea2_6.Modelos;

public class Tiempo {
    private String ciudad;
    private String grados;
    private String clima;
    private String precipitacion;

    public Tiempo() {}

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getGrados() {
        return grados;
    }

    public void setGrados(String grados) {
        this.grados = grados;
    }

    public String getClima() {
        return clima;
    }

    public void setClima(String clima) {
        this.clima = clima;
    }

    public String getPrecipitacion() {
        return precipitacion;
    }

    public void setPrecipitacion(String precipitacion) {
        this.precipitacion = precipitacion;
    }

    @Override
    public String toString() {
        return "Tiempo{" +
                "ciudad='" + ciudad + '\'' +
                ", grados=" + grados +
                ", clima='" + clima + '\'' +
                ", precipitacion='" + precipitacion + '\'' +
                '}';
    }
}