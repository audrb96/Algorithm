package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈_박명규 {
    static int N,M;
    static int[][] matrix;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        matrix = new int[N][M];
        visited = new boolean[N][M];

        int sum =0;
        for(int i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++) {
                matrix[i][k] = Integer.parseInt(st.nextToken());
                if(matrix[i][k] == 1)	sum++;
            }
        }

        int time = 0;
        while(true) {
            time++;
            Queue<int[]> queue = new LinkedList<int[]>();
            queue.add(new int[] {0,0});
            for(int i=0;i<N;i++) {
                for(int k=0;k<M;k++) {
                    visited[i][k] = false;
                }
            }
            //2인거를 0으로 바꿔줘야함.

            int count = 0;
            //새로운 2를 찾아서..
            while(!queue.isEmpty()) {
                int [] temp = queue.poll();
                int r = temp[0];
                int c = temp[1];
                for(int i=0;i<4;i++) {
                    int nr = r+dr[i];
                    int nc = c+dc[i];
                    if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc]) {
                        if(matrix[nr][nc] == 0) {
                            queue.add(new int[] {nr, nc});
                            visited[nr][nc] = true;
                        }
                        else {
                            matrix[nr][nc] = 2;
                            visited[nr][nc] = true;
                            count++;
                        }
                    }
                }
            }
            if(sum-count <= 0)	break;

            sum -= count;
            for(int i=0;i<N;i++) {
                for(int k=0;k<M;k++) {
                    if(matrix[i][k] == 2) {
                        matrix[i][k] = 0;
                    }
                }
            }
        }
        System.out.println(time);
        System.out.println(sum);
    }
}
