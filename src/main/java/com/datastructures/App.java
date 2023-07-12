package com.datastructures;


import com.datastructures.entities.LinkedList;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>(new Integer[]{1,2,3,4,5,6,7});
        System.out.println(linkedList);
    }
}

