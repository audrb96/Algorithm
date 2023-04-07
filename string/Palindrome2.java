package string;

import java.util.Scanner;

public class Palindrome2 {
    public String solution(String str){
        StringBuffer sb = new StringBuffer(str.toUpperCase().replaceAll("[^A-Z]",""));
        String answer = "NO";
        if(sb.toString().equals(sb.reverse().toString())) answer = "YES";

        return answer;

    }

    public static void main(String[] args) {
        Palindrome2 T = new Palindrome2();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(T.solution(str));
    }
}
