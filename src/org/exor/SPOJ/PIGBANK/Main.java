package org.exor.SPOJ.PIGBANK;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

    public void solve() throws Exception {
        init();
        // ----- solution starts here -----
        int T = nextInt();
        int[] minAmount = new int[10000 + 1];
        int[] coinAmount = new int[1000 + 1];
        int[] coinWt = new int[1000 + 1];
        for(int testCase = 0; testCase < T; testCase++) {
            int E = nextInt(), F = nextInt();
            Arrays.fill(minAmount, 0, F + 1, Integer.MAX_VALUE / 2);
            int N = nextInt();
            for(int i = 0; i < N; i++) {
                coinAmount[i] = nextInt();
                coinWt[i] = nextInt();
            }
            for(int wt = 0; wt <= F; wt++)
                for(int i = 0; i < N; i++)
                    if(wt - coinWt[i] >= 0)
                        minAmount[wt] = Math.min(minAmount[wt],
                                                 minAmount[wt - coinWt[i]]
                                                         + coinAmount[i]);
            out.println(minAmount[F]);
        }
        // ----- solution ends here -----
        // printRuntimeInfo();
        out.flush();
    }

    private final int BUFFER_SIZE = 5 * 1024 * 1024;
    private StreamInputReader scan;
    private PrintWriter out;

    public void debug(Object... o) {
        System.err.println(Arrays.deepToString(o));
    }

    public static void main(String[] args) throws Exception {
        new Main().solve();
    }

    private void init() {
        scan = new StreamInputReader(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out, BUFFER_SIZE));
    }

    public int nextInt() {
        return scan.readInt();
    }

    public long nextLong() {
        return scan.readLong();
    }

    public double nextDouble() {
        return scan.readDouble();
    }

    public String nextString() {
        return scan.readString();
    }

    public String nextLine() {
        return scan.readLine();
    }

    public String nextLine(boolean ignoreEmpty) {
        return scan.readLine(ignoreEmpty);
    }

    public BigInteger nextBigInteger() {
        return scan.readBigInteger();
    }

    public char nextChar() {
        return scan.readCharacter();
    }

    public int[] nextIntArray(int size) {
        return scan.readIntArray(size);
    }

    public long[] nextLongArray(int size) {
        return scan.readLongArray(size);
    }

    public double[] nextDoubleArray(int size) {
        return scan.readDoubleArray(size);
    }

    public String[] nextStringArray(int size) {
        return scan.readStringArray(size);
    }

    public char[][] nextCharTable(int rowCount, int columnCount) {
        return scan.readTable(rowCount, columnCount);
    }

    public void nextIntArrays(int[]... arrays) {
        scan.readIntArrays(arrays);
    }

    private abstract class InputReader {
        public abstract int read();

        public int readInt() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-' || c == '+') {
                sgn = (c == '-') ? -1 : 1;
                c = read();
            }
            int res = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while(!isSpaceChar(c));
            return res * sgn;
        }

        public long readLong() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-' || c == '+') {
                sgn = (c == '-') ? -1 : 1;
                c = read();
            }
            long res = 0;
            do {
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            while(!isSpaceChar(c));
            return res * sgn;
        }

        public String readString() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            }
            while(!isSpaceChar(c));
            return res.toString();
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private String readLine0() {
            StringBuilder buf = new StringBuilder();
            int c = read();
            while(c != '\n' && c != -1) {
                if(c != '\r')
                    buf.appendCodePoint(c);
                c = read();
            }
            return buf.toString();
        }

        public String readLine() {
            String s = readLine0();
            while(s.trim().length() == 0)
                s = readLine0();
            return s;
        }

        public String readLine(boolean ignoreEmptyLines) {
            if(ignoreEmptyLines)
                return readLine();
            else
                return readLine0();
        }

        public BigInteger readBigInteger() {
            try {
                return new BigInteger(readString());
            }
            catch(NumberFormatException e) {
                throw new InputMismatchException();
            }
        }

        public char readCharacter() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            return (char)c;
        }

        public double readDouble() {
            int c = read();
            while(isSpaceChar(c))
                c = read();
            int sgn = 1;
            if(c == '-' || c == '+') {
                sgn = (c == '-') ? -1 : 1;
                c = read();
            }
            double res = 0;
            while(!isSpaceChar(c) && c != '.') {
                if(c == 'e' || c == 'E')
                    return res * Math.pow(10, readInt());
                if(c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            }
            if(c == '.') {
                c = read();
                double m = 1;
                while(!isSpaceChar(c)) {
                    if(c == 'e' || c == 'E')
                        return res * Math.pow(10, readInt());
                    if(c < '0' || c > '9')
                        throw new InputMismatchException();
                    m /= 10;
                    res += (c - '0') * m;
                    c = read();
                }
            }
            return res * sgn;
        }

        public int[] readIntArray(int size) {
            int[] array = new int[size];
            for(int i = 0; i < size; i++)
                array[i] = readInt();
            return array;
        }

        public long[] readLongArray(int size) {
            long[] array = new long[size];
            for(int i = 0; i < size; i++)
                array[i] = readLong();
            return array;
        }

        public double[] readDoubleArray(int size) {
            double[] array = new double[size];
            for(int i = 0; i < size; i++)
                array[i] = readDouble();
            return array;
        }

        public String[] readStringArray(int size) {
            String[] array = new String[size];
            for(int i = 0; i < size; i++)
                array[i] = readString();
            return array;
        }

        public char[][] readTable(int rowCount, int columnCount) {
            char[][] table = new char[rowCount][columnCount];
            for(int i = 0; i < rowCount; i++) {
                for(int j = 0; j < columnCount; j++)
                    table[i][j] = readCharacter();
            }
            return table;
        }

        public void readIntArrays(int[]... arrays) {
            for(int i = 0; i < arrays[0].length; i++) {
                for(int j = 0; j < arrays.length; j++)
                    arrays[j][i] = readInt();
            }
        }
    }

    private class StreamInputReader extends InputReader {
        private final FileChannel channel;
        private final byte[] buf = new byte[BUFFER_SIZE];
        private final ByteBuffer bb = ByteBuffer.wrap(buf);
        private int curChar, numChars;

        public StreamInputReader(java.io.InputStream stream) {
            this.channel = getFileInputStream(stream).getChannel();
        }

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

        @Override
        public int read() {
            if(numChars == -1)
                throw new InputMismatchException();
            if(curChar >= numChars) {
                curChar = 0;
                try {
                    bb.clear();
                    numChars = channel.read(bb);
                }
                catch(IOException e) {
                    throw new InputMismatchException();
                }
                if(numChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }
    }

}
