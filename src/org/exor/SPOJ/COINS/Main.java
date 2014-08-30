package org.exor.SPOJ.COINS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private long[] memo;

    public long foo(long n) {
        if(n < memo.length)
            return memo[(int)n];
        else
            return Math.max(n, foo(n / 2) + foo(n / 3) + foo(n / 4));
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        memo = new long[10000000];
        for(int i = 0; i < memo.length; i++)
            memo[i] = Math.max(i, memo[i / 2] + memo[i / 3] + memo[i / 4]);
        String line;
        while((line = nextToken()) != null)
            out.println(foo(Long.valueOf(line)));
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
