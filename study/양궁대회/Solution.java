package study.양궁대회;


import java.util.Arrays;

class Solution {
    int total;
    int[] aInfo;
    int maxDiff;
    int[] maxLInfo;


    public int[] solution(int n, int[] info) {
        aInfo = info;
        total = n;
        maxDiff = 0;
        dfs(0,new int[10], 0);

        return maxDiff > 0 ? maxLInfo : new int[]{-1};
    }

    private void dfs(int remain, int[] lInfo, int idx) {
        if(remain == total) {
                int lScore = 0;
                int aScore = 0;

                for(int i =0; i< 11; i++) {
                    if(lInfo[i] > aInfo[i]) {
                        lScore += 10 - i;
                    } else if(aInfo[i] != 0) {
                        aScore += 10 - i;
                    }
                }
                int scoreDiff = lScore - aScore;

                if(maxDiff < scoreDiff) {
                    maxDiff = scoreDiff;
                    maxLInfo = lInfo;
                } else if (maxDiff > 0 && maxDiff == scoreDiff) {
                    for(int i =10; i>=0 ;i--) {
                        if(lInfo[i] > maxLInfo[i]) {
                            maxLInfo = lInfo;
                        } else if(maxLInfo[i] > lInfo[i]) {
                            return;
                        }
                    }
                }
            return;
        }

        for(int i = idx; i<11; i++) {
            int[] nextLInfo = Arrays.copyOf(lInfo, 11);

            if(i == 10) {
                nextLInfo[i] += total - remain;
                dfs(total, nextLInfo, i);
                continue;
            }

            if(total - remain > aInfo[i]) {
                nextLInfo[i] += aInfo[i]+1;
                dfs(remain + aInfo[i] + 1, nextLInfo, i);
            }
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 5;
        int[] info = {2,1,1,1,0,0,0,0,0,0,0};
        int[] answer = solution.solution(n, info);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}