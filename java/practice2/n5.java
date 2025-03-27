import java.util.Scanner;

public class n5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите начало ряда: ");
        int start = scanner.nextInt();
        System.out.print("Введите шаг: ");
        int step = scanner.nextInt();
        System.out.print("Введите количество шагов: ");
        int count = scanner.nextInt();
        
        for (int i = 0; i < count; i++) {
            System.out.print(start + i * step);
            if (i < count - 1) {
                System.out.print(", ");
            }
        }
    }
}