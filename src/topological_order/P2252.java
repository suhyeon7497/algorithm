package topological_order;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class P2252 {

    static ArrayList<Integer> answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        graph.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            input = br.readLine().split(" ");
            graph.get(Integer.parseInt(input[0])).add(Integer.parseInt(input[1]));
        }

        answer = new ArrayList<>();
        boolean[] visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i])
                dfs(i, graph, visited);
        }

        Collections.reverse(answer);
        for (int i = 0; i < n; i++) {
            System.out.print(answer.get(i) + " ");
        }
        bw.flush();
    }

    private static void dfs(int v, ArrayList<ArrayList<Integer>> graph, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < graph.get(v).size(); i++) {
            if (!visited[graph.get(v).get(i)]) {
                dfs(graph.get(v).get(i), graph, visited);
            }
        }
        answer.add(v);
    }
}
