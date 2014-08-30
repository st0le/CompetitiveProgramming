package org.exor.SPOJ.BITMAP;

import java.util.Random;

public class Testgen {

	public static void main(String[] args) {
		Random r = new Random();
		int testCases = 1, N = 185;
		System.out.println(testCases);
		for (int t = 0; t < testCases; t++) {
			int R = r.nextInt(N) + 1, C = r.nextInt(N) + 1;
			System.out.println(R + " " + C);
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++)
					System.out.print(r.nextBoolean() ? '1' : '0');
				System.out.println();
			}
		}
	}

}
