package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2606_바이러스_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int ans = 0;
        boolean[] isVisited = new boolean[N+1];
        int[][] arr = new int[N+1][N+1];

        for(int i =0;i<K;i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        isVisited[1] = true;

        while (!queue.isEmpty()){
            int temp = queue.poll();

            for(int i =1;i<N+1;i++){
                if(arr[temp][i]!=1 || isVisited[i]) continue;
                queue.add(i);
                isVisited[i] = true;
                ans++;
            }
        }
        System.out.println(ans);

    }
}
