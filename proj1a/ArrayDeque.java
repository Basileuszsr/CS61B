public class ArrayDeque<T> {
    T[] items;
    int size;
    int
    public ArrayDeque() {
        items = (T[]) new Object[100];
        size  = 0;
    }
    public void addFirst(T item);
    public void addLast(T item);
    public boolean isEmpty();
    
    public int size() {
        return size;
    }

    public void printDeque();
    public T removeFirst();
    public T removeLast();
    public T get(int index);
}
