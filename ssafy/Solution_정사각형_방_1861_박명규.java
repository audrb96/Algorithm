package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_정사각형_방_1861_박명규 {
    public static void main(String[] args) throws IOException {
        int max = Integer.MIN_VALUE;
        int maxRoom = -1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        for(int tc =1;tc<=T;tc++){
            int N = Integer.parseInt(br.readLine());
            int[][] room = new int[N][N];
            int count = 1;
            for(int i =0;i<N;i++){
                st= new StringTokenizer(br.readLine());
                for(int j=0;j<N;j++){
                    room[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for(int y=0;y<N;y++){
                for(int x=0;x<N;x++){
                    int curX = x;
                    int curY = y;
                    
                    for(int d=0;d<4;d++){
                        int ny= curY+dy[d];
                        int nx= curX+dx[d];
                        if(nx>N-1||ny>N-1||nx<0||ny<0||(room[ny][nx]-room[curY][curX]!=1)) continue;
                        count++;
                        curX = nx;
                        curY = ny;
                        d=-1;
                    }
                    if(max<count){
                        max = count;
                        maxRoom = room[y][x];
                    }
                    if(max==count){
                        if(maxRoom>room[y][x])
                            maxRoom = room[y][x];
                    }
                    count = 1;
                }
            }
            System.out.println("#"+tc+" "+maxRoom+" "+max);
            max = Integer.MIN_VALUE;
            maxRoom = -1;
        }
    }
}
