package greedy_algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * HACKERRANK MINIMUM ABSOLUTE DIFFERENCE
 *  Link: https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
 *  Input: An array of N integers
 *  Output: Minimum absolute difference
 *
 * EXAMPLE
 *  Input:
 *      N = 3
 *      arr[] = [3, -7, 0]
 *  Output: 3
 *
 * SOLUTION
 *  Important note: When we minus 2 numbers with same sign then result will be smaller
 * and when we minus 2 numbers with different sign then result will be greater.
 *  1/ Sorts the array in ascending order
 *  2/ Because result of subtraction between two adjacent numbers is min, then we
 * subtract two first numbers and assign it to min value.
 *  3/ Repeat step: Subtract next pair numbers
 *      3a/ If result is smaller than min value then assign min to that result
 *      3b/ Otherwise continue
 */
public class HKRMinAbsoluteDifference {

    public static void solve(long[] arr) {
        Arrays.sort(arr);
        long min = Math.abs(arr[0] - arr[1]);

        for (int i = 1;i < arr.length - 1;++i) {
            long result = Math.abs(arr[i] - arr[i + 1]);
            if (min > Math.abs(result)) {
                min = Math.abs(result);
            }
        }

        System.out.println("Min: " + min);
    }

    public static void main(String[] args) {
        int elements;
        long[] numbersArray;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        elements = sc.nextInt();

        numbersArray = new long[elements];
        System.out.print("Enter element in array: ");
        for (int i = 0;i < elements;++i) {
            numbersArray[i] = sc.nextInt();
        }

        solve(numbersArray);
    }
}
