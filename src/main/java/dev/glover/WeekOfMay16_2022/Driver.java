package dev.glover.WeekOfMay16_2022;

import java.util.*;

public class Driver
{
    public static void main(String[] args)
    {
        Driver d = new Driver();

        // Experimental Grounds ---

        // 123 + 456 = 579
        LinkedList<Integer> l1 = d.convertToLinkedList(123, true);
        LinkedList<Integer> l2 = d.convertToLinkedList(456, true);
        System.out.println(d.SumLists(l1, l2, true));

        LinkedList<Integer> n1 = new LinkedList<>(), n2 = new LinkedList<>();

        // 56
        n1.add(5);
        n1.add(6);

        // 42
        n2.add(4);
        n2.add(2);

        // 56 + 42 = 98
        System.out.println(d.SumLists(n1, n2, false));

        // Minimum -> -4
        IntegerStack stack = new IntegerStack(5, 6, 2, 0, -4, 15);
        System.out.println(stack.min());

        // ---
    }

    /**
     * Helper method to convert an Integer into a LinkedList
     * @param num The Integer to convert
     * @param reverse True/False, Should the method return the list as a reversed version of the number? (i.e. 57 would return a list of [7, 5])
     * @return The num as a LinkedList
     */
    private LinkedList<Integer> convertToLinkedList(Integer num, boolean reverse)
    {
        // Convert number into a String for looping
        String strNum = num.toString();

        // Create a LinkedList to hold the digits of the number
        LinkedList<Integer> numList = new LinkedList<>();

        if (reverse)
        {
            // Loop through number and add them to the list
            for (Character c: strNum.toCharArray())
            {
                numList.addFirst(Integer.parseInt(c.toString()));
            }
        }
        else
        {
            // Loop through number and add them to the list
            for (Character c: strNum.toCharArray())
            {
                numList.addLast(Integer.parseInt(c.toString()));
            }
        }

        // Return the LinkedList created
        return numList;
    }

    /**
     * Sum Lists: You have two numbers represented by a linked list,
     * where each node contains a single
     * digit. The digits are stored in reverse order,
     * such that the 1 's digit is at the head of the list. Write a
     * function that adds the two numbers and returns the sum as a linked list.
     *
     * EXAMPLE
     * Input: (7-> 1 -> 6) + (5 -> 9 -> 2).That is,617 + 295.
     * Output: 2 -> 1 -> 9. That is, 912.
     *
     * FOLLOW UP
     * Suppose the digits are stored in forward order. Repeat the above problem.
     * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).That is,617 + 295.
     * Output: 9 -> 1 -> 2. That is, 912.
     *
     * @param num1 An addend for the sum
     * @param num2 An addend for the sum
     * @param areReversed True/False, are the addends (LinkedList) reversed versions of their respective number?
     * @return The sum of num1 and num2 as a LinkedList
     */
    private LinkedList<Integer> SumLists(LinkedList<Integer> num1, LinkedList<Integer> num2, Boolean areReversed)
    {
        int sum;                // Holds sum of the numbers
        int n1 = 0, n2 = 0;     // References to value of each number
        int digitPlace = 1;     // Keeps track of digit place value when looping

        // Check if the numbers are reversed or not
        // Add numbers
        if (areReversed)
        {
            // Loop through the first number while converting into an int for addition operation
            for (Integer integer : num1)
            {
                n1 += (digitPlace * integer);
                digitPlace *= 10;
            }

            // Loop through the second number while converting into an int for addition operation
            digitPlace = 1;
            for (Integer integer : num2)
            {
                n2 += (digitPlace * integer);
                digitPlace *= 10;
            }

        }
        else
        {
            // Loop through the first number while converting into an int for addition operation
            for (int i = num1.size() - 1; i >= 0; i--)
            {
                n1 += (digitPlace * num1.get(i));
                digitPlace *= 10;
            }

            // Loop through the second number while converting into an int for addition operation
            digitPlace = 1;
            for (int i = num2.size() - 1; i >= 0; i--)
            {
                n2 += (digitPlace * num2.get(i));
                digitPlace *= 10;
            }
        }

        sum = n1 + n2;                                      // Add numbers

        return convertToLinkedList(sum, areReversed);       // Return the LinkedList of the sum
    }
}
