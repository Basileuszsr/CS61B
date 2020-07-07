package es.datastructur.synthesizer;
import java.util.Iterator;

public class ArrayRingBuffer<T> implements BoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;
    private int fillCount;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        first = 0;
        last = 0;
        fillCount = 0;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        if (isFull()) {
            throw new RuntimeException("Overflow!");
        } else {
            rb[last] = x;
            last = (last + 1) % capacity();
            fillCount += 1;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    @Override
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Empty!");
        } else {
            T dequeueitem = rb[first];
            first = (first + 1) % capacity();
            fillCount -= 1;
            return dequeueitem;
        }
    }

    /**
     * Return oldest item, but don't remove it.
     */
    @Override
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Empty!");
        } else {
            return rb[first];
        }
    }

    @Override
    public int capacity() {
        return rb.length;
    }

    @Override
    public int fillCount() {
        return fillCount;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayRingBufferIterator();
    }

    private class ArrayRingBufferIterator implements Iterator<T> {
        int currPos;
        int count;

        ArrayRingBufferIterator() {
            currPos = first;
            count = 0;
        }

        @Override
        public boolean hasNext() {
            return count < fillCount();
        }

        @Override
        public T next() {
            T currItem = rb[currPos];
            currPos = (currPos + 1) % capacity();
            count += 1;
            return currItem;
        }
    }

    @Override
    public boolean equals(Object other) {
        // Compare to itself.
        if (other == this) {
            return true;
        }
        if (other == null) {
            return false;
        }
        if (other.getClass() != this.getClass()) {
            return false;
        }
        ArrayRingBuffer<T> o = (ArrayRingBuffer<T>) other;
        if (o.fillCount() != this.fillCount()) {
            return false;
        }
        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = o.iterator();
        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            if (thisIterator.next() != otherIterator.next()) {
                return false;
            }
        }
        return true;
    }

}
