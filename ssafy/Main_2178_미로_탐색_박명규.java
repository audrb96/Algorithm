package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178_미로_탐색_박명규 {
    static int min = Integer.MAX_VALUE;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] maze = new char[N][M];

        for(int i =0;i<N;i++){
            maze[i] = br.readLine().toCharArray();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0,1});
        maze[0][0] = '0';
        while (!queue.isEmpty()){
            int[] temp = queue.poll();
            for(int i =0;i<4;i++){
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];
                if(nx>M-1||nx<0||ny>N-1||ny<0||maze[ny][nx]=='0') continue;
                queue.add(new int[]{nx,ny,temp[2]+1});
                maze[ny][nx] = '0';
                if(nx==M-1&&ny==N-1&&(min>temp[2])){
                    min = temp[2]+1;
                }
            }
        }

        System.out.println(min);

    }
}
