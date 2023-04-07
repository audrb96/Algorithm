package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1389_케빈_베이컨의_6단계_법칙_박명규 {
    static int N,M;
    static int min = Integer.MAX_VALUE;
    static int[][] connect;
    static boolean[] isVisited;
    static int ans = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        connect = new int[N+1][N+1];
        for(int i =0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken());
            int col = Integer.parseInt(st.nextToken());
            connect[row][col] = 1;
            connect[col][row] = 1;
        }

        for(int i =1;i<N+1;i++){
            isVisited = new boolean[N+1];
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{i,0});
            int tempAns = 0;

            while (!queue.isEmpty()){
                int[] temp = queue.poll();
                int num = temp[0];
                int count = temp[1];
                if(isVisited[num]) continue;
                isVisited[num] = true;
                tempAns += count;
                for(int j =1 ;j<N+1;j++){
                    if(connect[num][j] == 0) continue;
                    queue.add(new int[]{j,count+1});
                }
            }

            if(tempAns < min) {
                min = tempAns;
                ans = i;
            }

        }

        System.out.println(ans);
    }
}
