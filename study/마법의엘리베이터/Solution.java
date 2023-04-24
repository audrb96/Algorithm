package study.마법의엘리베이터;

class Solution {

    int min;

    public int solution(int storey) {
        int answer = 0;
        int count = 0;
        int temp = storey;
        min = Integer.MAX_VALUE;

        while (temp > 0) {
            temp = temp/10;
            count++;
        }
        dfs(storey, 1, 0);
        answer = min;
        return answer;
    }

    public void dfs(int storey,int i, int result) {
        if(result > min) return;

        int count = 0;
        int temp = storey;
        while (temp > 0) {
            temp = temp/10;
            count++;
        }

        if(i > count) {
            min = Math.min(min, result);
            return;
        };

        int num = (int) ((int)(storey%Math.pow(10, i))/Math.pow(10,i-1));

        dfs((int) (storey - (num*Math.pow(10,i-1))), i+1,result+num );
        dfs((int) (storey + ((10-num)*Math.pow(10,i-1))), i+1,result+(10-num));


    }


    public static void main(String[] args) {
        int storey = 155;
        Solution solution = new Solution();
        int answer = solution.solution(storey);
        System.out.println(answer);
    }
}