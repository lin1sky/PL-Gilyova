import java.util.Scanner;

public class n28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        
        System.out.print("Введите сдвиг: ");
        int shift = scanner.nextInt();
        
        System.out.print("Введите направление (1 - вправо, -1 - влево): ");
        int direction = scanner.nextInt();
        
        String result = caesarCipher(input, shift, direction);
        System.out.println("Результат: " + result);
    }
    
    public static String caesarCipher(String text, int shift, int direction) {
        StringBuilder result = new StringBuilder();
        shift = shift % 26; // Обеспечиваем корректность сдвига
        
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                int originalAlphabetPosition = c - base;
                int newAlphabetPosition = (originalAlphabetPosition + direction * shift + 26) % 26;
                char newChar = (char) (base + newAlphabetPosition);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }
}
