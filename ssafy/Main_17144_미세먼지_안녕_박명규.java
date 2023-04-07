package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17144_미세먼지_안녕_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] area = new int[R][C];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,-1,0,1};
        int[] clean1 = new int[2];
        int[] clean2 = new int[2];
        int cnt = 0;
        for(int i =0;i<R;i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0;j<C;j++){
                int temp  = Integer.parseInt(st.nextToken());
                area[i][j] = temp;
                if(temp == -1 && cnt==0) {
                    clean1[0] = j;
                    clean1[1] = i;
                    cnt ++;
                }
            }
        }
        clean2[0] = clean1[0];
        clean2[1] = clean1[1]+1;


        for(int t =0;t<T;t++){
            int[][] temp = new int[R][C];
            //미세먼지 확산
            for(int i = 0;i<R;i++){
                for(int j=0;j<C;j++){
                    cnt = 0;
                    for(int d = 0;d<4;d++){
                        int nx = j + dx[d];
                        int ny = i + dy[d];
                        if(nx<0||nx>C-1||ny<0||ny>R-1||area[ny][nx]==-1) continue;
                        cnt++;
                        temp[ny][nx] = temp[ny][nx] + area[i][j]/5;
                    }
                    area[i][j] = area[i][j] -(area[i][j]/5)*cnt;
                }
            }

            for(int i =0;i<R;i++){
                for(int j=0;j<C;j++){
                    area[i][j] = area[i][j]+temp[i][j];
                }
            }

            //공기 청정기 작동
            Queue<Integer> queue = new LinkedList<>();
            int x = clean1[0]+1;
            int y = clean1[1];
            while (x<C){
                queue.add(area[y][x]);
                x++;
            }
            x--;
            y--;
            while (y>=0){
                queue.add(area[y][x]);
                y--;
            }
            y++;
            x--;
            while (x>=0){
                queue.add(area[y][x]);
                x--;
            }
            x++;
            y++;
            while (y<clean1[1]){
                queue.add(area[y][x]);
                y++;
            }
           x = clean1[0]+2;
            y= clean1[1];
            while (x<C){
                area[y][x] = queue.poll();
                x++;
            }
            x--;
            y--;
            while (y>=0){
               area[y][x] = queue.poll();
                y--;
            }
            y++;
            x--;
            while (x>=0){
               area[y][x] = queue.poll();
                x--;
            }
            x++;
            y++;
            while (y<clean1[1]){
                if(area[y][x] == -1) break;
                area[y][x] = queue.poll();
                y++;
            }
            area[clean1[1]][clean1[0]+1] = 0;
            //공기청정기 2
            queue = new LinkedList<>();
            x = clean2[0]+1;
            y = clean2[1];
            while (x<C){
                queue.add(area[y][x]);
                x++;
            }
            x--;
            y++;
            while (y<R){
                queue.add(area[y][x]);
                y++;
            }
            y--;
            x--;
            while (x>=0){
                queue.add(area[y][x]);
                x--;
            }
            x++;
            y--;
            while (y>clean2[1]){
                queue.add(area[y][x]);
                y--;
            }


            x = clean2[0]+2;
            y= clean2[1];

            while (x<C){
                area[y][x] = queue.poll();
                x++;
            }
            x--;
            y++;
            while (y<R){
                area[y][x] = queue.poll();
                y++;
            }
            y--;
            x--;
            while (x>=0){
                area[y][x] = queue.poll();
                x--;
            }
            x++;
            y--;
            while (y>clean2[1]){
                if(area[y][x] == -1 ) break;
                area[y][x] = queue.poll();
                y--;
            }

            area[clean2[1]][clean2[0]+1] = 0;

        }
        int Sum = 0;
        for(int i =0;i<R;i++){
            for(int j=0;j<C;j++){
                if(area[i][j] != -1) {
                    Sum += area[i][j];
                }
            }
        }
        System.out.println(Sum);

    }
}
