// В калькулятор добавьте возможность отменить последнюю операцию.
// Пример
// 1
// +
// 2
// ответ:
// 3
// +
// 4
// ответ:
// 7
// Отмена
// 3
// *
// 3
// ответ:
// 9
package DZ4;

import java.util.LinkedList;
import java.util.Scanner;

public class task43 {

    public static void main(String[] args) {
        LinkedList<Double> results = new LinkedList<>();
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number: ");
        results.add(sc.nextDouble());
        sc.nextLine();

        while (true) {
            System.out.print("Enter operator (+, -, *, /, Cancel): ");
            String op = sc.nextLine();

            if ("".equals(op))
                break;
            else if ("Cancel".equals(op) || "cancel".equals(op)) {
                results.removeFirst();

                if (results.size() == 0)
                    results.add(0.0);
            } else {
                System.out.print("Enter second number: ");
                double secNumber = sc.nextDouble();

                process(results, op, secNumber);
                sc.nextLine();
            }

            System.out.println("Result: " + results.getFirst());
        }

        sc.close();
    }

    public static void process(LinkedList<Double> list, String op, double number) {
        switch (op) {
            case "+":
                list.add(0, list.getFirst() + number);
                break;

            case "-":
                list.add(0, list.getFirst() - number);
                break;

            case "*":
                list.add(0, list.getFirst() * number);
                break;

            case "/":
                if (number == 0) {
                    System.out.println("Cannot divide by zero!");
                    break;
                }
                list.add(0, list.getFirst() / number);
                break;

            default:
                System.out.println("Wrong operator!");
        }
    }
}