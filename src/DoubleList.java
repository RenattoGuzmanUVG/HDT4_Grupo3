/**Universidad del Valle de Guatemala
 * Facultad de Ingeniería
 * Departamento de Ciencia de la Computación.
 * Algoritmos y Estructuras de datos.
 * Sección: 20
 *
 * Hoja de Trabajo #4
 *
 * Entorno: El ejercicio tiene como objetivo, traducir del formato Infix to Postfix y devolver el resultado de la operación.
 * Clase: DoubleList
 * Proposito: Clase que utiliza estructura de lista doblemente encadenada, sera utilizada para crear la clase StackUsingDoubleList
 *
 * @version 1.0
 * @author Diego Alexander Hernández Silvestre
 * @author Renatto Esteban Guzman Sosa
 * @author Adrian Fulladolsa Palma
 * @author David Jonathan Aragon Vasquez
 */
public class DoubleList<T> implements IList<T> {

    private DoubleNode<T> start;
    private DoubleNode<T> end;
    private int count;

    /**
     * Constructor de la clase DoubleList.
     */
    public DoubleList() {
        start = null;
        end = null;
        count = 0;
    }

    /**
     * Metodo que cuenta el numero de nodos.
     * @return count
     */
    @Override
    public int count() {
        return count;
    }

    /**
     * Retorna si esta vacio
     * @return count
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * Inserta el valor al inicio
     * @param value Valor que el usuario desea insertar.
     */
    @Override
    public void InsertAtStart(T value) {

        DoubleNode<T> newNode = new DoubleNode<T>(value);

        if (isEmpty()) {

            start = newNode;
            end = newNode;
            start.setNext(start);
            start.setPrevious(start);
        } else {

            newNode.setNext(start);
            start.setPrevious(newNode);
            newNode.setPrevious(end);
            end.setNext(newNode);
            start = newNode;
        }

        count++;
    }

    /**
     * Inserta el valor al final
     * @param value Valor que se insertara al final.
     */
    @Override
    public void InsertAtEnd(T value) {
        DoubleNode<T> newNode = new DoubleNode<T>(value);

        if (isEmpty()) {
            start = newNode;
            end = newNode;
            start.setNext(start);
            start.setPrevious(start);
        } else {

            newNode.setPrevious(end);
            newNode.setNext(start);
            start.setPrevious(newNode);
            end.setNext(newNode);
            end = newNode;
        }

        count++;
    }

    /**
     * Inserta el valor en cierto indice
     * @param value Valor que se insertara.
     * @param index Indice en el que se insertara el valor.
     */
    @Override
    public void Insert(T value, int index) {
        if (isEmpty()) //if the list is empty then insert at start
        {
            InsertAtStart(value);
        } else {
            if (index >= count()) //if the index is equal or greater than count then insert at end
            {
                InsertAtEnd(value);
            } else if (index == 0) //If the index to insert is 0 and the list is not empty
            {
                InsertAtStart(value);
            } else if ((index > 0) && (index < count())) //Index between 1 (second element) and Count() - 1 previous the last one
            {
                DoubleNode<T> newNode = new DoubleNode<T>(value);
                DoubleNode<T> temp = start;
                int i = 0;

                //Search the position where the node will be inserted
                while ((temp != null) && (i < index)) {
                    temp = temp.getNext();
                    i++;
                }

                //doing the insertion
                newNode.setNext(temp);
                newNode.setPrevious(temp.getPrevious());
                temp.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                count++;
            }
        }
    }

    /**
     * Elimina el valor que se encuentre en cierto indice
     * @param index Indice en el que se eliminara el valor.
     * @return valor eliminado
     */
    @Override
    public T Delete(int index) {
        return null;
    }

    /**
     * Elimina el valor del inicio
     * @return valor eliminado
     */
    @Override
    public T DeleteAtStart() {
        if (!isEmpty()) {

            if (count() == 1) {
                DoubleNode<T> temp = start;
                start = null;
                end = null;
                count--;
                return temp.getValue();
            } else {
                DoubleNode<T> temp = start;
                end.setNext(temp.getNext());
                temp.getNext().setPrevious(end);
                start = temp.getNext();
                count--;
                return temp.getValue();
            }

        } else {
            return null;
        }
    }

    /**
     * Elimina el valor del final
     * @return valor eliminado
     */
    @Override
    public T DeleteAtEnd() {
        return null;
    }

    /**
     * Obtiene el valor que esté en cierto indice
     * @param index Número de indice del cual, se obtendra el valor.
     * @return valor obtenido
     */
    @Override
    public T Get(int index) {

        if (!isEmpty()) {
            if (index == 0) {
                return start.getValue();
            }
            else if (index == (count() - 1)) {
                return end.getValue();
            }
            else if ((index > 0) && (index < (count() - 1))) {
                DoubleNode<T> temp = start;
                int i = 0;
                while ((temp != null) && (i != index))
                {
                    temp = temp.getNext();
                    i++;
                }

                if (temp != null)
                {
                    return temp.getValue();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }
        return null;
    }
}