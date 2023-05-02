package study.숫자카드나누기;

import java.util.ArrayList;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int A = getNum(arrayA, arrayB);
        int B = getNum(arrayB, arrayA);

        answer = Math.max(A,B);

        return answer;
    }

    private int getNum(int[] arrayA, int[] arrayB) {
        int max = 0;
        int gcd = 0;

        if(arrayA.length == 1) {
            gcd = arrayA[0];
        } else {
            gcd = arrayA[0];
            for(int i =1; i<arrayA.length; i++) {
                gcd = gcd(gcd, arrayA[i]);
            }
        }

        ArrayList<Integer> list = getCd(gcd);

        for(int i =0; i<list.size(); i++) {
            boolean flag = true;
            for(int j = 0; j<arrayB.length; j++) {
                if(arrayB[j]%list.get(i) == 0) flag = false;
            }
            if(flag) max = Math.max(max, list.get(i));
        }

        return max;
    }

    private ArrayList<Integer> getCd(int gcd) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i =2; i<=gcd; i++) {
            if(gcd%i == 0) list.add(i);
        }
        return list;
    }

    private int gcd(int a, int b) {
        if(b == 0) {
            return a;
        } else {
            return gcd(b,a%b);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] arrayA = {10,17};
//        int[] arrayB = {5,17};
        int[] arrayA = {10,20};
        int[] arrayB = {5,17};
        int answer = solution.solution(arrayA, arrayB);
        System.out.println(answer);
    }
}