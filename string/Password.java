package string;

import java.util.Scanner;

public class Password {
    public String solution(String str, int N){
        StringBuffer sb = new StringBuffer();
        for(int i =0;i<N;i++){
            String temp = str.substring(i*7,(i+1)*7);
            int tempInt = 0;
            temp= temp.replace("#","1").replace("*","0");
            tempInt = Integer.parseInt(temp,2);
            sb.append((char)tempInt);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Password T = new Password();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();
        System.out.println(T.solution(str,N));
    }
}
