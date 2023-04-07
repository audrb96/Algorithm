package Array;

import java.util.Scanner;

public class RockScissorsPaper {
    public String[] solution(int[] A, int[] B){
        String[] answer = new String[A.length];
        for(int i=0;i<answer.length;i++){
            if(A[i]==1 && B[i]==2) answer[i] = "B";
            if(A[i]==1 && B[i]==3) answer[i] = "A";
            if(A[i]==1 && B[i]==1) answer[i] = "D";
            if(A[i]==2 && B[i]==1) answer[i] = "A";
            if(A[i]==2 && B[i]==2) answer[i] = "D";
            if(A[i]==2 && B[i]==3) answer[i] = "B";
            if(A[i]==3 && B[i]==1) answer[i] = "B";
            if(A[i]==3 && B[i]==2) answer[i] = "A";
            if(A[i]==3 && B[i]==3) answer[i] = "D";
        }
        return answer;
    }
    public static void main(String[] args) {
        RockScissorsPaper T = new RockScissorsPaper();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int[] B = new int[N];

        for(int i =0;i <N;i++){
           A[i] =sc.nextInt();
        }
        for(int i =0;i <N;i++){
            B[i] =sc.nextInt();
        }
        String[] answer= T.solution(A,B);
        for (String s : answer) {
            System.out.println(s);
        }

    }
}
