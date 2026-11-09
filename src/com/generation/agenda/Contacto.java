package com.generation.agenda;

public class Contacto extends Persona{
    private String telefono;

    public Contacto (String nombre, String apellido, String telefono) {
        super(nombre, apellido);
        this.telefono = telefono;

    }

    public boolean coincide (String nombre, String apellido) {
        return nombre != null
                && apellido != null
                && getNombre().equalsIgnoreCase(nombre.strip())
                && getApellido().equalsIgnoreCase(apellido.strip());

    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
