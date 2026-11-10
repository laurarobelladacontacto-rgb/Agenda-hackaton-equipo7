package com.generation.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Agenda {
    private List<Contacto> agenda;
    private int capacidadMaxima;

    public Agenda() {
        this(10);
    }

    public Agenda(int capacidadMaxima) {
        if (capacidadMaxima < 0) {
            throw new IllegalArgumentException("La capacidad debe ser mayor o igual a cero.");
        }
        this.capacidadMaxima = capacidadMaxima;
        this.agenda = new ArrayList<>();
    }

    public void añadirContacto(Contacto contacto) {
        if (contacto == null) {
            throw new IllegalArgumentException("El contacto es obligatorio.");
        }
        int indice = buscarIndice(contacto);
        if (indice >= 0) {
            System.out.println("El contacto ya existe.");
        } else if (agendaLlena()) {
            System.out.println("La agenda está llena. No hay espacio disponible.");
        } else {
            int posicionInsercion = -indice - 1;
            agenda.add(posicionInsercion, contacto);
            System.out.println("Contacto añadido correctamente.");
        }
    }

    public boolean agendaLlena () {
        return agenda.size() >= capacidadMaxima;
    }

    private int buscarIndice(String nombre, String apellido) {
        int indice = -1;
        if (nombre != null && apellido != null && !nombre.isBlank() && !apellido.isBlank()) {
            indice = buscarIndice(new Contacto(nombre, apellido, ""));
        }
        return indice;
    }

    private int buscarIndice(Contacto contacto) {
        Comparator<Contacto> ordenContactos = Comparator
                .comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER);
        return Collections.binarySearch(agenda, contacto, ordenContactos);
    }

    public boolean existeContacto (Contacto contacto) {
        return contacto != null && buscarIndice(contacto) >= 0;
    }

    public void listarContactos() {
        if (agenda.isEmpty()) {
            System.out.println("La agenda está vacía.");
        }
        for (Contacto contacto : agenda) {
            System.out.println(contacto.getNombre() + " " + contacto.getApellido() + " - " + contacto.getTelefono());
        }
    }

    public void buscaContacto (String nombre, String apellido) {
        int indice = buscarIndice(nombre, apellido);
        if (indice < 0) {
            System.out.println("No existe usuario.");
        }else {
            System.out.println("El teléfono del usuario buscado es: " + agenda.get(indice).getTelefono());
        }
    }

    public void eliminarContacto(Contacto contacto) {
        if (contacto == null) {
            System.out.println("El usuario no se encuentra.");
        } else {
            eliminarContacto(contacto.getNombre(), contacto.getApellido());
        }
    }

    public void eliminarContacto (String nombre, String apellido) {
        int indice = buscarIndice(nombre, apellido);
        if (indice >= 0) {
            agenda.remove(indice);
            System.out.println("Contacto eliminado correctamente.");
        }else {
            System.out.println("El usuario no se encuentra.");
        }
    }

    public void modificarTelefono (String nombre, String apellido, String nuevoTelefono) {
        int indice = buscarIndice(nombre, apellido);
        if (indice >= 0) {
            agenda.get(indice).setTelefono(nuevoTelefono);
            System.out.println("Teléfono modificado correctamente.");
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    public void espaciosLibres () {
        System.out.println("Espacios libres: " + espacioLibres());
    }

    public int espacioLibres() {
        return capacidadMaxima - agenda.size();
    }
}
