import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Edge {
    public int next, length;
    public Edge(int next, int length) {
        this.next = next;
        this.length = length;
    }
}

public class P20924 {

    static int rootToGigaLength = 0;
    static int gigaToLeafLength = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> tree = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            tree.get(v).add(new Edge(w, length));
            tree.get(w).add(new Edge(v, length));
        }

        boolean[] vis = new boolean[n + 1];
        int giga = findGiga(r, tree, vis);
        dfs(giga, tree, vis, 0);

        System.out.println(rootToGigaLength + " " + gigaToLeafLength);
    }

    private static int findGiga(int r, ArrayList<ArrayList<Edge>> tree, boolean[] vis) {
        Queue<Edge> q = new LinkedList<>();

        vis[r] = true;
        q.offer(new Edge(r, 0));
        while (!q.isEmpty()) {
            Edge e = q.poll();
            ArrayList<Edge> edges = tree.get(e.next);
            if (e.next == r && edges.size() == 2) break; // 루트가 giga 인 경우
            rootToGigaLength += e.length;
            if (edges.size() > 2) return e.next;
            for (Edge edge : edges) {
                if (!vis[edge.next]) {
                    vis[edge.next] = true;
                    q.offer(new Edge(edge.next, edge.length));
                }
            }
        }

        return r;
    }

    private static void dfs(int v, ArrayList<ArrayList<Edge>> tree, boolean[] vis, int totalLength) {
        ArrayList<Edge> edges = tree.get(v);
        if (edges.size() == 1) {
            gigaToLeafLength = Math.max(gigaToLeafLength, totalLength);
            return;
        }
        for (Edge edge : edges) {
            if (!vis[edge.next]) {
                vis[v] = true;
                totalLength += edge.length;
                dfs(edge.next, tree, vis, totalLength);
                totalLength -= edge.length;
            }
        }
    }
}
