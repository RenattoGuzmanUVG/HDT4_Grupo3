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


public class SingleList<T> implements IList<T> {

    private int count;
    private Node<T> start;
    private Node<T> end;

    /**
     * Inserta el valor al inicio
     * @param value Valor que se insertara al inicio
     */
    @Override
    public void InsertAtStart(T value) {
        Node<T> newNode = new Node<T>(value);

        if (isEmpty())
        {
            start = newNode;
            end = newNode;
        }
        else
        {
            newNode.setNext(start);
            start = newNode;
        }
        count++;
    }

    /**
     * Inserta el valor al final
     * @param value Valor que se insertara al final
     */
    @Override
    public void InsertAtEnd(T value) {
        Node<T> newNode = new Node<T>(value);

        if (isEmpty())
        {
            start = newNode;
            end = newNode;
        }
        else {
            end.setNext(newNode);
            end = newNode;
        }

        count++;

    }

    /**
     * Inserta el valor en cierto indice
     * @param value Valor a insertar.
     * @param index Indice en el que se insertara el valor.
     */
    @Override
    public void Insert(T value, int index){

        if (isEmpty()) //if the list is empty then insert at start
        {
            InsertAtStart(value);
        }
        else
        {
            if (index >= count()) //if the index is equal or greater than count then insert at end
            {
                InsertAtEnd(value);
            }
            else if (index == 0) //If the index to insert is 0 and the list is not empty
            {
                InsertAtStart(value);
            }
            else if ((index > 0) && (index < count())) //Index between 1 (second element) and Count() - 1 previous the last one
            {
                Node<T> newNode = new Node<T>(value);
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();
                int i = 1;

                //Search the position where the node will be inserted
                while ((temp != null) && (i < index)) {
                    pretemp = temp;
                    temp = temp.getNext();
                    i++;
                }

                //doing the insertion
                newNode.setNext(temp);
                pretemp.setNext(newNode);
                count++;
            }
        }
    }

    /**
     * Elimina el valor que se encuentre en cierto indice
     * @param index Valor del indice a eliminar.
     * @return valor temporal o null
     */
    @Override
    public T Delete(int index) {

        if (index == 0)
        {
            return DeleteAtStart();
        }
        else if (index == (count() - 1))
        {
            return DeleteAtEnd();
        }
        else if ((index > 0) && (index < (count() - 1)))
        {
            Node<T> pretemp = start;
            Node<T> temp = start.getNext();
            int i = 1;

            //Search the position where the node will be inserted
            while ((temp != null) && (i < (count() - 1)))
            {
                pretemp = temp;
                temp = temp.getNext();
                i++;
            }

            //Delete the node
            pretemp.setNext(temp.getNext());
            count--;
            return temp.getValue();
        }
        else
        {
            return null;
        }
    }

    /**
     * Elimina el valor del inicio
     * @return null
     */
    @Override
    public T DeleteAtStart() {

        if (!isEmpty())
        {
            Node<T> temp = start;
            start = start.getNext();
            count--;
            return temp.getValue();
        }

        return null;
    }

    /**
     * Elimina el valor del final
     * @return null
     */
    @Override
    public T DeleteAtEnd() {
        if (!isEmpty())
        {

            if (count() == 1) //Only one node then delete
            {
                Node<T> temp = start;
                start = null;
                end = null;
                count--;
                return temp.getValue();
            }
            else
            {
                Node<T> pretemp = start;
                Node<T> temp = start.getNext();

                //Search the position where the node will be inserted
                while (temp != null)
                {
                    pretemp = temp;
                    temp = temp.getNext();
                }

                //Delete the node
                end = pretemp;
                end.setNext(null);
                count--;
                return temp.getValue();
            }

        }

        return null;
    }

    /**
     * Obtiene el valor que esté en cierto indice
     * @param index Número de indice del cual, se obtendra el valor.
     * @return valor a obtener.
     */
    @Override
    public T Get(int index) {

        if (!isEmpty())
        {
            if (index == 0)
            {
                return start.getValue();
            }
            else if (index == (count() - 1))
            {
                return end.getValue();
            }
            else if ((index > 0) && (index < (count() - 1)))
            {
                Node<T> temp = start;
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

    /**
     * Retorna si está vacío
     * @return count
     */
    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * @return count
     */
    @Override
    public int count() {
        // TODO Auto-generated method stub
        return count;
    }

}