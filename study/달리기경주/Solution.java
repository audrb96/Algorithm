package study.달리기경주;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String, Integer> map = new HashMap<>();
        Map<Integer, String> map2 = new HashMap<>();
        for(int i =0; i<players.length; i++) {
            map.put(players[i], i+1);
            map2.put(i+1, players[i]);
        }

        for(int i =0; i<callings.length; i++) {
            String call = callings[i];

            int idx = map.get(call);
            String temp = map2.get(idx);

            String temp2 = map2.get(idx-1);
            int idx2 = map.get(temp2);

            map.put(call, idx-1);
            map.put(temp2, idx2+1);

            map2.put(idx, temp2);
            map2.put(idx2, call);
        }
        for(int i =0; i<answer.length;i++) {
            answer[i] = map2.get(i+1);
        }



        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] players = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] answer = solution.solution(players, callings);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}