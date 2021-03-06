package org.exor.SPOJ.SUMFOUR;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.InputMismatchException;

public class Main {

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		int N = nextInt();
		int[] a = new int[N];
		int[] b = new int[N];
		int[] c = new int[N];
		int[] d = new int[N];
		int[] f = new int[N * N];
		int[] s = new int[N * N];
		for (int i = 0; i < N; i++) {
			a[i] = nextInt();
			b[i] = nextInt();
			c[i] = nextInt();
			d[i] = nextInt();
		}
		for (int i = 0, k = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				f[k] = a[i] + b[j];
				s[k] = c[i] + d[j];
				k++;
			}
		}
		int len = N * N;
		Arrays.sort(f);
		Arrays.sort(s);
		int l = 0, r = len - 1, count = 0;
		while (l < len && r >= 0) {
			int q = f[l] + s[r];
			if (q < 0)
				l++;
			else if (q > 0)
				r--;
			else { // zero sum? nice!
				int x = l+1, y = r-1;
				while (x < len && f[l] == f[x])
					x++;
				while (y >= 0 && s[r] == s[y])
					y--;
				count += (x - l) * (r - y);
				l = x; r = y;
			}
		}
		out.println(count);

		// ----- solution ends here -----
		out.flush();
	}

	private final int BUFFER_SIZE = 15 * 1024 * 1024;
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
		out = new PrintWriter(new BufferedOutputStream(System.out));
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

	public int nextChar() {
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
			if (c == '-') {
				sgn = -1;
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
			if (c == '-') {
				sgn = -1;
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
			while (c != '\n' && c != -1) {
				if (c != '\r')
					buf.appendCodePoint(c);
				c = read();
			}
			return buf.toString();
		}

		public String readLine() {
			String s = readLine0();
			while (s.trim().length() == 0)
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
			if (c == '-') {
				sgn = -1;
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
		private java.io.InputStream stream;
		private byte[] buf = new byte[BUFFER_SIZE];
		private int curChar, numChars;

		public StreamInputReader(java.io.InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1)
				throw new InputMismatchException();
			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
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
