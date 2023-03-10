package es.uma.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
    Test cases:
    1 - Unique node: previous and next nodes are null
    2 - Two nodes: first node has next but not previous and second node has previous but not next
    3 - Three nodes: second node has previous and next, first has previous and third has next
 */

class DequeNodeTest {

    @Nested
    @DisplayName("Valid DequeNode")
    class nodes {
        @Test
        @DisplayName("which has an unique node")
        void uniqueNode() {
            int item = 4;
            DequeNode<Integer> node = new DequeNode<>(item, null, null);

            assertEquals(item, node.getItem());
            assertNull(node.getPrevious());
            assertNull(node.getNext());
        }

        @Test
        @DisplayName("which has two nodes")
        void twoNodes() {
            int item1 = 1;
            int item2 = 5;
            DequeNode<Integer> node1 = new DequeNode<>(item1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(item2, null, null);

            node1.setNext(node2);
            node2.setPrevious(node1);

            assertNull(node1.getPrevious());
            assertNotNull(node1.getNext());
            assertNotNull(node2.getPrevious());
            assertNull(node2.getNext());
        }

        @Test
        @DisplayName("which has three nodes")
        void threeNodes() {
            int item1 = 2;
            int item2 = 3;
            int item3 = 7;
            DequeNode<Integer> node1 = new DequeNode<>(item1, null, null);
            DequeNode<Integer> node2 = new DequeNode<>(item2, null, null);
            DequeNode<Integer> node3 = new DequeNode<>(item3, null, null);

            node1.setNext(node2);
            node2.setPrevious(node1);
            node2.setNext(node3);
            node3.setPrevious(node2);

            assertNull(node1.getPrevious());
            assertNotNull(node1.getNext());
            assertNotNull(node2.getPrevious());
            assertNotNull(node2.getNext());
            assertNotNull(node3.getPrevious());
            assertNull(node3.getNext());
        }
    }
}