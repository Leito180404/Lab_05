import java.util.LinkedList;
import java.util.List;

public class GestorDeTareas<T> {
    private List<T> tareas;

    public GestorDeTareas() {
        tareas = new LinkedList<>(); 
    }

    public void agregarTarea(T tarea) {
        tareas.add(tarea);
    }

    public boolean eliminarTarea(T tarea) {
        return tareas.remove(tarea);  
    }

    public boolean contieneTarea(T tarea) {
        return tareas.contains(tarea);  
    }

    public void imprimirTareas() {
        for (T tarea : tareas) {
            System.out.println(tarea);
        }
    }

    public int contarTareas() {
        return tareas.size(); 
    }


    public T obtenerTareaMasPrioritaria() {
        if (tareas.isEmpty() || !(tareas.get(0) instanceof Tarea)) {
            return null; 
        }

        Tarea tareaMasPrioritaria = (Tarea) tareas.get(0);
        for (T tarea : tareas) {
            if (tarea instanceof Tarea) {
                Tarea tareaActual = (Tarea) tarea;
                if (tareaActual.getPrioridad() < tareaMasPrioritaria.getPrioridad()) {
                    tareaMasPrioritaria = tareaActual;
                }
            }
        }
        return (T) tareaMasPrioritaria;
    }

    public void invertirTareas() {
        List<T> listaInvertida = new LinkedList<>();
        for (int i = tareas.size() - 1; i >= 0; i--) {
            listaInvertida.add(tareas.get(i));
        }
        tareas = listaInvertida;
    }

    public List<T> getTareas() {
        return tareas;
    }
}

