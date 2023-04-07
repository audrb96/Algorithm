package ssafy_live;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjMatrixTest {
    static int N;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int C = sc.nextInt();

        int[][] adjMatrix = new int[N][N];

        for(int i =0;i<C;i++){
            int from = sc.nextInt();
            int to = sc.nextInt();

            adjMatrix[from][to] = adjMatrix[to][from] = 1;
        }
//        for (int[] matrix : adjMatrix) {
//            System.out.println(Arrays.toString(matrix));
//        }
//        bfs(0,adjMatrix);
        dfs(adjMatrix,new boolean[N],0);
    }

    public static void bfs(int start,int[][] adjMatrix){
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[N];

        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current);

            //current 정점의 인접정점 처리(단, 방문하지 않은 인접정점만)
            for (int i = 0; i < N; i++) {
                if(!visited[i] && adjMatrix[current][i]>0){
                 queue.offer(i);
                 visited[i] = true;
                }
            }

        }

    }

    public static void dfs(int[][] adjMatrix, boolean[] visited,int current){
        visited[current] = true;
        System.out.println(current);

        for (int i = 0; i < N; i++) {
            if(!visited[i] && adjMatrix[current][i]>0){
               dfs(adjMatrix,visited,i);
            }
        }


    }
}
