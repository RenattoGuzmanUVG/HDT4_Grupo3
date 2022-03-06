public class StackUsingDoubleLinkedList<T> extends Stack<T> {

    private DoubleList<T> listaInterna;

    public StackUsingDoubleLinkedList() {
        listaInterna = new DoubleList<T>();
    }

    @Override
    public int count() {
        return listaInterna.count();
    }

    @Override
    public boolean isEmpty() {
        return listaInterna.isEmpty();
    }

    @Override
    public void push(T value) {
        listaInterna.InsertAtStart(value);
    }

    @Override
    public T pull() {
        return listaInterna.DeleteAtStart();
    }

    @Override
    public T peek() {
        return listaInterna.Get(0);
    }


}