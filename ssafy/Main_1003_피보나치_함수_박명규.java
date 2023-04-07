package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1003_피보나치_함수_박명규 {
    static int T,N;
    static int[][] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        fibo = new int[41][2];

        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        for(int i = 2;i<=40;i++) {
            fibo[i][0] = fibo[i-1][0] + fibo[i-2][0];
            fibo[i][1] = fibo[i-1][1] + fibo[i-2][1];
        }

        for(int tc= 1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            sb.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
        }
        System.out.print(sb);
    }
}
