package Array;

import java.util.Scanner;

public class MaxSell {
    public int solution(int[] a,int N,int K){
        int p = 0;
        int sum = 0;
        int max;
        for(int i =0;i<K;i++){
            sum += a[i];   
        }
        max = sum;
        while (p+K<N){
            sum -= a[p];
            sum += a[p+K];
            if(max<sum) max = sum;
            p++;
        }
        return max;
    }
    public static void main(String[] args) {
        MaxSell T = new MaxSell();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] a = new int[N];
        for(int i=0;i<N;i++){
            a[i] = sc.nextInt();
        }
        System.out.println(T.solution(a,N,K));
    }
}
