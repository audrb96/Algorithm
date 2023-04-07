package ssafy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main_1194_달이_차오른다_가자_박명규 {

    static class Node{
        int r;
        int c;
        int keyNum;
        int move;
        public Node(int r, int c, int keyNum, int move) {
            super();
            this.r = r;
            this.c = c;
            this.keyNum = keyNum;
            this.move = move;
        }
    }


    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N, M;
        char[][] map;
        boolean[][][] visited;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        Node start = null;
        for(int i=0;i<N;i++) {
            map[i] = br.readLine().toCharArray();
            for(int k=0;k<M;k++) {
                if(map[i][k] == '0') {
                    start = new Node(i,k,0,0);
                }
            }
        }
        visited = new boolean[N][M][64];
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(start);
        int answer = -1;

        int[] dr = {0, 0, 1, -1};
        int[] dc = {1, -1, 0, 0};
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            if(map[current.r][current.c] == '1') {
                answer = current.move;
                break;
            }
            for(int i=0;i<4;i++) {
                int nr = current.r + dr[i];
                int nc = current.c + dc[i];
                if(0<=nr && nr<N && 0<=nc && nc<M && !visited[nr][nc][current.keyNum] && map[nr][nc] != '#') {
                    if(Pattern.matches("^[a-f]", map[nr][nc]+"")) {	//0 1 . # A~F
                        int key = current.keyNum|(1<<(map[nr][nc]-'a'));
                        queue.add(new Node(nr, nc, key, current.move+1));
                        visited[nr][nc][key] = true;
                    }
                    else if(Pattern.matches("^[A-F]", map[nr][nc]+"")) {	//0 1 . # A~F
                        if((current.keyNum & (1<<map[nr][nc]-'A')) != 0) {
                            queue.add(new Node(nr, nc, current.keyNum, current.move+1));
                            visited[nr][nc][current.keyNum] = true;
                        }
                    }
                    else {
                        queue.add(new Node(nr, nc, current.keyNum, current.move+1));
                        visited[nr][nc][current.keyNum] = true;
                    }
                }
            }

        }


        System.out.println(answer);

    }

}
