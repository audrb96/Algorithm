package ssafy;

import java.util.*;

public class Solution_1218_괄호_짝짓기_박명규 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<Character,Character> map = new HashMap<>();
        map.put('{','}');
        map.put('[',']');
        map.put('(',')');
        map.put('<','>'); //짝이 맞는지 확인하기 위한 map
        int T = 10;
        int testCase = 1;
        while (T-->0){
            int N = sc.nextInt();
            String line = sc.next();
            char[] arr = line.toCharArray();
            boolean answer = true;
            Stack<Character> stack = new Stack<>(); //스택을 선언한다.
            for(int i =0;i<N;i++){
                if(arr[i]=='{'||arr[i]=='['||arr[i]=='('||arr[i]=='<'){
                    stack.push(arr[i]); //여는 괄호라면 stack에 push
                }
                else{
                    char temp = stack.pop(); //닫는 괄호라면 stack에서 pop하고 pop한 여는괄호와 짝이 맞는지 확인, 아니라면 답을 false로 바꾸고 break;
                    if(arr[i] != map.get(temp)){
                        answer = false;
                        break;
                    }
                }
            }
            if(!stack.isEmpty()) answer = false;
            int a = answer ? 1 : 0;
            System.out.println("#"+testCase++ +" "+a);
        }
    }
}
