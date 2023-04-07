package ssafy_live;

import java.util.Scanner;

public class SubSetSumTest {
    static int N,S,ans;
    static  boolean[] isSelected;
    static int[] input;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        S = sc.nextInt();
        input = new int[N];
        isSelected = new boolean[N];
        ans = 0;
        for(int i =0;i<N;i++){
            input[i] = sc.nextInt();
        }

        generateSubset(0);
        System.out.println(ans);
    }
    public static void generateSubset(int cnt){
        if(cnt==N){

            int sum = 0;
            int elementCnt = 0;
            for(int i =0;i<N;i++){
                if(isSelected[i]) {
                    sum+= input[i];
                    elementCnt++;
                }
            }

            if(sum == S && elementCnt>0) {
                ++ans;
                for (int i = 0; i < N; i++) {
                    System.out.print(isSelected[i] ? input[i]+" " : "");
                }
                System.out.println();
            }
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt+1);
        isSelected[cnt] = false;
        generateSubset(cnt+1);

    }
}
