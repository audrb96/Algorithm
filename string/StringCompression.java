package string;

import java.util.Scanner;

public class StringCompression {
    public String solution(String str){
        char temp = str.charAt(0);
        StringBuffer sb =new StringBuffer();
        int count=0;
        for(int i =0;i<str.length();i++){
            if(str.charAt(i) == temp) {
                count++;
            }
            else if(str.charAt(i) != temp){
                sb.append(temp);
                sb.append(count);
                temp = str.charAt(i);
                count=1;
            }
            if(i == str.length()-1){
                    if(str.charAt(i)==temp){
                        sb.append(temp);
                        sb.append(count);
                    }
                    else{
                        sb.append(str.charAt(i));
                    }
            }
        }
        return sb.toString().replaceAll("1","");

    }

    public static void main(String[] args) {
        StringCompression T = new StringCompression();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
