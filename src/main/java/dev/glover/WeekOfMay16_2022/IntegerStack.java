package dev.glover.WeekOfMay16_2022;

import java.util.EmptyStackException;
import java.util.Stack;

public class IntegerStack
{
    // Use a Stack as a structure for the data
    private final Stack<Integer> stack;
    // Reference to the minimum element (in this case an Integer)
    private Integer min = 0;

    // Default contructor
    public IntegerStack()
    {
        stack = new Stack<>();
    }

    // Varargs Constructor to initialize the Stack with any number of Integers
    public IntegerStack(Integer ...args)
    {
        // Instantiate
        stack = new Stack<>();

        // Push elements onto stack
        for (Integer i: args)
        {
            this.push(i);
        }
    }

    // Method for pushing new elements onto the stack
    public void push(Integer element)
    {
        // Check if stack is empty
        if (stack.isEmpty())
            min = element;      // Store first element as the minimum

        // Compare new elements to the minimum
        if (element < min )
            min = element;      // Reassign as needed

        // Add new element to stack
        stack.push(element);
    }

    // Method for popping elements from the top of the stack
    public Integer pop()
    {
        try
        {
            return stack.pop();     // Pop top element if possible
        }
        catch (EmptyStackException e)
        {
            throw new RuntimeException("No elements to pop!");      // The stack was empty
        }
    }

    // Method to return the minimum element which is tracked when elements are initially pushed onto the stack
    public Integer min()
    {
        return min;
    }
}
