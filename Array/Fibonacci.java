package Array;

import java.util.Scanner;

public class Fibonacci {
    public int[] solution(int N){
        int[] answer = new int[N];
        for(int i =0; i<N;i++){
            if(i==0 || i==1){
                answer[i] = 1;
                continue;
            }
            answer[i] = answer[i-1]+answer[i-2];
        }
        return answer;
    }
    public static void main(String[] args) {
        Fibonacci T = new Fibonacci();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] answer = T.solution(N);
        for (int i : answer) {
            System.out.print(i + " ");
        }
    }
}
