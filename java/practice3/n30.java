import java.util.Scanner;

public class n30 {
    public static boolean sC(int a, int w) {
        int num = a;
        int sum = 0;
        String numStr = String.valueOf(num);
        int len = numStr.length();

        for (int i = 0; i < len; i++) {
            int digit = Character.getNumericValue(numStr.charAt(i));
            sum += Math.pow(digit, w + i);
        }

        for (int s = 1; s <= Math.pow(2, 6); s *= 2) {
            if (sum == a * s) {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите положительное число: ");
        int a = scanner.nextInt();

        System.out.print("Введите число для начала ряда: ");
        int w = scanner.nextInt();

        if (a <= 0) {
            System.out.println("Число a должно быть положительным.");
            return;
        }

        boolean result = sC(a, w);
        System.out.println(result);

        scanner.close();
    }
}