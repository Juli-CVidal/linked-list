package com.datastructures.entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LinkedList<T> {
    private Node<T> head;
    private int length = 0;


    /**
     * The value will be added at the beginning (it will be the new head)
     *
     * @param value The value to be added
     */
    public void add(T value) {
        Node<T> node = new Node<>(value);
        node.setNextNode(this.head);
        this.head = node;
        this.length++;
    }


    /**
     * @param value The value to be searched
     * @return The index of the first occurrence of the value.
     *
     * <p>If the value is not found, the method will return -1.
     */
    public int getIndex(T value) {
        int index = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.hasValue(value)) {
                return index;
            }
            index++;
            currentNode = currentNode.getNextNode();
        }
        return -1;
    }


    /**
     * @param targetIndex The index of the node to return
     * @return The node that is in the indicated index
     */
    public Node<T> getNodeAtIndex(int targetIndex) {
        if (!isValidIndex(targetIndex)) {
            return null;
        }

        int index = 0;
        Node<T> currentNode = this.head;
        while (currentNode != null) {
            if (index == targetIndex) {
                return currentNode;
            }
            currentNode = currentNode.getNextNode();
            index++;
        }
        return null;
    }


    /**
     * @param value The value to be inserted
     * @param index The index where the value should be inserted
     * @return true if insertion has been possible, otherwise return false
     */
    public boolean insert(T value, int index) {
        if (!isValidIndex(index)) {
            return false;
        }
        if (index == 0) {
            add(value);
            return true;
        }

        Node<T> previousNode = getNodeAtIndex(index - 1);
        if (previousNode == null) {
            return false;
        }

        Node<T> newNode = new Node<>(value);
        newNode.setNextNode(previousNode.getNextNode());
        previousNode.setNextNode(newNode);
        this.length++;
        return true;
    }


    /**
     * This method will remove the first occurrence of the indicated value
     *
     * @param value The value to be deleted
     * @return true if the deletion has been possible, false otherwise.
     */
    public boolean deleteByValue(T value) {
        Node<T> currentNode = this.head;

        if (currentNode.getValue() == value) {
            this.head = currentNode.getNextNode();
            return true;
        }
        Node<T> nextNode = currentNode.getNextNode();
        while (nextNode != null) {
            if (nextNode.hasValue(value)) {
                currentNode.setNextNode(nextNode.getNextNode());
                return true;
            }

            currentNode = nextNode;
            nextNode = nextNode.getNextNode();
        }

        return false;
    }


    /**
     * This method will delete the node that is in the specified index.
     *
     * @param index The index where the node to be deleted is located
     * @return true if the deletion has been possible, false otherwise.
     */
    public boolean deleteByIndex(int index) {
        if (!isValidIndex(index)) {
            return false;
        }

        if (index == 0) {
            this.head = this.head.getNextNode();
            return true;
        }

        Node<T> prevNode = getNodeAtIndex(index - 1);
        prevNode.setNextNode(prevNode.getNextNode().getNextNode());
        return true;
    }

    /**
     * @param index The index to be evaluated
     * @return True if the index is between 0 and the length of the list, false otherwise
     */
    private boolean isValidIndex(int index) {
        return 0 <= index && index <= this.length;
    }
}
