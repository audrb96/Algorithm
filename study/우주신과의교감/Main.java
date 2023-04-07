package study.우주신과의교감;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Edge implements Comparable<Edge> {
        int from;
        int to;
        double distance;

        public Edge(int from, int to, double distance) {
            this.from = from;
            this.to = to;
            this.distance = distance;
        }

        @Override
        public int compareTo(Edge o) {
            return (this.distance - o.distance) > 0 ? 1 : -1;
        }
    }

    int[] parents;
    int N,M;

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

    public double solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Point[] points = initPoint(br);
        ArrayList<Edge> edges = initEdge(points);
        makeSet();
        alreadyConnect(br);
        Collections.sort(edges);
        double answer = kruskal(edges);

        return answer;
    }

    private double kruskal(ArrayList<Edge> edges) {
        double answer = 0;
        int cnt = 0;
        for (Edge edge : edges) {
            if(union(edge.from, edge.to)) {
                answer += edge.distance;
                if(++cnt == N-1) break;
            }
        }

        return answer;
    }

    private Point[] initPoint(BufferedReader br) throws IOException {
        String[] line = br.readLine().split(" ");
        N = Integer.parseInt(line[0]);
        M = Integer.parseInt(line[1]);

        Point[] points = new Point[N+1];

        for(int i =1; i<N+1; i++) {
            String[] temp = br.readLine().split(" ");
            points[i] = new Point(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
        return points;
    }

    private void alreadyConnect(BufferedReader br) throws IOException {
        for(int i =0; i<M; i++) {
            String[] temp = br.readLine().split(" ");
            union(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
        }
    }

    private ArrayList<Edge> initEdge(Point[] points) throws IOException {
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i =1; i<N+1; i++) {
            Point point1 = points[i];
            for(int j = i; j<N+1; j++ ) {
                Point point2 = points[j];
                edges.add(new Edge(i,j, Math.sqrt(Math.pow(point1.x-point2.x,2) + Math.pow(point1.y - point2.y,2))));
            }
        }

        return edges;
    }


    public static void main(String[] args) throws IOException {
        Main main = new Main();
        double answer = main.solution();
        System.out.printf("%.2f", answer);
    }
}
