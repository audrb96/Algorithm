package study.행성연결;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    class Flow implements Comparable<Flow>{
        int from;
        int to;
        int weight;

        public Flow(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Flow o) {
            return this.weight - o.weight;
        }
    }
    int N;
    int[] parents;

    public void makeSet() {
        parents = new int[N];
        for(int i =0; i<N; i++) {
            parents[i] = i;
        }
    }

    public int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    public boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public long solution() throws IOException {
        long answer = 0;
        Flow[] flows = initFlow();
        Arrays.sort(flows);
        makeSet();
        answer = findMinimumCost(flows);

        return answer;
    }

    private long findMinimumCost(Flow[] flows) {
        long answer = 0;
        int cnt = 0;
        for (Flow flow : flows) {
            if(union(flow.from, flow.to)) {
                answer += flow.weight;
                if(++cnt == N-1) break;
            }
        }

        return answer;
    }

    private Flow[] initFlow() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        Flow[] flows = new Flow[N*N-N];
        for(int i =0; i<N;i++) {
            String[] line = br.readLine().split(" ");
            for(int j =0; j<N; j++) {
                if(line[j].equals("0")) continue;
                flows[cnt++] = new Flow(i,j,Integer.parseInt(line[j]));
            }
        }
        return flows;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        long answer = main.solution();
        System.out.println(answer);
    }
}
