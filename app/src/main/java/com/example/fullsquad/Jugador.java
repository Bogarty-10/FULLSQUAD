package com.example.fullsquad;

public class Jugador {

    private String correo;
    private String nombre;
    private String fechaNacimiento;
    private int dorsal;
    private String posicion;

    public Jugador(String correo, String nombre, String fechaNacimiento, int dorsal, String posicion) {
        this.correo = correo;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.dorsal = dorsal;
        this.posicion = posicion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public int getDorsal() {
        return dorsal;
    }

    public String getPosicion() {
        return posicion;
    }
}
