package com.ssafy.bj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class bj_16926 {
    static int N;
    static boolean eat_fish;
    static int curX;
    static int curY;

    static int[][] area;
    static int weight;

    static int[] dx = { 0, -1, 1, 0 };
    static int[] dy = { -1, 0, 0, 1 };
    static boolean[][] isVisited;
    static int time = 0;
    static int eat = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        area = new int[N][N];
        weight = 2;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int temp = Integer.parseInt(st.nextToken());
                area[i][j] = temp;

                if (temp == 9) {
                    curX = j;
                    curY = i;
                }
            }
        }
        isVisited = new boolean[N][N];
        Queue<Integer[]> block = new LinkedList<>();

        boolean find = false;
        Integer[] temp;
        int min = Integer.MAX_VALUE;
        int x_min = Integer.MAX_VALUE;
        int y_min = Integer.MAX_VALUE;
        int eat = 0;
        int count =0;
        isVisited[curY][curX]= true;
        area[curY][curX]=0;
        while (true) {
            block.add(new Integer[] { curY, curX, 0 });
            isVisited[curY][curX]= true;
            while (!(block.isEmpty())) {
                Integer[] idx = block.poll();
                for (int k = 0; k < 4; k++) {
                    int i_i = idx[0] + dy[k];
                    int j_j = idx[1] + dx[k];
                    if (i_i < N && i_i >= 0 && j_j < N && j_j >= 0 && idx[2] < min) {
                        if (area[i_i][j_j] < weight && area[i_i][j_j] != 0 && !isVisited[i_i][j_j]) {
                            find=true;
                            if (min > idx[2] + 1) {
                                min = idx[2] + 1;
                                x_min = j_j;
                                y_min = i_i;
                            } else if (min == idx[2] + 1) {
                                if (y_min > i_i) {
                                    x_min = j_j;
                                    y_min = i_i;
                                } else if (y_min == i_i) {
                                    if (x_min > j_j) {
                                        x_min = j_j;
                                        y_min = i_i;
                                    }

                                }
                            }
                        }
                        else if ((area[i_i][j_j] == 0||area[i_i][j_j] <= weight) && !isVisited[i_i][j_j] &&min>idx[2]+1) {
                            block.add(new Integer[] {i_i,j_j,idx[2]+1});
                            isVisited[i_i][j_j]=true;
                        }

                    }
                }
            }
            if(find) {
                eat++;
                curX =x_min;
                curY = y_min;

                ;
                count = count+min;
                area[curY][curX]=0;

                if(eat ==weight) {
                    eat =0;
                    weight++;
                }

                find=false;
                min = Integer.MAX_VALUE;
                isVisited = new boolean[N][N];
                x_min = Integer.MAX_VALUE;
                y_min = Integer.MAX_VALUE;

            }
            else {
                break;
            }
        }
        System.out.println(count);

    }
}