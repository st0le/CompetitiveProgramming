package org.exor.SPOJ.UCI2009B;

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

	private int[][] table;
	private int[] primes;

	public void solve() throws Exception {
		startTime = System.currentTimeMillis();
		init();
		primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41,
				43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103, 107,
				109, 113, 127, 131, 137, 139, 149, 151, 157, 163, 167, 173,
				179, 181, 191, 193, 197, 199, 211, 223, 227, 229, 233, 239,
				241, 251, 257, 263, 269, 271, 277, 281, 283, 293, 307, 311,
				313, 317, 331, 337, 347, 349, 353, 359, 367, 373, 379, 383,
				389, 397, 401, 409, 419, 421, 431, 433, 439, 443, 449, 457,
				461, 463, 467, 479, 487, 491, 499, 503, 509, 521, 523, 541,
				547, 557, 563, 569, 571, 577, 587, 593, 599, 601, 607, 613,
				617, 619, 631, 641, 643, 647, 653, 659, 661, 673, 677, 683,
				691, 701, 709, 719, 727, 733, 739, 743, 751, 757, 761, 769,
				773, 787, 797, 809, 811, 821, 823, 827, 829, 839, 853, 857,
				859, 863, 877, 881, 883, 887, 907, 911, 919, 929, 937, 941,
				947, 953, 967, 971, 977, 983, 991, 997 };

		int N = 1002;
		table = new int[N][primes.length + 1];
		for (int i = 0; i < N; i++) {
			for (int pi = 0, l = primes.length; pi < l; pi++) {
				int n = i;
				int prime = primes[pi];
				int c = 0;
				while (n > 0) {
					n /= prime;
					c += n;
				}
				table[i][pi] = c;
			}
		}

		for (int testCase = 0, T = nextInt(); testCase < T; testCase++) {
			out.println(binomialForm(nextInt()));
		}
		// ----- solution ends here -----
		// printRuntimeInfo();
		out.flush();
	}

	private String binomialForm(int n) {
		if (n == 0)
			return "1";
		StringBuilder sb = new StringBuilder(10000);
		for (int i = 0; i <= n; i++) {
			if (sb.length() > 0)
				sb.append('+');
			String coeff = primeFactorisation(n, i);
			if (coeff != null)
				sb.append(coeff);
			int powa = n - i, powb = i;
			if (powa > 0) {
				sb.append('A');
				if (powa > 1)
					sb.append('^').append(powa);
			}
			if (powb > 0) {
				sb.append('B');
				if (powb > 1)
					sb.append('^').append(powb);
			}
		}

		return sb.toString();
	}

	private String primeFactorisation(int n, int r) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0, l = primes.length; i < l; i++) {
			int j = Math.abs(table[n][i] - table[r][i] - table[n - r][i]);
			if (j > 0) {
				sb.append(primes[i]);
				if (j > 1)
					sb.append('^').append(j);
				if (sb.length() > 0)
					sb.append('x');
			}
		}
		return sb.toString();
	}

	private final int BUFFER_SIZE = 5 * 1024 * 1024;
	private StreamInputReader scan;
	private PrintWriter out;
	private long startTime;

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

	private void printRuntimeInfo() {
		Runtime runtime = Runtime.getRuntime();
		out.println(String.format("Total Memory : %d", runtime.totalMemory()));
		out.println(String.format("Free Memory : %d", runtime.freeMemory()));
		out.println(String.format("Max Memory : %d", runtime.maxMemory()));
		out.println(String.format("Time Elapsed : %.3f sec",
				(System.currentTimeMillis() - startTime) / 1e3));
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
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-' || c == '+') {
				sgn = (c == '-') ? -1 : 1;
				c = read();
			}
			int res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public long readLong() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-' || c == '+') {
				sgn = (c == '-') ? -1 : 1;
				c = read();
			}
			long res = 0;
			do {
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));
			return res.toString();
		}

		private boolean isSpaceChar(int c) {
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		private String readLine0() {
			StringBuilder buf = new StringBuilder();
			int c = read();
			if (c == -1)
				return null;
			while (c != '\n' && c != -1) {
				if (c != '\r')
					buf.appendCodePoint(c);
				c = read();
			}
			return buf.toString();
		}

		public String readLine() {
			String s = readLine0();
			while (s != null && s.trim().length() == 0)
				s = readLine0();
			return s;
		}

		public String readLine(boolean ignoreEmptyLines) {
			if (ignoreEmptyLines)
				return readLine();
			else
				return readLine0();
		}

		public BigInteger readBigInteger() {
			try {
				return new BigInteger(readString());
			} catch (NumberFormatException e) {
				throw new InputMismatchException();
			}
		}

		public char readCharacter() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			return (char) c;
		}

		public double readDouble() {
			int c = read();
			while (isSpaceChar(c))
				c = read();
			int sgn = 1;
			if (c == '-' || c == '+') {
				sgn = (c == '-') ? -1 : 1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E')
					return res * Math.pow(10, readInt());
				if (c < '0' || c > '9')
					throw new InputMismatchException();
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E')
						return res * Math.pow(10, readInt());
					if (c < '0' || c > '9')
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
			for (int i = 0; i < size; i++)
				array[i] = readInt();
			return array;
		}

		public long[] readLongArray(int size) {
			long[] array = new long[size];
			for (int i = 0; i < size; i++)
				array[i] = readLong();
			return array;
		}

		public double[] readDoubleArray(int size) {
			double[] array = new double[size];
			for (int i = 0; i < size; i++)
				array[i] = readDouble();
			return array;
		}

		public String[] readStringArray(int size) {
			String[] array = new String[size];
			for (int i = 0; i < size; i++)
				array[i] = readString();
			return array;
		}

		public char[][] readTable(int rowCount, int columnCount) {
			char[][] table = new char[rowCount][columnCount];
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < columnCount; j++)
					table[i][j] = readCharacter();
			}
			return table;
		}

		public void readIntArrays(int[]... arrays) {
			for (int i = 0; i < arrays[0].length; i++) {
				for (int j = 0; j < arrays.length; j++)
					arrays[j][i] = readInt();
			}
		}
	}

	private class StreamInputReader extends InputReader {
		private FileChannel channel;
		private byte[] buf = new byte[BUFFER_SIZE];
		private ByteBuffer bb = ByteBuffer.wrap(buf);
		private int curChar, numChars;

		public StreamInputReader(java.io.InputStream stream) {
			this.channel = getFileInputStream(stream).getChannel();
		}

		private FileInputStream getFileInputStream(InputStream in) {
			try {
				if (in instanceof BufferedInputStream) {
					Field field = in.getClass().getSuperclass()
							.getDeclaredField("in");
					field.setAccessible(true);
					return (FileInputStream) field.get(in);
				}
			} catch (Throwable e) {
				e.printStackTrace();
			}
			return (FileInputStream) in;
		}

		public int read() {
			if (numChars == -1)
				return -1;
			if (curChar >= numChars) {
				curChar = 0;
				try {
					bb.clear();
					numChars = channel.read(bb);
				} catch (IOException e) {
					throw new InputMismatchException();
				}
				if (numChars <= 0)
					return -1;
			}
			return buf[curChar++];
		}
	}

}
