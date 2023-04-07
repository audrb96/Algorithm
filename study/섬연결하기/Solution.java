package study.섬연결하기;

import java.util.Arrays;

class Solution {


    class Edge implements Comparable<Edge> {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    int[] parents;
    int N;

    public void makeSet() {
        parents = new int[N];
        for (int i =0; i<N; i++) {
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

    public int solution(int n, int[][] costs) {
        int answer = 0;
        N = n;
        Edge[] edges = initEdgeArray(n, costs);
        Arrays.sort(edges);
        makeSet();
        answer = kruskal(edges);

        return answer;
    }

    private int kruskal(Edge[] edges) {
        int answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                answer += edge.weight;
                if(cnt == N-1) break;
            }
        }

        return answer;
    }

    private Edge[] initEdgeArray(int n, int[][] costs) {
        Edge[] edges = new Edge[costs.length];

        for(int i =0; i<costs.length; i++) {
            edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
        }
        return edges;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
        int answer = solution.solution(n,costs);

        System.out.println(answer);
    }
}