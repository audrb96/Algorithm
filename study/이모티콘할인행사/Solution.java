package study.이모티콘할인행사;

class Solution {
    double[] percent = {0.1,0.2,0.3,0.4};
    double[] selectedPercent;
    int n,m;
    int[] answer;
    public int[] solution(int[][] users, int[] emoticons) {
        answer = new int[2];
        n = users.length;
        m = emoticons.length;
        selectedPercent = new double[m];
        backtracking(0, users, emoticons);

        return answer;
    }

    private void backtracking(int cnt, int[][] users, int[] emoticons) {

        if(cnt == emoticons.length) {
            int totalPrice = 0;
            int userCount = 0;

            for(int i =0; i<users.length;i++) {
                int price = 0;
                for(int j =0; j<m;j++) {
                    if(users[i][0]*0.01 <= selectedPercent[j]) {
                        price += emoticons[j]*(1-selectedPercent[j]);
                    }
                    if(price >= users[i][1]) {
                        userCount++;
                        break;
                    }
                }
                if(price >= users[i][1]) continue;
                totalPrice += price;
            }
            if((userCount > answer[0]) ||
                    (userCount == answer[0] && totalPrice > answer[1])) {
                answer = new int[]{userCount, totalPrice};
            }
            return;
        }

        for(int i =0; i< percent.length; i++) {
            selectedPercent[cnt] = percent[i];
            backtracking(cnt+1, users, emoticons);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] users = {{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}};
        int[] emoticons = {1300, 1500, 1600, 4900};
        int[] answer = solution.solution(users, emoticons);
        for (int i : answer) {
            System.out.println(i);
        }
    }

}