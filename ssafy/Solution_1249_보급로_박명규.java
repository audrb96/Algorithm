package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_1249_보급로_박명규 {
    static int N;
    static int[][] matrix;
    static int[][] temp;
    static boolean[][] visited;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=T;tc++) {
            N = Integer.parseInt(br.readLine());
            matrix = new int[N][N];
            temp = new int[N][N];
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                String s = br.readLine();
                for(int k=0;k<N;k++) {
                    matrix[i][k] = (s.charAt(k)-'0');
                    temp[i][k] = Integer.MAX_VALUE;
                }
            }
            PriorityQueue<Node> queue = new PriorityQueue<Node>();
            queue.offer(new Node(0,0,0));
            temp[0][0] = 0;
            Node current = null;
            while(!queue.isEmpty()) {
                current = queue.poll();
                if(current.r == N-1 && current.c == N-1) break;
                if(visited[current.r][current.c]) continue;

                visited[current.r][current.c] = true;
                for(int i=0;i<4;i++) {
                    int nr = current.r+dr[i];
                    int nc = current.c+dc[i];
                    if(0<=nr && nr<N && 0<=nc && nc<N && !visited[nr][nc]) {
                        if(temp[nr][nc] > temp[current.r][current.c]+matrix[nr][nc]) {
                            temp[nr][nc] = temp[current.r][current.c]+matrix[nr][nc];
                            queue.add(new Node(nr, nc, temp[nr][nc]));
                        }
                    }
                }
            }
            System.out.printf("#%d %d\n",tc,temp[N-1][N-1]);

        }
    }
    static class Node implements Comparable<Node>{
        int r;
        int c;
        int dist;

        public Node(int r, int c,int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return (this.dist - o.dist);
        }
    }
}

