package study.광물캐기;

import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        Map<Integer, Map<String, Integer>> map = setMap();
        int num = picks[0] + picks[1] + picks[2];

        List<String> mineralList = new LinkedList<>(Arrays.asList(minerals));
        ArrayList<int[]> section = new ArrayList<>();


        while (!mineralList.isEmpty() && num > 0) {

            int diaStress = getStress(map,mineralList, 0);
            int ironStress = getStress(map,mineralList, 1);
            int stoneStress = getStress(map,mineralList, 2);

            section.add(new int[]{diaStress, ironStress, stoneStress});
            int count = 0;

            while (count < 5 && !mineralList.isEmpty()) {
                mineralList.remove(0);
                count++;
            }
            num--;
        }

        Collections.sort(section, (o1, o2) -> o2[2] - o1[2]);

        int now = 0;
        int count = 0;

        while (count < section.size() && now<=2){
            if(picks[now] > 0) {
                answer += section.get(count)[now];
                picks[now] --;
                count++;
            } else {
                now++;
            }
        }

        return answer;
    }

    private int getStress(Map<Integer, Map<String, Integer>> map, List<String> mineralList, int pick) {
        int count = 0;
        int stress = 0;

        while (count < 5 && count < mineralList.size()) {
            String mineral = mineralList.get(count);
            stress += map.get(pick).get(mineral);
            count++;
        }

        return stress;
    }

    private Map<Integer, Map<String, Integer>> setMap() {
        Map<Integer, Map<String, Integer>> map = new HashMap<>();

        map.put(0,new HashMap<>());
        map.put(1,new HashMap<>());
        map.put(2,new HashMap<>());

        Map<String, Integer> stress = map.get(0);
        stress.put("diamond", 1);
        stress.put("iron", 1);
        stress.put("stone", 1);

        stress = map.get(1);
        stress.put("diamond", 5);
        stress.put("iron", 1);
        stress.put("stone", 1);

        stress = map.get(2);
        stress.put("diamond", 25);
        stress.put("iron", 5);
        stress.put("stone", 1);
        return map;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] picks = {0,1,1};
        String[] minerals = {"diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"};

        int answer = solution.solution(picks, minerals);
        System.out.println(answer);

    }
}