package study;


import java.util.Stack;

class Solution {
    char[] selected;
    char[] array = {'<', '>'};
    int answer = 0;
    public int solution(String S) {
        int questCount = 0;
        for(int i =0; i<S.length(); i++) {
            char temp = S.charAt(i);
            if(temp == '?') questCount++;
        }
        selected = new char[questCount];
        perm(0,S, questCount);
        return answer;
    }

    public void perm(int cnt, String S, int questCount) {
        if(cnt == questCount) {
            StringBuilder sb = new StringBuilder();
            StringBuilder SBuilder = new StringBuilder(S);
            for(int i =0; i< selected.length; i++) {
                sb.append(selected[i]);
            }
            String word = sb.toString();
            int temp = 0;
            for(int i =0; i<SBuilder.length(); i++) {
                if(SBuilder.charAt(i) == '?') SBuilder.replace(i, i+1, word.charAt(temp++) + "");
            }
            String full = SBuilder.toString();

            int tempAnswer = 0;
            Stack<Character> stack = new Stack<>();

            for(int i =0; i<full.length(); i++) {
                char now = full.charAt(i);
                if(now == '<') {
                    stack.push(now);
                    tempAnswer = 0;
                }
                if(now == '>' && !stack.isEmpty() && stack.peek() == '<') {
                    stack.pop();
                    tempAnswer = tempAnswer+2;
                    answer = Math.max(answer, tempAnswer);
                }
            }

            return;
        }

        for(int i =0; i<2; i++) {
            selected[cnt] = array[i];
            perm(cnt+1, S, questCount);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String S = "???????????????????????????????????????????????????????????????????????????????????";


        int answer = solution.solution(S);
        System.out.println(answer);
    }
}