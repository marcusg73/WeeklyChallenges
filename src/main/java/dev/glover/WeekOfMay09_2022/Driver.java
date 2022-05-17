package dev.glover.WeekOfMay09_2022;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Driver
{
    /**
     * Runs program
     */
    public static void main(String[] args)
    {
        Driver d = new Driver();
        int[] arr = {0,1,3,3,5,5,1,12,12356,123,12};

        d.MagicIndex(arr);
        System.out.println();
        System.out.println();

        Integer[] arr2 = {5,6,7};
        List<List<Integer>> theSets = d.PowerSet(arr2);

        System.out.println("Power Set --- 0 = Empty (since 0 is default value for int/Integers)");
        for (List<Integer> l: theSets)
        {
            System.out.println(l);
        }
        System.out.println();

        System.out.println("Recursion: " + d.RecursiveMultiply(2, 5));
    }

    /**
     * Magic Index: A magic index in an array A [ 0 ... n -1] is defined to be an index such that A[i] = i.
     * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
     *
     * @param arr The array to check for "magic"
     */
    private void MagicIndex(int[] arr)
    {
        // A list that stores the magic indices for recall purposes
        List<Integer> magicInds = new ArrayList<>(0);

        // Loops through the array passed in to find the magic indices
        for (int i = 0; i < arr.length; i++)
        {
            // Check if the element value matches the index
            if (arr[i] == i)
            {
                magicInds.add(i);   // Store magic index
            }
        }

        // If there is at least one magic index
        if (!magicInds.isEmpty())
        {
            // Show each magic index
            System.out.print("Magic Indices: ");
            for (int i: magicInds)
            {
                System.out.print(i + " ");
            }
        }
    }

    /**
     * Power Set: Write a method to return all subsets of a set.
     * @param arr Original array
     */
    private List<List<Integer>> PowerSet(Integer[] arr)
    {
        Integer[] subset = new Integer[arr.length];
        List<List<Integer>> allSets = new ArrayList<>(0);
        sub(arr, subset, 0, allSets);
        return allSets;
    }

    /**
     * Helper method for recursion to find the different subsets
     * @param arr The original array
     * @param subset The subset found/created
     * @param index Current index being checked
     * @param allSets Stores all subsets found
     * @see Driver#PowerSet(Integer[])
     */
    private void sub(Integer[] arr, Integer[] subset, Integer index, List<List<Integer>> allSets)
    {
        if (index == arr.length)
        {
            // Show all
            //print(subset);

            // Create a new reference
            List<Integer> newSub = new ArrayList<>(0);

            // Store necessary values to new reference
            newSub.addAll(Arrays.asList(subset));

            // Add subset to the list of all subsets
            allSets.add(newSub);
        }
        else
        {
            // At a given index, find subsets without the element
            subset[index] = 0;
            // Recurse for those varied subsets that do not include the current element based on incrementing index
            sub(arr, subset, index + 1, allSets);

            // Now find subsets with the element at the previously given index
            subset[index] = arr[index];
            // Recurse for varied subsets including the current element based on incrementing index
            sub(arr, subset, index + 1, allSets);
        }
    }

    /**
     * Helper method for printing out a subset, used for debugging purposes
     * @param subset The subset to print
     * @see Driver#sub(Integer[], Integer[], Integer, List)
     */
    private static void print(Integer[] subset)
    {
        boolean flag = false;
        System.out.print("[ ");
        for(Integer i : subset)
        {
            if(i!=0)
            {
                flag=true;
                System.out.print(i + " ");
            }
        }
        if(!flag) System.out.print("");
        System.out.print("]");
        System.out.println();
    }

    /**
     * Recursive Multiply: Write a recursive function to multiply two positive integers without
     * using the *operator. You can use addition, subtraction, and bit shifting,
     * but you should minimize the number of those operations.
     *
     * @param num1 An integer to be multiplied
     * @param num2 An integer to be multiplied
     * @return The result
     */
    private int RecursiveMultiply(int num1, int num2)
    {
        // Anything multiplied by 0 is 0
        if (num1 == 0 || num2 == 0) return 0;

        // Use first number to add the different multiples of itself based on the second number
        // since second number determines number of recursions
        return (num1 + RecursiveMultiply(num1, --num2));
    }
}
