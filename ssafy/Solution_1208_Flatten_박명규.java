package ssafy;

import java.util.Arrays;
import java.util.Scanner;
//Flatten
public class Solution_1208_Flatten_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T =10;
        int testCase = 1;
        while (T--> 0){
            int answer;
            int dump = sc.nextInt();
            int[] box = new int[100];
            for(int i =0;i< box.length;i++){
                box[i] = sc.nextInt();
            }
            for(int i =0;i<dump;i++){
                Arrays.sort(box);
                box[box.length-1]--;
                box[0]++;
                if(box[box.length-1] == box[0]) break;
            }
            Arrays.sort(box);
            answer = box[box.length-1] - box[0];
            System.out.println("#"+testCase++ +" "+ answer);
        }
    }
}
