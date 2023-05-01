package study.배달;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    static class Vertex implements Comparable<Vertex> {
        int no;
        int totalDistance;

        public Vertex(int no, int totalDistance) {
            this.no = no;
            this.totalDistance = totalDistance;
        }


        @Override
        public int compareTo(Vertex o) {
            return this.totalDistance - o.totalDistance;
        }
    }

    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] distance = new int[N+1];

        ArrayList<Vertex>[] matrix = setMatrix(N, road);
        Arrays.fill(distance, Integer.MAX_VALUE);

        PriorityQueue<Vertex> queue = new PriorityQueue<>();
        distance[1] = 0;
        queue.offer(new Vertex(1, distance[1]));
        Vertex current = null;

        while (!queue.isEmpty()) {

            current = queue.poll();

            if(distance[current.no] < current.totalDistance) {
                continue;
            }

            for(int c = 0; c<matrix[current.no].size(); c++) {
                Vertex curVertex = matrix[current.no].get(c);

                if(distance[curVertex.no] > current.totalDistance + curVertex.totalDistance) {
                    distance[curVertex.no] = current.totalDistance + curVertex.totalDistance;
                    queue.offer(new Vertex(curVertex.no, distance[curVertex.no]));
                }
            }
        }

        for(int i =1; i<N+1; i++) {
            if(distance[i] <= K) answer++;
        }

        return answer;
    }

    private ArrayList<Vertex>[] setMatrix(int N, int[][] road) {
        ArrayList<Vertex>[] matrix = new ArrayList[N+1];

        for(int i =1; i<N+1; i++) {
            matrix[i] = new ArrayList<>();
        }

        for(int i =0; i< road.length; i++) {
            int[] temp = road[i];
            matrix[temp[0]].add(new Vertex(temp[1], temp[2]));
            matrix[temp[1]].add(new Vertex(temp[0], temp[2]));
        }


        return matrix;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int N = 6;
        int[][] road = {{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
//        int[][] road = 	{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
        int K = 4;
        int answer = solution.solution(N, road, K);
        System.out.println(answer);
    }
}