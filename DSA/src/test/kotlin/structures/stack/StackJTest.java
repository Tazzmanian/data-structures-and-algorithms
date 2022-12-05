package structures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class StackJTest {
    @ParameterizedTest(name = "Creating stack with size {0}")
    @ValueSource(ints = {1, 3, 5, 15})
    public void testStackSizeCreation(int size) {
        Stack stack = new StackJ(size);
        assertEquals(size, stack.size());
        assertTrue(stack.isEmpty());
    }

    @ParameterizedTest(name = "Creating stack with negative size {0}")
    @ValueSource(ints = {-1, -3, -5, -15})
    public void testStackNegativeSize(int size) {
        assertThrows(NegativeArraySizeException.class, () -> {
            new StackJ(size);
        });
    }

    @Test
    public void testStackPushPeekAndPullPeek() {
        Stack stack = new StackJ(5);

        for (int i = 0; i < stack.size(); i++) {
            stack.push(i);
            assertEquals(i, stack.peek());
        }

        assertTrue(stack.isFull());
        assertFalse(stack.isEmpty());

        for (int i = 4; i >= 0; i--) {
            assertEquals(i, stack.peek());
            stack.pull();
        }

        assertFalse(stack.isFull());
        assertTrue(stack.isEmpty());
    }

    @Test
    public void testStackPushMore() {
        Stack stack = new StackJ(5);

        for (int i = 0; i < stack.size(); i++) {
            stack.push(i);
        }

        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> {
                    stack.push(1);
                });

        Assertions.assertEquals("Can not push more elements", thrown.getMessage());
    }

    @Test
    public void testPullMore() {
        Stack stack = new StackJ(5);
        RuntimeException thrown = Assertions
                .assertThrows(RuntimeException.class, () -> {
                    stack.pull();
                });

        Assertions.assertEquals("Can not get more elements", thrown.getMessage());
    }
}
