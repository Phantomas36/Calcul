import java.util.Scanner;

public class Main {
    public static String calc(String input) {

        String[] parts = input.split(" ");

        String result = null;
        String first = parts[0];
        String operation = parts[1];
        String second = parts[2];

        if (IsRoman.isRoman(first) != 0 && IsRoman.isRoman(second) == 0 || IsRoman.isRoman(first) == 0 && IsRoman.isRoman(second) != 0) {
            throw new NumberFormatException("Вы ввели арабские цифры вместе с римскими. Либо некоректные арабские цифры.");
        } else if (IsRoman.isRoman(first) > 10 || IsRoman.isRoman(second) > 10) {
            throw new NumberFormatException("Вы ввели римскую цифру превышающую значение 10.");
        } else if (IsRoman.isRoman(first) != 0 && IsRoman.isRoman(second) != 0) {
            result = (ArabianToRoman.ArabianToRoman(Calculator.Calculator(IsRoman.isRoman(first), operation, IsRoman.isRoman(second))));
        } else if (IsRoman.isRoman(first) == 0 && IsRoman.isRoman(second) == 0) {

            int a = Integer.parseInt(first);
            int b = Integer.parseInt(second);

            if (a > 10 || b > 10) {
                throw new NumberFormatException("Введено число больше 10.");
            } else if (parts.length != 3) {
                throw new NumberFormatException("Формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *).");
            } else result = Integer.toString(Calculator.Calculator(a, operation, b));
        }
        if (result == null) {
            throw new NumberFormatException("Ошибка");
        }
        return result;
    }

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите два числа (арабских или римских) и между ними операцию в формате: X - I или 10 - 1 или end для завершения программы");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("Конец");
                break;
            }
            System.out.println(calc(input));
        }
    }
}