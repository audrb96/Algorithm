package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_2239_스도쿠_박명규 {
    static int[][] sudoku;
    static int zero;
    static ArrayList<int[]> index;
    static int[][] ans;
    static boolean[][][] numUsed;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sudoku = new int[9][9];
        zero  = 0;
        index = new ArrayList<>();
        ans = new int[9][9];
        numUsed = new boolean[10][10][2];
        for(int i =0;i<9;i++){
            String line = br.readLine();
            for(int j =0;j<9;j++){
                sudoku[i][j] = line.charAt(j) - '0';
                if(sudoku[i][j] == 0) {
                    index.add(new int[]{i,j});
                    zero ++;
                }
                else {
                    numUsed[sudoku[i][j]][i][0] = true;
                    numUsed[sudoku[i][j]][j][1] = true;
                }
                ans[i][j] = 9;
            }
        }

        backtracking(0);
        for (int[] an : ans) {
            for (int i : an) {
                System.out.print(i);
            }
            System.out.println();
        }

    }
    public static void backtracking(int cnt){
        //기저조건
        if(zero == cnt){
            boolean check = false;

            for(int i =0;i<9;i++){
                for(int j =0;j<9;j++){
                    if(ans[i][j] > sudoku[i][j]) {
                     check=true;
                     break;
                    }
                }
                if(check) break;
            }
            if(check) {
                for(int i =0;i<9;i++){
                    for(int j =0;j<9;j++){
                        ans[i][j] = sudoku[i][j];
                    }
                }
            }

            return;
        }

        if(ans[0][0] + ans[0][1] != 18) return;
        //백트래킹 조건
        //가로탐색

        //세로탐색

        //사각형탐색


        //재귀
            for(int k =1;k<=9;k++){
                int[] temp = index.get(cnt);
                int r = temp[0];
                int c = temp[1];
                boolean tempUsedR = numUsed[k][r][0];
                boolean tempUsedC = numUsed[k][c][1];
                sudoku[r][c] = k;
                //가로
                boolean check = false;
                if(!numUsed[k][r][0]){
                    if(!numUsed[k][c][1]){
                        check = true;
                        numUsed[k][r][0] = true;
                        numUsed[k][c][1] = true;
                    }
                }

                for(int i=r/3*3;i<r/3*3+3;i++){
                    for(int j = c/3*3; j<c/3*3 +3;j++){
                        if(i == r && j==c) continue;
                        if(sudoku[i][j] == k){
                            check = false;
                            break;
                        }
                    }
                    if(!check) break;
                }


                if(check) {
                    backtracking(cnt+1);
                }
                sudoku[temp[0]][temp[1]] = 0;
                numUsed[k][r][0] = tempUsedR;
                numUsed[k][c][1] = tempUsedC;
                }
            }
    }
