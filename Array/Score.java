package Array;

import java.util.Scanner;

public class Score {
    public int solution(int[] arr){
        int count = 0;
        int sum = 0;
        for (int j : arr) {
            if (j == 0) {
                count = 0;
            } else {
                count++;
                sum += count;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Score T = new Score();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        System.out.println(T.solution(arr));
    }
}
