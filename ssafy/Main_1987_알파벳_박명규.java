package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
//DFS
public class Main_1987_알파벳_박명규 {
    static int R;
    static int C;
    static char[][] alphabet;
    static Set<Character> set; //지나온 알파벳을 저장할 set
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        set = new HashSet<>();
        alphabet = new char[R][C];
        for(int i =0;i<R;i++){
            alphabet[i] = br.readLine().toCharArray();
        }
        backtracking(0,0,1,set);
        System.out.println(max);
    }

    public static void backtracking(int r, int c,int cnt,Set<Character> set){
        max = Math.max(cnt,max);
        set.add(alphabet[r][c]);
        for(int i =0;i<4;i++){ //4방탐색을 하면서
           int nx = c+dx[i];
           int ny = r+dy[i];
           if(nx>C-1||ny>R-1||nx<0||ny<0) continue;
           if(isContain(ny,nx,set)) continue; //이미 지나간적 있는 알파벳은 continue로 pruning한다.
           backtracking(ny,nx,cnt+1,set); //재귀 dfs
           set.remove(alphabet[ny][nx]); // 돌아왔을때 set의 알파벳을 삭제
        }

    }
    public static boolean isContain(int r,int c,Set<Character> set){
        return set.contains(alphabet[r][c]);

    }
}
