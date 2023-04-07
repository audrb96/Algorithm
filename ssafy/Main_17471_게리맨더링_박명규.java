package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_17471_게리맨더링_박명규 {
    static int N,min;
    static int[] P;
    static int[][] adjMatrix;
    static boolean[] selected;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        selected = new boolean[N+1];
        st = new StringTokenizer(br.readLine());
        P = new int[N+1];
        for(int i =1;i<=N;i++){
            P[i] = Integer.parseInt(st.nextToken());
        }

        adjMatrix = new int[N+1][N+1];
        for(int i =1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for(int j =0;j<count;j++){
                adjMatrix[i][Integer.parseInt(st.nextToken())] = 1;
            }
        }
        subset(0);
        if(min == Integer.MAX_VALUE) min = -1;

        System.out.println(min);

    }

    public static void subset(int cnt){
        if(cnt == N) {
            ArrayList<Integer> graph1 = new ArrayList<>();
            ArrayList<Integer> graph2 = new ArrayList<>();

            for(int i =1;i<=N;i++){
                if(selected[i]){
                    graph1.add(i);
                }else{
                    graph2.add(i);
                }
            }

            if(graph1.size() == N || graph2.size() == N) return;
            boolean[] isSelected = new boolean[N+1];
            int count = 0;
            Queue<Integer> queue = new LinkedList<>();
            queue.add(graph1.get(0));
            count ++;
            isSelected[graph1.get(0)] = true;
            while (!queue.isEmpty()){
                int temp = queue.poll();
                for(int i =1;i<=N;i++) {
                    if (adjMatrix[temp][i] == 0 || isSelected[i]) continue;
                    if(selected[i]){
                        isSelected[i] = true;
                        queue.add(i);
                        count++;
                    }
                }
            }
            if(count != graph1.size()) return;

            isSelected = new boolean[N+1];
            count = 0;
            queue = new LinkedList<>();
            queue.add(graph2.get(0));
            count ++;
            isSelected[graph2.get(0)] = true;
            while (!queue.isEmpty()){
                int temp = queue.poll();
                for(int i =1;i<=N;i++) {
                    if (adjMatrix[temp][i] == 0 || isSelected[i]) continue;
                    if(!selected[i]){
                        isSelected[i] = true;
                        queue.add(i);
                        count++;
                    }
                }
            }
            if(count != graph2.size()) return;

            int popul1 = 0;
            int popul2 = 0;

            for(int i =1;i<=N;i++){
                if(selected[i]) popul1 += P[i];
                else popul2 += P[i];
            }

            min = Math.min(min,Math.abs(popul1-popul2));
            return;
        }

            selected[cnt+1] = true;
            subset(cnt+1);
            selected[cnt+1] = false;
            subset(cnt+1);
    }


}
