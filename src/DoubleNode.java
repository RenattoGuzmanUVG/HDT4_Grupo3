/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 *
 * Clase: DoubleNode
 * Proposito: Clase encargada de generar los nodos para que se desarrolle un encadenamiento doble.
 *
 * @version 1.0
 * @author Diego Alexander Hernandez Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class DoubleNode<T> {

    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    /**
     * Constructor de la clase.
     * @param value Valor a ingresar.
     */
    public DoubleNode(T value) {
        this.setValue(value);
    }

    /**
     * Obtiene el valor solicitado.
     * @return el valor
     */
    public T getValue() {
        return value;
    }
    /**
     * @param value el valor al set
     */
    public void setValue(T value) {
        this.value = value;
    }
    /**
     * @return el siguiente
     */
    public DoubleNode<T> getNext() {
        return next;
    }
    /**
     * @param next el siguiente al set
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
    /**
     * @return el anterior
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }
    /**
     * @param previous el anterior al set
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
