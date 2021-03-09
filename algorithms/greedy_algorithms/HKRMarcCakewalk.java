package greedy_algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * HACKERRANK MARC'S CAKEWALK
 *  Link: https://www.hackerrank.com/challenges/marcs-cakewalk/problem
 *  Input: An array of N integers
 *  Output: Min number of miles Marc must walk to maintain his weight
 *
 * EXAMPLE
 *  Input:
 *      N = 3
 *      arr[] = [1, 3, 2]
 *  Output: 11
 */
public class HKRMarcCakewalk {

    public static void solve(int[] arr) {

        long result = 0;

        Integer[] calories = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        Arrays.sort(calories, Collections.reverseOrder());

        for (int i = 0;i < calories.length;++i) {
            result += Math.pow(2, i) * calories[i];
        }

        System.out.println("Min: " + result);
    }

    public static void main(String[] args) {
        int elements;
        int[] arr;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        elements = sc.nextInt();

        arr = new int[elements];
        System.out.print("Enter element in array: ");
        for (int i = 0;i < elements;++i) {
            arr[i] = sc.nextInt();
        }

        solve(arr);
    }
}
