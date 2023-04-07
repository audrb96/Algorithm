package string;

import java.util.Locale;
import java.util.Scanner;

public class FindWord {
    public int solution(String str, char t){
        int count=0;
        str = str.toLowerCase(Locale.ROOT);
        t = Character.toLowerCase(t);
        for(char x : str.toCharArray()){
            if (x==t) count ++;
        }

        return count;
    }

    public static void main(String[] args) {
        FindWord T = new FindWord();
        Scanner sc = new Scanner(System.in);
        String word = sc.nextLine();
        char key = sc.next().charAt(0);

        System.out.println(T.solution(word,key));
    }
}
