package es.uma.mps;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedListDeque<Integer> doublyLinkedListDeque = new DoublyLinkedListDeque<>();
        doublyLinkedListDeque.append(3);
        doublyLinkedListDeque.prepend(4);
        doublyLinkedListDeque.prepend(10);
        System.out.println("First: " + doublyLinkedListDeque.first() + ", last: " + doublyLinkedListDeque.last() + " and size: " + doublyLinkedListDeque.size());
        doublyLinkedListDeque.deleteFirst();
        System.out.println(doublyLinkedListDeque);
        doublyLinkedListDeque.deleteLast();
        System.out.println(doublyLinkedListDeque);
    }
}
