package org.exor.SPOJ.CRYPTO1;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.StringTokenizer;
import java.util.TimeZone;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        BigInteger modPrime = BigInteger.valueOf(4000000007L);
        BigInteger k1 = BigInteger.valueOf(1000000002L); // (modPrime-3)/4 + 1
        BigInteger ak1 = modPrime.subtract(nextBigInteger().modPow(k1, modPrime));
        SimpleDateFormat sdf = new SimpleDateFormat("E MMM d HH:mm:ss yyyy");
        Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        int offset = TimeZone.getDefault().getOffset(ak1.longValue() * 1000);
        c.setTimeInMillis(ak1.longValue() * 1000 - offset);
        System.out.println(sdf.format(c.getTime()));

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
