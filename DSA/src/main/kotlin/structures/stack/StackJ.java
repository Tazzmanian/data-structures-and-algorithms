package structures.stack;

public class StackJ implements Stack {
    private int[] stack;
    private int position = -1;

    StackJ(int size) {
        stack = new int[size];
    }

    public void push(int i) {
        if (isFull()) {
            throw new RuntimeException("Can not push more elements");
        }
        position++;
        stack[position] = i;
    }

    public int pull() {
        if (isEmpty()) {
            throw new RuntimeException("Can not get more elements");
        }
        int tmp = stack[position];
        stack[position] = 0;
        position--;
        return tmp;
    }

    public int peek() {
        return stack[position];
    }

    @Override
    public boolean isFull() {
        return position == stack.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return position < 0;
    }

    @Override
    public int size() {
        return stack.length;
    }
}
