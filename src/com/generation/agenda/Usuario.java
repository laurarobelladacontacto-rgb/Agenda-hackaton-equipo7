package com.generation.agenda;

public class Usuario extends Persona{
    private Agenda agenda;

    public Usuario (String nombre, String apellido) {
        super(nombre, apellido);
        this.agenda = new Agenda();
    }

    public Usuario(String nombre, String apellido, int capacidadMaxima) {
        super(nombre, apellido);
        this.agenda = new Agenda(capacidadMaxima);
    }

    public Agenda getAgenda() {
        return this.agenda;
    }
}
