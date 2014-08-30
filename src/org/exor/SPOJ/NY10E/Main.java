package org.exor.SPOJ.NY10E;

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
		// Choose(index,9)
		long[] table = new long[] { 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 10, 55, 220,
				715, 2002, 5005, 11440, 24310, 48620, 92378, 167960, 293930,
				497420, 817190, 1307504, 2042975, 3124550, 4686825, 6906900,
				10015005, 14307150, 20160075, 28048800, 38567100, 52451256,
				70607460, 94143280, 124403620, 163011640, 211915132, 273438880,
				350343565, 445891810, 563921995, 708930508, 886163135,
				1101716330, 1362649145, 1677106640, 2054455634, 2505433700L,
				3042312350L, 3679075400L, 4431613550L, 5317936260L,
				6358402050L, 7575968400L, 8996462475L, 10648873950L,
				12565671261L, 14783142660L, 17341763505L, 20286591270L,
				23667689815L, 27540584512L, 31966749880L, 37014131440L,
				42757703560L, 49280065120L, 56672074888L, 65033528560L,
				74473879480L, 85113005120L, 97082021465L, 110524147514L,
				125595622175L, 142466675900L, 161322559475L, 182364632450L,
				205811513765L, 231900297200L, 260887834350L, 293052087900L,
				328693558050L, 368136785016L, 411731930610L, 459856441980L,
				512916800670L, 571350360240L, 635627275767L, 706252528630L };
		for (int testCase = 0, T = nextInt(); testCase < T; testCase++) {
			nextInt();
			out.println(String.format("%d %d", testCase + 1,
					table[nextInt() + 9]));
		}
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
