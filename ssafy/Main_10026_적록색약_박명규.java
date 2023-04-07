package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
//BFS
public class Main_10026_적록색약_박명규 {
    static int N;
    static char[][] area;
    static boolean[][] isVisited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        area = new char[N][N];
        isVisited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().toCharArray();
        }
        System.out.print(bfs()+ " ");
        for(int i=0;i<N;i++){
            for(int j =0;j<N;j++){
                if(area[i][j] == 'G') area[i][j] = 'R';
            }
        }
        isVisited = new boolean[N][N];
        System.out.println(bfs());
    }

    public static int bfs(){
        int count = 0;
        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(isVisited[i][j]) continue;
                count++;
                char temp = area[i][j];
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i,j});
                while (!queue.isEmpty()){
                    int[] current = queue.poll();
                    for(int d = 0; d<4;d++){
                        int nx = current[1] + dx[d];
                        int ny = current[0] + dy[d];
                        if(nx>N-1||nx<0||ny>N-1||ny<0||area[ny][nx] != temp||isVisited[ny][nx]) continue;
                        isVisited[ny][nx] =true;
                        queue.add(new int[]{ny,nx});
                    }
                }
            }
        }
        return count;
    }

}
