package org.exor.SPOJ.TFIB;

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
        BigInteger[] fibs = new BigInteger[500];
        fibs[0] = BigInteger.ONE;
        fibs[1] = BigInteger.valueOf(2);
        for(int i = 2; i < 500; i++)
            fibs[i] = fibs[i - 1].add(fibs[i - 2]);

        String line;
        while((line = scan.readLine()) != null) {
            if("0 0".equals(line))
                break;
            st = new StringTokenizer(line);
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());
            int pa = Arrays.binarySearch(fibs, a);
            pa = Math.max(pa, ~pa);
            int pb = Arrays.binarySearch(fibs, b);
            if(pb < 0)
                pb = ~pb;
            else
                pb++;
            out.println(pb - pa);
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
