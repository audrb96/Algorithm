
import java.util.ArrayList;
import java.util.Arrays;
public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        Integer[][] wrapper = new Integer[routes.length][2];

        for(int i = 0; i<routes.length; i++) {
            for(int j =0; j<routes[i].length; j++) {
                wrapper[i][j] = routes[i][j];
            }
        }

        Arrays.sort(wrapper, (o1, o2) -> o1[1]- o2[1]);
        int start = Integer.MIN_VALUE;
        int end = Integer.MIN_VALUE;

        for(int i =0;i<wrapper.length;i++) {
            start = wrapper[i][0];

            if(end < start) {
                answer++;
                end = wrapper[i][1];
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}};
//        int answer = solution.solution(routes);
//        System.out.println(answer);

    }
}
