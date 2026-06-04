// objeto modelo jugador con sus atributos
package com.example.fullsquad;

public class Jugador {
    private String correo;
    private String nombre;

    private String fechNacimiento;

    private int doral;

    private String posiscion;

    public Jugador(String correo, String nombre, String fechNacimiento, int doral, String posiscion) {
        this.correo = correo;
        this.nombre = nombre;
        this.fechNacimiento = fechNacimiento;
        this.doral = doral;
        this.posiscion = posiscion;
    }

    public String getCorreo() {
        return correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechNacimiento() {
        return fechNacimiento;
    }

    public int getDoral() {
        return doral;
    }

    public String getPosiscion() {
        return posiscion;
    }
}
