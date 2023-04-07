package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Pattern;

public class Main_15683_감시_박명규 {
    static int[] dir;
    static char[][] area;
    static int min = Integer.MAX_VALUE;
    static int zeroNum=0;
    static ArrayList<int[]> arrayList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = 0;
        area = new char[N][M];
        arrayList = new ArrayList<>();

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<M;j++){
                String temp = st.nextToken();
                area[i][j] = temp.charAt(0);
                if(area[i][j]=='0') zeroNum++;
                if(Pattern.matches("^[1-4]",temp)) {
                    R++;
                }
                if(Pattern.matches("^[1-5]",temp)) {
                    arrayList.add(new int[]{i,j});
                }
            }
        }

        dir = new int[R];
        permutation(0,N,M,R);
        System.out.println(min);
    }
    public static void permutation(int cnt,int N,int M,int R){

        if(cnt==R){
            int next = 0;
            int num = 0;
            char[][] temp = new char[N][M];
            for(int i =0;i<N;i++){
                for(int j =0;j<M;j++){
                    temp[i][j] = area[i][j];
                }
            }

            for(int size = 0;size<arrayList.size();size++){
                int i = arrayList.get(size)[0];
                int j =arrayList.get(size)[1];
                    if(temp[i][j]=='0'||temp[i][j]=='#'||temp[i][j]=='6') continue;
                    switch (temp[i][j]){
                        case '1':
                            int d = dir[next++];
                            int count = 1;
                            if(d==0){
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#')){
                                        temp[i][j+count++] = '#';
                                    }
                                    else break;
                                }
                            }
                            else if(d==1){
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++] = '#';
                                    else break;
                                }
                            }
                            else if(d==2){
                                while (true){
                                    if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                        temp[i-count++][j] = '#';
                                    else break;
                                }
                            }
                            else if(d==3){
                                while (true){
                                    if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(temp[i+count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                        temp[i+count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            break;
                        case '2':
                            d = dir[next++];
                            count =1;
                            if(d==0||d==1){
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                        temp[i][j+count++]= '#';
                                    else
                                        break;
                                }
                                count =1;
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++] = '#';
                                    else
                                        break;
                                }
                            }
                            if(d==2||d==3){
                                while (true){
                                    if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(temp[i+count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                        temp[i+count++][j]= '#';
                                    else
                                        break;
                                }
                                count =1;
                                while (true){
                                    if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                        temp[i-count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            break;
                        case '3' :
                            d = dir[next++];
                            count =1;
                            if(d==0){
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(area[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                        temp[i][j+count++]= '#';
                                    else
                                        break;
                                }
                                count =1;
                                while (true){
                                    if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                        temp[i-count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            if(d==1){
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++]= '#';
                                    else
                                        break;
                                }
                                count = 1;
                                while (true){
                                    if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                        temp[i-count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            if(d==2){
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                        temp[i][j+count++]= '#';
                                    else
                                        break;
                                }
                                count = 1;
                                while (true){
                                    if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(temp[i+count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                        temp[i+count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            if(d==3){
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++]= '#';
                                    else
                                        break;
                                }
                                count = 1;
                                while (true){
                                    if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(area[i+count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                        temp[i+count++][j] = '#';
                                    else
                                        break;
                                }
                            }
                            break;
                        case '4':
                            d = dir[next++];
                            count =1;
                            if(d==0||d==1){
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++]= '#';
                                    else
                                        break;
                                }
                                count = 1;
                                while (true){
                                    if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                        temp[i-count++][j] = '#';
                                    else
                                        break;
                                }
                                count=1;
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                        temp[i][j+count++]= '#';
                                    else
                                        break;
                                }
                            }
                            if(d==2||d==3){
                                while (true){
                                    if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(temp[i+count][j]))){
                                        count++;
                                        continue;
                                    }
                                    if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                        temp[i+count++][j] = '#';
                                    else
                                        break;
                                }
                                count = 1;
                                while (true){
                                    if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                        temp[i][j-count++]= '#';
                                    else
                                        break;
                                }
                                count =1;
                                while (true){
                                    if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                        count++;
                                        continue;
                                    }
                                    if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                        temp[i][j+count++]= '#';
                                    else
                                        break;
                                }
                            }
                            break;
                        case '5' :
                            count = 1;
                            while (true){
                                if(i-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i-count][j]))){
                                    count++;
                                    continue;
                                }
                                if(i-count>=0&&(temp[i-count][j]=='0'||temp[i-count][j]=='#'))
                                    temp[i-count++][j] = '#';
                                else
                                    break;
                            }
                            count=1;
                            while (true){
                                if(i+count<=N-1&&Pattern.matches("^[1-5]",Character.toString(temp[i+count][j]))){
                                    count++;
                                    continue;
                                }
                                if(i+count<=N-1&&(temp[i+count][j]=='0'||temp[i+count][j]=='#'))
                                    temp[i+count++][j] = '#';
                                else
                                    break;
                            }
                            count = 1;
                            while (true){
                                if(j-count>=0&&Pattern.matches("^[1-5]",Character.toString(temp[i][j-count]))){
                                    count++;
                                    continue;
                                }
                                if(j-count>=0&&(temp[i][j-count]=='0'||temp[i][j-count]=='#'))
                                    temp[i][j-count++]= '#';
                                else
                                    break;
                            }
                            count=1;
                            while (true){
                                if(j+count<=M-1&&Pattern.matches("^[1-5]",Character.toString(temp[i][j+count]))){
                                    count++;
                                    continue;
                                }
                                if(j+count<=M-1&&(temp[i][j+count]=='0'||temp[i][j+count]=='#'))
                                    temp[i][j+count++]= '#';
                                else
                                    break;
                            }
                            break;
                    }
                }


            for(int i =0;i<N;i++){
                for(int j =0;j<M;j++){
                    if(temp[i][j]=='0') num++;
                }
            }

            if(num<min){
                min = num;
            }
            return;
        }
        for(int i =0;i<4;i++){
            dir[cnt] = i;
            permutation(cnt+1,N,M,R);
        }

    }
}
