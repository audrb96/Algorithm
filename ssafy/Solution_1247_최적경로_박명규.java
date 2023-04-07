package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1247_최적경로_박명규 {
    static int[] com,home;
    static int[][] cus;
    static int N;
    static int min;
    static boolean[] isVisited;
    static int[][] root;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            com = new int[2];
            home = new int[2];
            cus = new int[N][2];
            root = new int[N+1][2];

            root[0] = com;
            min = Integer.MAX_VALUE;
            isVisited = new boolean[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 2; i++) {
                com[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =0;i<2;i++){
                home[i] = Integer.parseInt(st.nextToken());
            }
            for(int i =0;i<N;i++){
                cus[i][0] = Integer.parseInt(st.nextToken());
                cus[i][1] = Integer.parseInt(st.nextToken());
            }
            backtracking(1,0);

           sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);
    }
    public static void backtracking(int cnt,int sum){
        if(sum>min) return;
        if(cnt==N+1){
            sum+= Math.abs(root[cnt-1][0]-home[0])+Math.abs(root[cnt-1][1]-home[1]);
            min = Math.min(min,sum);
            return;
        }


        for(int i =0;i<N;i++){
            if(isVisited[i]) continue;
            isVisited[i] = true;
            int tempSum = sum+Math.abs(root[cnt-1][0]-cus[i][0])+Math.abs(root[cnt-1][1]-cus[i][1]);
            root[cnt] = cus[i];
            backtracking(cnt+1,tempSum);
            isVisited[i] = false;
        }

    }
}
