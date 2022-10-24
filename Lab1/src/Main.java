import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int n;
        int max=0;
        int temp = 0;
        int count_u = 0;
        int count_v = 0;
        do{
            n = scanner.nextInt();
            if(temp < n || n == 0 || temp == 0){
                if(count_v>max){
                    max = count_v;
                    count_v = 0;
                }
                count_u++;
            }
            if(temp > n || n == 0 || temp == 0){
                if(count_u>=max){
                    max = count_u;
                    count_u = 0;
                }
                count_v++;
            }
            temp = n;
        }while (n != 0);
        System.out.println(max);
    }
}
