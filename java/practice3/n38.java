import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class n38 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество игроков: ");
        int numPlayers = scanner.nextInt();

        System.out.print("Введите номер игрока, с которого начинается игра: ");
        int startPlayer = scanner.nextInt();

        List<Integer> eliminated = josephus(numPlayers, startPlayer);

        System.out.println("Список выбывших игроков (включая победителя): " + eliminated);
    }

    public static List<Integer> josephus(int numPlayers, int startPlayer) {
        List<Integer> players = new ArrayList<>();
        for (int i = 1; i <= numPlayers; i++) {
            players.add(i);
        }

        List<Integer> eliminated = new ArrayList<>();
        int currentIndex = startPlayer - 1; 

        while (players.size() > 1) {
            currentIndex = (currentIndex + 2) % players.size(); 
            eliminated.add(players.remove(currentIndex));
        }

        eliminated.add(players.get(0)); 
        return eliminated;
    }
}