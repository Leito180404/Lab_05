package Ejercicios;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestorDeTareas = new GestorDeTareas<>();
        Scanner scanner = new Scanner(System.in);

        Tarea tarea1 = new Tarea("Estudiar Java", 2);
        Tarea tarea2 = new Tarea("Hacer ejercicio", 1);
        Tarea tarea3 = new Tarea("Leer un libro", 3);

        List<Tarea> tareasCompletadas = new LinkedList<>();


        gestorDeTareas.agregarTarea(tarea1);
        gestorDeTareas.agregarTarea(tarea2);
        gestorDeTareas.agregarTarea(tarea3);

        while (true) {
            System.out.println("\n---- Bienvenido al menu mi causayin ----");
            System.out.println("1. Agregar tarea");
            System.out.println("2. Eliminar tarea");
            System.out.println("3. Imprimir tareas");
            System.out.println("4. Verificar si una tarea existe");
            System.out.println("5. Contar tareas");
            System.out.println("6. Obtener tarea con mayor prioridad");
            System.out.println("7. Invertir el orden de las tareas");
            System.out.println("8. Transferir tarea a completadas");
            System.out.println("9. Ver tareas completadas");
            System.out.println("10. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nIntroduce el título de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Introduce la prioridad de la tarea (número): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    Tarea nuevaTarea = new Tarea(titulo, prioridad);
                    gestorDeTareas.agregarTarea(nuevaTarea);
                    System.out.println("Tarea agregada con éxito.");
                    break;

                case 2:
                    System.out.print("\nIntroduce el título de la tarea a eliminar: ");
                    String tareaEliminar = scanner.nextLine();
                    boolean tareaEliminada = false;
                    for (Tarea tarea : gestorDeTareas.getTareas()) {
                        if (tarea.getTitulo().equals(tareaEliminar)) {
                            gestorDeTareas.eliminarTarea(tarea);
                            tareaEliminada = true;
                            System.out.println("Tarea eliminada con éxito.");
                            break;
                        }
                    }
                    if (!tareaEliminada) {
                        System.out.println("La tarea no se encontró.");
                    }
                    break;

                case 3:
                    System.out.println("\nTareas actuales:");
                    gestorDeTareas.imprimirTareas();
                    break;

                case 4:
                    System.out.print("\nIntroduce el titulo de la tarea para verificar si existe: ");
                    String tareaExistente = scanner.nextLine();
                    boolean existe = false;
                    for (Tarea tarea : gestorDeTareas.getTareas()) {
                        if (tarea.getTitulo().equals(tareaExistente)) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println("La tarea existe en la lista.");
                    } else {
                        System.out.println("La tarea no se encuentra en la lista.");
                    }
                    break;

                case 5:
                    System.out.println("\nNumero total de tareas: " + gestorDeTareas.contarTareas());
                    break;

                case 6:
                    Tarea tareaMasPrioritaria = (Tarea) gestorDeTareas.obtenerTareaMasPrioritaria();
                    if (tareaMasPrioritaria != null) {
                        System.out.println("\nTarea con mayor prioridad: " + tareaMasPrioritaria);
                    } else {
                        System.out.println("No hay tareas disponibles o el tipo no es correcto.");
                    }
                    break;

                case 7:
                    gestorDeTareas.invertirTareas();
                    System.out.println("\nLas tareas han sido invertidas.");
                    break;

                case 8:
                    System.out.print("\nIntroduce el ttulo de la tarea para transferir a completadas: ");
                    String tareaTransferir = scanner.nextLine();
                    Tarea tareaTransferida = null;
                    for (Tarea tarea : gestorDeTareas.getTareas()) {
                        if (tarea.getTitulo().equals(tareaTransferir)) {
                            tareaTransferida = tarea;
                            tareasCompletadas.add(tarea);
                            gestorDeTareas.eliminarTarea(tarea);
                            System.out.println("Tarea transferida a tareas completadas.");
                            break;
                        }
                    }
                    if (tareaTransferida == null) {
                        System.out.println("No se encontro la tarea para transferir.");
                    }
                    break;

                case 9:
                    System.out.println("\nTareas completadas:");
                    for (Tarea tarea : tareasCompletadas) {
                        System.out.println(tarea);
                    }
                    break;
                case 10:
                    System.out.print("\nIntroduce el titulo de la tarea a buscar: ");
                    String tituloBuscar = scanner.nextLine();
                    Tarea tareaBuscar = null;
                    for (Tarea tarea : gestorDeTareas.getTareas()) {
                        if (tarea.getTitulo().equals(tituloBuscar)) {
                            tareaBuscar = tarea;
                            break;
                        }
                    }
                    if (tareaBuscar != null && GestorDeTareas.buscarElemento(gestorDeTareas.getTareas(), tareaBuscar)) {
                        System.out.println("Tarea encontrada: " + tareaBuscar);
                    } else {
                        System.out.println("Tarea no encontrada.");
                    }
                    break;

                case 11:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opción no valida, intenta de nuevo.");
            }
        }
    }
}
