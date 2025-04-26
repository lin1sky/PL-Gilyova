import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class n36 {

    public static void main(String[] args) {
        try {
            // 1. Получаем текст с сайта fish-text.ru (10,000 символов)
            String referenceText = getFishText(10000);
            
            // 2. Анализируем частоту символов в эталонном тексте
            Map<Character, Double> referenceFrequencies = calculateFrequencies(referenceText);
            
            // 3. Пример зашифрованного текста (можно заменить на любой другой)
            String encryptedText = "Привет, это зашифрованный текст!";
            System.out.println("Зашифрованный текст: " + encryptedText);
            
            // 4. Расшифровываем текст
            String decryptedText = decryptCaesarCipher(encryptedText, referenceFrequencies);
            System.out.println("Расшифрованный текст: " + decryptedText);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Метод для получения текста с fish-text.ru
    private static String getFishText(int charCount) throws Exception {
        String url = "https://fish-text.ru/get?type=paragraph&number=1&format=json";
        URL fishTextUrl = new URL(url);
        URLConnection connection = fishTextUrl.openConnection();
        connection.setRequestProperty("Accept-Charset", "UTF-8");
        
        StringBuilder response = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(connection.getInputStream(), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
        }
        
        // Извлекаем текст из JSON ответа
        String json = response.toString();
        String text = json.split("\"text\":\"")[1].split("\"}")[0];
        
        // Если текста недостаточно, запрашиваем еще
        while (text.length() < charCount) {
            text += " " + getFishText(charCount - text.length());
        }
        
        return text.substring(0, Math.min(text.length(), charCount));
    }

    // Метод для расчета частоты символов
    private static Map<Character, Double> calculateFrequencies(String text) {
        Map<Character, Integer> charCounts = new HashMap<>();
        int totalLetters = 0;
        
        // Подсчитываем количество каждого символа
        for (char c : text.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                totalLetters++;
            }
        }
        
        // Рассчитываем частоту
        Map<Character, Double> frequencies = new HashMap<>();
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            frequencies.put(entry.getKey(), (double) entry.getValue() / totalLetters);
        }
        
        return frequencies;
    }

    // Метод для расшифровки шифра Цезаря
    private static String decryptCaesarCipher(String encryptedText, Map<Character, Double> referenceFrequencies) {
        // Попробуем все возможные сдвиги (1-33 для русского алфавита)
        int bestShift = 0;
        double bestScore = Double.NEGATIVE_INFINITY;
        
        for (int shift = 1; shift <= 33; shift++) {
            String candidate = applyShift(encryptedText, -shift);
            double score = calculateFrequencyScore(candidate, referenceFrequencies);
            
            if (score > bestScore) {
                bestScore = score;
                bestShift = shift;
            }
        }
        
        return applyShift(encryptedText, -bestShift);
    }

    // Применяем сдвиг к тексту
    private static String applyShift(String text, int shift) {
        StringBuilder result = new StringBuilder();
        
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'а' : 'А';
                int originalAlphabetPosition = c - base;
                int newAlphabetPosition = (originalAlphabetPosition + shift) % 33;
                if (newAlphabetPosition < 0) {
                    newAlphabetPosition += 33;
                }
                char newChar = (char) (base + newAlphabetPosition);
                result.append(newChar);
            } else {
                result.append(c);
            }
        }
        
        return result.toString();
    }

    // Рассчитываем оценку соответствия частотам
    private static double calculateFrequencyScore(String text, Map<Character, Double> referenceFrequencies) {
        Map<Character, Double> textFrequencies = calculateFrequencies(text);
        double score = 0.0;
        
        for (Map.Entry<Character, Double> entry : referenceFrequencies.entrySet()) {
            char c = entry.getKey();
            double referenceFreq = entry.getValue();
            double textFreq = textFrequencies.getOrDefault(c, 0.0);
            score += referenceFreq * textFreq;
        }
        
        return score;
    }
}