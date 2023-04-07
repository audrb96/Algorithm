package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_4014_활주로_건설_박명규 {
    static int T, N, X;
    static int[][] map;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            X = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int i = 0; i < N; i++) {
                int last = map[i][0];
                int count = 1;
                boolean isAns = true;
                loop:
                for (int j = 1; j < N; j++) {
                    if (last == map[i][j]) {
                        count++;
                    } else if (map[i][j] - last == 1) {
                        if (count < X) {
                            isAns = false;
                            break;
                        } else {
                            count = 1;
                            last = map[i][j];
                        }
                    } else if (last - map[i][j] == 1) {
                        if (N < X + j) {
                            isAns = false;
                            break;
                        }
                        for (int k = 1; k < X; k++) {
                            if (last - map[i][++j] != 1) {
                                isAns = false;
                                break loop;
                            }
                        }
                        last = map[i][j];
                        count = 0;
                    } else {
                        isAns = false;
                        break;
                    }
                }
                if (isAns) ans++;
            }


            for (int i = 0; i < N; i++) {
                int last = map[0][i];
                int count = 1;
                boolean isAns = true;
                loop2:
                for (int j = 1; j < N; j++) {
                    if (last == map[j][i]) {
                        count++;
                    } else if (map[j][i] - last == 1) {
                        if (count < X) {
                            isAns = false;
                            break;
                        } else {
                            count = 1;
                            last = map[j][i];
                        }
                    } else if (last - map[j][i] == 1) {
                        if (N < X + j) {
                            isAns = false;
                            break;
                        }
                        for (int k = 1; k < X; k++) {
                            if (last - map[++j][i] != 1) {
                                isAns = false;
                                break loop2;
                            }
                        }
                        last = map[j][i];
                        count = 0;
                    } else {
                        isAns = false;
                        break;
                    }
                }
                if (isAns) ans++;
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
