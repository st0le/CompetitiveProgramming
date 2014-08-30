package org.exor.codechef.practice.ATM;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

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
        scan = new BufferedReader(new InputStreamReader(System.in));
    }

    public void solve() throws Exception {
        init();
        int withdrawAmount = nextInt();
        float balance = nextFloat();
        DecimalFormat df = new DecimalFormat();
        df.setMinimumFractionDigits(2);
        df.setMaximumFractionDigits(2);
        df.setGroupingUsed(false);
        if(withdrawAmount % 5 != 0
           || Float.compare(withdrawAmount + 0.5f, balance) > 0) {
            System.out.println(df.format(balance));
        }
        else {
            System.out.println(df.format(balance - withdrawAmount - 0.5f));
        }
    }

}
