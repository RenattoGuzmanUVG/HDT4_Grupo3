/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Interface: IList
 * Proposito: implementa Stack en SingleList
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */

/**
 * interface que implementa SingleList y DoubleList
 * @param <T> indica que puede ser cualquier tipo de valor
 */
public interface IList<T> {

    /**
     * Cuenta la cantidad de datos que tiene la pila en ese momento.
     * @return El número de elementos de la pila.
     */
    int count();

    /**
     * Verifica si la pila se encuentra vacia.
     * @return True = Vacia, False = Contiene elementos.
     */
    boolean isEmpty();

    /**
     * Inserta el valor al inicio
     * @param value
     */
    void InsertAtStart(T value);

    /**
     * Inserta el valor al final
     * @param value
     */
    void InsertAtEnd(T value);

    /**
     * Inserta el valor en cierto indice
     * @param value
     * @param index
     */
    void Insert(T value, int index);

    /**
     * Elimina el valor que se encuentre en cierto indice
     * @param index
     * @return null
     */
    T Delete(int index);

    /**
     * Elimina el valor del inicio
     * @return null
     */
    T DeleteAtStart();

    /**
     * Elimina el valor del final
     * @return null
     */
    T DeleteAtEnd();

    /**
     * Obtiene el valor que esté en cierto indice
     * @param index
     * @return null
     */
    T Get(int index);

}
