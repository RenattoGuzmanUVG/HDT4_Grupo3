import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingDoubleLinkedListTest {

    @Test
    void push() {
        StackUsingDoubleLinkedList<Integer> Stack = new StackUsingDoubleLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }

    @Test
    void pull() {
        StackUsingDoubleLinkedList<Integer> Stack = new StackUsingDoubleLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);
        Stack.pull();

        assertEquals(5, Stack.peek());
    }

    @Test
    void peek() {
        StackUsingDoubleLinkedList<Integer> Stack = new StackUsingDoubleLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }


    @Test
    void count() {
        StackUsingDoubleLinkedList<Integer> Stack = new StackUsingDoubleLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(3, Stack.count());
    }

    @Test
    void isEmpty() {
        StackUsingDoubleLinkedList<Integer> Stack = new StackUsingDoubleLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(false, Stack.isEmpty());

        Stack.pull();
        Stack.pull();
        Stack.pull();

        assertEquals(true, Stack.isEmpty());
    }
}