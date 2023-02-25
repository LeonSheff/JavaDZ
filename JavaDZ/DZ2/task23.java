// Напишите метод, который принимает на вход строку (String) и определяет является
//  ли строка палиндромом (возвращает boolean значение).

package DZ2;

public class task23 {
    public static void main(String[] args) {
        // Можно и по другому, так мне проще)
        String input1 = "Hello";
        String input2 = "nagan";
        System.out.println(input1 + " " + input2);
        System.out.println(isPalindrome(input1) + " " + isPalindrome(input2));
    }

    public static boolean isPalindrome(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            if (input.charAt(i) != input.charAt(input.length() - 1 - i))
                return false;
        }
        return true;
    }
}