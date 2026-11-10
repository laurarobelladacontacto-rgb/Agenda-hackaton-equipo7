package com.generation.agenda;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Menu {
    public void iniciar () {
        try (Scanner menu = new Scanner(System.in)) {
            Usuario usuario = crearUsuario(menu);
            Agenda agenda = usuario.getAgenda();
            System.out.println("Agenda de " + usuario.getNombre() + " " + usuario.getApellido());

            boolean salir = false;
            while (!salir) {
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
                        9. Comprobar si la agenda está llena.
                        """);
                String eleccionUsuario = menu.nextLine().strip();
                try {
                    switch (eleccionUsuario) {
                        case "1" -> agenda.añadirContacto(leerContacto(menu, true));
                        case "2" -> System.out.println(
                                agenda.existeContacto(leerContacto(menu, false))
                                        ? "El contacto existe."
                                        : "El contacto no existe.");
                        case "3" -> agenda.listarContactos();
                        case "4" -> {
                            Contacto datos = leerContacto(menu, false);
                            agenda.buscaContacto(datos.getNombre(), datos.getApellido());
                        }
                        case "5" -> agenda.eliminarContacto(leerContacto(menu, false));
                        case "6" -> agenda.espaciosLibres();
                        case "7" -> {
                            Contacto datos = leerContacto(menu, false);
                            String telefono = leer(menu, "Nuevo teléfono: ");
                            agenda.modificarTelefono(datos.getNombre(), datos.getApellido(), telefono);
                        }
                        case "8" -> {
                            System.out.println("Hasta luego.");
                            salir = true;
                        }
                        case "9" -> System.out.println(agenda.agendaLlena()
                                ? "La agenda está llena. No hay espacio disponible."
                                : "La agenda tiene espacio disponible.");
                        default -> System.out.println("Opción inválida.");
                    }
                } catch (IllegalArgumentException error) {
                    System.out.println(error.getMessage());
                }
            }
        } catch (NoSuchElementException error) {
            System.out.println("\nEntrada finalizada.");
        }
    }

    private Usuario crearUsuario(Scanner menu) {
        Usuario usuario = null;
        while (usuario == null) {
            String nombre = leer(menu, "Nombre del usuario: ");
            String apellido = leer(menu, "Apellido del usuario: ");
            try {
                Usuario usuarioPredeterminado = new Usuario(nombre, apellido);
                while (usuario == null) {
                    String capacidad = leer(menu, "Capacidad máxima (Enter para usar 10): ").strip();
                    if (capacidad.isEmpty()) {
                        usuario = usuarioPredeterminado;
                    } else {
                        try {
                            usuario = new Usuario(nombre, apellido, Integer.parseInt(capacidad));
                        } catch (IllegalArgumentException error) {
                            System.out.println("Escribe un número entero mayor o igual a cero.");
                        }
                    }
                }
            } catch (IllegalArgumentException error) {
                System.out.println(error.getMessage());
            }
        }
        return usuario;
    }

    private Contacto leerContacto(Scanner menu, boolean pedirTelefono) {
        String nombre = leer(menu, "Nombre: ");
        String apellido = leer(menu, "Apellido: ");
        String telefono = pedirTelefono ? leer(menu, "Teléfono: ") : "";
        return new Contacto(nombre, apellido, telefono);
    }

    private String leer(Scanner menu, String mensaje) {
        System.out.print(mensaje);
        return menu.nextLine();
    }
}
