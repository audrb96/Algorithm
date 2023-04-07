package study.전력망을둘로나누기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] matrix = new int[n+1][n+1];

        for(int i =0; i< wires.length; i++) {
            int[] wire = wires[i];
            int to = wire[0];
            int from = wire[1];

            matrix[to][from] = 1;
            matrix[from][to] = 1;
        }

        for(int i =0; i< wires.length;i++) {
            int[] wire = wires[i];
            int to = wire[0];
            int from = wire[1];
            int[][] tempMatrix = new int[n+1][n+1];
            for(int j =0; j<n+1; j++) {
                System.arraycopy(matrix[j], 0, tempMatrix[j], 0, tempMatrix.length);
            }

            tempMatrix[to][from] = 0;
            tempMatrix[from][to] = 0;
            int gap = bfs(tempMatrix,n,to, from);

            answer = Math.min(answer, gap);
        }

        return answer;
    }

    private int bfs(int[][] tempMatrix,int n, int to, int from) {
        int[] gap = new int[2];
        int[] toFrom = {to, from};
        boolean[] isVisited = new boolean[n+1];

        for(int i =0; i<2; i++) {
            int now = toFrom[i];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(now);
            isVisited[now] = true;
            gap[i] ++;

            while (!queue.isEmpty()) {
                int temp = queue.poll();

                for(int j =1; j<n+1;j++) {
                    if(isVisited[j] || tempMatrix[temp][j] == 0) continue;
                    queue.add(j);
                    isVisited[j] = true;
                    gap[i]++;
                }
            }
        }
        return Math.abs(gap[0] - gap[1]);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
        int answer = solution.solution(n, wires);
        System.out.println(answer);
    }
}