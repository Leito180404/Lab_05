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

        public static <T> int contNo(Node<T> head) {
            int contador = 0;
            Node<T> actual = head;
        
            while (actual != null) {
                contador++;
                actual = actual.getNext();
            }
        
            return contador;
        }//ejercicio 4

        public static <T> boolean ifsoniguales(Node<T> lista1, Node<T> lista2) {
            Node<T> temp1 = lista1;
            Node<T> temp2 = lista2;
        
            while (temp1 != null && temp2 != null) {
                if (!temp1.equals(temp2)) {
                    return false; 
                }
                temp1 = temp1.getNext();
                temp2 = temp2.getNext();
            }
            return temp1 == null && temp2 == null; }  // Ambos deben ser null al final
        //ejercicio 5
        
        public static <T> Node<T> concatenarListas(Node<T> lista1, Node<T> lista2) {
            Node<T> nuevaLista = null;
            Node<T> actual = null;
        
            // Agregar los elementos de lista1 a nuevaLista
            Node<T> temp = lista1;
            while (temp != null) {
                if (nuevaLista == null) {
                    nuevaLista = new Node<>(temp.getDato());
                    actual = nuevaLista;
                } else {
                    actual.setNext(new Node<>(temp.getDato()));
                    actual = actual.getNext();
                }
                temp = temp.getNext();
            }
        
            // Agregar los elementos de lista2 a nuevaLista
            temp = lista2;
            while (temp != null) {
                if (nuevaLista == null) {
                    nuevaLista = new Node<>(temp.getDato());
                    actual = nuevaLista;
                } else {
                    actual.setNext(new Node<>(temp.getDato()));
                    actual = actual.getNext();
                }
                temp = temp.getNext();
            }
        
            return nuevaLista;
        }        
}
