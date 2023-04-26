package study.테이블해시함수;

import java.util.Arrays;

class Solution {

    public int solution(int[][] data, int col, int row_begin, int row_end) {
        int answer = 0;
        Arrays.sort(data,((o1, o2) -> {
            if(o1[col-1] != o2[col-1]) return o1[col-1] - o2[col-1];
            else return o2[0] - o1[0];
        }));

        for (int i = row_begin-1; i < row_end; i++) {
            int[] tuple = data[i];
            int S_i = 0;

            for (int j = 0; j < tuple.length; j++) {
                S_i += tuple[j]%(i+1);
            }
            answer = answer ^ S_i;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] data = {{2,2,6},{1,5,10},{4,2,9},{3,8,3}};
        int col = 2;
        int row_begin = 2;
        int row_end = 3;
        int answer = solution.solution(data, col, row_begin, row_end);
        System.out.println(answer);
    }
}