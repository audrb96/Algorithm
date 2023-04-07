package string;

import java.util.Scanner;

public class ReverseString {
    public String solution(String str) {
        StringBuffer sb = new StringBuffer(str);
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        ReverseString T = new ReverseString();
        Scanner sc= new Scanner(System.in);
        int tc = sc.nextInt();
        for(int testCase = 0;testCase<tc;testCase++){
            String str = sc.next();
            System.out.println(T.solution(str));
        }
    }
}
