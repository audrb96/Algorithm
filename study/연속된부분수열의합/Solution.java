package study.연속된부분수열의합;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {};

        int i = 0;
        int j = 0;
        int N = sequence.length;
        int min = Integer.MAX_VALUE;
        int sum = 0;

        while (i < N+1) {
            if(sum <= k && i<N) {
                sum += sequence[i++];
            } else {
                sum -= sequence[j++];
            }

            if(min > i-j && sum == k) {
                min = i-j;
                answer = new int[]{j,i-1};
            }
            if(i==j) break;
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] sequence = {2, 2, 2, 2, 2};
        int k = 6;
        Solution solution = new Solution();
        int[] answer = solution.solution(sequence, k);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}