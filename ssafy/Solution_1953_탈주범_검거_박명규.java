package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_1953_탈주범_검거_박명규 {
    static int T,R,C,L,N,M;
    static int[][] map;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static int[][] pipeDir = {{0,0,0,0},{0,1,2,3},{0,2},{1,3},{2,1},{0,1},{0,3},{2,3}};
    static boolean[][][] isPossible;
    static boolean[][] isVisited;
    static class Pipe {
        int x;
        int y;
        int kind;
        int time;

        public Pipe(int x, int y, int kind, int time) {
            this.x = x;
            this.y = y;
            this.kind = kind;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc<=T;tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            int count = 1;
            isPossible = new boolean[8][8][4];

            setPossible(isPossible);

            for(int i = 0; i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            isVisited = new boolean[N][M];

            Queue<Pipe> queue = new LinkedList<>();
            queue.add(new Pipe(C,R,map[R][C],1));
            isVisited[R][C] = true;
            while (!queue.isEmpty()){
                Pipe temp = queue.poll();

                for (int d : pipeDir[temp.kind]) {
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if(nx<0 || ny<0 || nx>M-1 || ny>N-1||isVisited[ny][nx]) continue;
                    if(!isPossible[temp.kind][map[ny][nx]][d]) continue;
                    isVisited[ny][nx] = true;
                    if(temp.time+1 <=L ) count++;
                    queue.add(new Pipe(nx,ny,map[ny][nx],temp.time+1));
                }
            }

            sb.append("#").append(tc).append(" ").append(count).append("\n");

        }
        System.out.print(sb);

    }

    private static void setPossible(boolean[][][] isPossible) {
        isPossible[1][1][0] = true;
        isPossible[1][1][1] = true;
        isPossible[1][1][2] = true;
        isPossible[1][1][3] = true;
        isPossible[1][2][0] = true;
        isPossible[1][2][2] = true;
        isPossible[1][3][1] = true;
        isPossible[1][3][3] = true;
        isPossible[1][4][0] = true;
        isPossible[1][4][3] = true;
        isPossible[1][5][2] = true;
        isPossible[1][5][3] = true;
        isPossible[1][6][1] = true;
        isPossible[1][6][2] = true;
        isPossible[1][7][0] = true;
        isPossible[1][7][1] = true;

        isPossible[2][1][0] =true;
        isPossible[2][1][2] = true;
        isPossible[2][2][0] = true;
        isPossible[2][2][2] = true;
        isPossible[2][4][0] = true;
        isPossible[2][5][2] = true;
        isPossible[2][6][2] = true;
        isPossible[2][7][0] = true;

        isPossible[3][1][1] = true;
        isPossible[3][1][3] = true;
        isPossible[3][3][1] = true;
        isPossible[3][3][3] = true;
        isPossible[3][4][3] = true;
        isPossible[3][5][3] = true;
        isPossible[3][6][1] = true;
        isPossible[3][7][1] = true;

        isPossible[4][1][2] = true;
        isPossible[4][1][1] = true;
        isPossible[4][2][2] = true;
        isPossible[4][3][1] = true;
        isPossible[4][5][2] = true;
        isPossible[4][6][1] = true;
        isPossible[4][6][2] = true;
        isPossible[4][7][1] = true;

        isPossible[5][1][0] = true;
        isPossible[5][1][1] = true;
        isPossible[5][2][0] = true;
        isPossible[5][3][1] = true;
        isPossible[5][4][0] = true;
        isPossible[5][6][1] = true;
        isPossible[5][7][0] = true;
        isPossible[5][7][1] = true;

        isPossible[6][1][0] = true;
        isPossible[6][1][3] = true;
        isPossible[6][2][0] = true;
        isPossible[6][3][3] = true;
        isPossible[6][4][0] = true;
        isPossible[6][4][3] = true;
        isPossible[6][5][3] = true;
        isPossible[6][7][0] = true;

        isPossible[7][1][2] = true;
        isPossible[7][1][3] = true;
        isPossible[7][2][2] = true;
        isPossible[7][3][3] = true;
        isPossible[7][4][3] = true;
        isPossible[7][5][2] = true;
        isPossible[7][5][3] = true;
        isPossible[7][6][2] = true;








    }
}
