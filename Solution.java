package StackDemo;

public class Solution {
    // ArrayStack Class
    static class ArrayStack {

        private int[] stack;
        private int top;

        // Constructor
        public ArrayStack(int capacity) {
            stack = new int[capacity];
            top = -1;
        }

        // Push Method
        public void push(int value) {

            if (top == stack.length - 1) {
                expandCapacity();
            }

            top++;
            stack[top] = value;
        }

        // Pop Method
        public int pop() {

            if (isEmpty()) {
                throw new RuntimeException("Stack is empty");
            }

            int value = stack[top];
            top--;

            return value;
        }

        // isEmpty Method
        public boolean isEmpty() {
            return top == -1;
        }

        // Size Method
        public int size() {
            return top + 1;
        }

        // Expand Capacity Method
        private void expandCapacity() {

            int[] newStack = new int[stack.length * 2];

            for (int i = 0; i < stack.length; i++) {
                newStack[i] = stack[i];
            }

            stack = newStack;
        }
    }

    // Reverse Array Method
    public static int[] reverseArray(int[] numbers) {

        ArrayStack stack = new ArrayStack(2);

        // Push all numbers
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        // Create new array
        int[] reversed = new int[numbers.length];

        // Pop all elements
        int i = 0;

        while (!stack.isEmpty()) {
            reversed[i] = stack.pop();
            i++;
        }

        return reversed;
    }

    // Bonus: Reverse First K Elements
    public static int[] reverseFirstK(int[] numbers, int k) {

        if (k < 0 || k > numbers.length) {
            throw new IllegalArgumentException("Invalid K value");
        }

        ArrayStack stack = new ArrayStack(2);

        // Push first K elements
        for (int i = 0; i < k; i++) {
            stack.push(numbers[i]);
        }

        int[] result = new int[numbers.length];

        // Pop first K elements
        for (int i = 0; i < k; i++) {
            result[i] = stack.pop();
        }

        // Copy remaining elements
        for (int i = k; i < numbers.length; i++) {
            result[i] = numbers[i];
        }

        return result;
    }

    // Print Array Method
    public static void printArray(int[] numbers) {

        for (int num : numbers) {
            System.out.print(num + " ");
        }

        System.out.println();
    }

    // Main Method
    public static void main(String[] args) {

        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Original Array:");
        printArray(numbers);

        System.out.println("Reversed Array:");
        int[] reversed = reverseArray(numbers);
        printArray(reversed);

        System.out.println("Bonus Challenge:");

        int[] bonus = reverseFirstK(numbers, 3);
        printArray(bonus);
    }
}


