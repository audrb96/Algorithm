package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_16935_배열_돌리기3_박명규 {

    static int N;
    static int M;
    static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        int[][] arr = new int[N][M];
        int[] num = new int[R];
        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        for(int i =0;i<R;i++){
         num[i] = Integer.parseInt(st.nextToken());
        }



        int row = 0;
        int col = 0;


        for(int n= 0 ;n<R;n++){
         if(num[n]==1){
             Stack<int[]> stack = new Stack<>();
             for(int i =0;i<N;i++){
                 stack.push(arr[i]);
             }
             for(int i =0;i<N;i++){
                 arr[i] = stack.pop();
             }
             continue;
         }
         if(num[n]==2){
             Stack<Integer> stack = new Stack<>();
             for(int i =0;i<N;i++){
                 for(int j=0;j<M;j++){
                     stack.push(arr[i][j]);
                 }
                 for(int j =0;j<M;j++){
                     arr[i][j] = stack.pop();
                 }
             }
             continue;
         }
         if(num[n]==3){
             Queue<Integer> queue = new LinkedList<>();
             for(int i =0;i<M;i++){
                 for(int j=N-1;j>=0;j--){
                     queue.add(arr[j][i]);
                 }
             }
             int[][] temp = new int[M][N];
             for(int i =0;i<M;i++){
                 for(int j=0;j<N;j++){
                    temp[i][j] = queue.poll();
                 }
             }
             arr = temp;
             int tmp = N;
             N=M;
             M = tmp;
             continue;
         }
         if(num[n]==4) {
             Queue<Integer> queue = new LinkedList<>();
             for(int i =M-1;i>=0;i--){
                 for(int j=0;j<N;j++){
                     queue.add(arr[j][i]);
                 }
             }
             int[][] temp = new int[M][N];
             for(int i =0;i<M;i++){
                 for(int j=0;j<N;j++){
                     temp[i][j] = queue.poll();
                 }
             }
             arr= temp;
             int tmp = N;
             N=M;
             M = tmp;
             continue;
         }
         if(num[n]==5){
             int[][] group1 = new int[N/2][M/2];
             int[][] group2 = new int[N/2][M/2];
             int[][] group3 = new int[N/2][M/2];
             int[][] group4 = new int[N/2][M/2];

             for(int i =0;i<N/2;i++){
                 for(int j=0;j<M/2;j++){
                     group1[i][j] = arr[i][j];
                 }
             }
             for(int i =0;i<N/2;i++){
                 for(int j=M/2;j<M;j++){
                     group2[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j=M/2;j<M;j++){
                     group3[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j=0;j<M/2;j++){
                     group4[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;

             for(int i =0;i<N/2;i++){
                 for(int j =0;j<M/2;j++){
                     arr[i][j] = group4[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =0;i<N/2;i++){
                 for(int j =M/2;j<M;j++){
                     arr[i][j] = group1[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j =M/2;j<M;j++){
                     arr[i][j] = group2[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j =0;j<M/2;j++){
                     arr[i][j] = group3[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
           continue;
         }
         if(num[n]==6){
             int[][] group1 = new int[N/2][M/2];
             int[][] group2 = new int[N/2][M/2];
             int[][] group3 = new int[N/2][M/2];
             int[][] group4 = new int[N/2][M/2];

             for(int i =0;i<N/2;i++){
                 for(int j=0;j<M/2;j++){
                     group1[i][j] = arr[i][j];
                 }
             }
             for(int i =0;i<N/2;i++){
                 for(int j=M/2;j<M;j++){
                     group2[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j=M/2;j<M;j++){
                     group3[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j=0;j<M/2;j++){
                     group4[row][col++] = arr[i][j];
                 }
                 row++;
                 col=0;
             }
             row=0;

             for(int i =0;i<N/2;i++){
                 for(int j =0;j<M/2;j++){
                     arr[i][j] = group2[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =0;i<N/2;i++){
                 for(int j =M/2;j<M;j++){
                     arr[i][j] = group3[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j =M/2;j<M;j++){
                     arr[i][j] = group4[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             for(int i =N/2;i<N;i++){
                 for(int j =0;j<M/2;j++){
                     arr[i][j] = group1[row][col++];
                 }
                 row++;
                 col=0;
             }
             row=0;
             continue;
         }
        }
        for (int[] ints : arr) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }

    }

}
