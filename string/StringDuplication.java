package string;

import java.util.Scanner;

public class StringDuplication {
    public String solution(String str){
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<str.length();i++){
            if(sb.toString().contains(String.valueOf(str.charAt(i)))) continue;
            sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        StringDuplication T = new StringDuplication();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
