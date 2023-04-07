package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Main_3040_백설_공주와_일곱_난쟁이_박명규 {
    static ArrayList<int[]> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr= new int[9];
        int[] ans = new int[7];
        for(int i =0;i<9;i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        combination(arr,ans,0,0);
        for(int i =0;i<list.get(0).length;i++){
            System.out.println(list.get(0)[i]);
        }
    }

    public static void combination(int[] arr,int ans[],int start,int cnt){
        if(cnt==7) {
            int sum = 0;
            for(int i =0;i<ans.length;i++){
                sum+=ans[i];
            }
            if(sum==100) {
                Arrays.sort(ans);
                list.add(Arrays.copyOf(ans,7));
            }
            return;
        }
        for(int i =start;i<9;i++){
            ans[cnt] = arr[i];
            combination(arr,ans,i+1,cnt+1);
        }
    }

}
