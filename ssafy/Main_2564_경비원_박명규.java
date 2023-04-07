package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2564_경비원_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());
        int dir;
        int position;
        int sum=0;
        int N = Integer.parseInt(br.readLine());
        List<int[]> list = new ArrayList<>();

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())});
        }
        st = new StringTokenizer(br.readLine());
        dir = Integer.parseInt(st.nextToken()); //동근이 방향
        position = Integer.parseInt(st.nextToken()); //동근이 위치

        for(int i =0;i<N;i++){
            int resDir = list.get(i)[0];
            int resPosition = list.get(i)[1];
            switch (dir){
                case 1: //동근이의 방향이 북쪽일때
                    //각 상점의 방향별 최소거리 계산
                    if(resDir==1){
                        sum+= Math.abs(position-resPosition);
                    }
                    if(resDir==2){
                        sum+=Math.min(col+position+resPosition,col+(row-position)+(row-resPosition));
                    }
                    if(resDir==3){
                        sum+=position+resPosition;
                    }
                    if(resDir==4){
                        sum+=(row-position)+resPosition;
                    }
                    break;
                case 2: //동근이의 방향이 남쪽일때
                    if(resDir==1){
                        sum+=Math.min(col+position+resPosition,col+(row-position)+(row-resPosition));
                    }
                    if(resDir==2){
                        sum+= Math.abs(position-resPosition);
                    }
                    if(resDir==3){
                        sum+= (col-resPosition)+position;
                    }
                    if(resDir==4){
                        sum+=(row-position)+(col-resPosition);
                    }
                    break;
                case 3: //동근이의 방향이 서쪽일 때
                    if(resDir == 1){
                        sum+=resPosition+position;
                    }
                    if(resDir == 2){
                        sum += (col-resPosition)+position;
                    }
                    if(resDir == 3){
                        sum+=Math.abs(position-resPosition);
                    }
                    if(resDir==4){
                        sum+=Math.min(row+position+resPosition,row+(col-position)+(col-resPosition));
                    }
                    break;
                case 4: //동근이의 방향이 동쪽일때
                    if(resDir ==1){
                        sum+=position+(row-resPosition);
                    }
                    if(resDir == 2){
                        sum+=(col-position) + (row-resPosition);
                    }
                    if(resDir == 3){
                        sum+=Math.min(row+position+resPosition,row+(col-position)+(col-resPosition));
                    }
                    if(resDir ==4){
                        sum+=Math.abs(position-resPosition);
                    }
                    break;
                default:
                    break;
            }
        }
        System.out.println(sum);
    }
}
