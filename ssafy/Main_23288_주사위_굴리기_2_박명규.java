package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_23288_주사위_굴리기_2_박명규 {
    static int N, M, K;
    static int[][] map;
    static int[] dice = {6, 4, 1, 3, 2, 5};
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int ans = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int curX = 0;
        int curY = 0;
        int d = 20000;

        for (int i = 0; i < K; i++) {
            int nx = curX + dx[d % 4];
            int ny = curY + dy[d % 4];
            if (nx > M - 1 || ny > N - 1 || nx < 0 || ny < 0) {
                d = d + 2;
                i--;
                continue;
            }

            curX = nx;
            curY = ny;
            rolling(d % 4);
            boolean[][] isVisited = new boolean[N][M];
            isVisited[curY][curX] = true;
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{curY, curX});
            int count = map[curY][curX];
            while (!queue.isEmpty()) {
                int[] temp = queue.poll();
                for (int dr = 0; dr < 4; dr++) {
                    int bx = temp[1] + dx[dr];
                    int by = temp[0] + dy[dr];
                    if (bx > M - 1 || bx < 0 || by > N - 1 || by < 0 || isVisited[by][bx] || map[by][bx] != map[curY][curX])
                        continue;
                    isVisited[by][bx] = true;
                    queue.add(new int[]{by, bx});
                    count += map[by][bx];
                }
            }
            ans += count;
            if (dice[0] > map[curY][curX]) {
                d++;
            } else if (dice[0] < map[curY][curX]) {
                d--;
            }

        }
        System.out.println(ans);
    }

    public static void rolling(int d) {
        if (d == 0) {
            int temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[2];
            dice[2] = dice[1];
            dice[1] = temp;
        }
        if (d == 1) {
            int temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[2];
            dice[2] = dice[4];
            dice[4] = temp;
        }
        if (d == 2) {
            int temp = dice[0];
            dice[0] = dice[1];
            dice[1] = dice[2];
            dice[2] = dice[3];
            dice[3] = temp;
        }
        if (d == 3) {
            int temp = dice[4];
            dice[4] = dice[2];
            dice[2] = dice[5];
            dice[5] = dice[0];
            dice[0] = temp;
        }
    }
}
