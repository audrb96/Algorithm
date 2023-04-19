package study.공원산책;

class Solution {

    int[] dx = {0,-1,0,1};
    int[] dy = {1,0,-1,0};

    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0,0};
        char[][] parkArr = new char[park.length][park[0].length()];

        for(int i =0; i<parkArr.length; i++) {
            String row = park[i];
            for(int j =0; j<row.length(); j++) {
                parkArr[i][j] = row.charAt(j);
                if(parkArr[i][j] == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }

        for(int i =0; i<routes.length; i++) {
            String[] route = routes[i].split(" ");
            String dir = route[0];
            int distance = Integer.parseInt(route[1]);
            int dirNum = -1;

            switch (dir) {
                case "E" :
                    dirNum = 3;
                    break;
                case "S" :
                    dirNum = 0;
                    break;
                case "W" :
                    dirNum = 1;
                    break;
                case "N" :
                    dirNum = 2;
                    break;
            }

            boolean able =answer[0] + dy[dirNum] * distance >= 0
                    && answer[1] + dx[dirNum] * distance >= 0
                    && answer[1] + dx[dirNum] * distance < parkArr[0].length
                    && answer[0] + dy[dirNum] * distance < parkArr.length;

            int nx = answer[1];
            int ny = answer[0];

            if(able) {
                for(int j = 0; j<distance; j++) {
                    nx = nx + dx[dirNum];
                    ny = ny + dy[dirNum];

                    if(parkArr[ny][nx] == 'X') {
                        able = false;
                        break;
                    }
                }
            }

            if(able) {
                answer[1] = answer[1] + dx[dirNum]*distance;
                answer[0] = answer[0] + dy[dirNum]*distance;
            }

        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        String[] park = {"OSO","OOO","OXO","OOO"};
        String[] routes = {"E 2","S 3","W 1"};

        int[] answer = solution.solution(park, routes);
        for (int i : answer) {
            System.out.println(i);
        }

    }
}