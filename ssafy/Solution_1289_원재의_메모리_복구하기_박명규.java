package ssafy;

import java.util.Scanner;

public class Solution_1289_원재의_메모리_복구하기_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int testCase =0;testCase<T;testCase++){
            String str = sc.next();
            int count = 0;
            if(str.charAt(0) == '0'){
                for(int i =1; i<str.length();i++){
                    if(str.charAt(i-1) != str.charAt(i)) count ++;
                }
            }
            else{
                count++;
                for(int i =1; i<str.length();i++){
                    if(str.charAt(i-1) != str.charAt(i)) count ++;
                }
            }
            System.out.printf("#%d %d%n",testCase+1,count);
        }

    }
}
