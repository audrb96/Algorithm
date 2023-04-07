package study.전력난;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

class Main {
    class Edge implements Comparable<Edge> {
        int to;
        int from;
        int weight;

        public Edge(int to, int from, int weight) {
            this.to = to;
            this.from = from;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    int N;
    int E;
    int[] parents;
    int total;

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
        int bRoot= findSet(b);
        if(aRoot == bRoot) return false;
        parents[bRoot] = aRoot;
        return true;
    }

    public ArrayList<Integer> solution() throws IOException {
        ArrayList<Integer> answer = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            total = 0;
            String[] line = br.readLine().split(" ");
            N = Integer.parseInt(line[0]);
            E = Integer.parseInt(line[1]);
            if(N == 0 && E==0) break;
            Edge[] edges = initEdgeArray(br);
            Arrays.sort(edges);
            makeSet();
            int saving = kruskal(edges);
            answer.add(total - saving);
        }

        return answer;
    }

    private int kruskal(Edge[] edges) {
        int answer = 0;
        int cnt = 0;

        for (Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                answer += edge.weight;
                if(++cnt == N-1) break;
            }
        }

        return answer;
    }

    private Edge[] initEdgeArray(BufferedReader br) throws IOException {
        Edge[] edges = new Edge[E];

        for(int i =0; i<E; i++) {
            String[] line = br.readLine().split(" ");
            total += Integer.parseInt(line[2]);
            edges[i] = new Edge(Integer.parseInt(line[0]), Integer.parseInt(line[1]), Integer.parseInt(line[2]));
        }

        return edges;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        ArrayList<Integer> answer = main.solution();
        for (Integer integer : answer) {
            System.out.println(integer);
        }
    }
}

