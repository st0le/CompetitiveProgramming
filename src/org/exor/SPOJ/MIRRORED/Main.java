package org.exor.SPOJ.MIRRORED;

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
        out.println("Ready");
        while(true) {
            String line = scan.readLine();
            if("  ".equals(line))
                break;
            boolean mirror = foo(line.charAt(0), line.charAt(1), 'p', 'q')
                             || foo(line.charAt(0), line.charAt(1), 'b', 'd');
            out.println(mirror ? "Mirrored pair" : "Ordinary pair");
        }
        // ----- solution ends here -----
        out.flush();
    }

    private boolean foo(char c1, char c2, char c, char d) {
        return (c1 == c && c2 == d) || (c1 == d && c2 == c);
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
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}
