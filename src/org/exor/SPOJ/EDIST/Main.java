package org.exor.SPOJ.EDIST;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int computeEditDistance(String s1, String s2) {
        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for(int i = 0; i < dp.length; i++) {
            for(int j = 0; j < dp[i].length; j++) {

                dp[i][j] = i == 0 ? j : j == 0 ? i : 0;

                if(i > 0 && j > 0) {

                    if(s1.charAt(i - 1) == s2.charAt(j - 1))
                        dp[i][j] = dp[i - 1][j - 1];

                    else
                        dp[i][j] = Math.min(dp[i][j - 1] + 1,
                                            Math.min(dp[i - 1][j - 1] + 1,
                                                     dp[i - 1][j] + 1));

                }
            }
        }
        return dp[s1.length()][s2.length()];
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            out.println(computeEditDistance(nextToken(), nextToken()));
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
