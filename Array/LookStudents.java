package Array;

import java.util.Scanner;

public class LookStudents {
    public int solution(int[] arr){
        int Max = 0;
        int answer = 0;
        for (int j : arr) {
            if (Max < j) {
                answer++;
                Max = j;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        LookStudents T = new LookStudents();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i]= sc.nextInt();
        }
        System.out.println(T.solution(arr));


    }
}
