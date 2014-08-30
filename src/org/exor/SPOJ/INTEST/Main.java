package org.exor.SPOJ.INTEST;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

public class Main {
    class Reader {
        private static final int BUFSIZE = 1024 * 1024;
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

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        Reader r = new Reader(System.in);
        int c = 0;
        for(int testCase = 0, T = r.readInt(), k = r.readInt(); testCase < T; testCase++) {
            if(r.readInt() % k == 0)
                c++;
        }
        out.println(c);
        // ----- solution ends here -----
        out.flush();
    }

    private PrintWriter out;

    public void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    private void init() {
        out = new PrintWriter(new BufferedOutputStream(System.out));
    }

}
