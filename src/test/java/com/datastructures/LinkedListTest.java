package com.datastructures;


import com.datastructures.entities.LinkedList;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;


public class LinkedListTest {

    private LinkedList<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedList<>();
    }

    @Test
    void testAdd() {
        linkedList.add(3);

        Integer expectedValue = 1;
        linkedList.add(expectedValue);
        Assertions.assertTrue(linkedList.getHead().hasValue(expectedValue));
    }

    @Test
    void testAddUpdatesTheLength() {
        int length = linkedList.getLength();
        linkedList.add(1);

        Assertions.assertNotEquals(length, linkedList.getLength());
    }


    @Test
    void testCreateFromList() {
        Integer[] list = new Integer[]{1, 2, 3};
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        LinkedList<Integer> resultLinkedList = new LinkedList<>(list);

        Assertions.assertTrue(linkedList.equals(resultLinkedList));
    }


    @Test
    void testHaveTheSameLength() {
        Integer[] list = new Integer[]{1, 2, 3};
        LinkedList<Integer> resultLinkedList = new LinkedList<>(list);

        Assertions.assertEquals(list.length, resultLinkedList.getLength());
    }


    @Test
    void testConvertToCorrectType() {
        linkedList.add(3);
        Integer[] list = linkedList.toList();

        Assertions.assertEquals(Integer[].class, list.getClass());
    }


    @Test
    void testConvertToList() {
        Integer[] expectedList = new Integer[]{1, 2, 3};


        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        Integer[] resultList = linkedList.toList();

        Assertions.assertEquals(Arrays.toString(expectedList), Arrays.toString(resultList));
    }


    @Test
    void testValidIndexReturnsFalseForNegativeIndex() {
        int negativeIndex = -1;

        Assertions.assertFalse(linkedList.isValidIndex(negativeIndex));
    }


    @Test
    void testValidIndexReturnsFalseForInvalidIndex() {
        int invalidIndex = linkedList.getLength() + 1;

        Assertions.assertFalse(linkedList.isValidIndex(invalidIndex));
    }


    @Test
    void testValidIndexReturnsTrueForIndexZero() {
        int index = 0;

        Assertions.assertTrue(linkedList.isValidIndex(index));
    }


    @Test
    void testValidIndexReturnsTrueForLengthIndex() {
        int index = linkedList.getLength();

        Assertions.assertTrue(linkedList.isValidIndex(index));
    }

    @Test
    void testInsert() {
        Integer expectedValue = 5;

        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);
        linkedList.insert(expectedValue, 1);


        Assertions.assertTrue(linkedList.getHead().getNextNode().hasValue(expectedValue));
    }


    @Test
    void testInsertUpdatesTheLength() {
        int length = linkedList.getLength();

        linkedList.insert(1, 0);

        Assertions.assertNotEquals(length, linkedList.getLength());
    }

    @Test
    void testInsertShouldThrowExceptionOnNegativeIndex() {
        int negativeIndex = -1;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> linkedList.insert(5, negativeIndex));
    }

    @Test
    void testInsertShouldThrowExceptionOnInvalidIndex() {
        int invalidIndex = Integer.MAX_VALUE;
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> linkedList.insert(5, invalidIndex));
    }

    @Test
    void testSearchAnElementNotInList() {
        Integer value = 5, expectedIndex = -1;
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        Assertions.assertEquals(-1, linkedList.getIndex(value));
    }

    @Test
    void testSearchAnElementInList() {
        Integer value = 3;
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        Assertions.assertTrue(linkedList.getIndex(value) >= 0);
    }

    @Test
    void testSearchReturnsCorrectIndex() {
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        int value = 3, expectedIndex = 2;

        Assertions.assertEquals(linkedList.getIndex(value), expectedIndex);
    }

    @Test
    void testGetNodeReturnsTheCorrectNode() {
        linkedList.add(3);
        linkedList.add(2);
        linkedList.add(1);

        int index = 1, expectedValue = 2;

        Assertions.assertTrue(linkedList.getNodeAtIndex(index).hasValue(expectedValue));
    }


}
