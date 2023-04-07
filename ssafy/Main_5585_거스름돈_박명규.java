package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_5585_거스름돈_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] moneys = {500,100,50,10,5,1};
        int money = 1000-N;
        int ans = 0;
        int i =0;
        while (money!=0){
            if(money<moneys[i]){
                i++;
                continue;
            }
            ans += money/moneys[i];
            money = money%moneys[i];
            i++;
        }
        System.out.println(ans);
    }
}
