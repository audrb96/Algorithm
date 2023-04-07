package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

class Enemy implements Comparable<Enemy>{
    int r;
    int c;
    int dist;
    int index;

    public Enemy(int r, int c, int dist, int index) {
        this.r = r;
        this.c = c;
        this.dist = dist;
        this.index = index;
    }

    @Override
    public int compareTo(Enemy o) {
        return (this.dist - o.dist)==0?this.c-o.c:this.dist-o.dist;
    }


}

public class Main_17135_캐슬디펜스_박명규 {
    static int N,M,D;
    static int[][] map;
    static ArrayList<int[]> enemy;
    static int killEnemy;
    static int enemyCount;
    static int max;
    static int[] seleted = new int[3];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        map = new int[N+1][M];
        enemy = new ArrayList<>();

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    enemy.add(new int[] {i,j});
                }
            }
        }
        max = Integer.MIN_VALUE;

        combi(0,0);
        System.out.println(max);

    }

    private static void combi(int start, int cnt) {
        if(cnt == 3) {
            ArrayList<int[]> temp = new ArrayList<>();
            for(int i =0;i<enemy.size();i++){
                temp.add(new int[]{enemy.get(i)[0], enemy.get(i)[1]});
            }
            enemyCount = enemy.size();
            killEnemy = 0;

            while(enemyCount > 0) {
                PriorityQueue<Enemy> pqueue = new PriorityQueue<>();
                ArrayList<Integer> killList = new ArrayList<>();
                int size = temp.size();
                for(int j = 0; j < 3; j++) {
                    pqueue.clear();
                    for(int i = 0; i < size; i++) {
                        int r = temp.get(i)[0];
                        int c = temp.get(i)[1];
                        int dist = Math.abs(r - N) + Math.abs(c - seleted[j]);
                        if(dist <= D) {
                            pqueue.add(new Enemy(r, c, dist, i));
                        }
                    }
                    if(pqueue.isEmpty())continue;
                    Enemy current = pqueue.poll();
                    killList.add(current.index);
                }
                Collections.sort(killList);
                Set<Integer> set = new HashSet<>();
                for(int i = killList.size()-1; i >= 0; i--) {
                    if(set.add(killList.get(i))) {
                        temp.remove((int)killList.get(i));
                        enemyCount--;
                        killEnemy++;
                    }
                }

                size = temp.size();
                for(int i = size-1; i >= 0; i--) {
                    if(temp.get(i)[0] + 1 == N) {
                        temp.remove(i);
                        enemyCount--;
                    }else {
                        temp.get(i)[0]++;
                    }
                }

            }
            max = Math.max(max, killEnemy);
            return;
        }

        for(int i = start; i < M; i++) {
            seleted[cnt] = i;
            combi(i+1, cnt+1);
        }

    }

}
