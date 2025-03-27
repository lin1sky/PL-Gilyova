import java.util.Scanner;
public class n4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первое число: ");
        int num1 = scanner.nextInt();
        System.out.print("Введите второе число: ");
        int num2 = scanner.nextInt();
        
        int start = Math.min(num1, num2); 
        int end = Math.max(num1, num2);   
        int step = start;                 
        
        for (int i = start; i <= end; i += step) {
            System.out.print((i * i) + " ");
        }
    }
}
