import java.util.Scanner;

public class n46 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите римское число (I до MMMMMMMMCMXCIX): ");
        String rNumber = scanner.nextLine().toUpperCase();
        scanner.close();

        int arNumber = convertToArabic(rNumber);
        if (arNumber == -1) {
            System.out.println("Ошибка: Недопустимый символ в римском числе");
        } else if (arNumber == -2) {
            System.out.println("Ошибка: Некорректная запись римского числа");
        } else if (arNumber <= 0 || arNumber >= 10000) {
            System.out.println("Число должно быть в диапазоне 1-9999");
        } else {
            System.out.println(rNumber + " -> " + arNumber);
        }
    }

    public static int convertToArabic(String roman) {
        int result = 0;
        int prevValue = 0;
        
        for (int i = roman.length() - 1; i >= 0; i--) {
            char c = roman.charAt(i);
            int currValue = 0;
            
            switch (c) {
                case 'I': currValue = 1; break;
                case 'V': currValue = 5; break;
                case 'X': currValue = 10; break;
                case 'L': currValue = 50; break;
                case 'C': currValue = 100; break;
                case 'D': currValue = 500; break;
                case 'M': currValue = 1000; break;
                default: return -1; // Недопустимый символ
            }
            
            if (currValue < prevValue) {
                result -= currValue;
            } else {
                result += currValue;
            }
            prevValue = currValue;
        }
        
        if (!roman.equals(convertToRoman(result))) {
            return -2; // Некорректная запись числа
        }
        
        return result;
    }
    public static String convertToRoman(int num) {
        String[] thousands = {"", "M", "MM", "MMM", "MMMM", "MMMMM", 
                             "MMMMMM", "MMMMMMM", "MMMMMMMM", "MMMMMMMMM"};
        String[] hundreds = {"", "C", "CC", "CCC", "CD", "D", 
                            "DC", "DCC", "DCCC", "CM"};
        String[] tens = {"", "X", "XX", "XXX", "XL", "L", 
                        "LX", "LXX", "LXXX", "XC"};
        String[] ones = {"", "I", "II", "III", "IV", "V", 
                        "VI", "VII", "VIII", "IX"};

        return thousands[num / 1000] + hundreds[(num % 1000) / 100] + tens[(num % 100) / 10] + ones[num % 10];
    }
}
