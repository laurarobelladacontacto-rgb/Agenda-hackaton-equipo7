package com.generation.agenda;

public abstract class Persona {
    private String nombre;
    private String apellido;

    public Persona (String nombre, String apellido) {
        if (nombre == null || nombre.isBlank() || apellido == null || apellido.isBlank()) {
            throw new IllegalArgumentException("El nombre y el apellido son obligatorios.");
        }
        this.nombre = nombre.strip();
        this.apellido = apellido.strip();
    }

    public String getNombre() {
        return this.nombre;
    }

    public String getApellido() {
        return this.apellido;
    }
}
