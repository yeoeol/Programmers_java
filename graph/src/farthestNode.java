import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class farthestNode {
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    static boolean[] visited;
    static int[] result;

    public static void main(String[] args) {
        int answer = 0;
        int n = 6;
        int[][] edge = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        visited = new boolean[n+1];
        result = new int[n+1];

        for (int i = 0; i < edge.length; i++) {
            int a = edge[i][0];
            int b = edge[i][1];
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        bfs();
        int max = Arrays.stream(result).max().getAsInt();
        for (int i = 1; i <= n; i++) {
            if (max == result[i]) {
                answer++;
            }
        }
        System.out.println(answer);
    }

    static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        visited[1] = true;
        result[1] = 1;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            for (Integer integer : graph.get(poll)) {
                if (!visited[integer]) {
                    visited[integer] = true;
                    result[integer] = result[poll]+1;
                    queue.add(integer);
                }
            }
        }
    }
}

/*
class Solution {
    private ArrayList<Integer>[] adj;
    private int[] visit;
    private int depth = 0;

    public int solution(int n, int[][] edge) {
        int answer = 0;
        visit = new int[n+1];
        adj = new ArrayList[n+1];
        for(int i=1; i<=n; i++) adj[i] = new ArrayList<>();
        for(int i=0; i<edge.length; i++){
            adj[edge[i][0]].add(edge[i][1]);
            adj[edge[i][1]].add(edge[i][0]);
        }

        bfs(1, 1);

        for(int i=1; i<=n; i++){
            if(depth == visit[i]) answer+=1;
        }

        return answer;
    }

    private void bfs(int start, int count){
        Queue<Integer> q = new LinkedList();
        q.add(start);
        q.add(count);
        visit[start] = count;

        while(!q.isEmpty()){
            int node = q.poll();
            int n = q.poll();

            if(depth < n) depth = n;
            for(int i=0; i<adj[node].size(); i++){
                int next = adj[node].get(i);

                if(visit[next] != 0) continue;
                visit[next] = n+1;
                q.add(next);
                q.add(n+1);
            }
        }
    }
}*/
