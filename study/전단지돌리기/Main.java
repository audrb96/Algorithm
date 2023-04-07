package study.전단지돌리기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    int N,S,D;
    int answer = 0;
    boolean[] isVisited;

    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setVar(br);
        ArrayList<Integer>[] nodeList = setNode(br);
        isVisited[S] = true;
        dfs(nodeList,S);
        br.close();
        return Math.max(0,(answer-1)*2);
    }

    private int dfs(ArrayList<Integer>[] nodeList, int start) {

        int max = 0;

        ArrayList<Integer> node = nodeList[start];

        for (Integer integer : node) {
            if(isVisited[integer]) continue;
            isVisited[integer] = true;
            max = Math.max(max, dfs(nodeList, integer));
        }
        if(max >= D) answer++;

        return max+1;
    }

    private ArrayList<Integer>[] setNode(BufferedReader br) throws IOException {
        ArrayList<Integer>[] nodeList = new ArrayList[N+1];

        for(int i =1; i<N+1; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for(int i =1; i<N; i++) {
            String[] line = br.readLine().split(" ");
            int to = Integer.parseInt(line[0]);
            int from = Integer.parseInt(line[1]);
            nodeList[to].add(from);
            nodeList[from].add(to);
        }

        return nodeList;
    }

    private void setVar(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        S = Integer.parseInt(line[1]);
        D = Integer.parseInt(line[2]);
        isVisited = new boolean[N+1];
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
