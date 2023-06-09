package ssafy_live;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DijkstraTest1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int V = Integer.parseInt(br.readLine());

        int[][] adjMatrix = new int[V][V];
        int start = 0;

        for(int i =0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<V;j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] distance = new int[V];
        boolean[] visited = new boolean[V];

        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[start] = 0;
        visited[start] = true;
        int min =0,current = 0;
        for(int i =0;i<V;i++){
            //단계1 : 최소비용이 확정되지 않은 정점중 최소비용의 정점 선택
            for (int j=0;j<V;j++){
                if(!visited[j] && min>distance[j]){
                    min = distance[j];
                    current = j;
                }
            }
            visited[current] = true;
            //단계2 : 선택된 정점을 경유지로 하여 아직 최소비용이 확정되지 않은 다른 정점의 최소비용을 고려
            for(int j=0;j<V;j++){
                if(!visited[j] && adjMatrix[current][j] != 0 && distance[j] > distance[current] + adjMatrix[current][j]){
                    distance[j] = distance[current] + adjMatrix[current][j];
                }
            }
        }
        System.out.println(Arrays.toString(distance));
    }


}
