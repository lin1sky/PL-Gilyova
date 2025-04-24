import java.util.Scanner;
public class n29 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n (0 < n < 100000): ");
        int n = scanner.nextInt();
        
        if (n <= 0 || n >= 100000) {
            System.out.println("Число должно быть в диапазоне 0 < n < 100000");
            return;
        }
        
        if (n % 2 == 1) {
            int k = (n - 1) / 2;
            System.out.printf("%d = %d - %d%n", n, (k+1)*(k+1), k*k);
        } 
        // Для четных чисел решение возможно, если n делится на 4
        else if (n % 4 == 0) {
            int k = n / 4;
            System.out.printf("%d = %d - %d%n", n, (k+1)*(k+1), (k-1)*(k-1));
        } else {
            System.out.println("Для данного n не существует последовательных квадратов с такой разницей");
        }
    }
}