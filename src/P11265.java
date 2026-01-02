import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class P11265 {

    static class Edge implements Comparable<Edge> {
        int v, cost;
        public Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        public int compareTo(Edge e) {
            return cost - e.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> edges = new ArrayList<>();
        edges.add(new ArrayList<>());
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            edges.add(new ArrayList<>());
            for (int j = 1; j <= n; j++) {
                edges.get(i).add(new Edge(j, Integer.parseInt(st.nextToken())));
            }
        }
        int[][] sp = new int[n+1][n+1];
        for (int i = 1; i <= n; i++) {
            sp[i] = resolveShortestPath(i, n, edges);
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (sp[a][b] <= c) {
                System.out.println("Enjoy other party");
                continue;
            }
            System.out.println("Stay here");
        }
    }

    private static int[] resolveShortestPath(int v, int n, ArrayList<ArrayList<Edge>> edges) {
        int[] sp = new int[n+1];
        Arrays.fill(sp, Integer.MAX_VALUE);
        sp[v] = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(v, 0));

        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (edge.cost > sp[edge.v]) continue;
            ArrayList<Edge> nextEdges = edges.get(edge.v);
            for (Edge nextEdge : nextEdges) {
                if (sp[nextEdge.v] > sp[edge.v] + nextEdge.cost) {
                    sp[nextEdge.v] = sp[edge.v] + nextEdge.cost;
                    pq.offer(new Edge(nextEdge.v, sp[nextEdge.v]));
                }
            }
        }

        return sp;
    }
}
