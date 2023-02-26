// * Задан целочисленный список ArrayList. Найти минимальное, максимальное и
// среднее ариф. из этого списка

package DZ3;

import java.util.*;

public class task32 {
    public static void main(String[] args) {
        ArrayList<Integer> intList = new ArrayList<>();
        randFillList(10, 100, intList);

        printArrayList(", ", intList);

        System.out.println("Maximal value: " + max(intList));
        System.out.println("Minimal value: " + min(intList));
        System.out.println("Average: " + getAvg(intList));
    }

    public static int max(ArrayList<Integer> list) {
        int maxValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) > maxValue)
                maxValue = list.get(i);
        }

        return maxValue;
    }

    public static int min(ArrayList<Integer> list) {
        int minValue = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < minValue)
                minValue = list.get(i);
        }

        return minValue;
    }

    public static double getAvg(ArrayList<Integer> list) {
        double avg = 0;

        for (Integer value : list) {
            avg += value.doubleValue();
        }

        avg /= list.size();

        return avg;
    }

    public static void printArrayList(String sep, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                System.out.println(list.get(i));
                break;
            }
            System.out.print(list.get(i) + sep);
        }
    }

    public static void randFillList(int count, int maxValue, ArrayList<Integer> list) {
        Random rand = new Random();
        for (int i = 0; i < count; i++)
            list.add(rand.nextInt(maxValue));
    }
}