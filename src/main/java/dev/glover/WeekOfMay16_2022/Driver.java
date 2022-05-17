package dev.glover.WeekOfMay16_2022;

import java.util.*;

public class Driver
{
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        Driver d = new Driver();

//        // 123 + 456 = 579
//        System.out.println(d.SumLists(d.convertToReversedLinkedList(123), d.convertToReversedLinkedList(456), true));
//        LinkedList<Integer> n1 = new LinkedList<>(), n2 = new LinkedList<>();
//        // 56
//        n1.add(5);
//        n1.add(6);
//
//        // 42
//        n2.add(4);
//        n2.add(2);
//
//        // 56 + 42 = 98
//        System.out.println(d.SumLists(n1, n2, false));

        IntegerStack stack = new IntegerStack(5, 6, 2, 0, -4, 15);
        System.out.println(stack.min());

    }

    private LinkedList<Integer> convertToReversedLinkedList(Integer num)
    {
        // Convert number into a String for looping
        String strNum = num.toString();

        // Create a LinkedList to hold the digits of the number
        LinkedList<Integer> reversedNum = new LinkedList<>();

        // Loop through number and add them to the list
        for (int i = 0; i < strNum.length(); i++)
        {
            reversedNum.addFirst(Integer.parseInt(String.valueOf(strNum.charAt(i))));
        }

        // Return the list
        return reversedNum;
    }

    private LinkedList<Integer> SumLists(LinkedList<Integer> num1, LinkedList<Integer> num2, Boolean areReversed)
    {
        Integer sum;            // Holds sum of the numbers
        int n1 = 0, n2 = 0;     // References to value of each number
        int digitPlace = 1;     // Keeps track of digit place value when looping

        // Check if the numbers are reversed or not
        if (areReversed)
        {
            // Loop through the first number while converting into an int for addition operation
            for (int i = 0; i < num1.size(); i++)
            {
                n1 += (digitPlace * num1.get(i));
                digitPlace *= 10;
            }

            // Loop through the second number while converting into an int for addition operation
            digitPlace = 1;
            for (int i = 0; i < num2.size(); i++)
            {
                n2 += (digitPlace * num2.get(i));
                digitPlace *= 10;
            }

            sum = n1 + n2;                              // Add numbers

            return convertToReversedLinkedList(sum);    // Return the reversed LinkedList of the sum
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

            sum = n1 + n2;                                      // Add numbers

            String strNum = sum.toString();                     // Convert sum into a String for looping

            LinkedList<Integer> sumList = new LinkedList<>();   // Create a LinkedList to hold the digits of the sum

            // Convert sum into a LinkedList
            for (int i = 0; i < strNum.length(); i++)
            {
                sumList.addLast(Integer.parseInt(String.valueOf(strNum.charAt(i))));
            }

            return sumList;     // Return the LinkedList of the sum
        }
    }
}
