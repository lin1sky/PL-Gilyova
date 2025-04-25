import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class n32 {
    public static long fibonacci(int i) {
        if (i <= 1) {
            return i;
        }

        long a = 0;
        long b = 1;
        long result = 0;
        for (int j = 2; j <= i; j++) {
            result = a + b;
            a = b;
            b = result;
        }
        return result;
    }

    public static int[] findMostFrequentDigit(long number) {
        String numberStr = String.valueOf(number);
        Map<Character, Integer> digitCounts = new HashMap<>();

        for (char digit : numberStr.toCharArray()) {
            digitCounts.put(digit, digitCounts.getOrDefault(digit, 0) + 1);
        }

        int maxCount = 0;
        char maxDigit = '0';
        for (Map.Entry<Character, Integer> entry : digitCounts.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                maxDigit = entry.getKey();
            } else if (entry.getValue() == maxCount) {
                // Если одинаковое количество, выбираем большую цифру
                maxDigit = (entry.getKey() > maxDigit) ? entry.getKey() : maxDigit;
            }
        }
        return new int[] { maxCount, Integer.parseInt(String.valueOf(maxDigit)) };
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите значение i (10 <= i <= 100000): ");
        int i = scanner.nextInt();
        scanner.close();

        if (i < 10 || i > 100000) {
            System.out.println("Ошибка: i должно быть в диапазоне [10, 100000]");
            return;
        }

        long fibonacciNumber = fibonacci(i);
        int[] result = findMostFrequentDigit(fibonacciNumber);

        System.out.println("f(" + i + ") = " + fibonacciNumber + " [" + result[0] + ", " + result[1] + "]");
    }
}