package es.uma.mps;

/*
 * @author David Castaños Benedicto
 * @author Óscar Fernández Díaz
 */


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.Comparator;

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
*  Test 9: Check Get is working
*  Test 10: Check Contains is working
*  Test 11: Check Remove is working
*  Test 12: Check Sort is working
*
*  All Tests: Check First is working
*             Check Last is working
*             Check Size is working
*/

class DoublyLinkedListDequeTest {
    DoublyLinkedListDeque<DequeNode<Integer>> doublyLinkedListDeque;
    DoublyLinkedListDeque doublyLinkedListDequeMocked;
    @BeforeEach
    void setUp() {
        doublyLinkedListDeque = new DoublyLinkedListDeque<>();
        doublyLinkedListDequeMocked = Mockito.mock(DoublyLinkedListDeque.class);
    }
    @Nested
    @DisplayName("Valid Basics Operations in Doubly Linked List Deque")
    class BasicsOperations {
        @Test
        @DisplayName("which is empty")
            // Test 1
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
            // Test 2
        void oneNodeDoublyLinkedListDeque() {
            DequeNode<Integer> node = new DequeNode<>(18, null, null);
            doublyLinkedListDeque.prepend(node);
            int expectedSize = 1;

            assertEquals(node, doublyLinkedListDeque.last());
            assertEquals(node, doublyLinkedListDeque.last());
            assertEquals(expectedSize, doublyLinkedListDeque.size());
        }

        @Test
        @DisplayName("which has two nodes")
            // Test 3
        void twoNodesDoublyLinkedListDeque() {
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.append(node2);
            int expectedSize = 2;

            assertEquals(node1, doublyLinkedListDeque.last());
            assertEquals(node2, doublyLinkedListDeque.last());
            assertEquals(expectedSize, doublyLinkedListDeque.size());
        }

        @Test
        @DisplayName("which has three nodes")
            // Test 4
        void threeNodesDoublyLinkedListDeque() {

            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.append(node2);
            doublyLinkedListDeque.append(node3);

            int expectedSize = 3;

            assertEquals(node1, doublyLinkedListDeque.last());
            assertEquals(node3, doublyLinkedListDeque.last());
            assertEquals(expectedSize, doublyLinkedListDeque.size());
        }

        @Test
        @DisplayName("Prepend is Working")
            // Test 5
        void CheckPrependWithValues() {
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            doublyLinkedListDeque.prepend(node1);
            assertEquals(node1, doublyLinkedListDeque.last());

            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            doublyLinkedListDeque.prepend(node2);
            assertEquals(node2, doublyLinkedListDeque.last());

            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            doublyLinkedListDeque.prepend(node3);
            assertEquals(node3, doublyLinkedListDeque.last());

        }

        @Test
        @DisplayName("Apend is Working")
            // Test 6
        void CheckApendWithValues() {
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            doublyLinkedListDeque.append(node1);
            assertEquals(node1, doublyLinkedListDeque.last());

            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            doublyLinkedListDeque.append(node2);
            assertEquals(node2, doublyLinkedListDeque.last());

            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            doublyLinkedListDeque.append(node3);
            assertEquals(node3, doublyLinkedListDeque.last());

        }

        @Test
        @DisplayName("DeleteFirst is Working")
            // Test 7
        void CheckDeleteFirstWithValues() {
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            assertEquals(node1, doublyLinkedListDeque.last());
            assertEquals(node3, doublyLinkedListDeque.first());

            doublyLinkedListDeque.deleteFirst();

            assertEquals(node2, doublyLinkedListDeque.first());
            assertEquals(2, doublyLinkedListDeque.size());

            doublyLinkedListDeque.deleteFirst();

            assertEquals(node1, doublyLinkedListDeque.first());
            assertEquals(1, doublyLinkedListDeque.size());

            doublyLinkedListDeque.deleteFirst();

            assertEquals(0, doublyLinkedListDeque.size());
        }

