package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2667_단지번호붙이기_stack_박명규 {
    //DFS
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int complex = 0;
        char[][] area = new char[N][N];
        int[] dx = {1,0,-1,0};
        int[] dy = {0,1,0,-1};
        Stack<int[]> stack = new Stack<>();
        for(int i =0;i<N;i++){
            area[i] = br.readLine().toCharArray();
        }

        for(int i =0;i<N;i++){
            for(int j =0;j<N;j++){
                if(area[i][j]!='1') continue;
                complex++;
                int building = 1;
                stack.push(new int[]{i,j});
                area[i][j] = '2';
                while (!stack.isEmpty()){
                    int[] temp = stack.pop();
                    int curY = temp[0];
                    int curX = temp[1];
                    for(int d= 0;d<4;d++){
                           int nx = curX+dx[d];
                           int ny = curY+dy[d];
                           if(nx<0||ny<0||nx>N-1||ny>N-1||area[ny][nx] !='1') continue;
                           stack.push(new int[]{ny,nx});
                           area[ny][nx] = '2';
                           building++;
                    }
                }
                arr.add(building);
            }
        }
        Collections.sort(arr);
        System.out.println(complex);
        for (Integer integer : arr) {
            System.out.println(integer);
        }
    }
}
