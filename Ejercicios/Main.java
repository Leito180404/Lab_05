package Ejercicios;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GestorDeTareas<Tarea> gestorDeTareas = new GestorDeTareas<>();
        Scanner scanner = new Scanner(System.in);
        List<Tarea> tareasCompletadas = new LinkedList<>();

        Tarea tarea1 = new Tarea("Estudiar Java", 2);
        Tarea tarea2 = new Tarea("Hacer ejercicio", 1);
        Tarea tarea3 = new Tarea("Leer un libro", 3);

        Node<Tarea> nodo1 = new Node<>(tarea1);
        Node<Tarea> nodo2 = new Node<>(tarea2);
        Node<Tarea> nodo3 = new Node<>(tarea3);

        nodo1.setNext(nodo2);
        nodo2.setNext(nodo3);

        gestorDeTareas.setTareas(nodo1);

        Tarea tarea2_1 = new Tarea("Estudiar Java", 2);
        Tarea tarea2_2 = new Tarea("Hacer ejercicio", 1);
        Tarea tarea2_3 = new Tarea("Leer un libro", 3);
    
        Node<Tarea> nodo2_1 = new Node<>(tarea2_1);
        Node<Tarea> nodo2_2 = new Node<>(tarea2_2);
        Node<Tarea> nodo2_3 = new Node<>(tarea2_3);
    
        nodo2_1.setNext(nodo2_2);
        nodo2_2.setNext(nodo2_3);


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
            System.out.println("10. Insertar nodo al final");
            System.out.println("11. Contar nodos en lista");
            System.out.println("12. Comparar dos listas");
            System.out.println("13. Concatenar dos listas");
            System.out.println("14. Salir");
            System.out.print("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("\nIntroduce el titulo de la tarea: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Introduce la prioridad de la tarea (numero): ");
                    int prioridad = scanner.nextInt();
                    scanner.nextLine();
                    Tarea nuevaTarea = new Tarea(titulo, prioridad);
                    Node<Tarea> nuevoNodo = new Node<>(nuevaTarea);
                    gestorDeTareas.agregarTarea(nuevoNodo); 
                    System.out.println("Tarea agregada con exito.");
                    break;

                case 2:
                    System.out.print("\nIntroduce el titulo de la tarea a eliminar: ");
                    String tareaEliminar = scanner.nextLine();
                    boolean tareaEliminada = gestorDeTareas.eliminarTarea(new Tarea(tareaEliminar, 0)); 
                    if (tareaEliminada) {
                        System.out.println("Tarea eliminada con exito.");
                    } else {
                        System.out.println("La tarea no se encontro.");
                    }
                    break;

                case 3:
                    System.out.println("\nTareas actuales:");
                    gestorDeTareas.imprimirTareas();
                    break;

                case 4:
                    System.out.print("\nIntroduce el titulo de la tarea para verificar si existe: ");
                    String tareaExistente = scanner.nextLine();
                    boolean existe = gestorDeTareas.contieneTarea(new Tarea(tareaExistente, 0));
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
                    gestorDeTareas.setTareas(GestorDeTareas.invertirLista(gestorDeTareas.getTareas()));
                    System.out.println("\nLas tareas han sido invertidas.");
                    break;

                case 8:
                    System.out.print("\nIntroduce el titulo de la tarea para transferir a completadas: ");
                    String tareaTransferir = scanner.nextLine();
                    Tarea tareaTransferida = new Tarea(tareaTransferir, 0);
                    if (gestorDeTareas.eliminarTarea(tareaTransferida)) {
                        tareasCompletadas.add(tareaTransferida);
                        System.out.println("Tarea transferida a tareas completadas.");
                    } else {
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
                    System.out.print("\nIntroduce el valor a insertar al final: ");
                    String valor = scanner.nextLine();
                    Node<Tarea> head = gestorDeTareas.getTareas(); 
                    Node<Tarea> listaConNodoAgregado = insertaralfinal.insertarAlFinal(head, new Tarea(valor, 1));
                    gestorDeTareas.setTareas(listaConNodoAgregado);
                    System.out.println("Nodo insertado al final con exito.");
                    break;

                case 11:
                    System.out.println("\nTotal de nodos en la lista: " + insertaralfinal.contNo(gestorDeTareas.getTareas()));
                    break;

                    case 12:
                    boolean sonIguales = insertaralfinal.ifsoniguales(nodo1, nodo2_1); 
                    if (sonIguales) {
                        System.out.println("\nLas listas son iguales.");
                    } else {
                        System.out.println("\nLas listas no son iguales.");
                    }
                    break;
    
                case 13: 
                    Node<Tarea> listaConcatenada = insertaralfinal.concatenarListas(nodo1, nodo2_1);
                    System.out.println("\nLista concatenada:");
                    Node<Tarea> temp = listaConcatenada;
                    while (temp != null) {
                        System.out.println(temp.getDato());
                        temp = temp.getNext();
                    }
                    break;
                case 14:
                    System.out.println("¡Hasta luego!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Opcion no valida, intenta de nuevo.");
            }
        }
    }
}


