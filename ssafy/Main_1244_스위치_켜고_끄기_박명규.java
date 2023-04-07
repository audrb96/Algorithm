package ssafy;

import java.util.Scanner;

public class Main_1244_스위치_켜고_끄기_박명규 {
    public void solution(int[] switchBit,int[] num ){
        if(num[0]==1){ //남학생일때
            for(int i =1;i<switchBit.length+1;i++){
                if(num[1]*i-1>switchBit.length-1) break; //다음 스위치가 범위를 벗어나면 break;
                if(switchBit[num[1]*i-1]==0) //스위치의 배수가 0이면 1, 1이면 0
                    switchBit[num[1]*i-1]=1;
                else
                    switchBit[num[1]*i-1]=0;
            }
        }
        if(num[0]==2){ //여학생일때
            //뽑은 숫자의 비트를 바꾸기
            if(switchBit[num[1]-1]==0)
                switchBit[num[1]-1]=1;
            else
                switchBit[num[1]-1]=0;
            //뽑은 숫자의 앞 뒤 비트가 같으면 바꾸고 아니면 break;
            for(int i =1;i<switchBit.length+1;i++){
                if(num[1]+i-1<=switchBit.length-1 &&num[1]-i-1>=0)
                if(switchBit[num[1]+i-1]==switchBit[num[1]-i-1]){
                    if(switchBit[num[1]+i-1]==0)
                        switchBit[num[1]+i-1]=1;
                    else
                        switchBit[num[1]+i-1]=0;
                    if(switchBit[num[1]-i-1]==0)
                        switchBit[num[1]-i-1]=1;
                    else
                        switchBit[num[1]-i-1]=0;
                }
                else{
                    break;
                }
                else{
                    break;
                }
            }

        }
    }

    public static void main(String[] args) {
        Main_1244_스위치_켜고_끄기_박명규 T = new Main_1244_스위치_켜고_끄기_박명규();
        Scanner sc = new Scanner(System.in);
        int switchNum = sc.nextInt();
        int[] switchBit = new int[switchNum];
        for(int i =0;i<switchNum;i++){ //스위치 입력
            switchBit[i] = sc.nextInt();
        }
        int students = sc.nextInt();
        int[][] num = new int[students][2];
        for(int i =0;i<students;i++){
            num[i][0] = sc.nextInt(); //학생의 성별
            num[i][1] = sc.nextInt(); //학생이 받은 수
        }

        for(int i =0;i<students;i++){
            T.solution(switchBit,num[i]);
        }
        int count = 0;
        for(int i =0;i<switchBit.length;i++){
            if(count==19) {
                System.out.println(switchBit[i]);
                count = 0;
                continue;
            }
            else{
                System.out.print(switchBit[i]+" ");
            }
            count++;
        }
    }
}
