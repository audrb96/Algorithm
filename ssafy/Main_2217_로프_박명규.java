package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2217_로프_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int max = Integer.MIN_VALUE;
        for(int i =0;i<N;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        int i =N-1;
        int count = 1;
        Arrays.sort(arr);

        while (true){
            int temp = arr[i]*count;
            max = Math.max(temp,max);
            i--;
            count++;
            if(i<0) break;
        }
        System.out.println(max);
    }
}
