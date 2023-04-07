package string;

import java.util.Scanner;

public class WordReverse {
    public String solution(String str) {
        char[] array = str.toCharArray();
        int lt = 0;
        int rt = array.length-1;
        while (lt<rt){
            if(!Character.isAlphabetic(array[lt])){
                lt++;
            }
            else if(!Character.isAlphabetic(array[rt])){
                rt--;
            }
            else {
                char tmp = array[lt];
                array[lt] = array[rt];
                array[rt] = tmp;
                lt++;
                rt--;
            }
        }
        return String.valueOf(array);
    }

    public static void main(String[] args) {
        WordReverse T = new WordReverse();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(T.solution(str));
    }
}
