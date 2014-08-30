package org.exor.codechef.practice.SUMTRIAN;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int t = nextInt();
        int[] first = new int[10];
        int[] second = new int[10];
        while(t-- > 0) {
            int n = nextInt(), max = Integer.MIN_VALUE;
            for(int row = 0; row < n; row++) {
                for(int col = 0; col < row + 1; col++)
                    second[col] = nextInt();
                for(int col = 0; col < row + 1; col++) {
                    if(col == 0)
                        second[col] += first[col];
                    else {
                        second[col] += Math.max(first[col], first[col - 1]);
                    }
                    if(max < second[col])
                        max = second[col];
                }
                System.arraycopy(second, 0, first, 0, first.length);
                debug(first);
            }
            System.out.println(max);
        }
    }

    private StringTokenizer st;
    private BufferedReader scan;

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
        if(st == null || !st.hasMoreTokens())
            st = new StringTokenizer(scan.readLine());
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
    }

}
