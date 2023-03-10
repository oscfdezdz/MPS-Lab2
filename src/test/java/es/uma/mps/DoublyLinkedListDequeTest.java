package es.uma.mps;

/*
 * @author David Castaños Benedicto
 * @author Óscar Fernández Díaz
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
*  Test 1: Check an Empty Doubly Linked List
*  Test 2: Check a Doubly Linked List with one node
*  Test 3: Check a Doubly Linked List with two nodes
*  Test 4: Check a Doubly Linked List with three nodes
*  Test 5: Check Prepend is working
*  Test 6: Check Append is working
*  Test 7: Check DeleteFirst is working
*  Test 8: Check DeleteLast is working
*
*  All Tests: Check First is working
*             Check Last is working
*             Check Size is working
*/

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
        @DisplayName("which is empty") // Test 1
        void emptyDoublyLinkedListDeque() {
            int expectedSize = 0;

            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteFirst);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteLast);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::first);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::last);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
        }
        @Test
        @DisplayName("which has one node") // Test 2
        void oneNodeDoublyLinkedListDeque() {
            DequeNode<Integer> node = new DequeNode<>(18, null, null);
            doublyLinkedListDeque.prepend(node);
            int expectedSize = 1;

            assertEquals(doublyLinkedListDeque.first(), node);
            assertEquals(doublyLinkedListDeque.last(), node);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
            }

        @Test
        @DisplayName("which has two nodes") // Test 3
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
        @DisplayName("which has three nodes") // Test 4
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
        @DisplayName("Prepend is Working") // Test 5
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
        @DisplayName("Apend is Working") // Test 6
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
        @DisplayName("DeleteFirst is Working") // Test 7
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
        @DisplayName("DeleteLast is Working") // Test 8
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