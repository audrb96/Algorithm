package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//재귀
public class Main_1992_쿼드트리_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder(); //결과를 저장할 StringBuilder
        char[][] area = new char[N][N];
        for(int i =0;i<N;i++){
            area[i] = br.readLine().toCharArray();
        }
        solution(area,sb,0,N,0,N);
        System.out.println(sb);
    }
    public static void solution(char[][] area, StringBuilder sb, int rowStart,int rowEnd, int colStart,int colEnd){
        if(isZero(area,rowStart,rowEnd,colStart,colEnd)){ //범위 전체가 0인지 확인
            sb.append('0');
        }
        else if(isOne(area,rowStart,rowEnd,colStart,colEnd)){ //범위 전체가 1인지 확인
            sb.append('1');
        }
        else{
            sb.append('('); //범위에 0과 1이 섞여있다면 ( append
            solution(area,sb,rowStart,(rowStart+rowEnd)/2,colStart,(colStart+colEnd)/2); //왼쪽 위
            solution(area,sb,rowStart,(rowStart+rowEnd)/2,(colStart+colEnd)/2,colEnd); //오른쪽 위
            solution(area,sb,(rowStart+rowEnd)/2,rowEnd,colStart,(colStart+colEnd)/2); //왼쪽 아래
            solution(area,sb,(rowStart+rowEnd)/2,rowEnd,(colStart+colEnd)/2,colEnd); //오른쪽 아래
            sb.append(')'); //재귀를 다 돌면 ) append
        }
    }

    public static boolean isZero(char[][] area, int rowStart,int rowEnd,int colStart,int colEnd){
        boolean is  = true;
        for(int i =rowStart;i<rowEnd;i++){
            for(int j =colStart;j<colEnd;j++){
                if(area[i][j] != '0') {
                    is = false;
                    break;
                }
            }
        }
        return is;
    }
    public static boolean isOne(char[][] area, int rowStart,int rowEnd,int colStart,int colEnd){
        boolean is  = true;
        for(int i =rowStart;i<rowEnd;i++){
            for(int j =colStart;j<colEnd;j++){
                if(area[i][j] != '1') {
                    is = false;
                    break;
                }
            }
        }
        return is;
    }

}
