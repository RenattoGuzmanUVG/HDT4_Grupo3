import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcIInPostFixTest {

    @Test
    void evaluatePostFixStack() {
        Factory f = new StackArrayList();
        CalcIInPostFix c = new CalcIInPostFix();
        int resultado= c.EvaluatePostFixStack("(3-1)*9", (Stack) f);

        assertEquals(18, resultado);
    }

    @Test
    void prec() {
        Character character = '*';
        CalcIInPostFix c = new CalcIInPostFix();
        int resultado= c.Prec(character);
        assertEquals(2, resultado);

    }

    @Test
    void infixToPostfixStack() {
        Factory f = new StackArrayList();
        CalcIInPostFix c = new CalcIInPostFix();
        String resultado= c.infixToPostfixStack("(3-1)*9", (Stack) f);

        assertEquals("3 1 - 9 * ", resultado);
    }
}