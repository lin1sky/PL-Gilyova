import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class n37 {
    private static final int CODE_LENGTH = 4;
    private static final int MAX_ATTEMPTS = 20;
    private static final int MAX_NUMBER = 9; // числа от 0 до 9

    private int[] secretCode;
    private Random random;
    private Scanner scanner;

    public n37() {
        random = new Random();
        scanner = new Scanner(System.in);
        generateSecretCode();
    }

    private void generateSecretCode() {
        secretCode = new int[CODE_LENGTH];
        for (int i = 0; i < CODE_LENGTH; i++) {
            secretCode[i] = random.nextInt(MAX_NUMBER + 1);
        }
    }

    private int checkGuess(int[] guess) {
        int matches = 0;
        
        // Создаем копии, чтобы не изменять оригинальные массивы
        int[] secretCopy = Arrays.copyOf(secretCode, CODE_LENGTH);
        int[] guessCopy = Arrays.copyOf(guess, CODE_LENGTH);
        
        // Проверяем совпадения по позициям
        for (int i = 0; i < CODE_LENGTH; i++) {
            if (secretCopy[i] == guessCopy[i]) {
                matches++;
                secretCopy[i] = -1; // помечаем как проверенное
                guessCopy[i] = -2; // другое значение для исключения повторного подсчета
            }
        }
        return matches;
    }

    private int[] getGuessFromUser() {
        int[] guess = new int[CODE_LENGTH];
        System.out.print("Введите ваш вариант кода (4 числа через пробел): ");
        
        for (int i = 0; i < CODE_LENGTH; i++) {
            guess[i] = scanner.nextInt();
        }
        return guess;
    }

    public void play() {
        System.out.println("Угадайте 4-значный код, состоящий из цифр 0-9.");
        System.out.println("У вас есть " + MAX_ATTEMPTS + " попыток.");
        System.out.println("После каждой попытки я скажу, сколько цифр совпало.");
        
        boolean solved = false;
        int attempts = 0;
        
        while (!solved && attempts < MAX_ATTEMPTS) {
            attempts++;
            System.out.println("\nПопытка #" + attempts);
            
            int[] guess = getGuessFromUser();
            int matches = checkGuess(guess);
            
            System.out.println("Совпадений: " + matches);
            
            if (matches == CODE_LENGTH) {
                solved = true;
                System.out.println("Поздравляю! Вы угадали код за " + attempts + " попыток!");
                System.out.println("Загаданный код: " + Arrays.toString(secretCode));
            }
        }
        
        if (!solved) {
            System.out.println("\nК сожалению, вы не угадали код за " + MAX_ATTEMPTS + " попыток.");
            System.out.println("Загаданный код был: " + Arrays.toString(secretCode));
        }
    }

    public static void main(String[] args) {
        n37 game = new n37();
        game.play();
    }
}