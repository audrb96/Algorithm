package study.도시분할계획;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    int N,M;
    static class Load implements Comparable<Load>{
        int from;
        int to;
        int weight;

        public Load(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }


        @Override
        public int compareTo(Load o) {
            return this.weight - o.weight;
        }
    }
    int[] parents;

    private void makeSet() {
        parents = new int[N+1];
        for(int i =1; i<N+1; i++) {
            parents[i] = i;
        }
    }

    private int findSet(int a) {
        if(parents[a] == a) return a;
        return parents[a] = findSet(parents[a]);
    }

    private boolean union(int a, int b) {
        int aRoot = findSet(a);
        int bRoot = findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }



    public int solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Load[] loads = initLoad(br);
        Arrays.sort(loads);
        makeSet();
        int answer = kruskal(loads);
        return answer;
    }

    private int kruskal(Load[] loads) {
        int sum = 0;
        int cnt = 0;
        int maxValue = Integer.MIN_VALUE;

        for (Load load : loads) {
            if(union(load.from, load.to)) {
                sum += load.weight;
                maxValue = Math.max(maxValue, load.weight);
                if(cnt == N-1) break;
            }
        }

        return sum-maxValue;
    }

    private Load[] initLoad(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        Load[] loads = new Load[M];

        for(int i =0; i<M; i++) {
            String[] temp = br.readLine().split(" ");
            loads[i] = new Load(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]), Integer.parseInt(temp[2]));
        }

        return loads;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        int answer = main.solution();
        System.out.println(answer);
    }
}
