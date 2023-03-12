// Пусть дан LinkedList с несколькими элементами. Реализуйте метод
// (не void), который вернет “перевернутый” список.
package DZ4;

import java.util.LinkedList;
import java.util.Random;

public class task41 {

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        randFillList(10, 100, ll);
        LinkedList<Integer> newLL = returnReversedList(ll);

        System.out.println(ll.toString());
        System.out.println(newLL.toString());
    }

    public static LinkedList<Integer> returnReversedList(LinkedList<Integer> list) {
        LinkedList<Integer> newList = new LinkedList<>();

        for (int i = list.size(); i > 0; i--)
            newList.add(list.get(i - 1));

        return newList;
    }

    public static void randFillList(int count, int maxValue, LinkedList<Integer> list) {
        Random rand = new Random();

        for (int i = 0; i < count; i++) {
            list.add(rand.nextInt(maxValue));
        }
    }
}