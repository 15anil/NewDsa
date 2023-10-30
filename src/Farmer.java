import java.util.Scanner;

public class Farmer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int sum = 0;
        int land = 0;
        for(int i=1;i<=n;i++){
            land = land^i;
            sum = sum + land;
        }
        System.out.println(sum);

    }
}
