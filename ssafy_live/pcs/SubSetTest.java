package ssafy_live.pcs;

import java.util.Scanner;

public class SubSetTest {
    static int N;;
    static  boolean[] isSelected;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];

        for(int i =0;i<N;i++){
            input[i] = sc.nextInt();
        }

        generateSubset(0);
    }
    public static void generateSubset(int cnt){
        if(cnt==N){
            for(int i =0;i<N;i++){
                System.out.print((isSelected[i]?input[i]:"X")+" ");
            }
            System.out.println();
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt+1);
        isSelected[cnt] = false;
        generateSubset(cnt+1);

    }
}
