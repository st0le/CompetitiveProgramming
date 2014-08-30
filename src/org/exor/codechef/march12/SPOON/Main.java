package org.exor.codechef.march12.SPOON;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		char[][] mtx = new char[101][];
		for (int testCase = 0, T = nextInt(); testCase < T; testCase++) {
			int R = nextInt(), C = nextInt();
			for (int i = 0; i < R; i++)
				mtx[i] = nextToken().toLowerCase().toCharArray();

			boolean found = false;
			final char[] needle = "spoon".toCharArray();
			for (int i = 0; !found && i < R; i++)
				for (int j = 0; !found && j < C; j++)
					if (mtx[i][j] == 's')
						found = found || searchRowCol(mtx, i, j,R,C, needle);

			out.println(found ? "There is a spoon!"
					: "There is indeed no spoon!");

		}
		// ----- solution ends here -----
		out.flush();
	}

	private boolean searchRowCol(char[][] mtx, int i, int j,int R,int C ,char[] needle) {
		int rowMatch = 0, colMatch = 0;
		for (int index = 0, len = needle.length; index < len; index++) {
			if (index + i < R && mtx[index + i][j] == needle[index])
				rowMatch++;
			if (index + j < C && mtx[i][j + index] == needle[index])
				colMatch++;
		}
		return rowMatch == needle.length || colMatch == needle.length;
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
		if (st == null || !st.hasMoreTokens()) {
			String line = null;
			while ((line = scan.readLine()) != null) {
				if (line.length() > 0)
					break;
			}
			if (line == null)
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
