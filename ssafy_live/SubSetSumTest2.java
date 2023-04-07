package ssafy_live;

import java.util.Scanner;

public class SubSetSumTest2 {
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

        generateSubset(0,0);
        System.out.println(ans);
    }
    public static void generateSubset(int cnt,int sum){ //cnt: 부분집합에 고려해야 하는 원서, 직전까지 고려한 원소 수
                                                        //sum: 직전까지 고려한 원소 합

        if(sum == S) {
            ++ans;
            for (int i = 0; i < N; i++) {
                System.out.print(isSelected[i] ? input[i]+" " : "");
            }
            System.out.println();
            return;
        }
        if(sum>S) return;
        if(cnt==N){
            return;
        }

        isSelected[cnt] = true;
        generateSubset(cnt+1,sum+input[cnt]);
        isSelected[cnt] = false;
        generateSubset(cnt+1,sum);

    }
}
