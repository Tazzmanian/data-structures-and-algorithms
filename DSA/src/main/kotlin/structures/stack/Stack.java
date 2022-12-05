package structures.stack;

public interface Stack {
    void push(int i);
    int pull();
    int peek();
    boolean isFull();
    boolean isEmpty();
    int size();
}
