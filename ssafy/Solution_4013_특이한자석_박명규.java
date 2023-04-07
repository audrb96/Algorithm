package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_4013_특이한자석_박명규 {
    static int[] dc = {-1,1};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int[][] magnet = new int[5][8];

            for(int i = 1; i < 5; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 8; j++) {
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int magnetNum = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());

                spin(magnetNum, dir, magnet);
            }

            int sum = 0;
            for(int i = 1; i < 5; i++) {
                if(magnet[i][0] == 1) {
                    sum += 1 << (i - 1);
                }
            }
            sb.append("#").append(tc).append(" ").append(sum).append("\n");
        }
        System.out.println(sb);

    }

    private static void spin(int magnetNum, int dir, int[][] magnet) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[] isVisited = new boolean[5];
        queue.add(new int[] {magnetNum, dir});
        isVisited[magnetNum] = true;
        while(!queue.isEmpty()) {
            int[] current = queue.poll();

            for(int i = 0; i < 2; i++) {
                int nc = current[0] + dc[i];
                if(nc >= 1 && nc < 5 && !isVisited[nc]) {
                    if(current[0] > nc) { //비교하려는 자석이 왼쪽에 있음
                        if(magnet[current[0]][6] != magnet[nc][2]) {
                            queue.add(new int[] {nc, (-current[1])});
                            isVisited[nc] = true;
                        }
                    }else {
                        if(magnet[current[0]][2] != magnet[nc][6]) {
                            queue.add(new int[] {nc, (-current[1])});
                            isVisited[nc] = true;
                        }
                    }
                }
            }

            //자석 회전
            Queue<Integer> cycle = new LinkedList<Integer>();
            for(int i = 0; i < 8; i++) {
                cycle.add(magnet[current[0]][i]);
            }
            for(int i = 0; i < 8; i++) {
                magnet[current[0]][(i + current[1] + 8)%8] = cycle.poll();
            }
        }
    }
}
