package org.exor.SPOJ.EXFOR;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public int f(int x1, int x2, int x3, int x4, int x5, int x6, int x7,
                 int x8, int x9, int x10) {
        return (x1 | x2) ^ (x1 | x3) ^ (x1 | x4) ^ (x1 | x5) ^ (x1 | x6)
               ^ (x1 | x7) ^ (x1 | x8) ^ (x1 | x9) ^ (x1 | x10) ^ (x2 | x3)
               ^ (x2 | x4) ^ (x2 | x5) ^ (x2 | x6) ^ (x2 | x7) ^ (x2 | x8)
               ^ (x2 | x9) ^ (x2 | x10) ^ (x3 | x4) ^ (x3 | x5) ^ (x3 | x6)
               ^ (x3 | x7) ^ (x3 | x8) ^ (x3 | x9) ^ (x3 | x10) ^ (x4 | x5)
               ^ (x4 | x6) ^ (x4 | x7) ^ (x4 | x8) ^ (x4 | x9) ^ (x4 | x10)
               ^ (x5 | x6) ^ (x5 | x7) ^ (x5 | x8) ^ (x5 | x9) ^ (x5 | x10)
               ^ (x6 | x7) ^ (x6 | x8) ^ (x6 | x9) ^ (x6 | x10) ^ (x7 | x8)
               ^ (x7 | x9) ^ (x7 | x10) ^ (x8 | x9) ^ (x8 | x10) ^ (x9 | x10)
               ^ (x1 | x2 | x3) ^ (x1 | x2 | x4) ^ (x1 | x2 | x5)
               ^ (x1 | x2 | x6) ^ (x1 | x2 | x7) ^ (x1 | x2 | x8)
               ^ (x1 | x2 | x9) ^ (x1 | x2 | x10) ^ (x1 | x3 | x4)
               ^ (x1 | x3 | x5) ^ (x1 | x3 | x6) ^ (x1 | x3 | x7)
               ^ (x1 | x3 | x8) ^ (x1 | x3 | x9) ^ (x1 | x3 | x10)
               ^ (x1 | x4 | x5) ^ (x1 | x4 | x6) ^ (x1 | x4 | x7)
               ^ (x1 | x4 | x8) ^ (x1 | x4 | x9) ^ (x1 | x4 | x10)
               ^ (x1 | x5 | x6) ^ (x1 | x5 | x7) ^ (x1 | x5 | x8)
               ^ (x1 | x5 | x9) ^ (x1 | x5 | x10) ^ (x1 | x6 | x7)
               ^ (x1 | x6 | x8) ^ (x1 | x6 | x9) ^ (x1 | x6 | x10)
               ^ (x1 | x7 | x8) ^ (x1 | x7 | x9) ^ (x1 | x7 | x10)
               ^ (x1 | x8 | x9) ^ (x1 | x8 | x10) ^ (x1 | x9 | x10)
               ^ (x2 | x3 | x4) ^ (x2 | x3 | x5) ^ (x2 | x3 | x6)
               ^ (x2 | x3 | x7) ^ (x2 | x3 | x8) ^ (x2 | x3 | x9)
               ^ (x2 | x3 | x10) ^ (x2 | x4 | x5) ^ (x2 | x4 | x6)
               ^ (x2 | x4 | x7) ^ (x2 | x4 | x8) ^ (x2 | x4 | x9)
               ^ (x2 | x4 | x10) ^ (x2 | x5 | x6) ^ (x2 | x5 | x7)
               ^ (x2 | x5 | x8) ^ (x2 | x5 | x9) ^ (x2 | x5 | x10)
               ^ (x2 | x6 | x7) ^ (x2 | x6 | x8) ^ (x2 | x6 | x9)
               ^ (x2 | x6 | x10) ^ (x2 | x7 | x8) ^ (x2 | x7 | x9)
               ^ (x2 | x7 | x10) ^ (x2 | x8 | x9) ^ (x2 | x8 | x10)
               ^ (x2 | x9 | x10) ^ (x3 | x4 | x5) ^ (x3 | x4 | x6)
               ^ (x3 | x4 | x7) ^ (x3 | x4 | x8) ^ (x3 | x4 | x9)
               ^ (x3 | x4 | x10) ^ (x3 | x5 | x6) ^ (x3 | x5 | x7)
               ^ (x3 | x5 | x8) ^ (x3 | x5 | x9) ^ (x3 | x5 | x10)
               ^ (x3 | x6 | x7) ^ (x3 | x6 | x8) ^ (x3 | x6 | x9)
               ^ (x3 | x6 | x10) ^ (x3 | x7 | x8) ^ (x3 | x7 | x9)
               ^ (x3 | x7 | x10) ^ (x3 | x8 | x9) ^ (x3 | x8 | x10)
               ^ (x3 | x9 | x10) ^ (x4 | x5 | x6) ^ (x4 | x5 | x7)
               ^ (x4 | x5 | x8) ^ (x4 | x5 | x9) ^ (x4 | x5 | x10)
               ^ (x4 | x6 | x7) ^ (x4 | x6 | x8) ^ (x4 | x6 | x9)
               ^ (x4 | x6 | x10) ^ (x4 | x7 | x8) ^ (x4 | x7 | x9)
               ^ (x4 | x7 | x10) ^ (x4 | x8 | x9) ^ (x4 | x8 | x10)
               ^ (x4 | x9 | x10) ^ (x5 | x6 | x7) ^ (x5 | x6 | x8)
               ^ (x5 | x6 | x9) ^ (x5 | x6 | x10) ^ (x5 | x7 | x8)
               ^ (x5 | x7 | x9) ^ (x5 | x7 | x10) ^ (x5 | x8 | x9)
               ^ (x5 | x8 | x10) ^ (x5 | x9 | x10) ^ (x6 | x7 | x8)
               ^ (x6 | x7 | x9) ^ (x6 | x7 | x10) ^ (x6 | x8 | x9)
               ^ (x6 | x8 | x10) ^ (x6 | x9 | x10) ^ (x7 | x8 | x9)
               ^ (x7 | x8 | x10) ^ (x7 | x9 | x10) ^ (x8 | x9 | x10);
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            out.println(f(nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt(),
                          nextInt()));
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
