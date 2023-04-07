package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_3289_서로소집합_박명규 {
    static int N,M;
    static int[] parents;

    public static void makeSet() {
        parents = new int[N+1];
        for(int i =1;i<N+1;i++){
            parents[i] = i;
        }
    }

    public static int findSet(int a){
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    public static boolean union(int a, int b){
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder ans = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            StringBuilder sb = new StringBuilder();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            makeSet();
            for(int i =0;i<M;i++){
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int temp = -1;
                if(cmd==0) {
                    union(a,b);
                    continue;
                }
                if(cmd==1){
                    temp = findSet(a)==findSet(b) ? 1 : 0;
                }
                sb.append(temp);
            }
            ans.append("#").append(tc).append(" ").append(sb).append("\n");
        }
        System.out.print(ans);
    }
}
