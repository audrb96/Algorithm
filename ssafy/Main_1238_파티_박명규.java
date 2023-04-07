package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1238_파티_박명규 {
    static int N,M,X,min;
    static boolean[] isVisited;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N+1][N+1];
        isVisited = new boolean[N+1];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            matrix[from][to] = t;
        }

        for(int i =1;i<N+1;i++){
            int sum = 0;
            min = Integer.MAX_VALUE;
            dfs(matrix,i,X,0);
            sum += min;
            min = Integer.MAX_VALUE;
            isVisited = new boolean[N+1];
            dfs(matrix,X,i,0);
            sum= sum+ min;
            max = Math.max(sum,max);
            isVisited = new boolean[N+1];
        }
        System.out.println(max);
    }
    public static void dfs(int[][] matrix,int current,int dest,int sum){
        if(current == dest ){
            min = Math.min(min,sum);
            return;
        }
        isVisited[current] = true;
        for(int i =1;i<N+1;i++){
            if(isVisited[i] || matrix[current][i] ==0 ) continue;
            dfs(matrix,i,dest,sum+matrix[current][i]);
        }

    }
}
