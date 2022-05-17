package dev.glover.WeekOfMay16_2022;

import java.util.*;

public class Driver
{
    private Scanner input = new Scanner(System.in);

    public static void main(String[] args)
    {
        Driver d = new Driver();

        // 123 + 456 = 579
        //System.out.println(d.SumLists(d.convertToReversedLinkedList(123), d.convertToReversedLinkedList(456), true));
        LinkedList<Integer> n1 = new LinkedList<>(), n2 = new LinkedList<>();
        // 56
        n1.add(5);
        n1.add(6);

        // 42
        n2.add(4);
        n2.add(2);

        // 56 + 42 = 98
        System.out.println(d.SumLists(n1, n2, false));

    }

    private LinkedList<Integer> convertToReversedLinkedList(Integer num)
    {
        String strNum = num.toString();

        LinkedList<Integer> reversedNum = new LinkedList<>();

        for (int i = 0; i < strNum.length(); i++)
        {
            reversedNum.addFirst(Integer.parseInt(String.valueOf(strNum.charAt(i))));
        }

        return reversedNum;
    }

    private LinkedList<Integer> SumLists(LinkedList<Integer> num1, LinkedList<Integer> num2, Boolean areReversed)
    {
        Integer sum;
        int n1 = 0, n2 = 0;
        int digitPlace = 1;

        if (areReversed)
        {
            for (int i = 0; i < num1.size(); i++)
            {
                n1 += (digitPlace * num1.get(i));
                digitPlace *= 10;
            }

            digitPlace = 1;
            for (int i = 0; i < num2.size(); i++)
            {
                n2 += (digitPlace * num2.get(i));
                digitPlace *= 10;
            }

            sum = n1 + n2;

            return convertToReversedLinkedList(sum);
        }
        else
        {
            for (int i = num1.size() - 1; i >= 0; i--)
            {
                n1 += (digitPlace * num1.get(i));
                digitPlace *= 10;
            }

            digitPlace = 1;
            for (int i = num2.size() - 1; i >= 0; i--)
            {
                n2 += (digitPlace * num2.get(i));
                digitPlace *= 10;
            }

            sum = n1 + n2;

            String strNum = sum.toString();

            LinkedList<Integer> sumList = new LinkedList<>();

            for (int i = 0; i < strNum.length(); i++)
            {
                sumList.addLast(Integer.parseInt(String.valueOf(strNum.charAt(i))));
            }

            return sumList;
        }
    }
}
