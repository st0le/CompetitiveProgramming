package org.exor.SPOJ.WORDS1;

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
        // ----- solution starts here -----
        final int V = 26;
        int[][] wt = new int[V][V];
        int[] ind = new int[V];
        int[] outd = new int[V];

        boolean[] visited = new boolean[V];
        int[] stack = new int[1000000];
        int top = -1;

        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            for(int[] w: wt)
                Arrays.fill(w, 0);
            Arrays.fill(ind, 0);
            Arrays.fill(outd, 0);
            Arrays.fill(visited, false);

            int E = nextInt();
            for(int i = 0; i < E; i++) {
                String edge = nextToken();
                int a = edge.charAt(0) - 'a';
                int b = edge.charAt(edge.length() - 1) - 'a';
                wt[a][b]++;
                outd[a]++;
                ind[b]++;
            }
            int src = 0;
            for(int i = 0; i < V; i++)
                if(outd[i] > ind[i]) {
                    src = i;
                    break;
                }
            top = -1;
            stack[++top] = src;
            while(top >= 0) {
                int u = stack[top--];
                if(!visited[u]) {
                    visited[u] = true;
                    for(int v = 0; v < V; v++)
                        if(wt[u][v] > 0 && !visited[v])
                            stack[++top] = v;
                }
            }
            boolean eulerPath = true;
            for(int u = 0; u < V; u++)
                if((ind[u] > 0 || outd[u] > 0) && !visited[u]) {
                    eulerPath = false;
                    break;
                }
            if(eulerPath) {

                int oddDiff = 0;
                for(int u = 0; u < V; u++) {
                    if(Math.abs(ind[u] - outd[u]) == 1)
                        oddDiff++;
                    if(Math.abs(ind[u] - outd[u]) > 1)
                        oddDiff = Integer.MAX_VALUE;
                }
                eulerPath = oddDiff == 0 || oddDiff == 2;
            }

            out.println(eulerPath ? "Ordering is possible."
                                 : "The door cannot be opened.");

        }
        // ----- solution ends here -----
        out.flush();
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;

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
            String line = null;
            while((line = scan.readLine()) != null) {
                if(line.length() > 0)
                    break;
            }
            if(line == null)
                return null;
            st = new StringTokenizer(line);
        }
        return st == null ? null : st.nextToken();
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
