//* Пусть дан произвольный список целых чисел, удалить из него четные числа

package DZ3;

import java.util.*;

public class task31 {
    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>();
        Random rn = new Random();
        for (int i = 0; i < 20; i++) {
            nums.add(rn.nextInt(100));
        }
        System.out.println(nums);
        for (int j = 0; j < nums.size(); j++) {
            if (nums.get(j) % 2 == 0) {
                nums.remove(j);
                j--;
            }
        }
        System.out.println(nums);
    }
}