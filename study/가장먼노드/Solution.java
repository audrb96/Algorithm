package study.가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        for(int i =0; i<n+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i =0; i<edge.length; i++) {
            int[] node = edge[i];
            graph[node[0]].add(node[1]);
            graph[node[1]].add(node[0]);
        }

        answer = bfs(graph);
        return answer;
    }

    private int bfs(ArrayList<Integer>[] graph) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[graph.length];
        queue.add(new int[]{1, 0});
        isVisited[1] = true;
        int max = 0;
        int count = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int next : graph[temp[0]]) {
                if(isVisited[next]) continue;
                if(temp[1] + 1 > max) {
                    max = temp[1]+1;
                    count = 1;
                } else if (temp[1] + 1 == max) {
                    count++;
                }
                queue.add(new int[]{next, temp[1]+1});
                isVisited[next] = true;
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;
        Solution solution = new Solution();
        int answer = solution.solution(n, vertex);
        System.out.println(answer);
    }
}