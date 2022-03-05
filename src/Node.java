public class Node<T> {

    private T value;
    private Node<T> next;

    public Node(T value) {
        this.setValue(value);
    }
    /**
     * @return el valor
     */
    public T getValue() {
        return value;
    }
    /**
     * @param value el valor del set
     */
    public void setValue(T value) {
        this.value = value;
    }
    /**
     * @return el siguiente
     */
    public Node<T> getNext() {
        return next;
    }
    /**
     * @param next el siguiente al set
     */
    public void setNext(Node<T> next) {
        this.next = next;
    }

}
