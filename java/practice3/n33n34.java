import java.util.Scanner;

public class n33n34 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n (1 <= n <= 10^18): ");
        long n = scanner.nextLong();

        long tanya = 0;
        long sasha = 0;
        boolean tanyaTurn = true;

        while (n > 0) {
            if (n % 2 == 0) { // Четное количество
                if (n / 2 >= 1) {
                    if (tanyaTurn) {
                        tanya += n / 2; // Таня берет половину
                        n /= 2;
                    } else {
                        sasha += n / 2; // Саша берет половину
                        n /= 2;
                    }
                } else {
                    if (tanyaTurn) {
                        tanya += 1; // Таня берет 1
                        n -= 1;
                    } else {
                        sasha += 1; // Саша берет 1
                        n -= 1;
                    }
                }

            } else { // Нечетное количество
                if (tanyaTurn) {
                    tanya += 1; // Таня берет 1
                    n -= 1;
                } else {
                    sasha += 1; // Саша берет 1
                    n -= 1;
                }
            }
            tanyaTurn = !tanyaTurn;
        }

        System.out.println(tanya);
        //System.out.println(sasha); // Для проверки
    }
}