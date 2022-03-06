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
 * Intefaz: IStack
 * Proposito: Clase encargada de implementar los métodos de Stack.
 *
 * @version 1.0
 * @author Diego Alexander Hernandez Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public interface IStack<T> {

    /**
     * Añade un valor a la pila en la primera posición.
     * @param value Valor a anadir.
     */
    void push(T value);

    /**
     * Elimina el elemento de la pila en la posición cero.
     */
    T pull();

    /**
     * Obtiene el valor del elemento de la posición cero de la pila
     */
    T peek();


}
