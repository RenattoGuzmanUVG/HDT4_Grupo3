/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: StackVector
 * Proposito: Implementacion de vectores
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */

/**
 * Clase padre que crea los metodos para vector, Array, StackUsingDoubleLinkedList y StackUsingLinkedList
 * @param <T> indica que puede ser cualquier tipo de valor
 */
public abstract class Stack<T> extends Factory implements IStack<T>{
    /**
     * Constructor de la clase StackVector
     */
    @Override
    public int count() {
        return 0;
    }

    /**
     * Cuenta la cantidad de datos que tiene la pila en ese momento.
     * @return El número de elementos de la pila.
     */
    @Override
    public boolean isEmpty() {
        return false;
    }

    /**
     * Añade un valor a la pila en la primer posición.
     * @param value Valor a agregar.
     */
    @Override
    public void push(T value) {

    }

    /**
     * Elimina el elemento de la pila en la posición cero.
     * @return El elemento removido
     */
    @Override
    public T pull() {
        return null;
    }

    /**
     * Obtiene el valor del elemento de la posición cero de la pila
     * @return El elemento obtenido.
     */
    @Override
    public T peek() {
        return null;
    }



}
