package string;

import java.util.Scanner;

public class Palindrome {
    public String solution(String str){
        boolean answer = false;
        str = str.toLowerCase();
        for(int i =0 ;i<str.length()/2;i++){
            if(str.charAt(i)!= str.charAt(str.length()-1-i)) break;
            if(i==str.length()/2-1) answer= true;
        }
        if(answer){
            return "YES";
        }
        else{
            return "NO";
        }
    }

    public static void main(String[] args) {
        Palindrome T = new Palindrome();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
