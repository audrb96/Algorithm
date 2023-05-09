package study.풍선터트리기;

class Solution {
    public int solution(int[] a) {
        int[] leftMin = new int[a.length];
        int[] rightMin = new int[a.length];
        int left = a[0];
        int right = a[a.length-1];

        for(int i = 1;i<a.length-1; i++) {
            if(left > a[i]) left = a[i];
            leftMin[i] = left;
        }

        for(int i = a.length-1; i>0; i--) {
            if(right > a[i]) right = a[i];
            rightMin[i] = right;
        }
        if(a.length == 1) return 1;
        int answer = 2;


        for(int i =1; i<a.length-1;i++) {
            if(a[i] > leftMin[i] && a[i] > rightMin[i]) continue;
            answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] a = {-16,27,65,-2,58,-92,-71,-68,-61,-33};
        Solution solution = new Solution();
        int answer = solution.solution(a);
        System.out.println(answer);
    }
}