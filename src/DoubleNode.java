public class DoubleNode<T> {

    private T value;
    private DoubleNode<T> next;
    private DoubleNode<T> previous;

    public DoubleNode(T value) {
        this.setValue(value);
    }

    /**
     * @return el valor
     */
    public T getValue() {
        return value;
    }
    /**
     * @param value el valor al set
     */
    public void setValue(T value) {
        this.value = value;
    }
    /**
     * @return el siguiente
     */
    public DoubleNode<T> getNext() {
        return next;
    }
    /**
     * @param next el siguiente al set
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
    /**
     * @return el anterior
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }
    /**
     * @param previous el anterior al set
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
}
