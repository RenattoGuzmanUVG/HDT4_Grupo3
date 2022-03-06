import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackUsingLinkedListTest {

    @Test
    void push() {
        StackUsingLinkedList<Integer> Stack = new StackUsingLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }

    @Test
    void pull() {
        StackUsingLinkedList<Integer> Stack = new StackUsingLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);
        Stack.pull();

        assertEquals(5, Stack.peek());
    }

    @Test
    void peek() {
        StackUsingLinkedList<Integer> Stack = new StackUsingLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }


    @Test
    void count() {
        StackUsingLinkedList<Integer> Stack = new StackUsingLinkedList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(3, Stack.count());
    }

    @Test
    void isEmpty() {
        StackUsingLinkedList<Integer> Stack = new StackUsingLinkedList<>();
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