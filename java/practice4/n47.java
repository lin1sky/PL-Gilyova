import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class n47 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите N: ");
        int N = scanner.nextInt();
        
        int size = (int) Math.ceil(Math.sqrt(N));
        int[][] matrix = generateRandomMatrix(size, N);
        
        System.out.println("Исходная матрица:");
        printMatrix(matrix);
        
        int[] snailSorted = snailSort(matrix);
        System.out.println("Результат сортировки змейкой:");
        System.out.println(Arrays.toString(snailSorted));
    }
    
    public static int[][] generateRandomMatrix(int size, int N) {
        int[][] matrix = new int[size][size];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int row = i / size;
            int col = i % size;
            matrix[row][col] = random.nextInt(100);
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static int[] snailSort(int[][] matrix) {
        int n = matrix.length;
        if (n == 0) return new int[0];
        
        int[] result = new int[n * n];
        int index = 0;
        int top = 0, bottom = n - 1, left = 0, right = n - 1;
        
        while (top <= bottom && left <= right) {
            for (int i = left; i <= right; i++) {
                result[index++] = matrix[top][i];
            }
            top++;
            
            for (int i = top; i <= bottom; i++) {
                result[index++] = matrix[i][right];
            }
            right--;
            
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result[index++] = matrix[bottom][i];
                }
                bottom--;
            }
            
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result[index++] = matrix[i][left];
                }
                left++;
            }
        }
        return result;
    }
}
