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

    @Override
    public boolean equals(Object objeto) {
        return objeto instanceof Contacto otro
                && coincide(otro.getNombre(), otro.getApellido());
    }

    @Override
    public int hashCode() {
        return 31 * hashSinMayusculas(getNombre()) + hashSinMayusculas(getApellido());
    }

    private static int hashSinMayusculas(String texto) {
        int hash = 1;
        for (int indice = 0; indice < texto.length();) {
            int letra = texto.codePointAt(indice);
            int letraNormalizada = Character.toLowerCase(Character.toUpperCase(letra));
            hash = 31 * hash + letraNormalizada;
            indice += Character.charCount(letra);
        }
        return hash;
    }

}
