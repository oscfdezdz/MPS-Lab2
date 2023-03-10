package es.uma.mps;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoublyLinkedListDequeTest {
    @Nested
    @DisplayName("Valid Doubly Linked List Deque")
    class test {
        @Test
        @DisplayName("which is empty")
        void emptyDoublyLinkedListDeque() {
            DoublyLinkedListDeque<Integer> doublyLinkedListDeque = new DoublyLinkedListDeque<>();
            int expectedSize = 0;

            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteFirst);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::deleteLast);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::first);
            assertThrows(DoubleEndedQueueException.class, doublyLinkedListDeque::last);
            assertEquals(doublyLinkedListDeque.size(), expectedSize);
        }
    }
}