package string;

import java.util.Scanner;

public class SwitchUpperLower {
//    public String solution(String str){
//        StringBuffer str2 = new StringBuffer(str);
//        for(int i =0; i<str2.length();i++){
//            if(str2.charAt(i)==Character.toUpperCase(str2.charAt(i)))
//                str2.setCharAt(i,Character.toLowerCase(str2.charAt(i)));
//            else if(str2.charAt(i) == Character.toLowerCase(str2.charAt(i)))
//                str2.setCharAt(i,Character.toUpperCase(str2.charAt(i)));
//        }
//        return str2.toString();
//    }
    public String solution(String str){
        String answer = "";
        for(char x : str.toCharArray()){
            if(Character.isLowerCase(x)) answer += Character.toUpperCase(x);
            else if (Character.isUpperCase(x)) answer += Character.toLowerCase(x);
        }
        return answer;
    }
    public static void main(String[] args) {
        SwitchUpperLower T = new SwitchUpperLower();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
