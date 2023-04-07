package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2491_수열_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int incCnt=1;
        int decCnt = 1;
        int max = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }
        for(int i =0;i<N-1;i++){
            //연속해서 증가하는 경우
            if(arr[i]<=arr[i+1]) incCnt++;
            else incCnt = 1;
           max = Math.max(max,incCnt);
            }
        for(int i =0;i<N-1;i++){
            //연속해서 감소하는 경우
            if(arr[i]>=arr[i+1]) decCnt++;
            else decCnt = 1;
            max = Math.max(max,decCnt);
        }
        System.out.println(max);
         }
    }
