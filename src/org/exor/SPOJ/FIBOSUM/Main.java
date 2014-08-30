package org.exor.SPOJ.FIBOSUM;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public long fibMod(long n, long mod) {
        long[][] mtx = new long[][] { {1, 1}, {1, 0}};
        long[][] res = new long[][] { {1, 0}, {0, 1}};
        long a, b, c, d, e, f, g, h;
        while(n > 0) {
            a = mtx[0][0];
            b = mtx[0][1];
            c = mtx[1][0];
            d = mtx[1][1];
            if(n % 2 == 1) {
                // res *= mtx;
                e = res[0][0];
                f = res[0][1];
                g = res[1][0];
                h = res[1][1];
                res[0][0] = ((a * e) % mod + (b * g) % mod) % mod;
                res[0][1] = ((a * f) % mod + (b * h) % mod) % mod;
                res[1][0] = ((c * e) % mod + (c * g) % mod) % mod;
                res[1][1] = ((c * f) % mod + (d * h) % mod) % mod;
            }
            n >>= 1;
            // mtx = mtx*mtx
            mtx[0][0] = ((a * a) % mod + (b * c) % mod) % mod;
            mtx[0][1] = ((a * b) % mod + (b * d) % mod) % mod;
            mtx[1][0] = ((a * c) % mod + (c * d) % mod) % mod;
            mtx[1][1] = ((b * c) % mod + (d * d) % mod) % mod;
        }
        return res[0][1] % mod;
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----

        // Info : Sum of fib(0) + fib(1) + ... + fib(n) = fib(n+2) - 1
        // Therefore, fib(n) + fib(n+1) + ... + fib(m) = fib(m+2) - fib(n+2-1)
        long MOD = 1000000007;
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            long n = nextLong(), m = nextLong();
            out.println((fibMod(m + 2, MOD) - fibMod(n + 1, MOD) + MOD) % MOD);
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
