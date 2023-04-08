package study.과제진행하기;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;

class Solution {
    static class Homework implements Comparable<Homework>{
        String name;
        int start;
        int remain;

        public Homework(String name, int start, int remain) {
            this.name = name;
            this.start = start;
            this.remain = remain;
        }

        @Override
        public int compareTo(Homework o) {
            return this.start - o.start;
        }
    }

    public String[] solution(String[][] plans) {
        ArrayList<String> answer = new ArrayList<>();
        int N = plans.length;
        PriorityQueue<Homework> queue = new PriorityQueue<>();
        Stack<Homework> stop = new Stack<>();

        for(int i =0; i<N; i++) {
            String name = plans[i][0];
            int start = getTime(plans[i]);
            int remain = getSpend(plans[i]);

            queue.add(new Homework(name,start,remain));
        }

        int now = 0;
        boolean flag = false;

        while (!queue.isEmpty()) {
            Homework cur;
            if(flag&&stop.isEmpty()) {
                cur = queue.poll();
                flag = false;
            } else {
                cur = flag ? stop.pop() : queue.poll();
            }
            if(cur == null) break;
            if(!flag) now = cur.start;

            if(!queue.isEmpty() && now + cur.remain > queue.peek().start) { // 과제 중간에 새로운 과제를 시작할 시각이 되었을 때,
                stop.add(new Homework(cur.name, cur.start, now+cur.remain - queue.peek().start));
                flag = false;
                continue;
            }

            if(!queue.isEmpty() && now + cur.remain == queue.peek().start) {
                flag = false;
                answer.add(cur.name);
                continue;
            }

            flag = true;
            now = now + cur.remain;
            answer.add(cur.name);
        }

        while (!stop.isEmpty()) {
            answer.add(stop.pop().name);
        }

        return answer.toArray(new String[answer.size()]);
    }

    private static int getSpend(String[] plans) {
        return Integer.parseInt(plans[2]);
    }

    private static int getTime(String[] plans) {
        return Integer.parseInt(plans[1].substring(0, 2)) * 60 + Integer.parseInt(plans[1].substring(3, 5));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String[][] plans = {{"1", "00:00", "30"}, {"2", "00:10", "10"}, {"3", "00:30", "10"}, {"4", "00:50", "10"}} ;
        String[] answer = solution.solution(plans);
        for (String s : answer) {
            System.out.println(s);
        }
    }
}