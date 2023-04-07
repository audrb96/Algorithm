package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10162_전자레인지_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] time = {300,60,10};
        int[] ans = new int[3];
        int i = 0;
        while (T>=10){
            if(T%10 != 0 ) break;
            if(T<time[i]){
                i++;
                continue;
            }
            ans[i] = T/time[i];
            T = T%time[i];
            i++;
        }
        if(T==0){
            for(int j =0;j<3;j++){
                System.out.print(ans[j]+" ");
            }
        }
        else{
            System.out.print(-1);
        }
    }
}
