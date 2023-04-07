package string;

import java.util.Scanner;

public class OnlyNumber {
    public int solution(String str){
        str = str.replaceAll("[^0-9]","");
        return Integer.parseInt(str);
    }

    public static void main(String[] args) {
        OnlyNumber T = new OnlyNumber();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        System.out.println(T.solution(str));
    }
}
