package Ejercicios;

public class GestorDeTareas<T> {
    private Node<T> tareas;

    public GestorDeTareas() {
        tareas = null;
    }

    public void agregarTarea(T tarea) {
        Node<T> nuevoNodo = new Node<>(tarea);
        if (tareas == null) {
            tareas = nuevoNodo;
        } else {
            Node<T> temp = tareas;
            while (temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(nuevoNodo);
        }
    }

    public Node<T> getTareas() {
        return tareas;
    }

    public boolean eliminarTarea(T tarea) {
        if (tareas == null) return false;
        
        if (tareas.getDato().equals(tarea)) {
            tareas = tareas.getNext();
            return true;
        }

        Node<T> temp = tareas;
        while (temp.getNext() != null) {
            if (temp.getNext().getDato().equals(tarea)) {
                temp.setNext(temp.getNext().getNext());
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public boolean contieneTarea(T tarea) {
        Node<T> temp = tareas;
        while (temp != null) {
            if (temp.getDato().equals(tarea)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }

    public void imprimirTareas() {
        Node<T> temp = tareas;
        while (temp != null) {
            System.out.println(temp.getDato());
            temp = temp.getNext();
        }
    }

    public int contarTareas() {
        int count = 0;
        Node<T> temp = tareas;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public T obtenerTareaMasPrioritaria() {
        if (tareas == null || !(tareas.getDato() instanceof Tarea)) {
            return null;
        }

        Tarea tareaMasPrioritaria = (Tarea) tareas.getDato();
        Node<T> temp = tareas;
        while (temp != null) {
            if (temp.getDato() instanceof Tarea) {
                Tarea tareaActual = (Tarea) temp.getDato();
                if (tareaActual.getPrioridad() < tareaMasPrioritaria.getPrioridad()) {
                    tareaMasPrioritaria = tareaActual;
                }
            }
            temp = temp.getNext();
        }
        return (T) tareaMasPrioritaria;
    }

    // Metodo para invertir lista de nodos
    public static <T> Node<T> invertirLista(Node<T> head) {
        Node<T> prev = null;
        Node<T> current = head;
        Node<T> next = null;
        
        while (current != null) {
            next = current.getNext();
            current.setNext(prev);
            prev = current;
            current = next;
        }
        
        return prev;
    }//ejercicio2

    public static <T> boolean buscarElemento(Node<T> head, T elemento) {
        Node<T> temp = head;
        while (temp != null) {
            if (temp.getDato().equals(elemento)) {
                return true;
            }
            temp = temp.getNext();
        }
        return false;
    }
}//ejercicio 1

