public class ArrayStack<T> {

    private int maxSize, top, size;

    private T[] nodes;

    public ArrayStack(int max) {
        maxSize = max;
        nodes = (T[]) new Object[max];
        top = -1;
        size = 0;
    }

    public T pop() {
        if (!isEmpty()) {
            size--;
            return nodes[--top];
        }

        return null;
    }

    public T peek() {
        if (!isEmpty())
            return nodes[top];
        return null;
    }

    public boolean sameOrder(ArrayStack<T> arr) {
        if (this.getSize() != arr.getSize())
            return false;
        for (int i = 0; i < size; i++) {
            int kingdom1 = (int) nodes[i];
            int kingdom2 = (int) arr.get(i);
            if (kingdom1 != kingdom2)
                return false;
        }

        return true;
    }

    public void push(T e) {
        if (!isFull()) {
            size++;
            nodes[++top] = e;
        }

    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < size; i++)
            if (i == size - 1)
                str.append(nodes[i]);
            else
                str.append(nodes[i] + ",");
        return str.toString();
    }

    public T get(int indxt) {
        if (indxt < 0 || indxt > size)
            return null;
        return nodes[indxt];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public int getSize() {
        return size;
    }

}
