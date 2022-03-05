public class DoubleList<T> extends List<T> {

    private DoubleNode<T> start;
    private DoubleNode<T> end;
    private int count;


    public DoubleList() {
        start = null;
        end = null;
        count = 0;
    }

    @Override
    public int count() {
        return count;
    }

    @Override
    boolean isEmpty() {
        return count == 0;
    }

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

    @Override
    public T Delete(int index) {
        return null;
    }

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

    @Override
    public T DeleteAtEnd() {
        return null;
    }

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