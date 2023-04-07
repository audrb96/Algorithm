package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BigNum {
    public List<Integer> solution(int[] arr){
        List<Integer> answer = new ArrayList<>();
        answer.add(arr[0]);
        for(int i =1;i<arr.length;i++){
            if(arr[i-1]<arr[i]){
                answer.add(arr[i]);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BigNum T = new BigNum();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i =0;i<N;i++){
            arr[i] = sc.nextInt();
        }
        List<Integer> answer = T.solution(arr);

        for(int i =0;i<answer.size();i++){
            System.out.print(answer.get(i)+" ");
        }

    }
}
