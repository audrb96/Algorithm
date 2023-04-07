package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_9205_맥주마시면서걸어가기_박명규 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[][] map = new int[N+2][2];
            boolean[] isVisited = new boolean[N+2];
            for(int i = 0 ; i < N + 2; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                map[i][0] = x;
                map[i][1] = y;
            }
            String ans = "sad";

            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(map[0]);
            isVisited[0] = true;

            while(!queue.isEmpty()) {
                int[] temp = queue.poll();

                if(temp[0] == map[N+1][0] && temp[1] == map[N+1][1]) {
                    ans = "happy";
                    break;
                }

                for(int i = 0; i < N+2; i++) {
                    if(isVisited[i])continue;
                    int dist = Math.abs(temp[0] - map[i][0]) + Math.abs(temp[1] - map[i][1]);
                    if(dist <= 1000) {
                        queue.add(map[i]);
                        isVisited[i] = true;
                    }
                }

            }

            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }

}
