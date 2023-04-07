package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16236_아기상어_박명규 {

    static int N;
    static int curX;
    static int curY;
    static int[][] area;
    static int weight;
    static int[] dx = {0,-1,1,0};
    static int[] dy = {-1,0,0,1};
    static boolean[][] isVisited;
    static int min;
    static int minX;
    static int minY;
    static int time = 0;
    static int eat = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        weight = 2;
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<N;j++){
                int temp = Integer.parseInt(st.nextToken());
                area[i][j] = temp;

                if(temp == 9){
                    curX = j;
                    curY = i;
                }
            }
        }
        area[curY][curX] = 0;
       Solution();
        System.out.println(time);

    }


    public static void Solution() {
        Queue<int[]> queue = new LinkedList<>();
        while (true) {
            boolean find = false;
            isVisited = new boolean[N][N];
            min = Integer.MAX_VALUE;
            minX = Integer.MAX_VALUE;
            minY = Integer.MAX_VALUE;
            queue.add(new int[]{curX, curY, 0});

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                for (int i = 0; i < 4; i++) {
                    int nx = temp[0] + dx[i];
                    int ny = temp[1] + dy[i];
                    if (nx > N - 1 || nx < 0 || ny > N - 1 || ny < 0) continue;
                    if (area[ny][nx] > weight || isVisited[ny][nx] || min<temp[2]) continue;
                    isVisited[ny][nx] = true;
                    queue.add(new int[]{nx, ny, temp[2] + 1});
                    if(area[ny][nx] != 0 && area[ny][nx] != weight){
                        find = true;
                        if(min > temp[2]+1){
                            min = temp[2]+1;
                            minX = nx;
                            minY = ny;
                        }
                        else if(min == temp[2]+1){
                            if(minY > ny){
                                minX = nx;
                                minY = ny;
                            }
                            else if(minY == ny){
                                if(minX>nx){
                                    minX = nx;
                                    minY = ny;
                                }
                            }
                        }
                    }
                }
            }
            if(find){
                eat++;
                curX = minX;
                curY = minY;

                time += min;
                area[curY][curX] = 0;

                if(eat == weight){
                    eat=0;
                    weight++;
                }
            }
            else break;
        }
    }


}
