package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1149_RGB거리_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[][] DP = new int[N+1][3];
        st = new StringTokenizer(br.readLine());
        DP[1][0] = Integer.parseInt(st.nextToken());
        DP[1][1] = Integer.parseInt(st.nextToken());
        DP[1][2] = Integer.parseInt(st.nextToken());


        for(int i =2;i<=N;i++){
            st= new StringTokenizer(br.readLine());
            DP[i][0] = Math.min(DP[i-1][1],DP[i-1][2]) + Integer.parseInt(st.nextToken());
            DP[i][1] = Math.min(DP[i-1][0],DP[i-1][2]) + Integer.parseInt(st.nextToken());
            DP[i][2] = Math.min(DP[i-1][0],DP[i-1][1]) + Integer.parseInt(st.nextToken());
        }

        System.out.println(Math.min(Math.min(DP[N][0],DP[N][1]),DP[N][2]));
    }
}
