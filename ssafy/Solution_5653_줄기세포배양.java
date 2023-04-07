package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution_5653_줄기세포배양 {
    static class Cell implements Comparable<Cell>{
        int x;
        int y;
        int life;
        int status;
        int time;

        @Override
        public String toString() {
            return "Cell{" +
                    "x=" + x +
                    ", y=" + y +
                    ", life=" + life +
                    ", status=" + status +
                    ", time=" + time +
                    '}';
        }

        public Cell(int x, int y, int life, int status, int time) {
            this.x = x;
            this.y = y;
            this.life = life;
            this.status = status;
            this.time = time;
        }

        @Override
        public int compareTo(Cell o) {
            return o.life- this.life;
        }
    }


    static int T,N,M,K,ans;
    static Cell[][] container;
    static boolean[][] isVisited;
    static int[] dx = {0,-1,0,1};
    static int[] dy = {1,0,-1,0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());
        for(int tc= 1;tc<=T;tc++){
            container = new Cell[1000][1000];
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            ans = 0;
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<M;j++){
                    int life = Integer.parseInt(st.nextToken());
                    container[500+i][500+j] = new Cell(500+j,500+i,life,0,0);
                }
            }

            for(int i =0;i<K;i++){
                isVisited = new boolean[1000][1000];
                incubate();
            }

            for (Cell[] cells : container) {
                for (Cell cell : cells) {
                    if(cell != null && cell.status != 2) ans++;
                }
            }
            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }

    private static void incubate() {

        Queue<Cell> queue = new LinkedList<>();
        queue.add(container[500][500]);
        isVisited[500][500] = true;
        ArrayList<Cell> cellList = new ArrayList<>();


        while (!queue.isEmpty()){
            Cell temp = queue.poll();

            if(temp.life == 0 ){
                for(int d = 0;d<4;d++){
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if(isVisited[ny][nx] || container[ny][nx] == null) continue;
                    queue.add(container[ny][nx]);
                    isVisited[ny][nx] = true;
                }
                continue;
            }


            if(temp.status==0){
                container[temp.y][temp.x].time ++;
                if(temp.life != temp.time){
                    for(int d = 0;d<4;d++){
                        int nx = temp.x + dx[d];
                        int ny = temp.y + dy[d];
                        if(isVisited[ny][nx] || container[ny][nx] == null) continue;
                        queue.add(container[ny][nx]);
                        isVisited[ny][nx] = true;
                    }
                }else {
                    container[temp.y][temp.x].status = 1;
                    container[temp.y][temp.x].time=0;
                    for(int d = 0;d<4;d++){
                        int nx = temp.x + dx[d];
                        int ny = temp.y + dy[d];
                        if(isVisited[ny][nx] || container[ny][nx] == null) continue;
                        queue.add(container[ny][nx]);
                        isVisited[ny][nx] = true;
                    }
                }
            } else if(temp.status==1){
                container[temp.y][temp.x].time++;
                if(container[temp.y][temp.x].time == 1){
                    for(int i =0;i<4;i++){
                        int nx = temp.x + dx[i];
                        int ny = temp.y + dy[i];
                        if(container[ny][nx] == null || container[ny][nx].life == 0) {
                            cellList.add(new Cell(nx,ny, temp.life, 0,0));
                        }
                    }
                }

                if(container[temp.y][temp.x].time == container[temp.y][temp.x].life) container[temp.y][temp.x].status = 2;
                for(int d = 0;d<4;d++){
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if(isVisited[ny][nx] || container[ny][nx] == null) continue;
                    queue.add(container[ny][nx]);
                    isVisited[ny][nx] = true;
                }
            }
            else if(temp.status == 2){
                for(int d = 0;d<4;d++){
                    int nx = temp.x + dx[d];
                    int ny = temp.y + dy[d];
                    if(isVisited[ny][nx] || container[ny][nx] == null) continue;
                    queue.add(container[ny][nx]);
                    isVisited[ny][nx] = true;
                }
            }
        }

        Collections.sort(cellList);
        Set<String> set = new HashSet<>();


        for(int i =0;i<cellList.size();i++){
            if(set.add( cellList.get(i).x+" "+cellList.get(i).y)){
                container[cellList.get(i).y][cellList.get(i).x] = cellList.get(i);
            }
        }
    }
}
