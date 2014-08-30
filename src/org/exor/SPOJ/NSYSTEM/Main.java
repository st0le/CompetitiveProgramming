package org.exor.SPOJ.NSYSTEM;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	private String encodeMCXI(int n) {
		StringBuilder sb = new StringBuilder();
		if (n >= 2000)
			sb.append(n / 1000);
		if (n >= 1000)
			sb.append('m');
		n %= 1000;
		if (n >= 200)
			sb.append(n / 100);
		if (n >= 100)
			sb.append('c');
		n %= 100;
		if (n >= 20)
			sb.append(n / 10);
		if (n >= 10)
			sb.append('x');
		n %= 10;
		if (n >= 2)
			sb.append(n);
		if (n >= 1)
			sb.append('i');
		return sb.toString();

	}

	private int decodeMCXI(String text) {
		int s = 0, n = 1;
		for (int i = 0, l = text.length(); i < l; i++) {
			char c = text.charAt(i);
			if (Character.isLetter(c)) {
				switch (c) {
				case 'm':
					n *= 1000;
					break;
				case 'c':
					n *= 100;
					break;
				case 'x':
					n *= 10;
					break;
				case 'i':
					n *= 1;
					break;
				default:
					break;
				}
				s += n;
				n = 1;
			} else
				n = c - '0';
		}
		return s;
	}

	public void solve() throws Exception {
		init();
		// ----- solution starts here -----
		for (int testCase = 0, T = nextInt(); testCase < T; testCase++) {
			out.println(encodeMCXI(decodeMCXI(nextToken())+decodeMCXI(nextToken())));
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
