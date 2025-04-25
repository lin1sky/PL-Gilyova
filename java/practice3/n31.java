import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class n31 {
    private static int maxSum = -1;

    public static void main(String[] args) {
        List<Integer> distances = Arrays.asList(50, 55, 57, 58, 60);
        int maxDistance = 175;
        int citiesToVisit = 3;

        Integer result = chooseBestSum(maxDistance, citiesToVisit, distances);
        System.out.println(result != null ? result : "Невозможно найти подходящий маршрут");
    }

    public static Integer chooseBestSum(int maxDistance, int citiesToVisit, List<Integer> distances) {
        maxSum = -1;
        generateCombinations(distances, citiesToVisit, 0, new ArrayList<>(), maxDistance);
        return maxSum == -1 ? null : maxSum;
    }

    private static void generateCombinations(List<Integer> distances, int k, int start, List<Integer> current, int maxDistance) {
        if (current.size() == k) {
            int sum = current.stream().mapToInt(Integer::intValue).sum();
            if (sum <= maxDistance && sum > maxSum) {
                maxSum = sum;
            }
            return;
        }

        for (int i = start; i < distances.size(); i++) {
            current.add(distances.get(i));
            generateCombinations(distances, k, i + 1, current, maxDistance);
            current.remove(current.size() - 1);
        }
    }
}