package es.uma.mps;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<DequeNode<Integer>> doublyLinkedListDeque;
    @BeforeEach
    void setUp() {
        doublyLinkedListDeque = new DoublyLinkedListDeque<>();
    }
    @Nested
    @DisplayName("Valid Doubly Linked List Deque")
    class test {
        @Test
        @DisplayName("which is empty")
        void emptyDoublyLinkedListDeque() {
            int expectedSize = 0;

            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteFirst);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteLast);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::first);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::last);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
        }
        @Test
        @DisplayName("which has one node")
        void oneNodeDoublyLinkedListDeque() {
            DequeNode<Integer> node = new DequeNode<>(18, null, null);
            doublyLinkedListDeque.prepend(node);
            int expectedSize = 1;

            assertEquals(doublyLinkedListDeque.first(), node);
            assertEquals(doublyLinkedListDeque.last(), node);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
            }

        @Test
        @DisplayName("which has two nodes")
        void twoNodesDoublyLinkedListDeque(){
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            
            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.append(node2);
            int expectedSize = 2;

            assertEquals(doublyLinkedListDeque.first(), node1);
            assertEquals(doublyLinkedListDeque.last(), node2);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
        }

        @Test
        @DisplayName("which has three nodes")
        void threeNodesDoublyLinkedListDeque(){

            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            
            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.append(node2);
            doublyLinkedListDeque.append(node3);
            
            int expectedSize = 3;

            assertEquals(doublyLinkedListDeque.first(), node1);
            assertEquals(doublyLinkedListDeque.last(), node3);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
        }

        @Test
        @DisplayName("Prepend is Working")
        void CheckPrependWithValues(){
            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            doublyLinkedListDeque.prepend(node1);
            assertEquals(doublyLinkedListDeque.first(), node1);

            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            doublyLinkedListDeque.prepend(node2);
            assertEquals(doublyLinkedListDeque.first(), node2);

            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            doublyLinkedListDeque.prepend(node3);
            assertEquals(doublyLinkedListDeque.first(), node3);

        }

        @Test
        @DisplayName("Apend is Working")
        void CheckApendWithValues(){
            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            doublyLinkedListDeque.append(node1);
            assertEquals(doublyLinkedListDeque.last(), node1);

            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            doublyLinkedListDeque.append(node2);
            assertEquals(doublyLinkedListDeque.last(), node2);

            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            doublyLinkedListDeque.append(node3);
            assertEquals(doublyLinkedListDeque.last(), node3);

        }

        @Test
        @DisplayName("DeleteFirst is Working")
        void CheckDeleteFirstWithValues(){
            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            assertEquals(doublyLinkedListDeque.last(), node1);
            assertEquals(doublyLinkedListDeque.first(), node3);

            doublyLinkedListDeque.deleteFirst();

            assertEquals(doublyLinkedListDeque.first(), node2);
            assertEquals(doublyLinkedListDeque.size(), 2);

            doublyLinkedListDeque.deleteFirst();

            assertEquals(doublyLinkedListDeque.first(), node1);
            assertEquals(doublyLinkedListDeque.size(), 1);

            doublyLinkedListDeque.deleteFirst();

            assertEquals(doublyLinkedListDeque.size(), 0);
        }

        @Test
        @DisplayName("DeleteLast is Working")
        void CheckDeleteLastWithValues(){
            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            assertEquals(doublyLinkedListDeque.last(), node1);
            assertEquals(doublyLinkedListDeque.first(), node3);

            doublyLinkedListDeque.deleteLast();

            assertEquals(doublyLinkedListDeque.last(), node2);
            assertEquals(doublyLinkedListDeque.size(), 2);

            doublyLinkedListDeque.deleteLast();

            assertEquals(doublyLinkedListDeque.last(), node3);
            assertEquals(doublyLinkedListDeque.size(), 1);

            doublyLinkedListDeque.deleteLast();

            assertEquals(doublyLinkedListDeque.size(), 0);
        }

    }
}