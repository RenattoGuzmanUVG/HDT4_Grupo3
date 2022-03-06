public class StackUsingLinkedList<T> extends Stack<T> {

    private SingleList<T> listaInterna;

    public StackUsingLinkedList()
    {
        listaInterna = new SingleList<T>();
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
        return listaInterna.Delete(0);
    }

    @Override
    public T peek() {
        return listaInterna.Get(0);
    }

}
