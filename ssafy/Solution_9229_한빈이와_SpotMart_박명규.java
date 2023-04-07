package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//조합
public class Solution_9229_한빈이와_SpotMart_박명규 {
    static int max = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int testCase = 1;
        while (T-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N =Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int[] arr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            solution(0,0,arr,N,M,0);
            System.out.println("#"+testCase++ + " " + max);
            max = -1;

        }
    }

    public static void solution(int cnt,int start,int arr[],int N,int M,int weight){
        if(weight>M){
            return;
        }
        if(cnt==2){
            if(max<weight)
                max = weight;
            return;
        }
        for(int i =start;i<N;i++){
            solution(cnt+1,i+1,arr,N,M,weight+arr[i]);
        }
    }
}
