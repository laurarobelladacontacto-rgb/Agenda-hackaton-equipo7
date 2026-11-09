package com.generation.agenda;

import java.util.Comparator;
import java.util.List;

public class Agenda {
    List<Contacto> agenda;

    /* Metodo AñadirContacto : valida por medio de un if si agenda está llena y si existe el contacto, por medio de los métodos que creamos.
    si cumple esta condición se agrega un nuevo contacto a la agenda, caso contrario manda mensaje de "la agenda está llena" o "el contacto ya existe"
     */
    public void anadirContacto(Contacto contacto) {
        if (agendaLlena(this.agenda) && existeContacto(contacto)) {
            agenda.add(contacto);
        } else {
            System.out.println("La agenda está llena o ya existe el contacto.");
        }
    }

    private boolean agendaLlena (List<Contacto> agenda) {
        return agenda.size() <= 10;
    }

    private int buscarIndice(String nombre, String apellido) {
        for (int i = 0; i < agenda.size(); i++) {
            if (agenda.get(i).coincide(nombre, apellido)) {
                return i;
            }
        }
        return -1;
    }

    private boolean existeContacto (Contacto contacto) {
        return contacto != null && buscarIndice(contacto.getNombre(), contacto.getApellido()) >= 0;
    }

    public void listarContactos() {
        agenda.sort(Comparator
                .comparing(Contacto::getNombre, String.CASE_INSENSITIVE_ORDER)
                .thenComparing(Contacto::getApellido, String.CASE_INSENSITIVE_ORDER));
        for(int i = 0; i < agenda.size(); i++) {
            agenda.get(i).getNombre();
            System.out.println(agenda.get(i).getNombre() + " " + agenda.get(i).getApellido() + " - " + agenda.get(i).getTelefono());
        }
    }

    public void buscarContacto (String nombre, String apellido) {
        int indice = buscarIndice(nombre, apellido);
        if (indice < 0) {
            System.out.println("No existe usuario.");
        }else {
            System.out.println("El teléfono del usuario buscado es: " + agenda.get(indice).getTelefono());
        }
    }

    public void eliminarContacto (String nombre, String apellido) {
        int indice = buscarIndice(nombre, apellido);
        if (indice >= 0) {
            agenda.remove(indice);
        }else {
            System.out.println("El usuario no se encuentra.");
        }
    }

    public void modificarTelefono (String nombre, String apellido, String nuevoTelefono) {
        int indice = buscarIndice(nombre, apellido);
        if (indice >= 0) {
            agenda.get(indice).setTelefono(nuevoTelefono);
        } else {
            System.out.println("No se encontró el contacto.");
        }
    }

    public void espaciosLibres () {
        System.out.println("Espacios libres: " + (10 - agenda.size()));
    }
}
