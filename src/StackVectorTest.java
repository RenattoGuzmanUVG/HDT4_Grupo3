import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class StackVectorTest {



    @Test
    void push() {

        StackVector<Integer> Stack = new StackVector<Integer>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());

    }

    @Test
    void pull() {
        StackVector<Integer> Stack = new StackVector<Integer>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);
        Stack.pull();

        assertEquals(5, Stack.peek());
    }

    @Test
    void peek() {
        StackVector<Integer> Stack = new StackVector<Integer>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(6, Stack.peek());
    }

    @Test
    void count() {
        StackVector<Integer> Stack = new StackVector<Integer>();
        Stack.push(4);
        Stack.push(5);
        Stack.push(6);

        assertEquals(3, Stack.count());
    }

    @Test
    void isEmpty() {
        StackVector<Integer> Stack = new StackVector<Integer>();
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