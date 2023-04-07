package Array;

import java.util.Scanner;

public class GradeSet {
    public int[] solution(int[] arr){
        int[] answer = new int[arr.length];
        for(int i = 0; i< arr.length;i++){
            int count = 1;
            for (int k : arr) {
                if (arr[i] < k)
                    count++;
            }
            answer[i] = count;
        }
        return answer;
    }
    public static void main(String[] args) {
        GradeSet T = new GradeSet();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0; i<N;i++){
            arr[i] = sc.nextInt();
        }
        int[] answer = T.solution(arr);
        for (int i : answer) {
            System.out.print(i+" ");
        }
    }
}
