package es.uma.mps;

import java.util.Comparator;

/**
 * @author David Castaños Benedicto
 * @author Óscar Fernández Díaz
 */

import java.util.Comparator;

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
            node.setPrevious(last);
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

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        DequeNode<T> node = first;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node.getItem();
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> node = first;
        boolean found = false;

        while (node != null && !found) {
            if (node.getItem().equals(value)) {
                found = true;
            }
            node = node.getNext();
        }

        return found;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> node = first;
        if (contains(value)) {
            while (node != null) {
                if (node.getItem().equals(value)) {
                    if (node.isFirstNode()) {
                        deleteFirst();
                    } else if (node.isLastNode()) {
                        deleteLast();
                    } else {
                        node.getPrevious().setNext(node.getNext());
                        node.getNext().setPrevious(node.getPrevious());
                        size--;
                    }
                }
                node = node.getNext();
            }
        } else {
            throw new DoubleEndedQueueException("Value not found");
        }
    }

    @Override
    public void sort(Comparator<? super T> comparator) {
        if (size > 1) {
            DequeNode<T> current = first.getNext();

            while (current != null) {
                T item = current.getItem();
                DequeNode<T> node = current.getPrevious();

                while (node != null && comparator.compare(node.getItem(), item) > 0) {
                    node.getNext().setItem(node.getItem());
                    node = node.getPrevious();
                }

                if (node == null) {
                    first.setItem(item);
                } else {
                    node.getNext().setItem(item);
                }

                current = current.getNext();
            }
        }else{
            throw new DoubleEndedQueueException("Invalid deque");
        }
    }
}
