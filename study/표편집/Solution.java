//package study.표편집;
//
//import java.util.Stack;
//
//class Solution {
//    boolean[] isDeleted;
//    Stack<Integer> stack;
//    int now;
//    int N,K;
//
//    public String solution(int n, int k, String[] cmd) {
//        String answer = "";
//        isDeleted = new boolean[n];
//        stack = new Stack<>();
//        N = n;
//        K = k;
//        now = k;
//
//        for(int i =0; i<cmd.length; i++) {
//            char action = cmd[i].charAt(0);
//            switch (action) {
//                case 'U' : up(cmd[i].charAt(2) - '0'); break;
////                case 'D' : down(cmd[i].charAt(2) - '0'); break;
//                case 'C' : delete(); break;
//                case 'Z' : back(); break;
//            }
//        }
//
//        for(int i =0; i<N; i++) {
//            if(isDeleted[i]) answer += 'X';
//            else answer += 'O';
//        }
//
//        return answer;
//    }
//
//    private void back() {
//        if(!stack.isEmpty()) {
//            int pop = stack.pop();
//            isDeleted[pop] = false;
//        }
//    }
//
//    private void delete() {
//        stack.add(now);
//        isDeleted[now] = true;
//        boolean isEnd = true;
//        for(int i = now+1; i<N; i++) {
//            if (!isDeleted[i]) {
//                isEnd = false;
//                break;
//            }
//        }
//        if(isEnd) {
//            up(1);
//        } else {
//            down(1);
//        }
//    }
//
//
//    private void down(int cnt, boolean flag) {
//        int downCount = 0;
//
//        while (now < N) {
//            if(isDeleted[now]) {
//                now++;
//                continue;
//            }
//            now++;
//            downCount++;
//            if(downCount >= cnt) break;
//        }
//    }
//
//    private void up(int cnt) {
//        int upCnt = 0;
//
//        while (upCnt < cnt && now > 0) {
//            if(isDeleted[now]) {
//                now--;
//                continue;
//            }
//            now--;
//            upCnt++;
//        }
//    }
//
//    public static void main(String[] args) {
//        int n = 8;
//        int k = 2;
//        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
//        Solution solution = new Solution();
//        String answer = solution.solution(n, k, cmd);
//        System.out.println(answer);
//    }
//}