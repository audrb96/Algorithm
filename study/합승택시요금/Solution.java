package study.합승택시요금;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class Node implements Comparable<Node> {
        int no;
        int totalDistance;

        public Node(int no, int totalDistance) {
            this.no = no;
            this.totalDistance = totalDistance;
        }


        @Override
        public int compareTo(Node o) {
            return this.totalDistance - o.totalDistance;
        }
    }


    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;

        ArrayList<Node>[] matrix = setMatrix(fares, n);
        int[] startDist = dijkstra(s,n, matrix);
        int min = Integer.MAX_VALUE;

        for(int i =1; i<n+1; i++) {
            int[] finalDist = dijkstra(i,n, matrix);
            min = Math.min(min, startDist[i] + finalDist[a] + finalDist[b]);
        }
        answer = min;
        return answer;
    }

    private int[] dijkstra(int s, int n, ArrayList<Node>[] matrix) {
        int[] dist = new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        dist[s] = 0;
        pQueue.add(new Node(s,dist[s]));
        Node cur;

        while (!pQueue.isEmpty()) {
            cur = pQueue.poll();

            if(cur.totalDistance > dist[cur.no]) {
                continue;
            }

            for(int c = 0; c<matrix[cur.no].size(); c++) {
                Node next = matrix[cur.no].get(c);

                if(dist[next.no] > cur.totalDistance + next.totalDistance ) {
                    dist[next.no] = cur.totalDistance + next.totalDistance;
                    pQueue.offer(new Node(next.no, dist[next.no]));
                }
            }
        }


        return dist;
    }

    private ArrayList<Node>[] setMatrix(int[][] fares,int n) {
        ArrayList<Node>[] matrix = new ArrayList[n+1];

        for(int i =1; i<n+1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for(int i = 0; i< fares.length; i++) {
            int[] temp = fares[i];
            matrix[temp[0]].add(new Node(temp[1], temp[2]));
            matrix[temp[1]].add(new Node(temp[0], temp[2]));
        }

        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 6;
        int s = 4;
        int a = 6;
        int b = 2;
        int[][] fares = {{4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}};
        int answer = solution.solution(n, s, a, b, fares);
        System.out.println(answer);
    }
}