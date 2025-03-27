import java.util.Scanner;

public class n3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        String result = input.replaceAll("[aeiouyAEIOUYауоыиэяюёеАУОЫИЭЯЮЁЕ]", "");
        System.out.println(result);
    }
}