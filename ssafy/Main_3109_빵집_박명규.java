package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_3109_빵집_박명규 {
    static int R,C;
    static int[] row;
    static char[][] area;
    static int[] dy = {-1,0,1};
    static int ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        area = new char[R][C];
        row = new int[C];
        for(int i =0;i<R;i++){
            area[i] = br.readLine().toCharArray();
        }

        for(int i =0;i<R;i++){
            backtracking(0,i);
        }

        System.out.println(ans);
    }
    public static boolean backtracking(int cnt,int y){
       if(cnt == C-1){
           ans++;
           return true;
       }
       cnt = cnt+1;
       for(int i =0;i<3;i++){
            int ny = y + dy[i];
            if(ny<0||ny > R-1) continue;
            if(area[ny][cnt]=='x') continue;
            area[ny][cnt] ='x';
            if(backtracking(cnt,ny)) return true;
       }
        return false;
    }
}
