package study.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        long q1Sum = 0;
        long q2Sum = 0;
        for(int i =0; i<queue1.length; i++) {
            q1.add(queue1[i]);
            q1Sum += queue1[i];

            q2.add(queue2[i]);
            q2Sum += queue2[i];
        }

        while (true) {
            if(q1Sum == q2Sum) break;
            if(q1.isEmpty() || q2.isEmpty()) break;
            if(answer > queue1.length*4) break;
            if(q1Sum > q2Sum) {
                int val = q1.poll();
                q1Sum -= val;
                q2Sum += val;
                q2.add(val);
            } else {
                int val = q2.poll();
                q1Sum += val;
                q2Sum -= val;
                q1.add(val);
            }
            answer++;
        }

        if(q1Sum != q2Sum) return -1;


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] queue1 = {3, 2, 7, 2};
//        int[] queue2 = {4,6,5,1};
//        int[] queue1 = {1, 2, 1, 2};
//        int[] queue2 = {1, 10, 1, 2};
        int[] queue1 = {1, 1};
        int[] queue2 = {1, 5};

        int answer = solution.solution(queue1, queue2);
        System.out.println(answer);
    }
}