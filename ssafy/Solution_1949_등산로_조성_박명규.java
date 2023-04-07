package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1949_등산로_조성_박명규 {
    static int T,N,K,max;
    static int[][] map;
    static int highest;
    static int[] maxIndex;
    static int[] dc = {-1,0,1,0};
    static int[] dr = {0,-1,0,1};
    static ArrayList<int[]> highestArray;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for(int tc= 1;tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            max = Integer.MIN_VALUE;
            maxIndex = new int[2];
            highest = Integer.MIN_VALUE;
            highestArray = new ArrayList<>();
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<N;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(highest < map[i][j]) {
                        highest = map[i][j];
                        maxIndex[0] = i;
                        maxIndex[1] = j;
                    }
                }
            }

            for(int k = 0; k<N;k++){
                for(int q = 0; q<N;q++){
                    if(highest ==  map[k][q]) {
                        highestArray.add(new int[]{k,q});
                    }
                }
            }

            for(int i =0;i<=K;i++){
                for(int r = 0;r<N;r++){
                    for(int c=0;c<N;c++){
                        map[r][c] -= i;
                        bfs();
                        map[r][c] += i;
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }

    private static void bfs() {
        for(int i =0;i<highestArray.size();i++){
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{highestArray.get(i)[0], highestArray.get(i)[1] ,1});

            while (!queue.isEmpty()) {
                int[] temp = queue.poll();

                for(int d = 0; d<4;d++){
                    int nr = temp[0] + dr[d];
                    int nc = temp[1] + dc[d];
                    if(nr > N-1 || nc > N-1 || nr<0 || nc<0|| map[nr][nc] >= map[temp[0]][temp[1]]) continue;
                    queue.add(new int[]{nr,nc,temp[2]+1});
                    max = Math.max(max,temp[2]+1);
                }
            }
        }


    }
}
