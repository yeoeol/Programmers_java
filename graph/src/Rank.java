public class Rank {
    public static void main(String[] args) {
        int[][] results = new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        System.out.println(solution(5, results));
    }
    public static int solution(int n, int[][] results) {
        int answer = 0;
        int[][] rank = new int[n][n];

        for (int i = 0; i < results.length; i++) {
            int winner = results[i][0]-1;
            int loser = results[i][1]-1;
            rank[winner][loser] = 1;
            rank[loser][winner] = -1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (rank[i][k] == 1 && rank[k][j] == 1) {
                        rank[i][j] = 1;
                        rank[j][i] = -1;
                    }
                    if (rank[i][k] == -1 && rank[k][j] == -1) { //k가 i를 이기고 j가 k를 이김
                        rank[i][j] = -1;
                        rank[j][i] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (rank[i][j] != 0) {
                    cnt++;
                }
            }
            if (cnt == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}
