package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//dfs (백트래킹)
public class Main_1681_해밀턴_순환회로_박명규 {
    static int N;
    static int[][] adjMatrix;
    static int min = Integer.MAX_VALUE;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        adjMatrix = new int[N][N];
        isVisited = new boolean[N];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0,0,0);
        System.out.println(min);
    }
    public static void dfs(int cnt,int cost,int current){
        if(min <= cost) return;
        if(cnt ==N-1){
            if(adjMatrix[current][0] != 0){
                min = Math.min(min,cost+adjMatrix[current][0]);
            }
            return;
        }

        isVisited[current] = true;

        for(int i=0;i<N;i++){
            if(isVisited[i] || adjMatrix[current][i]==0) continue;
            dfs(cnt+1,cost+adjMatrix[current][i],i);
            isVisited[i] = false;
        }
    }
}
