import java.util.ArrayList;
import java.util.*;

public class StackVector<T> extends Stack<T>{
    private Vector miVector;


    public StackVector() {
        miVector = new Vector<T>();
    }

    /**
     * Añade un valor a la pila en la primer posición.
     * @param value Valor a agregar.
     */
    @Override
    public void push(T value) {
        miVector.add(0, value);
    }

    /**
     * Elimina el elemento de la pila en la posición cero.
     * @return El elemento removido
     */
    @Override
    public T pull() {
        return (T) miVector.remove(0);
    }

    /**
     * Obtiene el valor del elemento de la posición cero de la pila
     * @return El elemento obtenido.
     */
    @Override
    public T peek() {
        return (T) miVector.get(0);
    }

    /**
     * Cuenta la cantidad de datos que tiene la pila en ese momento.
     * @return El número de elementos de la pila.
     */
    @Override
    public int count() {
        return miVector.size();
    }

    /**
     * Verifica si la pila se encuentra vacia.
     * @return True = Vacia, False = Contiene elementos.
     */
    @Override
    public boolean isEmpty() {
        return miVector.isEmpty();
    }

}

