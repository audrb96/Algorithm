package study.부대복귀;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = {};
        ArrayList<Integer>[] lists = setLists(n,roads);
        answer = bfs(lists,sources,destination);

        return answer;
    }

    private int[] bfs(ArrayList<Integer>[] lists, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        int[] dist = new int[lists.length];
        Arrays.fill(dist,-1);
        Queue<int[]> queue = new LinkedList<>();
        boolean[] isVisited = new boolean[lists.length];

        queue.add(new int[]{destination, 0});
        isVisited[destination] = true;
        dist[destination] = 0;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            for(int j = 0; j<lists[temp[0]].size(); j++) {
                Integer next = lists[temp[0]].get(j);
                if(isVisited[next]) continue;
                isVisited[next] = true;
                dist[next] = temp[1] + 1;
                queue.add(new int[]{next, temp[1]+1});
            }
        }

        for(int i =0; i<sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }

    private ArrayList<Integer>[] setLists(int n, int[][] roads) {
        ArrayList<Integer>[] lists = new ArrayList[n+1];

        for(int i =1; i<n+1; i++) {
            lists[i] = new ArrayList<>();
        }

        for(int i =0; i<roads.length; i++) {
            int[] temp = roads[i];
            lists[temp[0]].add(temp[1]);
            lists[temp[1]].add(temp[0]);
        }


        return lists;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int n = 5;
        int[][] roads =	{{1, 2}, {1, 4}, {2, 4},{2, 5}, {4, 5}};
        int[] sources = {1,3,5};
        int destination = 5;
        int[] answer = solution.solution(n, roads, sources, destination);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}