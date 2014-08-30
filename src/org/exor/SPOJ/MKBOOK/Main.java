package org.exor.SPOJ.MKBOOK;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public long countDigits(long N, int d) {
        long n = N;
        long c = 0;
        long pow = 1;
        while(n > 0) {
            long numberBeforeDivideByTen = n / 10;
            long numberAfterDivideByTen = n % 10;
            if(d != 0) {
                c += numberBeforeDivideByTen * pow;
            }
            else {
                c += (numberBeforeDivideByTen - 1) * pow;
            }

            if(numberAfterDivideByTen > d) {
                c += pow;
            }
            else if(numberAfterDivideByTen == d) {
                c += N % pow + 1;
            }
            n = n / 10;
            pow = pow * 10;
        }
        return c;
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        StringBuilder sb = new StringBuilder();
        int testCase = 1;
        while(true) {
            long a = nextLong();
            if(a == 0)
                break;
            long b = nextLong();
            long mn = Math.min(a, b), mx = Math.max(a, b);
            sb.setLength(0);
            sb.append("Case ").append(testCase++).append(':');
            for(int i = 0; i < 10; i++)
                sb.append(String.format(" %d:", i))
                  .append(countDigits(mx, i) - countDigits(mn - 1, i));
            out.println(sb.toString());
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
