package com.generation.agenda;

import java.util.Scanner;

public class Menu {
    public void iniciar () {
        System.out.println("""
                Bienvenido a la agenda telefónica. Por favor elija una opción 
                1. Añadir contacto.
                2. Comprobar si un contacto existe.
                3. Listar contactos.
                4. Buscar contacto.
                5. Eliminar contacto.
                6. Ver espacios libres.
                7. Modificar teléfono.
                8. Salir.
                """);
        Scanner menu = new Scanner(System.in);
        String eleccionUsuario = menu.nextLine();
        switch (eleccionUsuario) {
            case "1" : "Añadir contacto."
            case "2" : "Comprobar si un contacto existe."
            case "3" : "Listar contactos."
            case "4" : "Buscar contacto."
            case "5" : "Eliminar contacto."
            case "6" : "Ver espacios libres."
            case "7" : "Modificar teléfono."
            case "8" : "Salir."
        }
    }
}
