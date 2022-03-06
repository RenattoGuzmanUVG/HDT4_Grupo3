import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackArrayListTest {

    @Test
    void push() {
        StackArrayList<Integer> Stack = new StackArrayList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }

    @Test
    void pull() {
        StackArrayList<Integer> Stack = new StackArrayList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);
        Stack.pull();

        assertEquals(5, Stack.peek());
    }

    @Test
    void peek() {
        StackArrayList<Integer> Stack = new StackArrayList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }


    @Test
    void count() {
        StackArrayList<Integer> Stack = new StackArrayList<>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(3, Stack.count());
    }

    @Test
    void isEmpty() {
        StackArrayList<Integer> Stack = new StackArrayList<>();
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