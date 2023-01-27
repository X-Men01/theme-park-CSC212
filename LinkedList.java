
public class LinkedList<T> {
    private Node<T> head, tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    public void insert(T data){
        Node<T> newNode = new Node<T>(data);
        if(isEmpty()){
            head = tail = newNode;
        }
        else{
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }
    public void print() {
        Node<T> temp = head;
        while(temp != null){
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }
    private boolean isEmpty(){
        return head == null;
    }
    public int getSize() {
        return size;
    }
}

class Node<T> {
    private T data;
    private Node<T> next;
    public Node (T data ){
       this.data = data;
       next = null; 
    }
    public Node (){
        data = null;
        next = null; 
     }
     public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node<T> getNext() {
        return next;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
}