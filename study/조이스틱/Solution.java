package study.조이스틱;

// 알파벳은 총 26개, 두 알파벳 사이의 간격은  알파벳2 - 알파벳1 or 26 - (알파벳2 - 알파벳1)
// 위로 조작 : 해당하는 알파벳 - 'A'
// 아래로 조작 : 26 - 위로 조작한 횟수
// 1. A가 끝나는 지점을 endA변수에 구함. 그 지점까지 이동하는데 걸리는 값 왼, 오 비교
// 2. 더 짧은 방향을 move에 넣어줌. 가장 작은 move 마지막에 반환
class Solution {
    public int solution(String name) {
        int answer = 0;
        int len = name.length();

        // 제일 짧은 좌, 우 이동은 그냥 맨 오른쪽으로 이동할 때
        int min = len - 1;

        for (int i = 0; i < len; i++) {
            // 조이스틱 상, 하 이동
            char c = name.charAt(i);
            int mov = Math.min(c - 'A', 'Z' - c + 1);
            answer += mov;

            // 조이스틱 좌, 우 이동
            int nextIndex = i + 1;
            // 다음 단어가 A이고, 단어가 끝나기 전까지 nextIndex 증가
            while (nextIndex < len && name.charAt(nextIndex) == 'A')
                nextIndex++;

            min = Math.min(min, Math.min((i * 2) + len - nextIndex, (len - nextIndex)*2 + i ));
        }

        answer += min;

        return answer;
    }

    public static void main(String[] args) {
        String name = "RCETAAAAVUEAETZAAAK";
        Solution solution = new Solution();
        int answer = solution.solution(name);
        System.out.println(answer);
    }
}