package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_2493_탑_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<int[]> top = new Stack<>();
        int N = Integer.parseInt(br.readLine());
        int[] answer = new int[N];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        for(int i =0;i<N;i++){
            int num = Integer.parseInt(st.nextToken());
            while (!top.isEmpty()){
                //stack의 맨위의 숫자가 현재 숫자보다 크면 답에 추가
                if(top.peek()[0] >num){
                    answer[i] = top.peek()[1];
                    break;
                }
                else{
                    //stack의 맨위의 숫자가 현재 숫자보다 작거나 같으면 pop
                    top.pop();
                }
            }
            int[] temp = {num,i+1};
            //현재 숫자를 push
            top.push(temp);
        }

        for(int i =0;i<N;i++){
            System.out.print(answer[i]+" ");
        }
        }
    }

