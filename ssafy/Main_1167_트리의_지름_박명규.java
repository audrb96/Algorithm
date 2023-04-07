package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1167_트리의_지름_박명규 {
    static int V;
    static int[] max;
    static int[][] adjMatrix;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        V = Integer.parseInt(br.readLine());
        max = new int[2];
        Arrays.fill(max,Integer.MIN_VALUE);

        adjMatrix = new int[V+1][V+1];
        isVisited = new boolean[V+1];
        for(int i=0;i<V;i++){
            st = new StringTokenizer(br.readLine());
            int tempV = Integer.parseInt(st.nextToken());
            while (true) {
                int dest = Integer.parseInt(st.nextToken());
                if (dest == -1) break;
                int weight = Integer.parseInt(st.nextToken());
                adjMatrix[tempV][dest] = weight;
                adjMatrix[dest][tempV] = weight;
            }
        }

        dfs(0,0,1);

    }
    public static void dfs(int num,int sum,int startNum) {
        if(sum>max[num]){
            max[num] = sum;
        }

        for(int i =startNum;i<V;i++){

        }
    }
}
