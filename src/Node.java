/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: Node
 * Proposito: Almacenar valor de un elemento de una lista simplemente encadenada
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class Node<T> {

    private T value;
    private Node<T> next;

    /**
     * @param value valor del elemento que sera guardado en este nodo
     */
    public Node(T value) {
        this.setValue(value);
    }
    /**
     * @return el valor
     */
    public T getValue() {
        return value;
    }
    /**
     * @param value el valor del set
     */
    public void setValue(T value) {
        this.value = value;
    }
    /**
     * @return el siguiente
     */
    public Node<T> getNext() {
        return next;
    }
    /**
     * @param next el siguiente al set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

}
