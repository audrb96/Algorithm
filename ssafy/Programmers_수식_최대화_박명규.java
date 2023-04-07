package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Programmers_수식_최대화_박명규 {

    static char[] operator = {'+','-','*'};
    static boolean[] isVisited = new boolean[3];
    static char[] selectedOper = new char[3];
    static long max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String expression = br.readLine();

        System.out.println( solution(expression));
    }

    public static long solution(String expression){
        LinkedList<Long> nums = new LinkedList<>();
        LinkedList<Character> oper = new LinkedList<>();
        String temp = "";

        for(int i =0;i<expression.length();i++){
            if(Pattern.matches("^[0-9]",Character.toString(expression.charAt(i)))){
                temp += expression.charAt(i);
            }
            else{
                nums.add(Long.parseLong(temp));
                temp ="";
                oper.add(expression.charAt(i));
            }
        }
        nums.add(Long.parseLong(temp));
        permutation(0,nums,oper);

        return max;

    }

    public static void permutation(int cnt,LinkedList<Long> nums, LinkedList<Character> oper){
        if(cnt==3){

            LinkedList<Long> tempNums = new LinkedList<>(nums);
            LinkedList<Character> tempOpers = new LinkedList<>(oper);

            for(int i =0;i<3;i++){
                char tempOper = selectedOper[i];
                for(int j=0;j<tempOpers.size();j++){
                 if(tempOper != tempOpers.get(j)) continue;
                 long first = tempNums.remove(j);
                 long second = tempNums.remove(j);
                 char operator = tempOpers.remove(j);
                 if(operator == '-') {
                     tempNums.add(j, first-second);
                 }
                 else if(operator == '+'){
                     tempNums.add(j,first+second);
                 }
                 else {
                     tempNums.add(j,first*second);
                 }
                 j--;
                }
            }
            max = Math.max(max,Math.abs(tempNums.get(0)));
            return;
        }

        for(int i =0;i<3;i++){
        if(isVisited[i]) continue;
        selectedOper[cnt] = operator[i];
        isVisited[i] = true;
        permutation(cnt+1,nums,oper);
        isVisited[i] = false;
        }

    }
}
