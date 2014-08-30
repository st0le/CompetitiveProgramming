package org.exor.SPOJ.TRICOUNT;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

// Problem Solved (but size < 500)
public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        for(int testCase = 0, T = nextInt(); testCase < T; testCase++) {
            BigInteger n = nextBigInteger();
            // n * (n + 2) * (2 * n + 1) / 8
            BigInteger n_2 = n.add(BigInteger.valueOf(2));
            BigInteger n2_1 = n.shiftLeft(1).add(BigInteger.ONE);
            out.println(n.multiply(n_2).multiply(n2_1).shiftRight(3));
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

    public BigInteger nextBigInteger() throws Exception {
        return new BigInteger(nextToken());
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

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    private void init() {
        scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }
}
