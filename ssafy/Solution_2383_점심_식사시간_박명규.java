package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_2383_점심_식사시간_박명규 {
    static class Person {
        int r;
        int c;
        int distance;
        int time;
        boolean isOut;
        boolean isIn;

        public Person(int r, int c, int distance,int time,boolean isOut,boolean isIn) {
            this.r = r;
            this.c = c;
            this.distance = distance;
            this.time = time;
            this.isOut = isOut;
            this.isIn = isIn;
        }
    }

    static class Stair {
        int r;
        int c;
        int length;
        int people;

        public Stair(int r, int c, int length, int people) {
            this.r = r;
            this.c = c;
            this.length = length;
            this.people = people;
        }

    }

    static int T,N,min;
    static ArrayList<Person> personList;
    static boolean[] selected;
    static Stair[] stairs;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int tc = 1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            stairs = new Stair[2];
            personList = new ArrayList<>();
            min = Integer.MAX_VALUE;
            int k =0;
            for(int i =0;i<N;i++){
                st = new StringTokenizer(br.readLine());
                for(int j =0;j<N;j++){
                    int temp = Integer.parseInt(st.nextToken());
                    if(temp == 0) continue;
                    if(temp == 1) personList.add(new Person(i,j,0,0,false,false));
                    else {
                        stairs[k++] = new Stair(i,j,temp,0);
                    }
                }
            }
            selected = new boolean[personList.size()];
            subset(0);
            sb.append("#").append(tc).append(" ").append(min).append("\n");
        }
        System.out.print(sb);

    }

    private static void subset(int cnt) {
        if(cnt == personList.size()) {
            ArrayList<Person> stair1P = new ArrayList<>();
            ArrayList<Person> stair2P = new ArrayList<>();

            for(int i =0;i<personList.size();i++){
                if(selected[i]) {
                    int distance = Math.abs(personList.get(i).r - stairs[0].r) + Math.abs(personList.get(i).c - stairs[0].c);
                    stair1P.add(new Person(personList.get(i).r, personList.get(i).c, distance,0,false,false));
                } else {
                    int distance = Math.abs(personList.get(i).r - stairs[1].r) + Math.abs(personList.get(i).c - stairs[1].c);
                    stair2P.add(new Person(personList.get(i).r, personList.get(i).c, distance,0,false,false));
                }
            }
            int curTime = 0;
            int out = 0;
            while (true){
                curTime++;
                if (min <= curTime) {
                    stairs[0].people = 0;
                    stairs[1].people = 0;
                    return;
                }

                for(int i =0;i<stair1P.size();i++){
                    if(stair1P.get(i).isIn) {
                        stair1P.get(i).time ++;
                        if(stair1P.get(i).time == stairs[0].length){
                            out ++;
                            stair1P.get(i).isOut = true;
                            stairs[0].people--;
                        }
                    }
                }

                for(int i =0;i<stair2P.size();i++){
                    if(stair2P.get(i).isIn) {
                        stair2P.get(i).time ++;
                        if(stair2P.get(i).time == stairs[1].length){
                            out ++;
                            stair2P.get(i).isOut = true;
                            stairs[1].people--;
                        }
                    }
                }

                if(out == personList.size()) break;



                for (int i = 0; i < stair1P.size(); i++) {
                    if (!stair1P.get(i).isIn && !stair1P.get(i).isOut && stair1P.get(i).distance <= curTime && stairs[0].people < 3) {
                        stair1P.get(i).isIn = true;
                        stairs[0].people ++;
                    }
                }

                for (int i = 0; i < stair2P.size(); i++) {
                    if (!stair2P.get(i).isIn && !stair2P.get(i).isOut && stair2P.get(i).distance <= curTime && stairs[1].people < 3) {
                        stair2P.get(i).isIn = true;
                        stairs[1].people++;
                    }
                }

            }
            stairs[0].people = 0;
            stairs[1].people = 0;
            min = Math.min(min,curTime+1);
            return;
        }

        selected[cnt] = true;
        subset(cnt + 1);
        selected[cnt] = false;
        subset(cnt + 1);

    }
}
