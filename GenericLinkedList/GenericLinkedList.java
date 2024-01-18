/**
 * @garrettspillman1
 * A generic linked list implementation.
 * This class provides methods for the manipulation of elements in a linked list,
 * allowing for navigation, modification, retrieval, and information about the list.
 *
 * @param <T> The type of elements stored in the linked list.
 */
public class GenericLinkedList<T> {

    /**
     * Inner class representing a node in the linked list.
     */
    private class ListNode {
        T data;
        ListNode link;

        /**
         * Constructs a new node with the specified data and link to the next node.
         *
         * @param data The data to be stored in the node.
         * @param link The link to the next node.
         */
        public ListNode(T data, ListNode link) {
            this.data = data;
            this.link = link;
        }
    }

    private ListNode head;
    private ListNode current;
    private ListNode previous;
    private int size;

    /**
     * Constructs an empty linked list.
     */
    public GenericLinkedList() {
        head = current = previous = null;
        size = 0;
    }

    /**
     * Resets the current position to the head of the list.
     */
    public void reset() {
        current = head;
        previous = null;
    }

    /**
     * Gets the data of the last node in the list.
     *
     * @return The data of the last node, or null if the list is empty.
     */
    public T getLast() {
        if (head == null) {
            return null;
        }

        ListNode temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }

        return temp.data;
    }

    /**
     * Moves the current position to the next node in the list.
     */
    public void gotoNext() {
        if (current != null) {
            previous = current;
            current = current.link;
        }
    }

    /**
     * Gets the data at the current position.
     *
     * @return The data at the current position, or null if the position is null.
     */
    public T getCurrent() {
        return current != null ? current.data : null;
    }

    /**
     * Sets the data at the current position.
     *
     * @param data The data to set.
     */
    public void setCurrent(T data) {
        if (current != null && data != null) {
            current.data = data;
        }
    }

    /**
     * Adds a new node with the specified data to the end of the list.
     *
     * @param data The data to be added.
     */
    public void add(T data) {
        if (data == null) {
            return;
        }

        ListNode newNode = new ListNode(data, null);

        if (head == null) {
            head = current = newNode;
            size = 1;
            return;
        }

        ListNode temp = head;
        while (temp.link != null) {
            temp = temp.link;
        }

        temp.link = newNode;
        size++;
    }

    /**
     * Adds a new node with the specified data after the current position.
     *
     * @param data The data to be added.
     */
    public void addAfterCurrent(T data) {
        if (data == null || current == null) {
            return;
        }
        ListNode newNode = new ListNode(data, current.link);
        current.link = newNode;
        this.size++;
    }

    /**
     * Removes the node at the current position from the list.
     */
    public void removeCurrent() {
        if (current != null && previous != null) {
            previous.link = current.link;
            current = current.link;
        } else if (current != null && previous == null) {
            head = head.link;
            current = head;
        }
        if (this.size > 0)
            size--;
    }

    /**
     * Prints the elements in the linked list.
     */
    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.link;
        }
    }

    /**
     * Checks if the linked list contains the specified data.
     *
     * @param data The data to check for.
     * @return True if the data is found, false otherwise.
     */
    public boolean contains(T data) {
        if (data != null) {
            ListNode temp = head;
            while (temp != null) {
                if (temp.data.equals(data)) {
                    return true;
                }
                temp = temp.link;
            }
        }
        return false;
    }

    /**
     * Checks if there are more nodes in the list.
     *
     * @return True if there are more nodes, false otherwise.
     */
    public boolean hasMore() {
        return current != null;
    }

    /**
     * Gets the size of the linked list.
     *
     * @return The size of the linked list.
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Checks if the linked list is empty.
     *
     * @return True if the list is empty, false otherwise.
     */
    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Gets the data at a specified index within the bounds of the list size.
     *
     * @param i The index.
     * @return The data at the specified index, or null if the index is out of bounds.
     */
    public T getIterable(int i) {
        if (i < 0 || i >= size) {
            return null;
        }
        ListNode current = head;
        for (int j = 0; j < i; j++) {
            current = current.link;
        }
        return current.data;
    }
}