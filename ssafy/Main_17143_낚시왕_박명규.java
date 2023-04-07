package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_17143_낚시왕_박명규 {
    static class shark {
        int r;
        int c;
        int s;
        int d;
        int z;

        public shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M,sum;
    static int[][] map;
    static ArrayList<shark> sharkList;
    static int[] dc = {0,0,0,1,-1};
    static int[] dr = {0,-1,1,0,0};
    static Map<Integer,Integer> switching = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sum = 0;
        map = new int[R + 1][C + 1];
        sharkList = new ArrayList<>();
        switching.put(1,2);
        switching.put(2,1);
        switching.put(3,4);
        switching.put(4,3);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            sharkList.add(new shark(r, c, s, d, z));
            map[r][c] = sharkList.size();
        }

        for (int i = 1; i <= C; i++) {
            fishing(i);
            move();
        }
        System.out.println(sum);

    }

    private static void move() {
        ArrayList<Integer> killList = new ArrayList<>();

        for(int i =0;i<sharkList.size();i++){
            shark temp = sharkList.get(i);
            map[temp.r][temp.c] = 0;
        }

        for(int i =0;i<sharkList.size();i++){
            shark temp = sharkList.get(i);
            int nr = temp.r;
            int nc = temp.c;
            for(int j = 0;j<temp.s;j++){
                nr += dr[temp.d];
                nc += dc[temp.d];
                if(nr<1 || nr>R || nc<1 || nc>C) {
                    nr -= dr[temp.d];
                    nc -= dc[temp.d];
                    temp.d = switching.get(temp.d);
                    j--;
                }
            }

            temp.r = nr;
            temp.c = nc;
            if(map[temp.r][temp.c] > 0){
                if(temp.z > sharkList.get(map[temp.r][temp.c]-1).z) {
                    killList.add(map[temp.r][temp.c]-1);
                    map[temp.r][temp.c] = i+1;
                } else {
                    killList.add(i);
                }
            } else {
                map[temp.r][temp.c] = i+1;
            }
        }
        Collections.sort(killList,Comparator.reverseOrder());
        Set<Integer> set = new HashSet<>();

        for(int i =0;i<killList.size();i++){
            if(set.add(killList.get(i))){
                sharkList.remove(killList.get(i));
            }
        }

    }

    private static void fishing(int c) {
        int r = 0;
        while (r <= R) {
            if (map[r][c] > 0) {
                sum += sharkList.get(map[r][c]-1).z;
                sharkList.remove(map[r][c] -1);
                map[r][c] = 0;
                break;
            }
            r++;
        }

    }


}
