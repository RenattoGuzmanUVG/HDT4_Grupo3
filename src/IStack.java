public interface IStack<T> {

    void push(T value);

    T pull();

    T peek();
}
