package com.niit.integerswap;


public class SwapIntegers {

    public static void main(String[] args) {

        SwapIntegers swapIntegers = new SwapIntegers();
        // Declare a scanner object here

        // Get the number value as integer from the console and store in variable 'number'
        int number = 0;
        long swappedNumber = swapIntegers.swapNumbers(number);
        System.out.println("Swapped Number is  : "+swappedNumber);
    }

    // Function accepts number and returns result with each pair of digits swapped.
    public long swapNumbers(long number) {
        int[] numArray = convertLongToIntArray(number);

        int arrLength = numArray.length;
        if (arrLength %2 == 0) {
            // if even length
            for (int i=0; i<arrLength; i+=2) {
                int temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
            }
        } else {
            // if odd length
            for (int i=1; i<arrLength; i+=2) {
                int temp = numArray[i];
                numArray[i] = numArray[i+1];
                numArray[i+1] = temp;
            }
        }

        long finalValue = convertIntArrayToLong(numArray);

        return finalValue;
    }

    // accept a number of type long and converts it into an array of digits of type int
    private int[] convertLongToIntArray(long num) {
        int length = 0;
        long temp = num;
        while (temp > 0) {
            temp /= 10;
            length++;
        }
        
        int[] arr = new int[length];
        temp = num;
        int index = 0;
        while (temp > 0) {
            arr[length - index - 1] = (int)(temp%10);
            temp /= 10;
            index++;
        }
        
        return arr;
    }

    // accepts an integer array as input [assuming each item is a digit] and converts it into a number of type long
    private long convertIntArrayToLong(int[] numArray) {
        // int exp = 0;
        long result = 0;

        int len = numArray.length;
        for (int i=0; i<len; i++) {
            result += numArray[i] * Math.pow(10, len-i-1);
        }

        return result;
    }
}
