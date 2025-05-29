import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n48 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите количество элементов x: ");
        int x = scanner.nextInt();

        List<Integer> u = new ArrayList<>();
        u.add(1); 

        int currentIndex = 0;
        while (u.size() < x) {
            int current = u.get(currentIndex);
            int y = 2 * current + 1;
            int z = 3 * current + 1;

            if (!u.contains(y)) {
                u.add(y);
            }
            
            if (!u.contains(z)) {
                u.add(z);
            }
            currentIndex++;
        }

        System.out.println("Последовательность u без дубликатов:");
        for (int i = 0; i < x; i++) {
            System.out.print(u.get(i) + " ");
        }
    }
}
