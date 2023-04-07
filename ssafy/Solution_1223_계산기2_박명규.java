package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.regex.Pattern;

public class Solution_1223_계산기2_박명규 {
    public static void main(String[] args) throws IOException {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        for(int tc = 1;tc<=T;tc++){
            StringBuilder postFix = new StringBuilder(); //후위표기식을 저장할 StringBuilder
            Stack<Character> stack = new Stack<>(); //활용할 stack
            Stack<Integer> st = new Stack<>();
            int N = Integer.parseInt(br.readLine());
            sb.append("#").append(tc).append(" ");
            String line = br.readLine();
            //중위 표기식을 후위 표기식으로 변환
            for(int i =0;i<N;i++){
                char temp = line.charAt(i); //중위 표기식을 한글자씩 가져온다.
                if (Pattern.matches("^[1-9]",Character.toString(temp))) { //숫자라면 StringBuilder에 append
                    postFix.append(temp);
                }
                else if(temp=='('){
                    stack.push(temp); //여는 괄호일 경우 stack에 push
                }
                else if(temp==')'){ //닫는 괄호일 경우 '('를 만날때까지 pop하여 StringBuilder에 append
                    while (!stack.isEmpty()){
                        if(stack.peek() == '('){
                            stack.pop();
                            break;
                        }
                        postFix.append(stack.pop());
                    }
                }
                else{
                    while (!stack.isEmpty()){
                        //연산자라면 해당 연산자와 stack에 맨위에 있는 연산자의 우선순위를 비교하여
                        // 스택의 연산자가 더 높으면 append 아니면 break 후에 해당 연산자를 stack에 push
                        int sp = priority(stack.peek());
                        int tp = priority(temp);
                        if(sp>=tp){
                            postFix.append(stack.pop());
                        }
                        else{
                            break;
                        }
                    }
                    stack.push(temp);
                }
            }
            //마지막에 stack에 남은 연산자 모두 pop하여 append
            while (!stack.isEmpty()){
                postFix.append(stack.pop());
            }
            //후위 표현식 연산
            for(int i =0;i<postFix.length();i++){
                char temp = postFix.toString().charAt(i);
                if(Pattern.matches("^[1-9]",Character.toString(temp))){
                    st.push(temp-'0');
                } //숫자를 만나면 stack에 push
                else{
                    int second = st.pop();
                    int first = st.pop(); //연산자를 만나면 stack에서 두 숫자를 pop하고 연산한뒤에 다시 스택에 push한다.
                    int ans;
                    if(temp=='*')
                        ans = first*second;
                    else
                        ans = first+second;

                    st.push(ans);
                }
            }
            sb.append(st.pop()).append("\n");
        }
        System.out.print(sb);
    }

    /**
     * 우선순위 결정 메소드
     * @param c
     * @return
     */
    public static int priority(char c){
        if(c=='*'||c=='/'){
            return 2;
        }
        else if(c=='+'||c=='-'){
            return 1;
        }
        else{
            return 0;
        }
    }
}
