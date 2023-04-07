package string;

import java.util.Scanner;

public class CharDistance {
    public int[] solution(String str, char c) {
        int[] array = new int[str.length()];
        int index = -1;
        int nextIndex = -1;
        int step=0;
        for(int i =0;i<str.length();i++){
            index = str.indexOf(c,step);
            nextIndex = str.indexOf(c,index+1);
            array[i] = Math.min(Math.abs(index-i),Math.abs(nextIndex-i));
            if(i==nextIndex) step = nextIndex;
        }
        return array;
    }

    public static void main(String[] args) {
        CharDistance T = new CharDistance();
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        int[] array = T.solution(str,c);
        for(int i =0;i<array.length;i++){
            if(i!=array.length-1)
                System.out.print(array[i]+" ");
            else
                System.out.println(array[i]);
        }
    }
}
