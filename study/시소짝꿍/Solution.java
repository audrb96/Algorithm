package study.시소짝꿍;

import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        Arrays.sort(weights);
        Map<Double, Integer> map = new HashMap<>();

        for(int i =0; i<weights.length; i++) {
            double a = weights[i];
            double b = (weights[i]*2.0)/3.0;
            double c = (weights[i]*1.0)/2.0;
            double d = (weights[i]*3.0)/4.0;

            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);

            map.put(weights[i] * 1.0, map.getOrDefault(weights[i] * 1.0, 0) +1);
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] weight = {100,180,360,100,270};

        long answer = solution.solution(weight);
        System.out.println(answer);
    }
}