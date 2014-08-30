package org.exor.SPOJ.EZDIJKST_;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    private int dijkstra(int[][] wt, int src, int dst, int V) {
        final int[] d = new int[V + 1];
        Arrays.fill(d, Integer.MAX_VALUE / 2);
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(V,
                                                               new Comparator<Integer>() {

                                                                   @Override
                                                                   public int compare(Integer o1,
                                                                                      Integer o2) {
                                                                       return d[o1]
                                                                              - d[o2];
                                                                   }
                                                               });
        d[src] = 0;
        pq.add(src);
        while(!pq.isEmpty()) {
            int u = pq.remove();
            for(int v = 0; v <= V; v++) {
                if(d[v] > d[u] + wt[u][v]) {
                    d[v] = d[u] + wt[u][v];
                    pq.add(v);
                }
            }
        }
        return d[dst];
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int[][] wt = new int[10000 + 1][1000];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            int V = nextInt(), E = nextInt();
            for(int i = 0; i <= V; i++)
                Arrays.fill(wt[i], Integer.MAX_VALUE / 2);
            for(int i = 0; i < E; i++) {
                wt[nextInt()][nextInt()] = nextInt();
            }
            int shortestPath = dijkstra(wt, nextInt(), nextInt(), V);
            out.println(shortestPath == Integer.MAX_VALUE / 2 ? "NO"
                                                             : shortestPath);
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
        scan = new BufferedReader(new InputStreamReader(System.in),
                                  5 * 1024 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out,
                                                       5 * 1024 * 1024));
    }

}
