package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌_깨기_박명규 {
    static int N;
    static int W;
    static int H;
    static int[][] map;
    static int[] selected;
    static int[] dr = {1, -1, 0, 0};
    static int[] dc = {0, 0, 1, -1};
    static int min;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            map = new int[H][W];
            selected = new int[N];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            min = Integer.MAX_VALUE;
            permutation(0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");

        }
        System.out.println(sb);
    }

    static void permutation(int cnt) {
        if (cnt == N) {
            int[][] tempMap = new int[H][W];
            for (int i = 0; i < H; i++) {
                tempMap[i] = Arrays.copyOf(map[i], W);
            }
            for (int i = 0; i < N; i++) {
                int num = selected[i];
                int next = 0;
                while (true) {
                    if(next>=H) break;
                    if (tempMap[next][num] != 0) {
                        bfs(next, num, tempMap[next][num], tempMap);
                        flat(tempMap);
                        break;
                    } else {
                        next++;
                    }
                }
            }
            int sum = 0;
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if (tempMap[i][j] != 0) {
                        sum++;
                    }
                }
            }

            min = Math.min(min, sum);
            return;
        }

        for (int i = 0; i < W; i++) {
            selected[cnt] = i;
            permutation(cnt + 1);
        }


    }

    private static void flat(int[][] map) {
        int count ;
        for(int j = 0; j < W; j++) {
            count = H-1;
            for(int i = H-1; i >= 0; i--) {
                if(map[i][j] != 0) {
                    map[count][j] = map[i][j];
                    if(count!=i) {
                        map[i][j] = 0;
                    }
                    count--;
                }
            }
        }

    }

    private static void bfs(int r, int c, int w, int[][] map) {
        Queue<Block> queue = new LinkedList<>();
        queue.add(new Block(r, c, w));

        while (!queue.isEmpty()) {
            Block current = queue.poll();

            for (int j = 0; j < 4; j++) {
                for (int i = 0; i <= current.w -1; i++) {
                    int nr = current.r + dr[j] * i;
                    int nc = current.c + dc[j] * i;
                    if (nr < 0 || nr >= H || nc < 0 || nc >= W) break;
                    if (map[nr][nc] == 0) continue;
                    if (map[nr][nc] == 1) {
                        map[nr][nc] = 0;
                        continue;
                    }
                    queue.add(new Block(nr, nc, map[nr][nc]));
                    map[nr][nc] = 0;
                }
            }
        }

    }
}

class Block {
    int r;
    int c;
    int w;

    public Block(int r, int c, int w) {
        super();
        this.r = r;
        this.c = c;
        this.w = w;
    }

}
