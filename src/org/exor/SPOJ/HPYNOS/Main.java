package org.exor.SPOJ.HPYNOS;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private int sumDigitsSquared(int n) {
        int s = 0;
        while(n > 0) {
            s += sqs[n % 10];
            n /= 10;
        }
        return s;
    }

    public void solve() throws Exception {
        init();
        sqs = new int[1000];
        for(int i = 0; i < 10; i++)
            sqs[i] = i * i;
        for(int i = 10; i < 1000; i++)
            sqs[i] = sumDigitsSquared(i);
        int N = Integer.valueOf(scan.readLine());
        int c = 0;
        while(true) {
            if(N == 1 || N == 4)
                break;
            int S = 0;
            while(N > 0) {
                S += sqs[N % 1000];
                N /= 1000;
            }
            N = S;
            c++;
        }
        out.println(N == 1 ? c : -1);
        // ----- solution ends here -----
        out.flush();
    }

    private StringTokenizer st;
    private BufferedReader scan;
    private PrintWriter out;
    private int[] sqs;

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
