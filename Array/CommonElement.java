package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class CommonElement {
    //two pointers Algorithm
    public void solution(int[] a, int[] b, int N,int M){
        List<Integer> answer = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;
        Arrays.sort(a);
        Arrays.sort(b);
        while (p1<N&& p2<M){
            if(a[p1]<b[p2]) p1++;
            else if(a[p1]>b[p2]) p2++;
            else {
                answer.add(a[p1]);
                p1++;
                p2++;
            }
        }
        for (Integer integer : answer) {
            System.out.print(integer+" ");
        }

    }

    public static void main(String[] args) {
        CommonElement T = new CommonElement();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] a = new int[N];
        for(int i =0;i<a.length;i++){
            a[i] = sc.nextInt();
        }
        int M = sc.nextInt();
        int[] b = new int[M];
        for(int i =0;i<b.length;i++)
        {
            b[i] = sc.nextInt();
        }
        T.solution(a,b,N,M);
    }
}
