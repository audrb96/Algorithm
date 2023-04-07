package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_5604_구간_합_박명규 {
    static int T;
    static int[] f;
    static Map<Long,Long> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());
            f = new int[10];
            f[0] = 0;
            for (int i = 1; i < 10; i++) {
                f[i] = f[i - 1] + i;
            }
            long ans = rangeSum(B) - rangeSum(A - 1);


            sb.append("#").append(tc).append(" ").append(ans).append("\n");
        }
        System.out.print(sb);

    }

    public static long rangeSum(long n) {
        if (n == -1) {
            return 0;
        }
        if (n < 10) {
            return f[(int) n];
        }
        if(map.containsKey(n)){
            return map.get(n);
        }
        long v = digitNum(n);
        long a = rangeSum(n - 1 - n % v);
        long b = n / v * (n % v + 1) + rangeSum(n % v);
        map.put(n,a+b);
        return a + b;
    }

    private static long digitNum(long n) {
        long v = 1;
        long temp = n;
        while (temp >= 10) {
            temp = temp / 10;
            v *= 10;
        }

        return v;
    }
}
