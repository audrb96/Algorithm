package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Solution_5650_핀볼_게임_박명규 {
    static int T, N;
    static int[][] map;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static ArrayList<int[]>[] wormhole;

    static int[][] ballDir = {
            {0, 2, 1, 3, 2, 2},
            {0, 3, 3, 2, 0, 3},
            {0, 1, 0, 0, 3, 0},
            {0, 0, 2, 1, 1, 1}
    };

    static ArrayList<int[]> start;
    static int max;

    static class Ball {
        int x;
        int y;
        int score;
        int dir;

        public Ball(int x, int y, int score, int dir) {
            this.x = x;
            this.y = y;
            this.score = score;
            this.dir = dir;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            max = Integer.MIN_VALUE;
            N = Integer.parseInt(br.readLine());
            start = new ArrayList<>();
            wormhole = new ArrayList[11];
            map = new int[N][N];
            for (int i = 1; i < 11; i++) {
                wormhole[i] = new ArrayList<>();
            }

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] == 0) start.add(new int[]{j, i});
                    else if (!Pattern.matches("^[1-5]", Integer.toString(map[i][j])) && map[i][j] != -1) {
                        wormhole[map[i][j]].add(new int[]{j, i});
                    }
                }
            }

            for (int i = 0; i < start.size(); i++) {
                for (int j = 0; j < 4; j++) {
                    Ball ball = new Ball(start.get(i)[0], start.get(i)[1], 0, j);

                    while (true) {
                        int nx = ball.x + dx[ball.dir];
                        int ny = ball.y + dy[ball.dir];
                        if (nx > N - 1 || ny > N - 1 || nx < 0 || ny < 0) {
                            ball.dir = (ball.dir + 2) % 4;
                            ball.score = ball.score + 1;
                            ball.x = ball.x - dx[ball.dir];
                            ball.y  = ball.y - dy[ball.dir];
                            continue;
                        }

                        if (map[ny][nx] == -1 || (nx == start.get(i)[0] && ny == start.get(i)[1])) {
                            max = Math.max(max, ball.score);
                            break;
                        }

                        if (map[ny][nx] == 0) {
                            ball.x = nx;
                            ball.y = ny;
                            continue;
                        }

                        if (Pattern.matches("^[1-5]", Integer.toString(map[ny][nx]))) {
                            ball.x = nx;
                            ball.y = ny;
                            ball.dir = ballDir[ball.dir][map[ny][nx]];
                            ball.score = ball.score + 1;
                        } else {
                            if (nx == wormhole[map[ny][nx]].get(0)[0] && ny == wormhole[map[ny][nx]].get(0)[1]) {
                                ball.x = wormhole[map[ny][nx]].get(1)[0];
                                ball.y = wormhole[map[ny][nx]].get(1)[1];
                            }
                            else {
                                ball.x = wormhole[map[ny][nx]].get(0)[0];
                                ball.y = wormhole[map[ny][nx]].get(0)[1];
                            }

                        }
                    }
                }
            }
            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
    }
}
