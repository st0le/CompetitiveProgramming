package org.exor.SPOJ.ROADNET;

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
        int[][] w = new int[300][300];
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            int n = nextInt();
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    w[i][j] = nextInt();
            for(int i = 0; i < n; i++)
                for(int j = i + 1; j < n; j++) {
                    boolean foundShorter = false;
                    for(int k = 0; k < n; k++)
                        if(i != k && j != k && w[i][j] == w[i][k] + w[k][j])
                            foundShorter = true;
                    if(!foundShorter)
                        out.println(String.format("%d %d", i + 1, j + 1));
                }
            if(testCase != T - 1) {
                out.println();
                nextToken(); // skip empty line
            }
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
            String line = scan.readLine();
            if(line == null || line.length() == 0)
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
