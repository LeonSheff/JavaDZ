// Реализовать алгоритм сортировки массива слиянием 

package DZ3;

import java.util.Random;
import java.util.Arrays;

public class task33 {
    public static void main(String[] args) {
        int[] intArray = getRandArray(10, 100);
        printArray(" ", intArray);

        int[] resArray = mergeSort(intArray);
        printArray(" ", resArray);
    }

    public static int[] mergeSort(int[] array) {
        if (array.length <= 1)
            return array;

        int[] left = Arrays.copyOfRange(array, 0, array.length / 2);
        int[] right = Arrays.copyOfRange(array, left.length, array.length);
        int[] result = merge(mergeSort(left), mergeSort(right));

        return result;
    }

    public static int[] merge(int[] left, int[] right) {

        int[] result = new int[left.length + right.length];

        int currInd = 0;
        int leftInd = 0;
        int rightInd = 0;

        while (leftInd < left.length && rightInd < right.length)
            if (left[leftInd] < right[rightInd]) {
                result[currInd] = left[leftInd];
                currInd++;
                leftInd++;
            } else {
                result[currInd] = right[rightInd];
                currInd++;
                rightInd++;
            }

        while (currInd < result.length)
            if (leftInd != left.length) {
                result[currInd] = left[leftInd];
                currInd++;
                leftInd++;
            } else {
                result[currInd] = right[rightInd];
                currInd++;
                rightInd++;
            }

        return result;
    }

    public static void printArray(String sep, int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i == array.length - 1) {
                System.out.println(array[i]);
                break;
            }
            System.out.print(array[i] + sep);
        }
    }

    public static int[] getRandArray(int size, int maxValue) {
        Random rand = new Random();
        int[] array = new int[size];

        for (int i = 0; i < size; i++)
            array[i] = rand.nextInt(maxValue);

        return array;
    }
}