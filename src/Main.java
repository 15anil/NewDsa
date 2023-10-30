import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static int findUniqueStones(int m, int n, int[] earthStones, int[] marsStones){
        Set<Integer> earthStonesSet = new HashSet<>();
        for (int stone : earthStones){
            earthStonesSet.add(stone);
        }

        int count = 0;

        for (int marsStone : marsStones){
            if (!earthStonesSet.contains(marsStone) && marsStone <= m){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the bag weight (input1): ");
        int m = scanner.nextInt();

        System.out.println("Enter the number of earth stones (input2): ");
        int n = scanner.nextInt();
        int[] earthStones = new int[n];

        System.out.println("Enter the weights of earth stones (input3): ");
        for (int i = 0; i < n; i++){
            earthStones[i] = scanner.nextInt();
        }

        int[] marsStones = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; // Mars stones (arr2)

        int result = findUniqueStones(m, n, earthStones, marsStones);
        System.out.println("Number of unique stones Rob can bring from Mars: " + result);

        scanner.close();
    }
}
