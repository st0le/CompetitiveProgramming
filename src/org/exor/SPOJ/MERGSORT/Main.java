package org.exor.SPOJ.MERGSORT;

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
        String[] nums = scan.readLine().split(" ");
        int[] arr = new int[nums.length];
        int i = 0;
        for(String num: nums)
            arr[i++] = Integer.valueOf(num);
        mergeSort(arr);
        StringBuilder sb = new StringBuilder();

        for(i = 0; i < arr.length; i++) {
            if(i > 0)
                sb.append(' ');
            sb.append(arr[i]);
        }
        out.println(sb.toString());
        // ----- solution ends here -----
        out.flush();
    }

    private void mergeSort(int[] arr) {
        mergeSort(arr, 0, arr.length, new int[arr.length]);
    }

    private void mergeSort(int[] arr, int lb, int ub, int[] aux) {
        if(lb + 1 < ub) {
            int mid = (lb + ub) / 2;
            mergeSort(arr, lb, mid, aux);
            mergeSort(arr, mid, ub, aux);
            int i = lb, j = mid, k = 0;
            while(i < mid && j < ub) {
                if(arr[i] < arr[j])
                    aux[k++] = arr[i++];
                else
                    aux[k++] = arr[j++];
            }
            while(i < mid)
                aux[k++] = arr[i++];
            while(j < ub)
                aux[k++] = arr[j++];
            for(i = 0; i < k; i++)
                arr[i + lb] = aux[i];
        }
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
        scan = new BufferedReader(new InputStreamReader(System.in),
                                  5 * 1024 * 1024);
        out = new PrintWriter(new BufferedOutputStream(System.out,
                                                       5 * 1024 * 1024));
    }

}
