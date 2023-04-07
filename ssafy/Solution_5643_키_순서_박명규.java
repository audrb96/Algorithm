package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키_순서_박명규 {
    static int T,N,M,count;
    static int[][] adjMatrix;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            M = Integer.parseInt(br.readLine());
            adjMatrix = new int[N+1][N+1];
            count = 0;
            for(int i =0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                adjMatrix[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
            }
            for(int i = 1;i<=N;i++){
                search(i);
            }
            sb.append("#").append(tc).append(" ").append(count).append("\n");
        }
        System.out.print(sb);
    }

    private static void search(int i) {
        if(N-1 == backBfs(i) + bfs(i)) count ++;
    }

    private static int backBfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        boolean[] isVisited = new boolean[N+1];
        queue.add(start);
        isVisited[start] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(int i =1;i<=N;i++){
                if(adjMatrix[i][temp] == 0 || isVisited[i]) continue;
                queue.add(i);
                cnt++;
                isVisited[i] = true;
            }
        }
        return cnt;
    }

    private static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int cnt = 0;
        boolean[] isVisited = new boolean[N+1];
        queue.add(start);
        isVisited[start] = true;
        while (!queue.isEmpty()){
            int temp = queue.poll();
            for(int i =1;i<=N;i++){
                if(adjMatrix[temp][i] == 0 || isVisited[i]) continue;
                queue.add(i);
                cnt++;
                isVisited[i] = true;
            }
        }
        return cnt;
    }
}
