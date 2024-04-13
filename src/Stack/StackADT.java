package Stack;

public interface StackADT<T> {
    void push(T data);

    T pop();

    T top();

    int size();

    boolean isEmpty();
}
