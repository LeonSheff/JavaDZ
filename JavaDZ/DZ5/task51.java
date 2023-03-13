// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
// Добавить функции 1) Добавление номера
// 2) Вывод всего
package DZ5;

import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class task51 {
    public static void main(String[] args) {
        Map<String, ArrayList<String>> phoneBook = new HashMap<>();
        Scanner sc = new Scanner(System.in, "cp866");

        boolean mainCycle = true;

        while (mainCycle) {
            System.out.println();
            System.out.print(
                    "Введите команду:\n\t1 - Показать все записи в телефонной книге\n\t2 - Добавить номер в книгу\n\t0 - Выход: ");

            String decisision = sc.nextLine();

            switch (decisision) {
                case "1":
                    showPhoneBook(phoneBook);
                    break;

                case "2":
                    addContact(phoneBook, sc);
                    break;

                case "0":
                    mainCycle = false;
                    System.out.println("Выход...");
                    break;

                default:
                    System.out.println("Такой команды нет!");
            }
        }

        sc.close();
    }

    public static void addContact(Map<String, ArrayList<String>> map, Scanner scanner) {
        int index = 1;
        Object[] names = map.keySet().toArray();

        System.out.println();
        System.out.println("Выберите, кому добавить номер:");

        for (Object el : names) {
            System.out.println("\t" + index + ". " + el);
            index++;
        }

        System.out.print("\t0. Добавить новый контакт\n Ваш выбор: ");

        int decision = scanner.nextInt();
        scanner.nextLine();

        if (decision <= names.length && decision > 0) {
            System.out.print("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();
            map.get(names[decision - 1]).add(phoneNumber);
        } else if (decision == 0) {
            System.out.print("Введите ФИО нового контакта: ");
            String name = scanner.nextLine();

            System.out.print("Введите номер телефона: ");
            String phoneNumber = scanner.nextLine();

            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);

            map.put(name, numbers);
        } else
            System.out.println("Такого выбора нет!");
    }

    public static void showPhoneBook(Map<String, ArrayList<String>> map) {
        System.out.println();

        for (var el : map.entrySet()) {
            System.out.println(el.getKey() + ":");

            for (String inner : el.getValue())
                System.out.println("\t" + inner);

            System.out.println();
        }
    }
}