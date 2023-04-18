package study.두원사이의정수쌍;

class Solution {
    public long solution(int r1, int r2) {
        long answer = 0;

        for(int i = 1; i< r2; i++) {
            answer += Math.floor(Math.sqrt(Math.pow(r2,2) - Math.pow(i,2)));
            if(i<r1) {
                answer -= Math.ceil(Math.sqrt(Math.pow(r1,2) - Math.pow(i,2)));
                answer ++;
            }
        }

        answer = (answer + r2 - r1 +1)*4;

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int r1 = 2;
        int r2 = 3;
        long answer = solution.solution(r1, r2);
        System.out.println(answer);
    }
}