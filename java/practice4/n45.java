import java.util.Scanner;

public class n45 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Введите число от 1 до 10000: ");
        int arNumber = scanner.nextInt();
        
        String rNumber = convertToRoman(arNumber);
        System.out.println(arNumber + " = " + rNumber);
        
        scanner.close();
    }

    public static String convertToRoman(int num) {
        if (num < 1 || num >= 10000) {
            return "Ошибка: число должно быть от 1 до 10000!";
        }

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
