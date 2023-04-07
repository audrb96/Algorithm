package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468_안전_영역_박명규 {
    static int N;
    static boolean[][] isVisited;
    static int maxHeight;
    static int dx[] = {0,0,-1,1};
    static int dy[] = {-1,1,0,0};
    static int[][] area;
    static int count;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        ans = Integer.MIN_VALUE;
        maxHeight = Integer.MIN_VALUE;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                area[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight,area[i][j]);
            }
        }

        for(int h = 0;h<= maxHeight;h++){
            isVisited = new boolean[N][N];
            count = 0;
            for(int i =0;i<N;i++){
                for(int j=0;j<N;j++){
                    if(isVisited[i][j] || area[i][j] <= h) continue;
                    count++;
                    Queue<int[]> queue = new LinkedList<>();
                    queue.add(new int[]{i,j});
                    isVisited[i][j] = true;

                    while (!queue.isEmpty()){
                        int[] temp = queue.poll();
                        for(int d = 0;d<4;d++){
                            int nx = temp[1] + dx[d];
                            int ny = temp[0] + dy[d];
                            if(nx>N-1||nx<0||ny>N-1||ny<0|| area[ny][nx] <= h|| isVisited[ny][nx]) continue;
                            isVisited[ny][nx] = true;
                            queue.add(new int[]{ny,nx});
                        }
                    }
                }
            }
            ans = Math.max(ans,count);
        }
        System.out.println(ans);
    }
}
