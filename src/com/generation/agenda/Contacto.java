package com.generation.agenda;

public class Contacto extends Persona{
    private String telefono;

    public Contacto (String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;

    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
