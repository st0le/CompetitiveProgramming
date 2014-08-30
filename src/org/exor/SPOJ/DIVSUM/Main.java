package org.exor.SPOJ.DIVSUM;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        Reader r = new Reader(System.in);
        final int N = 500000;
        long[] divsum = new long[N + 1];
        divsum[1] = -1;
        for(int i = 2; i <= N; i++)
            for(int j = 2 * i; j <= N; j += i)
                divsum[j] += i;
        int T = r.readInt();
        PrintStream out = new PrintStream(new BufferedOutputStream(System.out));
        while(T-- > 0)
            out.println(divsum[r.readInt()] + 1);
        out.flush();
    }

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
        scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
    }

    class Reader {
        private static final int BUFSIZE = 0x10000;
        private final byte[] buffer = new byte[BUFSIZE];
        private final ByteBuffer bb = ByteBuffer.wrap(buffer);
        private final FileChannel channel;

        int bufSize = -1; // non empty buffer
        int bufOffset = 0; // non valid buffer

        private FileInputStream getFileInputStream(InputStream in) {
            try {
                if(in instanceof BufferedInputStream) {
                    Field field = in.getClass()
                                    .getSuperclass()
                                    .getDeclaredField("in");
                    field.setAccessible(true);
                    return (FileInputStream)field.get(in);
                }
            }
            catch(Throwable e) {
                e.printStackTrace();
            }
            return (FileInputStream)in;
        }

        Reader(InputStream in) throws IOException {
            this.channel = this.getFileInputStream(in).getChannel();
        }

        void fetchBuffer() throws IOException {
            bb.clear();
            bufSize = channel.read(bb);
            bufOffset = 0;
        }

        boolean isFinished() {
            return bufSize <= 0;
        }

        private int peek() throws IOException {
            if(bufOffset < bufSize)
                return buffer[bufOffset];
            fetchBuffer();
            if(bufSize > 0)
                return buffer[0];
            return -1;
        }

        private void skipSpace() throws IOException {
            int v = peek();
            while(v <= ' ' && v != -1) {
                bufOffset++;
                v = peek();
            }
        }

        void nextLine() throws IOException {
            int v = peek();
            while(v != -1 && v != '\n' && v != '\r') {
                bufOffset++;
                v = peek();
            }
            if(v == '\r') {
                bufOffset++;
                v = peek();
                if(v == '\n')
                    bufOffset++;
            }
            else if(v == '\n') {
                bufOffset++;
                v = peek();
                if(v == '\r')
                    bufOffset++;
            }
        }

        int readInt() throws IOException {
            skipSpace();
            int result = 0;
            int v = peek();
            while(v > ' ') {
                result = result * 10 + v - '0';
                bufOffset++;
                v = peek();
            }
            return result;
        }
    }
}
