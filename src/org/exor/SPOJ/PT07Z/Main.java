package org.exor.SPOJ.PT07Z;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    class Reader {
        private static final int BUFSIZE = 0x100000;
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
        int N = r.readInt();
        int[][] arr = new int[N + 1][N + 1];
        int[] cnt = new int[N + 1];
        for(int i = 0; i < N - 1; i++) {
            int u = r.readInt();
            int v = r.readInt();
            arr[u][cnt[u]++] = v;
            arr[v][cnt[v]++] = u;
        }
        int startNode = 1;
        for(int i = 2; i <= N; i++)
            if(cnt[startNode] > cnt[i])
                startNode = i;
        boolean[] visited = new boolean[N + 1];
        int[] queue = new int[N + 1];
        int[] d = new int[N + 1];
        int tail = 0, head = 0;
        queue[tail++] = startNode;
        d[startNode] = 0;
        int maxNode = startNode;
        while(head <= tail) {
            int u = queue[head++];
            if(!visited[u]) {
                visited[u] = true;
                for(int i = 0; i < cnt[u]; i++) {
                    int v = arr[u][i];
                    if(!visited[v]) {
                        queue[tail++] = v;
                        d[v] = d[u] + 1;
                        if(d[v] > d[maxNode])
                            maxNode = v;
                    }
                }
            }
        }
        // dfs again.
        Arrays.fill(visited, false);
        Arrays.fill(d, 0);
        head = tail = 0;
        queue[tail++] = maxNode;
        d[maxNode] = 0;
        while(head <= tail) {
            int u = queue[head++];
            if(!visited[u]) {
                visited[u] = true;
                for(int i = 0; i < cnt[u]; i++) {
                    int v = arr[u][i];
                    if(!visited[v]) {
                        queue[tail++] = v;
                        d[v] = d[u] + 1;
                        if(d[v] > d[maxNode])
                            maxNode = v;
                    }
                }
            }
        }
        out.println(d[maxNode]);
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
        scan = new BufferedReader(new InputStreamReader(System.in), 500 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out, 500 * 1024));
    }

}
