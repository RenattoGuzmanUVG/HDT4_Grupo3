import java.util.ArrayList;

public class StackArrayList<T> implements IStack<T> {

    private ArrayList<T> miListaInterna;

    public StackArrayList() {
        miListaInterna = new ArrayList<T>();
    }

    @Override
    public int count() {
        return miListaInterna.size();
    }

    @Override
    public boolean isEmpty() {
        return miListaInterna.isEmpty();
    }

    @Override
    public void push(T value) {
        miListaInterna.add(0, value);
    }

    @Override
    public T pull() {
        return miListaInterna.remove(0);
    }

    @Override
    public T peek() {
        return miListaInterna.get(0);
    }

}
