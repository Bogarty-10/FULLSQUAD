package com.example.fullsquad;

// Modelo de partido
public class Partido {

    private String nombreEvent;
    private String fechEvent;
    private String localizacionEvent;
    private String horaEvent;

    public Partido(String nombreEvent, String fechEvent, String localizacionEvent, String horaEvent) {
        this.nombreEvent = nombreEvent;
        this.fechEvent = fechEvent;
        this.localizacionEvent = localizacionEvent;
        this.horaEvent = horaEvent;
    }

    public String getNombreEvent() {
        return nombreEvent;
    }

    public String getFechEvent() {
        return fechEvent;
    }

    public String getLocalizacionEvent() {
        return localizacionEvent;
    }

    public String getHoraEvent() {
        return horaEvent;
    }
}