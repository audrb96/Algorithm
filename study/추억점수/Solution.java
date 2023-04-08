package study.추억점수;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        int[] answer = new int[photo.length];
        Map<String, Integer> map = new HashMap<>();

        for(int i =0; i<name.length;i++) {
            map.put(name[i], yearning[i]);
        }

        for(int i = 0; i< photo.length; i++) {
            int sum = 0;
            for(int j=0;j<photo[i].length;j++) {
                if(map.containsKey(photo[i][j])) sum += map.get(photo[i][j]);
            }
            answer[i] = sum;
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] name = {"may", "kein", "kain", "radi"};
        int[] yearning = {5, 10, 1, 3};
        String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};

        int[] answer = solution.solution(name, yearning, photo);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}