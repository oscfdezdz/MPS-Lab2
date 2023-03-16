package es.uma.mps;

import java.util.Comparator;

/**
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
        DequeNode<T> aux = first;
        if (size == 0 || index < 0 || index >= size){
            throw new DoubleEndedQueueException("Empty deque");
        }

        for (int i = 0; i < index; i++) {
             aux = aux.getNext();
        }
        return aux.getItem();
    }

    @Override
    public boolean contains(T value) {
        DequeNode<T> aux = first;
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }
        for (int i = 0; i < size; i++) {
            if(value == aux.getItem()){
                return true;
            }else{
                aux = aux.getNext();
            }
        }
        return false;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> aux = first;
        if (size == 0) {
            throw new DoubleEndedQueueException("Empty deque");
        }
        if(value == aux.getItem()){
            aux = first.getNext();
            aux.setPrevious(null);
        } else if (value == last.getItem()){
            aux = last.getPrevious();
            aux.setNext(null);
        } else {
            for (int i = 0; i < size; i++) {
                if (value == aux.getItem()) {
                    aux.getPrevious().setNext(aux.getNext());
                    aux.getNext().setPrevious(aux.getPrevious());
                } else {
                    aux = aux.getNext();
                }
            }
        }
    }


    @Override
    public void sort(Comparator<? super T> comparator) {

    }
}
