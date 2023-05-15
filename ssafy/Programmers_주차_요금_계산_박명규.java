package ssafy;

import java.util.*;

public class Programmers_주차_요금_계산_박명규 {
    public static class Record implements Comparable<Record>{
        int time;
        int carNum;
        int inOut;

        public Record(int time, int carNum, int inOut) {
            this.time = time;
            this.carNum = carNum;
            this.inOut = inOut;
        }

        @Override
        public int compareTo(Record o) {
                return this.carNum - o.carNum;

        }
    }

    public static int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> ansMap = new HashMap<>();

        List<Record> recordList = new ArrayList<>();
        for(int i =0;i<records.length;i++){
            String[] temp = records[i].split(" ");
            int hour = Integer.parseInt(temp[0].split(":")[0]);
            int minute = Integer.parseInt(temp[0].split(":")[1]);
            int carNum = Integer.parseInt(temp[1]);
            int inOut = temp[2].equals("IN") ? 1: 0;
            recordList.add(new Record(hour*60+minute, carNum,inOut));
        }
        Collections.sort(recordList);

        int beforeInOut = -1;
        int beforeTime = -1;
        int beforeCarNum = -1;

        for(int i =0;i<recordList.size();i++){
            Record temp = recordList.get(i);
            if(temp.inOut ==1 && beforeInOut ==1 && i==(recordList.size()-1)){
                if(ansMap.containsKey(temp.carNum)){
                    int ti = ansMap.remove(temp.carNum);
                    ansMap.put(temp.carNum,ti+1439-temp.time);
                }
                else{
                    ansMap.put(temp.carNum,1439-temp.time);
                }

                if(ansMap.containsKey(beforeCarNum)){
                    int ti = ansMap.remove(beforeCarNum);
                    ansMap.put(beforeCarNum,ti+1439-beforeTime);
                }
                else{
                    ansMap.put(beforeCarNum,1439-beforeTime);
                }
                break;
            }

            if(temp.inOut == 1 && i==(recordList.size()-1)){
                if(ansMap.containsKey(temp.carNum)){
                    int ti = ansMap.remove(temp.carNum);
                    ansMap.put(temp.carNum,ti+1439-temp.time);
                }
                else{
                    ansMap.put(temp.carNum,1439-temp.time);
                }
                break;
            }

            if(beforeInOut == 1 && temp.inOut ==1){
                if(ansMap.containsKey(beforeCarNum)){
                    int ti = ansMap.remove(beforeCarNum);
                    ansMap.put(beforeCarNum,ti+1439-beforeTime);
                }
                else{
                    ansMap.put(beforeCarNum,1439-beforeTime);
                }
                beforeInOut = 1;
                beforeTime = temp.time;
                beforeCarNum = temp.carNum;
                continue;
            }

            if(temp.inOut == 1){
                beforeTime = temp.time;
                beforeInOut = 1;
            }
            else if(temp.inOut ==0){
                if(ansMap.containsKey(temp.carNum)){
                    int ti = ansMap.remove(temp.carNum);
                    beforeInOut = 0;
                    ansMap.put(temp.carNum,ti+temp.time-beforeTime);
                }
                else{
                    beforeInOut = 0;
                    ansMap.put(temp.carNum,temp.time-beforeTime);
                }
            }
            beforeCarNum = temp.carNum;
        }


        ArrayList<Integer> ansList = new ArrayList<>();
        Object[] mapkey = ansMap.keySet().toArray();
        Arrays.sort(mapkey);


        for (Object integer : mapkey) {
            if(ansMap.get(integer)<= fees[0]){
                ansList.add(fees[1]);
            }
            else{
                double a = (ansMap.get(integer)-fees[0])%fees[2];
                if(a != 0 ){
                    a = (ansMap.get(integer)-fees[0])/fees[2]+1;
                }
                else{
                    a =  (ansMap.get(integer)-fees[0])/fees[2];
                }

                ansList.add((int) (fees[1]+a*fees[3]));
            }
        }

        int[] answer = new int[ansList.size()];
        for(int i =0;i<ansList.size();i++){
            answer[i] = ansList.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] fees = {180, 5000, 10, 600};
        String[] records = {"05:34 5961 IN", "06:00 0000 IN", "07:59 0148 IN"};

        int[] ans = solution(fees,records);

        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
    }
}
