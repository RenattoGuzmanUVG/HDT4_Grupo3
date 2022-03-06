/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: StackUsingDoubleLinkedList
 * Proposito: implementa Stack en DoubleList
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */

/**
 * Clase que implementa Stack en DoubleList
 * @param <T> indica que puede ser cualquier tipo de valor
 */
public class StackUsingDoubleLinkedList<T> extends Stack<T> {

    private DoubleList<T> listaInterna;

    /**
     * Constructor que instancia DoubleList
     */
    public StackUsingDoubleLinkedList() {
        listaInterna = new DoubleList<T>();
    }

    /**
     * Cuenta la cantidad de datos que tiene la pila en ese momento.
     * @return El número de elementos de la pila.
     */
    @Override
    public int count() {
        return listaInterna.count();
    }

    /**
     * Verifica si la pila se encuentra vacia.
     * @return True = Vacia, False = Contiene elementos.
     */
    @Override
    public boolean isEmpty() {
        return listaInterna.isEmpty();
    }

    /**
     * Añade un valor a la pila en la primer posición.
     * @param value Valor a agregar.
     */
    @Override
    public void push(T value) {
        listaInterna.InsertAtStart(value);
    }

    /**
     * Elimina el elemento de la pila en la posición cero.
     * @return El elemento removido
     */
    @Override
    public T pull() {
        return listaInterna.DeleteAtStart();
    }

    /**
     * Obtiene el valor del elemento de la posición cero de la pila
     * @return El elemento obtenido.
     */
    @Override
    public T peek() {
        return listaInterna.Get(0);
    }


}