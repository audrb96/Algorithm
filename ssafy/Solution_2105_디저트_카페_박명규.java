package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_2105_디저트_카페_박명규 {
    static int T,N,ans,startR,startC;
    static int[][] map;
    static int[] dr = {1,1,-1,-1};
    static int[] dc = {1,-1,-1,1};
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine());
        for(int tc = 1;tc<=T; tc++){
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            set = new HashSet<>();
            startR = 0;
            startC = 0;
            ans = -1;
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i =0;i<N;i++){
                for(int j =0;j<N;j++){
                    set.clear();
                    set.add(map[i][j]);
                    startC = j;
                    startR = i;
                    dfs(i,j,-1,-1,0);
                }
            }

            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
        }

    private static void dfs(int i, int j,int preR, int preC, int dir) {
        for(int d = dir ; d<4;d++){
            int nr = i + dr[d];
            int nc = j +dc[d];

            if(nr>N-1 || nc>N-1 || nr<0 || nc <0 ) continue;
            if(nr == preR && nc == preC) continue;
            if(nr == startR && nc == startC ){
                ans = Math.max(ans, set.size());
                return;
            }
            if(set.contains(map[nr][nc])) continue;
            set.add(map[nr][nc]);
            dfs(nr,nc,i,j, d);
            set.remove(map[nr][nc]);

    }


}
}
