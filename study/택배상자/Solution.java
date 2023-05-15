package study.택배상자;

import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        int cnt = 1;
        for(int i =0; i<order.length; i++) {
            while (order[i] > cnt) {
                stack.push(cnt++);
            }

            if(order[i] == cnt) {
                answer++;
                cnt++;
            } else if(!stack.isEmpty()&& stack.peek() == order[i]) {
                stack.pop();
                answer++;
            } else {
                break;
            }

        }


        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] order = {3,5,4,2,1};

        int answer = solution.solution(order);
        System.out.println(answer);
    }
}