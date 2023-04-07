package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16926_배열_돌리기1_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int NM = Math.min(N,M)/2;
        int R = Integer.parseInt(st.nextToken());
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Queue<Integer> vQueue = new LinkedList<>();
        Queue<int []> iQueue = new LinkedList<>();
        int[][] ans = new int[N][M];
        int[][] arr = new int[N][M];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
//        R%((M-i*2)*2+(N-2-i*2)*2);
        boolean[][] isVisited = new boolean[N][M];
            for (int i = 0; i < NM; i++) {
              int curX = i;
              int curY = i;
              int d = 0;
              int circle = (M-i*2)*2+(N-2-i*2)*2-1;
              int circle2 = (M-i*2)*2+(N-2-i*2)*2;
              int rotate = R%((M-i*2)*2+(N-2-i*2)*2);
              vQueue.add(arr[i][i]);
              iQueue.add(new int[]{i,i});
              isVisited[i][i] = true;
              while (circle!=0){
                int nx = curX+dx[d];
                int ny = curY+dy[d];
                if(nx>M-1||ny>N-1||nx<0||ny<0||isVisited[ny][nx]){
                    d++;
                    d=d%4;
                    continue;
                }
                curX = nx;
                curY = ny;
                vQueue.add(arr[ny][nx]);
                iQueue.add(new int[]{ny,nx});
                isVisited[ny][nx] = true;
                circle--;
              }

              for(int j =0;j<rotate;j++){
                  vQueue.add(vQueue.poll());
              }

              for(int j=0;j<circle2;j++){
                  int[] index = iQueue.poll();
                  ans[index[0]][index[1]] = vQueue.poll();
              }
            }


        for (int[] ints : ans) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
