
public class Calculator {

    public static int Calculator(int a, String operation, int b) {

    int result = 0;

    switch (operation) {

        case "-":
            result = a - b;
            break;
        case "+":
            result = a + b;
            break;
        case "*":
            result = a * b;
            break;
        case "/":
            result = a / b;
            break;
        default:
            throw new NumberFormatException("Такой операции нет.");
    }
    return result;
    }
}
