package study;


import java.util.Stack;

class Solution1 {
    public int solution(String S) {
        Stack<Character> stack = new Stack<>();
        int answer = 0;
        int tempAnswer = 0;
        for(int i =0; i<S.length(); i++) {
            char temp = S.charAt(i);
            if(temp == '<') {
                tempAnswer = 0;
                stack.push('<');
                continue;
            }
            boolean flag = false;
            if(temp == '?') {
                for(int j = i+1; j<S.length(); j++) {
                    if(S.charAt(j) == '?') continue;
                    if(S.charAt(j) == '<') break;
                    if(S.charAt(j) == '>') {
                        flag = true;
                    }
                }
            }
            if(!flag) {
                stack.push('<');
                tempAnswer = 0;
            }
            if((flag || temp == '>') && !stack.isEmpty() && stack.peek() == '<') {
                tempAnswer = tempAnswer+2;
                answer = Math.max(tempAnswer, answer);
            }
        }

        return answer;
    }



    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        String S = "<<?";


        int answer = solution.solution(S);
        System.out.println(answer);
    }
}