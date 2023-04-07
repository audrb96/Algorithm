package Array;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReversePrime {
    public boolean isPrimeNum(int num){
        int[] nums = new int[num+1];
        boolean isPrime = false;
        for(int i=2;i<num;i++){
            if(nums[i]==0){
                for(int j=i;j<nums.length;j=j+i){
                    nums[j] = 1;
                }
            }
        }
        if(num!= 1 && nums[num]==0) isPrime = true;
        return isPrime;
    }

    public List<Integer> solution(String[] str){
        List<Integer> answer = new ArrayList<>();
        for(int i =0;i<str.length;i++){
            StringBuffer sb = new StringBuffer(str[i]);
            sb.reverse();
            str[i] = sb.toString();
            if(isPrimeNum(Integer.parseInt(str[i]))) answer.add(Integer.parseInt(str[i]));
        }
        return answer;
    }
    public static void main(String[] args) {
        ReversePrime T = new ReversePrime();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        for(int i =0;i<N;i++){
            str[i] = sc.next();
        }
        List<Integer> answer = T.solution(str);
        for (Integer integer : answer) {
            System.out.print(integer.toString() + " ");
        }
    }
}
