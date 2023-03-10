package es.uma.mps;

/*
 * @author David Castaños Benedicto
 * @author Óscar Fernández Díaz
 */

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public void prepend(T value) {
        DequeNode<T> node = new DequeNode<>(value, null, first);

        if (size == 0) {
            last = node;
        } else {
            first.setPrevious(node);
        }

        first = node;
        size++;
    }

    @Override
    public void append(T value) {
        DequeNode<T> node = new DequeNode<>(value, last, null);

        if (size == 0) {
            first = node;
        } else {
            last.setNext(node);
        }

        last = node;
        size++;
    }

    @Override
    public void deleteFirst() {
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }

        if (size == 1) {
            first = null;
            last = null;
        } else {
            first = first.getNext();
            first.setPrevious(null);
        }

        size--;
    }

    @Override
    public void deleteLast() {
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }

        if (size == 1) {
            first = null;
            last = null;
        } else {
            last = last.getPrevious();
            last.setNext(null);
        }

        size--;
    }

    @Override
    public T first() {
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }

        return first.getItem();
    }

    @Override
    public T last() {
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }

        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }
}
