public class Node<T> {

    private T data;
    Node<T> nextNode;


    public Node(T data) {
        this.data = data;
        nextNode = null;
    }


    public Node(T data, Node<T> next) {
        this.data = data;
        this.nextNode = next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public T getData() {
        return this.data;
    }

    public Node<T> getNext() {
        return nextNode;
    }

    public void setNext(Node<T> next) {
        this.nextNode = next;
    }
}