import java.util.Scanner;

public class Meta {
    public static boolean isMeta(int num){
        return num%1 == 0 && num%2 == 0 && num%4 == 0 && num%8==0 && num%10!=0;
    }
    public static int countMetaNumbers(int n){
        int count = 0;
        for (int i=1;i<=n;i++){
            if (isMeta(i)){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the value of n: ");
        int n = scanner.nextInt();
        int result = countMetaNumbers(n);
        System.out.println("count is " + result);

    }
}
