package study.트리의기둥과가지;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    int N;
    int R;
    int[] answer;
    boolean[] isVisited;

    public int[] solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        R = Integer.parseInt(line[1]);
        ArrayList<Integer[]>[] nodes = setNodes(br);
        isVisited[R] = true;
        dfs(nodes, R,1, 0);
        return answer;
    }

    public void dfs(ArrayList<Integer[]>[] nodes, int cur,int flag, int total) {

        ArrayList<Integer[]> node = nodes[cur];

        if(node.size() - (cur==R ? 0 : 1) >= 2 && flag == 1 ) {
            flag = 0;
            answer[0] = total;
            total = 0;
        }

        if(node.size() == 1 && flag == 1 ) {
            answer[0] = total;
        }

        if(node.size() == 1 && flag == 0) {
            answer[1] = Math.max(answer[1], total);
        }

        for (Integer[] val : node) {
            int to = val[0];
            int length = val[1];

            if(isVisited[to]) continue;
            isVisited[to] = true;
            dfs(nodes,to, flag, total + length);
        }

    }

    private ArrayList<Integer[]>[] setNodes(BufferedReader br) throws IOException {
        ArrayList<Integer[]>[] nodes = new ArrayList[N+1];
        isVisited = new boolean[N+1];
        answer = new int[2];
        for(int i =1; i<N+1; i++) {
            nodes[i] = new ArrayList<>();
        }

        for(int i =1; i<N;i++) {
            String[] line = br.readLine().split(" ");
            int to = Integer.parseInt(line[0]);
            int from = Integer.parseInt(line[1]);
            int length = Integer.parseInt(line[2]);

            nodes[to].add(new Integer[]{from, length});
            nodes[from].add(new Integer[]{to,length});
        }

        return nodes;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int[] answer = main.solution();
        System.out.println(answer[0] + " " + answer[1]);
    }
}
