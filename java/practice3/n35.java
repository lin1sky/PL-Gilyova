import java.util.Arrays;
import java.util.Comparator;

public class n35 {
    public static void main(String[] args) {
        String input = "56 65 74 100 99 68 86 180 90";
        String[] weights = input.split(" ");
        
        Arrays.sort(weights, new Comparator<String>() {
            public int compare(String a, String b) {
                int sumA = sumOfDigits(a);
                int sumB = sumOfDigits(b);
                return Integer.compare(sumA, sumB);
            }
            
            private int sumOfDigits(String s) {
                int sum = 0;
                for (char c : s.toCharArray()) {
                    sum += Character.getNumericValue(c);
                }
                return sum;
            }
        });
        
        String result = String.join(" ", weights);
        System.out.println(result);
    }
}