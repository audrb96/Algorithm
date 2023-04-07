package ssafy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
//그리디 알고리즘 - 최고온도순으로 정렬한다음, 맨처음 원소를 list에 추가하고 list의 마지막원소의 최고온도보다 최저온도가 크면 list에 추가
public class Main_1828_냉장고_박명규 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N =Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        for(int i =0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = new int[]{Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())};
        }
        //배열의 2번째 요소를 오름차순으로 정렬
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1]==o2[1]){
                    return o1[0]-o2[0];
                }
                else{
                 return o1[1]-o2[1];
                }
            }
        }
        );
        List<int[]> answer = solution(arr);
        //리스트의 size 출력
        System.out.println(answer.size());

    }
    public static List<int[]> solution(int[][] arr){
        ArrayList<int[]> list = new ArrayList<>();
        //정렬된 배열의 첫번째 요소를 list에 집어넣는다.
        list.add(arr[0]);
        // 정렬된 배열의 마지막 요소의 최고보관온도보다, 배열의 최저보관온도가 크면 list에 추가
        for(int i=1,size=arr.length;i<size;i++){
            if(list.get(list.size()-1)[1]<arr[i][0]) list.add(arr[i]);
        }
        return list;

    }
}
