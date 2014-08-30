package org.exor.SPOJ.ABSYS;

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
		int T = Integer.valueOf(scan.readLine());
		final String m = "machula";
		while (T > 0) {
			String line = scan.readLine();
			if (line == null)
				break;
			if (line.length() == 0)
				continue;
			st = new StringTokenizer(line);
			String a = st.nextToken();
			st.nextToken();
			String b = st.nextToken();
			st.nextToken();
			String c = st.nextToken();
			if (a.indexOf(m) >= 0) {
				a = new BigInteger(c).subtract(new BigInteger(b)).toString();
			} else if (b.indexOf(m) >= 0) {
				b = new BigInteger(c).subtract(new BigInteger(a)).toString();
			} else if (c.indexOf(m) >= 0) {
				c = new BigInteger(a).add(new BigInteger(b)).toString();
			}
			out.println(String.format("%s + %s = %s", a, b, c));
			T--;
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
