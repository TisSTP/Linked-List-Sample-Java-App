public class List<T> {

    private Node<T> firstNode;
    private Node<T> lastNode;
    private String name;

    public List() {
        this.name = "List";
        this.firstNode = this.lastNode = null;
    }

    public List(String listName) {
        this.name = listName;
        this.firstNode = this.lastNode = null;
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    public void insertAtFront(T insertItem) {
        if (this.isEmpty())
        {
            this.firstNode = this.lastNode = new Node<T>(insertItem);
        }
        else
        {
            this.firstNode = new Node<T>(insertItem, this.firstNode);
        }
    }

    public void insertAtBack(T insertItem) {
        if (this.isEmpty()) {
            this.firstNode = this.lastNode = new Node<T>(insertItem);
        } else {
            this.lastNode.nextNode = new Node<T>(insertItem);
            this.lastNode = this.lastNode.nextNode;
        }
    }

    public String Print() {
        String str = null;
        if (this.isEmpty()) {
            str = "Empty: " + name;
            return str;
        } else {
            str = "The " + name + " is : \n\n";
        }

        Node<T> current = this.firstNode;

        while (current != null) {
            str = str + current.getData() + "\n";
            current = current.getNext();
        }

        str = str + "\n";
        str = str + "End: " + name + "\n";
        return str;
    }

    public void removeAll() {
        this.firstNode = this.lastNode = null;
    }

    public T removeFromFront() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException(name);
        }

        T removedItem = this.firstNode.getData();

        if (this.firstNode == this.lastNode) {
            this.firstNode = this.lastNode = null;
        } else {
            this.firstNode = this.firstNode.getNext();
        }

        return removedItem;
    }


    public T removeFromBack() throws EmptyListException {
        if (this.isEmpty()) {
            throw new EmptyListException(this.name);
        }

        T removeItem = this.lastNode.getData();

        if (this.firstNode == this.lastNode) {
            this.firstNode = this.lastNode = null;
        } else {
            Node<T> current = this.firstNode;
            while (current.getNext() != this.lastNode) {
                current = current.getNext();
            }
            this.lastNode = current;
            this.lastNode.setNext(null);
        }

        return removeItem;
    }
}
