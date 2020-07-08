/* Zhang Shirui LinkedListDeque */
public class LinkedListDeque<T> {
    private class Node {
        T item;
        Node next;
        Node prev;

        Node() {
            item = null;
            next = null;
            prev = null;
        }

        Node(T i, Node n, Node p) {
            item = i;
            next = n;
            prev = p;
        }
    }

    private int size;
    private Node sentinal;
    private Node curr;

    public LinkedListDeque() {
        size = 0;
        sentinal = new Node(null, null, null);
        sentinal.next = sentinal;
        sentinal.prev = sentinal;
        curr = sentinal;
    }

    public LinkedListDeque(T x) {
        sentinal = new Node();
        sentinal.next = new Node(x, sentinal, sentinal);
        sentinal.prev = sentinal.next;
        curr = sentinal;
        size = 1;
    }

    public void addFirst(T item) {
        Node p = new Node(item, sentinal.next, sentinal);
        sentinal.next.prev = p;
        sentinal.next = p;
        size += 1;
    }

    public void addLast(T item) {
        Node p = new Node(item, sentinal, sentinal.prev);
        sentinal.prev.next = p;
        sentinal.prev = p;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if (isEmpty()) {
            System.out.println("There is nothing in the Deque!");
            return;
        }
        Node p = sentinal;
        while (p.next != sentinal) {
            System.out.println(p.next.item);
            p = p.next;
        }
    }

    public T removeFirst() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinal.next;
        sentinal.next.next.prev = sentinal;
        sentinal.next = sentinal.next.next;
        size -= 1;
        return p.item;
    }

    public T removeLast() {
        if (isEmpty()) {
            return null;
        }
        Node p = sentinal.prev;
        sentinal.prev.prev.next = sentinal;
        sentinal.prev = sentinal.prev.prev;
        size -= 1;
        return p.item;
    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node p = sentinal;
        for (int i = 0; i < index; i++) {
            p = p.next;
        }
        return p.item;
    }

    public T getRecursive(int index) {
        if (index == 0) {
            return curr.next.item;
        }
        curr = curr.next;
        return getRecursive(index - 1);
    }
}
