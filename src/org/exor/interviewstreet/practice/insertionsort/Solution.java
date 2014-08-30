package org.exor.interviewstreet.practice.insertionsort;

import java.util.Scanner;

public class Solution {

	private int[] arr, aux;

	public static void main(String[] args) throws Exception {
		new Solution().solve(
				//new Scanner(new File("C:\\Users\\st0le\\Desktop\\test.txt"))
		new Scanner(System.in)
				);
	}

	public void solve(Scanner scan) {
		arr = new int[100000 + 1];
		aux = new int[100000 + 1];
		for (int T = scan.nextInt(); T-- > 0;) {
			int N = scan.nextInt();
			for (int i = 0; i < N; i++)
				arr[i] = scan.nextInt();
			System.out.println(countInversions(0, N / 2, N));
		}
	}

	public long brute(int N) {
		long c = 0;
		for (int i = 0; i < N; i++) {
			for (int j = i + 1; j < N; j++)
				if (arr[i] > arr[j])
					c++;
		}
		return c;
	}

	private long countInversions(int lb, int mid, int ub) {
		if (lb >= ub - 1)
			return 0;

		long c = countInversions(lb, (lb + mid) / 2, mid)
				+ countInversions(mid, (mid + ub) / 2, ub);
		int k = 0, i = lb, j = mid;
		while (i < mid && j < ub) {
			if (arr[i] <= arr[j])
				aux[k++] = arr[i++];
			else {
				aux[k++] = arr[j++];
				c += mid - i;
			}
		}
		while (i < mid)
			aux[k++] = arr[i++];
		while (j < ub)
			aux[k++] = arr[j++];
		System.arraycopy(aux, 0, arr, lb, (ub - lb));
		return c;
	}
}
