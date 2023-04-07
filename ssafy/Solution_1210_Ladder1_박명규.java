package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1210_Ladder1_박명규 {
    public static void main(String[] args) throws IOException {
        int T = 10;
        int[] dx = {-1,1,0};
        int[] dy = {0,0,1};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int tc = 1;tc<=T;tc++){
            int[][] area = new int[100][100];
            int tcNum = Integer.parseInt(br.readLine());
            int ans=0;
            for(int i =0;i<100;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<100;j++){
                    area[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int i =0;i<100;i++){
                if(area[0][i]==0) continue;
                int curX = i;
                int curY = 0;
                boolean isAns = false;
                boolean[][] isVisited = new boolean[100][100];
                while (true){
                    for(int j = 0;j<3;j++){
                        int nx = curX + dx[j];
                        int ny = curY + dy[j];
                        if(nx<0||nx>=100||area[ny][nx]==0||isVisited[ny][nx]) continue;
                        isVisited[ny][nx] = true;
                        curX = nx;
                        curY = ny;
                        if(area[curY][curX]==2) {
                            isAns = true;
                        }
                        break;
                    }
                    if(curY==99) break;
                }
                if(isAns){
                    ans = i;
                    break;
                }
            }
            System.out.println("#"+tcNum+" "+ans);
        }
    }
}
