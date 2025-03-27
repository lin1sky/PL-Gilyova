import java.util.Scanner;
public class n1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        System.out.println(str1.endsWith(str2));

        scanner.close(); 
    }
}
