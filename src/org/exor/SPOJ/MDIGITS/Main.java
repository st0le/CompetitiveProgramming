package org.exor.SPOJ.MDIGITS;

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
        StringBuilder sb = new StringBuilder();
        while(true) {
            int a = nextInt(), b = nextInt();
            if(a == 0 && b == 0)
                break;
            int mn = Math.min(a, b), mx = Math.max(a, b);
            sb.setLength(0);
            for(int i = 0; i < 10; i++)
                sb.append(countDigits(mx, i) - countDigits(mn - 1, i))
                  .append(' ');
            out.println(sb.toString());
        }
        // ----- solution ends here -----
        out.flush();
    }

    public int countDigits(int N, int d) {
        int n = N;
        int c = 0;
        int pow = 1;
        while(n > 0) {
            int numberBeforeDivideByTen = n / 10;
            int numberAfterDivideByTen = n % 10;
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
