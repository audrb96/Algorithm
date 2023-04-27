package study.디펜스게임;

import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int n, int k, int[] enemy) {
        int answer = 0;
        int now = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        while (n >= 0 && now < enemy.length) {

            n -= enemy[now];
            queue.add(enemy[now]);

            if(!queue.isEmpty() && n < 0 && k>0) {
                n += queue.poll();
                k--;
            }

            if(n >= 0) answer = now+1;
            now++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 10;
        int k = 1;
        int[] enemy = {2, 2, 2, 2, 2, 10};

//        int n = 2;
//        int k = 4;
//        int[] enemy = {3, 3, 3, 3};
        int answer = solution.solution(n, k, enemy);
        System.out.println(answer);
    }
}