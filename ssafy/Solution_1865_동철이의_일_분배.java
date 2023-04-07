package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1865_동철이의_일_분배 {
    static int T,N;
    static double[][] work;
    static double max;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for(int tc =1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            max = Double.MIN_VALUE;
            isVisited = new boolean[N];
            work = new double[N][N];
            for(int i =0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++) {
                    work[i][j] = Double.parseDouble(st.nextToken())/100;
                }
            }
            dfs(0,1);
            sb.append("#").append(tc).append(" ").append(String.format("%6f",Math.round(max*100*1000000)/1000000.0)).append("\n");
        }
        System.out.println(sb);
    }

    private static void dfs(int cnt,double possible) {
    if(cnt == N) {
        max = Math.max(max, possible);
        return;
    }

    if(possible < max) {
        return;
    }

    for(int i =0;i<N;i++) {
        if(isVisited[i]) continue;
        isVisited[i] = true;
        dfs(cnt+1,possible*work[cnt][i]);
        isVisited[i] = false;
    }

    }
}
