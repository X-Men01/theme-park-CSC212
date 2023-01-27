public class ArrayStack<T> {
    private int maxSize , top;
    private T[] nodes;

    public ArrayStack(int max) {
        maxSize = max;
        nodes = (T[]) new Object[max];
        top = -1;
    }
    public T pop() throws Exception {
        if (isEmpty())
            throw new Exception("Stack is empty");
        return nodes[--top];       
    }
    public void push(T e) throws Exception {
        if(isFull())
            throw new Exception("Stack is full");
        nodes[++top] = e; 
    }
    public boolean isEmpty(){
        return top == -1;
    }
    public boolean isFull(){
        return top == maxSize - 1;
    }

    
    
}
