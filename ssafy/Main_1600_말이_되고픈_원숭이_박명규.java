package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이_되고픈_원숭이_박명규 {

    static int ans = -1;
    static int K;
    static int W,H;
    static int[][] area;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][][] available;
    static int[] hx = {-1,-2,-2,-1,1,2,2,1};
    static int[] hy = {-2,-1,1,2,2,1,-1,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        W = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        area = new int[H][W];
        available = new boolean[H][W][K + 1];
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        Queue<Monkey> queue = new LinkedList<>();
        queue.add(new Monkey(0, 0, K, 0));
        available[0][0][0] = true;

        while (!queue.isEmpty()) {
            Monkey temp = queue.poll();
            int tempK = temp.leftK;
            for (int i = 0; i < 4; i++) {
                int nx = temp.x + dx[i];
                int ny = temp.y + dy[i];
                if (nx < 0 || nx > W - 1 || ny < 0 || ny > H - 1 || available[ny][nx][K - tempK] || area[ny][nx] == 1)
                    continue;
                if (nx == W - 1 && ny == H - 1) {
                    ans = temp.move + 1;
                    break;
                }
                queue.add(new Monkey(nx, ny, tempK, temp.move + 1));
                available[ny][nx][K - tempK] = true;
            }

            if (ans != -1) break;
            if (tempK > 0) {
                for (int i = 0; i < 8; i++) {
                    int nx = temp.x + hx[i];
                    int ny = temp.y + hy[i];
                    if (nx < 0 || nx > W - 1 || ny < 0 || ny > H - 1 || available[ny][nx][K - tempK + 1] || area[ny][nx] == 1)
                        continue;
                    if (nx == W - 1 && ny == H - 1) {
                        ans = temp.move + 1;
                        break;
                    }
                    queue.add(new Monkey(nx, ny, tempK - 1, temp.move + 1));
                    available[ny][nx][K - tempK + 1] = true;
                }
            }
            if (ans != -1) break;
        }
        if(W == 1 && H == 1) ans = 0;
            System.out.println(ans);
    }

}

class Monkey {
    int x;
    int y;
    int leftK;
    int move;


    public Monkey(int x, int y, int leftK, int move) {
        this.x = x;
        this.y = y;
        this.leftK = leftK;
        this.move = move;
    }
}