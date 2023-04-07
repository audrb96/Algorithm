package study.보석쇼핑;

import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> set = new HashSet<>(Arrays.asList(gems));
        Map<String, Integer> map = new HashMap<>();
        int distance = Integer.MAX_VALUE;

        int start = 0;
        int end = gems.length-1;

        int left = 0;
        int right = 0;

        while (true) {
            if(map.size() == set.size()) {
                map.put(gems[left], map.get(gems[left]) - 1);
                if(map.get(gems[left]) == 0) map.remove(gems[left]);
                left++;
            } else if (right > gems.length-1) break;
            else {
                map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
                right++;
            }

            if(map.size() == set.size()) {
                if(distance > right - left) {
                    distance = right - left;
                    start = left + 1;
                    end = right;
                }
            }
        }

        int[] answer = {start, end};


        return answer;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"}		;
//        String[] gems = {"AA", "AB", "AC", "AA", "AC"};
//        String[] gems = {"XYZ", "XYZ", "XYZ"};
        String[] gems = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
        int[] answer = solution.solution(gems);
        for (int i : answer) {
            System.out.println(i);
        }
    }
}