import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P2224 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());

        HashMap<Character, ArrayList<Character>> graph = new HashMap<>();
        HashMap<Character, Boolean> visited = new HashMap<>();

        ArrayList<Character> inputOrder = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(br.readLine());
            char p = st.nextToken().charAt(0);
            if (!inputOrder.contains(p)) inputOrder.add(p);
            st.nextToken();
            char q = st.nextToken().charAt(0);
            if (!graph.containsKey(p)) {
                graph.put(p, new ArrayList<>());
            }
            if (!graph.get(p).contains(q)) graph.get(p).add(q);

            if (!visited.containsKey(p)) {
                visited.put(p, false);
            }
            if (!visited.containsKey(q)) {
                visited.put(q, false);
            }
        }

        ArrayList<String> answers = new ArrayList<>();
        for (int i = 0; i < inputOrder.size(); i++) {
            HashMap<Character, Boolean> visit = (HashMap<Character, Boolean>) visited.clone();
            dfs(inputOrder.get(i), graph, visit, answers);
        }

        Collections.sort(answers);
        System.out.println(answers.size());
        answers.forEach(System.out::println);
    }

    private static void dfs(char start, HashMap<Character, ArrayList<Character>> graph, HashMap<Character, Boolean> visited, ArrayList<String> answers) {
        PriorityQueue<Character> pq = new PriorityQueue<>();

        visited.put(start, true);
        pq.add(start);

        while (!pq.isEmpty()) {
            Character c = pq.poll();
            ArrayList<Character> nextNodes = graph.get(c);
            if (nextNodes == null) continue;
            for (Character next : nextNodes) {
                if (!visited.get(next)) {
                    answers.add(start + " => " + next);
                    visited.put(next, true);
                    pq.add(next);
                }
            }
        }
    }
}