        @Test
        @DisplayName("DeleteLast is Working")
            // Test 8
        void CheckDeleteLastWithValues() {
            DequeNode<Integer> node1 = new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            assertEquals(node1, doublyLinkedListDeque.last());
            assertEquals(node3, doublyLinkedListDeque.first());

            doublyLinkedListDeque.deleteLast();

            assertEquals(node2, doublyLinkedListDeque.last());
            assertEquals(2, doublyLinkedListDeque.size());

            doublyLinkedListDeque.deleteLast();

            assertEquals(node3, doublyLinkedListDeque.last());
            assertEquals(1, doublyLinkedListDeque.size());

            doublyLinkedListDeque.deleteLast();

            assertEquals(0, doublyLinkedListDeque.size());
        }
    }

    @Nested
    @DisplayName("Valid Advanced Operation in Doubly Linked List Deque")
    class AdvancedOperations {
        @Test
        @DisplayName("Get is Working") // Test 9
        void GetIsWorking(){

            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            assertEquals(22, doublyLinkedListDeque.get(0).getItem());
            assertEquals(20, doublyLinkedListDeque.get(1).getItem());
            assertEquals(18, doublyLinkedListDeque.get(2).getItem());

            Mockito.when(doublyLinkedListDequeMocked.get(2)).thenReturn(18);
            Object result = doublyLinkedListDequeMocked.get(2);
            assertEquals(18, result);

            assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedListDeque.get(3));
            assertThrows(IndexOutOfBoundsException.class, () -> doublyLinkedListDeque.get(-1));

        }

        @Test
        @DisplayName("Contains is working") // Test 10
        void ContainsIsWorking(){

            DequeNode<Integer> node1= new DequeNode<>(18, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(20, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(22, null, null);
            DequeNode<Integer> node4 = new DequeNode<>(22, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            doublyLinkedListDequeMocked.prepend(node1);

            Mockito.when(doublyLinkedListDequeMocked.contains(node1)).thenReturn(true);
            boolean result = doublyLinkedListDequeMocked.contains(node1);
            assertTrue(result);


            assertTrue(doublyLinkedListDeque.contains(node1));
            assertTrue(doublyLinkedListDeque.contains(node2));
            assertTrue(doublyLinkedListDeque.contains(node3));
            assertFalse(doublyLinkedListDeque.contains(node4));
        }

        @Test
        @DisplayName("remove is working") // Test 11
        void RemoveIsWorking(){

            DequeNode<Integer> node1= new DequeNode<>(1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(2, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(3, null, null);
            DequeNode<Integer> node4 = new DequeNode<>(4, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);

            doublyLinkedListDequeMocked.remove(node1);
            boolean result = doublyLinkedListDequeMocked.contains(node1);
            assertFalse(result);

            doublyLinkedListDeque.remove(node2);
            assertFalse(doublyLinkedListDeque.contains(node2));

            assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.remove(node4));
        }

        @Test
        @DisplayName("sort is working") // Test 12
        void SortIsWorking(){

            DequeNode<Integer> node = Mockito.mock (DequeNode.class);
            Mockito.when(node.getItem()).thenReturn(18);
            int result = node.getItem();
            assertEquals(18, result);

            DequeNode<Integer> node1 = new DequeNode<>(1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(3, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(2, null, null);

            doublyLinkedListDeque.prepend(node1);
            doublyLinkedListDeque.prepend(node2);
            doublyLinkedListDeque.prepend(node3);


            doublyLinkedListDeque.sort(Comparator.comparing(DequeNode::getItem));

            assertEquals(1, doublyLinkedListDeque.get(0).getItem());
            assertEquals(2,doublyLinkedListDeque.get(1).getItem());
            assertEquals(3, doublyLinkedListDeque.get(2).getItem());

            doublyLinkedListDeque.remove(node1);
            doublyLinkedListDeque.remove(node2);

            assertThrows(DoubleEndedQueueException.class, () -> doublyLinkedListDeque.sort(Comparator.comparing(DequeNode::getItem)));

        }
    }
}