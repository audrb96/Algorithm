package study.요격시스템;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int e = 0;

        for(int i =0; i<targets.length; i++) {
            int[] temp = targets[i];
            if(e <= temp[0]) {
                answer++;
                e = temp[1];
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] target = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
        int answer = solution.solution(target);
        System.out.println(answer);
    }
}