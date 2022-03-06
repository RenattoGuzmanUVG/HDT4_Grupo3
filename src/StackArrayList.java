import java.util.ArrayList;
/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: StackArrayList
 * Proposito: Proporcionar los métodos utilizados para que el stack pueda realizar las operaciones requeridas por el método EvaluatePostFix.
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class StackArrayList<T> extends Stack<T> {

    private ArrayList<T> miListaInterna;

    public StackArrayList() {
        miListaInterna = new ArrayList<T>();
    }

    /**
     * Añade un valor a la pila en la primer posición.
     * @param value Valor a agregar.
     */
    @Override
    public void push(T value) {
        miListaInterna.add(0, value);
    }

    /**
     * Elimina el elemento de la pila en la posición cero.
     * @return El elemento removido
     */
    @Override
    public T pull() {
        return miListaInterna.remove(0);
    }

    /**
     * Obtiene el valor del elemento de la posición cero de la pila
     * @return El elemento obtenido.
     */
    @Override
    public T peek() {
        return miListaInterna.get(0);
    }



    /**
     * Cuenta la cantidad de datos que tiene la pila en ese momento.
     * @return El número de elementos de la pila.
     */
    @Override
    public int count() {
        return miListaInterna.size();
    }

    /**
     * Verifica si la pila se encuentra vacia.
     * @return True = Vacia, False = Contiene elementos.
     */
    @Override
    public boolean isEmpty() {
        return miListaInterna.isEmpty();
    }

}
