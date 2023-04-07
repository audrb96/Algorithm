package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

//순열, 부분집합
public class Solution_3234_준환이의_양팔저울 {
    static int ans;
    static int[] arr;
    static int N;
    static int T;
    static int[] numbers;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());

        for(int tc=1;tc<=T;tc++){
            N = Integer.parseInt(br.readLine());
            arr = new int[N];
            ans = 0;
            numbers = new int[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i =0;i<N;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);
            do{
                backtracking(0, 0,0);
            } while (np());


            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);
    }
    public static boolean np(){
        int i = N-1;
        while (i>0&& arr[i-1]>= arr[i]) --i;

        if(i==0) return false;

        int j =N-1;
        while (arr[i-1]>= arr[j]) --j;

        swap(i-1,j);

        int k =N-1;

        while (i<k){
            swap(i++,k--);
        }
        return true;
    }

    public static void swap(int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void backtracking(int cnt,int leftSum,int rightSum){
        if(leftSum<rightSum) return;
        if(cnt==N){
            ans++;
            return;
        }

        backtracking(cnt+1,leftSum+arr[cnt],rightSum);
        backtracking(cnt+1,leftSum,rightSum+arr[cnt]);
    }

}
