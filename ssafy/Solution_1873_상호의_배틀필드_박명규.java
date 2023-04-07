package ssafy;

import java.util.Scanner;

public class Solution_1873_상호의_배틀필드_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int testCase = 1;
        while (T-->0){
            int H = sc.nextInt();
            int W = sc.nextInt();
            sc.nextLine();
            char[][] field = new char[H][W];
            for(int i =0;i<H;i++){
                String line = sc.nextLine();
                for(int j=0;j<W;j++){
                    field[i][j] = line.charAt(j); //필드 정보를 입력받는다.
                }
            }
            int inputLen = sc.nextInt();
            sc.nextLine();
            char[] in = new char[inputLen];
            String line = sc.nextLine();
            for(int i =0;i<inputLen;i++){
                in[i] = line.charAt(i); //명령어 정보를 입력받는다.
            }
            int [] dx = {0,0,-1,1};
            int [] dy = {-1,1,0,0}; //방향을 설정할 dx,dy
            int curX =0; //현재위치 x
            int curY =0; //현재위치 y
            for(int i =0;i<H;i++){
                for(int j=0;j<W;j++){
                    if(field[i][j]=='^'||field[i][j]=='v'||field[i][j]=='<'||field[i][j]=='>'){
                        curX = j;
                        curY = i; //가장 처음 현재위치를 찾는다.
                        break;
                    }
                }
            }
            int count = 0;
            int X;
            int Y;

            while (count<inputLen){ //명령어만큼 읽어들인다.
                //명령어가 방향일때 가고자하는 방향이 평지라면 현재위치를 '.' 로 바꾸고 다음위치를 방향으로 바꾸어준다,
                //평지가 아니라 맵밖이거나 다른것이라면 방향만 바꾸어준다.
                if(in[count] == 'U' ){
                    X = curX+dx[0];
                    Y = curY+dy[0];
                    if(Y>=0&&Y<H&&field[Y][X]=='.'){
                        field[curY][curX] = '.';
                        field[Y][X] = '^';
                        curX = X;
                        curY = Y;
                    }
                    else{
                        field[curY][curX] = '^';
                    }
                    count++;
                }
                else if(in[count] == 'D'){
                    X = curX+dx[1];
                    Y = curY+dy[1];
                    if(Y<H&&field[Y][X]=='.'){
                        field[curY][curX] = '.';
                        field[Y][X] = 'v';
                        curX = X;
                        curY = Y;
                    }
                    else {
                        field[curY][curX] = 'v';
                    }
                    count++;
                }
                else if(in[count] == 'L'){
                    X = curX+dx[2];
                    Y = curY+dy[2];
                    if(X>=0&&field[Y][X]=='.'){
                        field[curY][curX] = '.';
                        field[Y][X] = '<';
                        curX = X;
                        curY = Y;
                    }
                    else{
                        field[curY][curX] = '<';
                    }
                    count++;
                }
                else if(in[count] == 'R'){
                    X = curX+dx[3];
                    Y = curY+dy[3];
                    if(X<W&&field[Y][X]=='.'){
                        field[curY][curX] = '.';
                        field[Y][X] = '>';
                        curX = X;
                        curY = Y;
                    }
                   else{
                        field[curY][curX] = '>';
                    }
                    count++;
                }
                else if(in[count] == 'S'){ //명령어가 S라면 방향에 위치한 벽돌'*'을 '.'로 바꾸어주고 강철 '*'이라면 break;
                    if(field[curY][curX]== '^'){
                        for(int i =1;i<H;i++){
                            X = curX+dx[0];
                            Y = curY+dy[0]*i;
                            if(Y>=0&&field[Y][X] == '*'){
                                field[Y][X] = '.';
                                break;
                            }
                            else if(Y>=0&&field[Y][X] == '#')
                                break;
                        }
                        count++;
                    }
                    else if(field[curY][curX]== 'v'){
                        for(int i =1;i<H;i++){
                            X = curX+dx[1];
                            Y = curY+dy[1]*i;
                            if(Y<H&&field[Y][X] == '*'){
                                field[Y][X] = '.';
                                break;
                            }
                            else if(Y<H&&field[Y][X] == '#')
                                break;
                        }
                        count++;
                    }
                    else if(field[curY][curX]== '<'){
                        for(int i =1;i<W;i++){
                            X = curX+dx[2]*i;
                            Y = curY+dy[2];
                            if(X>=0&&field[Y][X] == '*'){
                                field[Y][X] = '.';
                                break;
                            }
                            else if(X>=0&&field[Y][X] == '#')
                                break;
                        }
                        count++;
                    }
                    else if(field[curY][curX]== '>'){
                        for(int i =0;i<W;i++){
                            X = curX+dx[3]*i;
                            Y = curY+dy[3];
                            if(X<W&&field[Y][X] == '*'){
                                field[Y][X] = '.';
                                break;
                            }
                            else if(X<W&&field[Y][X] == '#')
                                break;
                        }
                        count++;
                    }
                }
            }
            System.out.print("#"+testCase++ +" ");
            for(int i =0;i<H;i++){
                for(int j=0;j<W;j++){
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
        }
    }
}
