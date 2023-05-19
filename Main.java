import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String result = calc(reader.readLine());
        System.out.println(result);
    }
    public static String calc(String input) {
        String[] parts = splitByParts(input);

        int a = fetchNumber(parts[0]);
        validateVariable(a);

        int b = fetchNumber(parts[2]);
        validateVariable(b);

        Operator operator = Operator.fromString(parts[1]);

        int result = makeOperation(a, b, operator);
        return String.valueOf(result);
    }

    private static void validateVariable(int variable) {
        if (variable > 10 || variable < 1) {
            throw new RuntimeException("Число должно быть в диапазоне от 1 до 10");
        }
    }

    private static int makeOperation(int a, int b, Operator operator) {
        switch (operator) {
            case DIVISION:
                return a / b;
            case MULTIPLICATION:
                return a * b;
            case SUBTRACTION:
                return a - b;
            case SUM:
                return a + b;
            default:
                throw new RuntimeException("Нет подходящей операции для оператора: " + operator);
        }
    }

    private static String[] splitByParts(String input) {
        String[] result = input.trim().split(" ");
        if (result.length != 3) {
            throw new RuntimeException("Неверный формат данных");
        }
        return result;
    }

    private static int fetchNumber(String variable) {
        try {
            return Integer.parseInt(variable.trim());
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Введен не верный параметр");
        }
    }
}