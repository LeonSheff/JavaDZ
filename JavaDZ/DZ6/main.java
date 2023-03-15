package DZ6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class main {
    public static void main(String[] args) {
        HashMap<Integer, String> criterions = new HashMap<>();
        criterions.put(1, "color");
        criterions.put(2, "os");
        HashSet<Laptop> laptops = new HashSet<>();
        laptops.add(new Laptop("Acer", "Windows", "blue", 256, 8));
        laptops.add(new Laptop("MacbookAir", "Mac", "black", 256, 8));
        laptops.add(new Laptop("Acer", "Windows", "black", 512, 8));
        laptops.add(new Laptop("HP", "Windows", "white", 256, 16));
        laptops.add(new Laptop("MacbookPro", "Mac", "blue", 256, 16));
        laptops.add(new Laptop("Asus", "Windows", "black", 512, 16));
        laptops.add(new Laptop("RedmibookPro", "Windows", "silver", 512, 32));
        laptops.add(new Laptop("Digma", "Linux", "black", 128, 4));
        laptops.add(new Laptop("Acer", "Windows", "pink", 128, 4));
        laptops.add(new Laptop("MSi", "Windows", "black", 512, 32));
        laptops.add(new Laptop("HP", "Linux", "white", 256, 16));
        laptops.add(new Laptop("Acer", "Windows", "black", 512, 8));
        laptops.add(new Laptop("XiaomiAir", "Windows", "pink", 256, 4));
        laptops.add(new Laptop("NotebookR", "Linux", "blue", 512, 8));
        laptops.add(new Laptop("Huanangi", "Windows", "perple", 256, 16));

        System.out.println(laptops);
        System.out.println();
        System.out.println("Отфильтрованный список: ");
        ArrayList<Laptop> res = filter("black", laptops);
        System.out.println(res);

        System.out.println(laptops);
        System.out.println();
        System.out.println("Отфильтрованный список: ");
        String[] find = chooseFilter1(criterions);
        System.out.println(find[0]);
        ArrayList<Laptop> res2 = filter2(find[0], find[1], laptops);
        System.out.println(res2);
        // System.out.println(chooseFilter(criterions));

    }

    // Метод возвращает Массив строк в формате [критерий, значение критерия]
    public static String[] chooseFilter1(HashMap<Integer, String> criterions) {

        System.out.println("Введите номер критерия для фильтрации.");
        System.out.println("1 - цвет, 2 - ОС");
        Scanner scan = new Scanner(System.in);
        Integer res = Integer.parseInt(scan.nextLine());

        String[] find = new String[5];
        find[0] = criterions.get(res);

        Scanner scan2 = new Scanner(System.in);
        String criterion;

        if (res == 1) {
            System.out.println("Введите цвет для фильтрации");
            criterion = scan2.nextLine();
            find[1] = criterion;
        }
        if (res == 2) {
            System.out.println("Введите название ОС для фильтрации");
            criterion = scan2.nextLine();
            find[1] = criterion;
        }
        return find;
    }

    // Метод запрашивает выбор критерия фильтрации и возвращает его название
    public static String chooseFilter2(HashMap<Integer, String> criterions) {
        System.out.println("Введите номер критерия для фильтрации.");
        System.out.println("1 - цвет, 2 - ОС");
        Scanner scan = new Scanner(System.in);
        Integer res = Integer.parseInt(scan.nextLine());
        return criterions.get(res);
    }

    // Метод Фильтрует множество ноутбуков по значению критерия
    public static ArrayList<Laptop> filter(String filter, HashSet<Laptop> laptops) {

        Laptop[] temp = laptops.toArray(new Laptop[laptops.size()]);
        ArrayList<Laptop> newFilter = new ArrayList<>();

        for (int i = 0; i < laptops.size(); i++) {
            if (filter.equals(temp[i].getColor())) {
                newFilter.add(temp[i]);
            }
        }
        return newFilter;
    }

    // Метод принимает на вход сам критерий и его значение
    public static ArrayList<Laptop> filter2(String criterion, String filter, HashSet<Laptop> laptops) {

        Laptop[] temp = laptops.toArray(new Laptop[laptops.size()]);
        ArrayList<Laptop> newFilter = new ArrayList<>();
        if (criterion.equals("color")) {
            for (int i = 0; i < laptops.size(); i++) {
                if (filter.equals(temp[i].getColor())) {
                    newFilter.add(temp[i]);
                }
            }
            return newFilter;
        } else if (criterion.equals("os")) {
            for (int i = 0; i < laptops.size(); i++) {
                if (filter.equals(temp[i].getOs())) {
                    newFilter.add(temp[i]);
                }
            }
            return newFilter;
        }

        return newFilter;
    }
}
