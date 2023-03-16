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
    Test cases:
    1 - Unique node
        1.1 - First node content is equal to first item
        1.2 - Node does not have previous or next nodes
        1.3 - First and last nodes are the same
    2 - Two nodes
        2.1 - Nodes contents are equal to their respective items
        2.2 - First node does not have previous node and last node does not have next node
        2.3 - First and last nodes are not the same
    3 - Three nodes
        3.1 - Nodes contents are equal to their respective items
        3.2 - First node does not have previous node, second node has both and last node does not
              have next node
        3.3 - First node is first, second node is not a terminal node and last node is last
 */

class DequeNodeTest {

    int item1;
    int item2;
    int item3;

    DequeNode<Integer> node1;
    DequeNode<Integer> node2;
    DequeNode<Integer> node3;

    @BeforeEach
    void setup() {
        item1 = 2;
        item2 = 3;
        item3 = 7;

        node1 = new DequeNode<>(null, null, null);
        node2 = new DequeNode<>(null, null, null);
        node3 = new DequeNode<>(null, null, null);
    }

    @Nested
    @DisplayName("Unique node DequeNode")
    class uniqueNode {
        @Test
        @DisplayName("where content is equal to expected item")
        void nodeContentIsEqualToItem() {
            node1.setItem(item1);
            assertEquals(item1, node1.getItem());
        }

        @Test
        @DisplayName("where does not have previous or next")
        void notPreviousNorNext() {
            assertNull(node1.getPrevious());
            assertNull(node1.getNext());
        }

        @Test
        @DisplayName("where first and last are the same node")
        void equalFirstAndLast() {
            assertTrue(node1.isFirstNode());
            assertTrue(node1.isLastNode());
        }
    }

    @Nested
    @DisplayName("Two nodes DequeNode")
    class twoNodes {
        @BeforeEach
        void setup() {
            node1.setNext(node2);
            node2.setPrevious(node1);
        }

        @Test
        @DisplayName("where contents are equal to expected items")
        void nodesContentAreEqualToItems() {
            node1.setItem(item1);
            node2.setItem(item2);

            assertEquals(item1, node1.getItem());
            assertEquals(item2, node2.getItem());
        }

        @Test
        @DisplayName("where first node has not previous and last one has not next")
        void notPreviousOnFirstNorNextOnLast() {
            assertNull(node1.getPrevious());
            assertNotNull(node1.getNext());
            assertNotNull(node2.getPrevious());
            assertNull(node2.getNext());
        }

        @Test
        @DisplayName("where first and last are not the same nodes")
        void equalFirstAndLast() {
            assertTrue(node1.isFirstNode());
            assertTrue(node2.isLastNode());
        }
    }

    @Nested
    @DisplayName("Three nodes DequeNode")
    class threeNodes {
        @BeforeEach
        void setup() {
            node1.setNext(node2);
            node2.setPrevious(node1);
            node2.setNext(node3);
            node3.setPrevious(node2);
        }

        @Test
        @DisplayName("where contents are equal to expected items")
        void nodesContentAreEqualToItems() {
            node1.setItem(item1);
            node2.setItem(item2);
            node3.setItem(item3);

            assertEquals(item1, node1.getItem());
            assertEquals(item2, node2.getItem());
            assertEquals(item3, node3.getItem());
        }

        @Test
        @DisplayName("where first node has not previous, second has both and last one has not next")
        void notPreviousOnFirstNorNextOnLast() {
            assertNull(node1.getPrevious());
            assertNotNull(node1.getNext());
            assertNotNull(node2.getPrevious());
            assertNotNull(node2.getNext());
            assertNotNull(node3.getPrevious());
            assertNull(node3.getNext());
        }

        @Test
        @DisplayName("where first node is first, second is not terminal and last node is last")
        void notEqualFirstAndLast() {
            assertTrue(node1.isFirstNode());
            assertFalse(node1.isNotATerminalNode());
            assertTrue(node2.isNotATerminalNode());
            assertTrue(node3.isLastNode());
            assertFalse(node3.isNotATerminalNode());
        }

    }
}