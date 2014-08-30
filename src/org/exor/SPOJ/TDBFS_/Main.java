package org.exor.SPOJ.TDBFS_;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solve() throws Exception {
        init();
        graph = new int[1001][1001];
        cnts = new int[1001];
        s_q = new int[1001];
        visited = new boolean[1001];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            vn = nextInt();
            for(int i = 0; i < vn; i++) {
                int src = nextInt();
                cnts[src] = nextInt();
                for(int j = 0; j < cnts[src]; j++)
                    graph[src][j] = nextInt();
            }
            out.println(String.format("graph %d", testCase + 1));
            while(true) {
                Arrays.fill(visited, false);
                int src = nextInt(), code = nextInt();
                if(src == 0)
                    break;
                if(code == 0)
                    dfs(src);
                else
                    bfs(src);
                out.println();
            }

        }
        // ----- solution ends here -----
        out.flush();
    }

    private void dfs(int src) {
        int top = 0;
        s_q[top++] = src;
        while(top > 0) {
            int cur = s_q[--top];
            if(!visited[cur]) {
                visited[cur] = true;
                out.print(String.format("%d ", cur));
                for(int i = cnts[cur] - 1; i >= 0; i--)
                    if(!visited[graph[cur][i]])
                        s_q[top++] = graph[cur][i];
            }
        }
    }

    private void bfs(int src) {
        int front = 0, end = 0;
        s_q[end++] = src;
        while(front < end) {
            int cur = s_q[front++];
            if(!visited[cur]) {
                visited[cur] = true;
                out.print(String.format("%d ", cur));
                for(int i = 0; i < cnts[cur]; i++)
                    if(!visited[graph[cur][i]])
                        s_q[end++] = graph[cur][i];
            }
        }
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;
    private int[][] graph;
    private int[] cnts, s_q;
    private boolean[] visited;
    private int vn;

    public int nextInt() throws Exception {
        return Integer.valueOf(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.valueOf(nextToken());
    }

    public BigInteger nextBigInteger() throws Exception {
        return new BigInteger(nextToken());
    }

    public float nextFloat() throws Exception {
        return Float.valueOf(nextToken());
    }

    public Double nextDouble() throws Exception {
        return Double.valueOf(nextToken());
    }

    public String nextToken() throws Exception {
        if(st == null || !st.hasMoreTokens()) {
            String line = scan.readLine();
            if(line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st.nextToken();
    }

    public void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    private void init() {
        scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}
