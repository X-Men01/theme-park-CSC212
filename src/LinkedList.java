package src;
import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private Node<T> head, tail;
    private int size;

    public LinkedList() {
        head = tail = null;
    }

    public void insert(T data) {
        Node<T> newNode = new Node<T>(data);
        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = tail.getNext();
        }
        size++;
    }

    public void print() {
        Node<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    private boolean isEmpty() {
        return head == null;
    }

    public int getSize() {
        return size;
    }

    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (hasNext()) {
                    T data = current.data;
                    current = current.next;
                    return data;
                }
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("Remove not implemented.");
            }

        };
    }

    class Node<T> {
        private T data;
        private Node<T> next;

        public Node(T data) {
            this.data = data;
            next = null;
        }

        public Node() {
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
}