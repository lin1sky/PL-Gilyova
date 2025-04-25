import java.util.Scanner;

public class n39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите текст:");
        String inputText = scanner.nextLine();
        
        String transformedText = transformText(inputText);
        System.out.println("Результат:"+transformedText);
    }
    
    public static String transformText(String text) {
        String[] words = text.split(" ");
        StringBuilder result = new StringBuilder();
        
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            // Проверяем, является ли последний символ знаком препинания
            int lastCharIndex = word.length() - 1;
            char lastChar = word.charAt(lastCharIndex);
            boolean hasPunctuation = !Character.isLetterOrDigit(lastChar);
            
            String baseWord = hasPunctuation ? word.substring(0, lastCharIndex) : word;
            String punctuation = hasPunctuation ? String.valueOf(lastChar) : "";
            
            if (baseWord.length() > 0) {
                // Перемещаем первую букву в конец и добавляем "ауч"
                String transformedWord = baseWord.substring(1) + baseWord.substring(0, 1).toLowerCase() + "ауч" + punctuation;
                result.append(transformedWord).append(" ");
            } else {
                result.append(punctuation).append(" ");
            }
        }
        return result.toString().trim();
    }
}