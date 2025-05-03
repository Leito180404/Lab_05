package Ejercicios;

public class insertaralfinal {
        public static <T> Node<T> insertarAlFinal(Node<T> head, T valor) {
            Node<T> nuevoNodo = new Node<>(valor);
    
            if (head == null) {
                return nuevoNodo;
            }
    
            Node<T> actual = head;
            while (actual.getNext() != null) {
                actual = actual.getNext();
            }
    
            actual.setNext(nuevoNodo);
            return head;
        } //ejercicio3

        public static <T> int contarNodos(Node<T> head) {
            int contador = 0;
            Node<T> actual = head;
        
            while (actual != null) {
                contador++;
                actual = actual.getNext();
            }
        
            return contador;
        }//ejercicio 4
        
}
