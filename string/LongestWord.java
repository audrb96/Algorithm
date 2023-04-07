package string;

import java.util.Scanner;

public class LongestWord {
//    public String solution(String str){
//        String[] strArray = str.split(" ");
//        int max = Integer.MIN_VALUE;
//        int maxIndex = -1;
//        for(int i =0;i<strArray.length;i++){
//            if(max<strArray[i].length()){
//                max = strArray[i].length();
//                maxIndex = i;
//            }
//        }
//        return strArray[maxIndex];
//    }
    public String solution(String str){
        String answer = "";
        int m = Integer.MIN_VALUE, pos;
        while ((pos = str.indexOf(" "))!= -1) {
            String tmp = str.substring(0,pos);
            int len = tmp.length();
            if(len>m){
                m=len;
                answer=tmp;
            }
            str = str.substring(pos+1);
        }
        if(str.length()>m) answer = str;
        return answer;
    }

    public static void main(String[] args) {
        LongestWord T = new LongestWord();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
