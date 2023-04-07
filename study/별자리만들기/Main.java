package study.별자리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    static class Point {
        double x;
        double y;

        public Point(double x, double y) {
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


    private double calculateDistance(Point point1, Point point2) {
        return Math.sqrt(Math.pow(point1.x - point2.x, 2) + Math.pow(point1.y - point2.y,2));
    }

    int[] parents;
    int N;

    private void makeSet() {
        parents = new int[N];
        for(int i =0; i<N; i++) {
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
        parents[bRoot] =aRoot;
        return true;
    }

    private double solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Point[] points = setPoints(br);
        ArrayList<Edge> edges = setEdges(points);
        Collections.sort(edges);
        makeSet();
        double answer = kruskal(edges);

        return answer;
    }

    private double kruskal(ArrayList<Edge> edges) {
        double answer = 0;
        int cnt = 0;

        for (Edge edge : edges) {
            if(union(edge.to, edge.from)) {
                answer += edge.distance;
                if(++cnt == N-1) break;
            }
        }
        return answer;
    }

    private ArrayList<Edge> setEdges(Point[] points) {
        ArrayList<Edge> edges = new ArrayList<>();

        for(int i =0; i<N;i++) {
            for(int j=i; j<N;j++) {
                edges.add(new Edge(i,j,calculateDistance(points[i], points[j])));
            }
        }
        return edges;
    }

    private Point[] setPoints(BufferedReader br) throws IOException {
        Point[] points = new Point[N];

        for(int i =0; i<N; i++) {
            String[] line = br.readLine().split(" ");
            points[i] = new Point(Double.parseDouble(line[0]), Double.parseDouble(line[1]));
        }
        return points;
    }

    public static void main(String[] args) throws IOException {
        Main main = new Main();
        double answer = main.solution();
        System.out.printf("%.2f", answer);
    }
}
