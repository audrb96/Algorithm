package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1012_유기농_배추_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};

        int T = Integer.parseInt(br.readLine());

        for(int tc =1; tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int ans = 0;

            int[][] arr = new int[N][M];

            for(int i =0;i<K;i++){
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                arr[Y][X] = 1;
            }

            for(int i =0;i<N;i++){
                for(int j=0;j<M;j++){
                    if(arr[i][j] == 0 ) continue;
                    ans++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    arr[i][j] = 0;

                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int d = 0;d<4;d++){
                            int nx = temp[1] + dx[d];
                            int ny = temp[0] + dy[d];
                            if(nx>M-1 || nx<0 || ny>N-1 || ny<0 || arr[ny][nx] == 0) continue;
                            queue.add(new int[]{ny,nx});
                            arr[ny][nx] = 0;
                        }
                    }
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb);
    }
}
