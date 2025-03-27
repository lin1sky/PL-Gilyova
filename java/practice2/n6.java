import java.util.Scanner;

public class n6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] memory = new int[3]; 
        int count = 0; // Количество заполненных ячеек
        
        while (true) {
            System.out.print("Введите число (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            
            try {
                int number = Integer.parseInt(input);
                
                if (count < 3) {  // Если есть свободные ячейки
                    memory[count] = number;
                    count++;
                    System.out.println("Добавлено число: " + number);
                }
                else { // Если нет свободных ячеек, ищем наименьшее число
                    int minIndex = 0;
                    for (int i = 1; i < 3; i++) {
                        if (memory[i] < memory[minIndex]) {
                            minIndex = i;
                        }
                    }
                    System.out.println("Заменяем наименьшее число " + memory[minIndex] + " на " + number);
                    memory[minIndex] = number;
                }
                
                // Выводим текущее состояние памяти
                System.out.print("Текущая ячейка памяти: [");
                for (int i = 0; i < count; i++) {
                    System.out.print(memory[i]);
                    if (i < count - 1) System.out.print(", ");
                }
                System.out.println("]");
            } 
            catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число или 'exit'");
            }
        }
        scanner.close();
    }
}