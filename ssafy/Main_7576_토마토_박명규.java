package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576_토마토_박명규 {
    //BFS
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][M];
        int[] dx = {0,0,-1,1};
        int[] dy = {-1,1,0,0};
        int max = 0;
        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i =0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                if(area[i][j] == 1) queue.add(new int[]{i,j,0});
                if(area[i][j] == 0) cnt++;
            }
        }

        while (!queue.isEmpty()){
            int[] temp  = queue.poll();
            for(int i =0;i<4;i++){
                int ny = temp[0] + dy[i];
                int nx = temp[1] + dx[i];
                if(ny<0||ny>N-1||nx<0||nx>M-1||area[ny][nx]==-1||area[ny][nx]==1) continue;
                cnt--;
                area[ny][nx] = 1;
                queue.add(new int[]{ny,nx,temp[2]+1});
                max = Math.max(max,temp[2]+1);
            }
            if(cnt==0) break;
        }

        if(cnt != 0) max = -1;
        System.out.println(max);
    }
}
