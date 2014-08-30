package org.exor.SPOJ.FANCY;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private void brute(char[] digits, int index, String t) {
        if(index < digits.length) {
            String v = "";
            for(int i = 0; i + index < digits.length && i < 3; i++) {
                if(digits[index] != digits[i + index])
                    break;
                v += digits[index + i];
                brute(digits, index + i + 1, t + v + ",");
            }
        }
        if(index == digits.length)
            out.println(t);
    }

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int T = nextInt();
        String line;
        long[] count = new long[50];
        while((line = scan.readLine()) != null) {
            Arrays.fill(count, 0);
            char[] digits = line.toCharArray();
            int L = digits.length;
            count[L] = 1;
            for(int i = L - 1; i >= 0; i--) {
                for(int j = i + 1, v = 0; j <= L && v < 3; j++, v++) {
                    count[i] += count[j];
                    if((j < L && digits[i] != digits[j]))
                        break;
                }
            }
            brute(digits, 0, "");
            out.println(count[0]);
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
