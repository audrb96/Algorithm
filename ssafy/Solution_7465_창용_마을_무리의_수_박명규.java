package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
//dfs
public class Solution_7465_창용_마을_무리의_수_박명규 {
    static int N,M;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int cnt = 0;
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int[][] matrix = new int[N+1][N+1];
            isVisited = new boolean[N+1];
            for(int i =0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                matrix[from][to] = 1;
                matrix[to][from] = 1;
            }
            for(int i =1;i<N+1;i++){
                if(isVisited[i]) continue;
                cnt++;
                dfs(matrix,i);
            }
            sb.append("#").append(tc).append(" ").append(cnt).append("\n");
        }
        System.out.print(sb);
    }
    public static void dfs(int[][] matrix, int current){
        isVisited[current] = true;

        for(int i =1;i<N+1;i++){
            if(isVisited[i] || matrix[current][i]==0 ) continue;
            dfs(matrix,i);
        }
    }
}
