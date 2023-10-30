import java.util.Scanner;

public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int exp = scanner.nextInt();
        int fresher = scanner.nextInt();
        int ans = (exp+fresher)/4;
        if(ans<Math.min(exp,fresher)){
            System.out.println(ans);
        }else {
            System.out.println(Math.min(exp,fresher));
        }
    }
}
