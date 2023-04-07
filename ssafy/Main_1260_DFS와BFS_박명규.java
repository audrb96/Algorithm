package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
//DFS,BFS
public class Main_1260_DFS와BFS_박명규 {
    static int N,M,V;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N+1][N+1];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            matrix[from][to] = 1;
            matrix[to][from] = 1;
        }
        dfs(matrix,new boolean[N+1],V);
        System.out.println();
        bfs(matrix,V);
    }

    public static void bfs(int[][] matrix,int start){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[N+1];
        isVisited[start] = true;
        queue.offer(start);

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.print(current+" ");
            for(int i =1;i<N+1;i++){
                if(isVisited[i]||matrix[current][i]==0) continue;
                isVisited[i] = true;
                queue.offer(i);
            }
        }
    }

    public static void dfs(int[][] matrix,boolean[] isVisited,int current){
        isVisited[current] = true;
        System.out.print(current+" ");

        for(int i =1;i<N+1;i++){
            if(isVisited[i]||matrix[current][i]==0) continue;
            dfs(matrix,isVisited,i);
        }

    }
}
