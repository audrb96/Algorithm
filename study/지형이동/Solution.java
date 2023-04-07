package study.지형이동;

import java.util.*;

class Solution {

    static class Edge implements Comparable<Edge> {
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

    int[] dx = {1,0};
    int[] dy = {0,1};
    int[] parents;
    int M;

    public void makeSet() {
        parents = new int[M];
        for(int i = 0; i< M; i++) {
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



    private int kruskal(ArrayList<Edge> edges) {
        int weight = 0;
        int cnt = 0;

        for (Edge edge : edges) {
            if(union(edge.to, edge.from)) {
                weight += edge.weight;
                if(++cnt == M -1) break;
            }
        }

        return weight;
    }

    private ArrayList<Edge> setEdge(int[][] land, int height) {
        ArrayList<Edge> edges = new ArrayList<>();
        int N = land.length;

        for(int i =0; i< N;i++) {
            for(int j =0; j<N;j++) {
                for(int d = 0; d<2;d++) {
                    int nx = j + dx[d];
                    int ny = i + dy[d];
                    if(nx >= N || nx < 0 || ny >= N || ny < 0) continue;
                    int weight =  Math.abs(land[i][j] - land[ny][nx]) <= height ? 0 :  Math.abs(land[i][j] - land[ny][nx]);
                    Edge edge = new Edge(i*N+j, ny*N + nx, weight);
                    edges.add(edge);
                }
            }
        }

        return edges;
    }

    public int solution(int[][] land, int height) {
        int answer = 0;
        M = land.length*land.length; //전체 크기
        ArrayList<Edge> edges = setEdge(land, height); // edge 세팅
        Collections.sort(edges); //정렬
        makeSet(); //초기화
        answer = kruskal(edges); //크루스칼

        return answer;
    }
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}};
        int height = 1;

        int answer = solution.solution(land,height);
        System.out.println(answer);
        }
}