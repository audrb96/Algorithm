package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2578_빙고_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] Bingo = new int[5][5];
        int[][] call = new int[5][5];
        int cnt = 0;

        StringTokenizer st;
        for(int i =0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                Bingo[i][j] = Integer.parseInt(st.nextToken()); //빙고판
            }
        }
        for(int i =0;i<5;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<5;j++){
                call[i][j] = Integer.parseInt(st.nextToken()); //사회자가 부르는 수
            }
        }

        loop: for(int r=0;r<5;r++){
            for(int c=0;c<5;c++){ //사회자가 부르는 수를 돌면서
                cnt ++;
                int num = call[r][c];
                int ans = 0;
                int binCnt = 0; //5개가 연달아 있는지 확인하기 위한 count
                for(int i =0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(Bingo[i][j] == num){
                            Bingo[i][j] = 0; //빙고판을 순회하면서 사회자가 부르는 숫자와 같으면 0으로 변경
                            break;
                        }
                    }
                }
                    //왼쪽위부터 오른쪽아래 대각선확인
                    for(int i =0;i<5;i++){
                        if(Bingo[i][i] == 0){
                            binCnt++;
                        }
                    }
                    if(binCnt==5) ans ++; //5개가 일치하면 1빙고 ++
                    binCnt = 0;
                    for(int i =0;i<5;i++){ //오른쪽위부터 왼쪽아래 대각선 확인
                        if(Bingo[i][4-i] == 0){
                            binCnt++;
                        }
                    }
                    if(binCnt==5) ans++;
                    binCnt = 0;

                for(int i =0;i<5;i++){
                    for(int j=0;j<5;j++){//
                        if(Bingo[i][j]==0) binCnt++;
                        if(binCnt==5) ans++;
                    }//가로 빙고 확인
                    binCnt = 0;
                }
                binCnt = 0;
                for(int i =0;i<5;i++){
                    for(int j=0;j<5;j++){
                        if(Bingo[j][i]==0) binCnt++;
                        if(binCnt==5) ans++;
                    }//세로 빙고 확인
                    binCnt = 0;
                }

                if(ans>=3) break loop; //빙고가 3개 이상이면 loop를 나간다.
            }
        }
        System.out.println(cnt);
    }
}
