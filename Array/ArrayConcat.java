package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ArrayConcat {
    //two pointers algorithm
    public void solution(int[] arr1, int[] arr2,int N,int M){
        List<Integer> answer = new ArrayList<>();
        int p1=0,p2=0;
        while (p1<N&&p2<M){
            if(arr1[p1]<arr2[p2])
                answer.add(arr1[p1++]);
            else answer.add(arr2[p2++]);
        }
        while (p1<N) answer.add(arr1[p1++]);
        while (p2<M) answer.add(arr2[p2++]);

        for (Integer integer : answer) {
            System.out.print(integer+" ");
        }

    }

    public static void main(String[] args) {
        ArrayConcat T = new ArrayConcat();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr1 = new int[N];
        for(int i =0;i<N;i++){
            arr1[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] arr2 = new int[M];
        for(int i =0;i<M;i++){
            arr2[i] = sc.nextInt();
        }
        T.solution(arr1,arr2,N,M);
    }
}
