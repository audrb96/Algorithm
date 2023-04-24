package study.뒤에있는큰수찾기;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        for(int i =1; i<numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] numbers = {9, 1, 5, 3, 6, 2};
        int[] answer = solution.solution(numbers);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}