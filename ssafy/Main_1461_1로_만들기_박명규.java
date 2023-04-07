package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1461_1로_만들기_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] DP = new int[N+3];
        DP[1] = 0;
        DP[2] = 1;
        DP[3] = 1;

        for(int i =4;i<=N;i++){
            int min = Integer.MAX_VALUE;
            if(i%3==0){
                min = DP[i/3] + 1;
            }
            if(i % 2 == 0) {
                min = Math.min(min,DP[i/2]+1);
            }
            min = Math.min(min,DP[i-1]+1);

            DP[i] = min;
        }
        System.out.println(DP[N]);
    }
}
