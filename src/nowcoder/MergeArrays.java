package nowcoder;

import java.util.Arrays;

/**
 * @author lvyue
 * @since 2021/1/21
 */
public class MergeArrays {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {6, 7, 8};
        System.arraycopy(b, 0, a, 2, 2);
        for (int i = 0; i< a.length; i++) {
            System.out.println(a[i]);
        }



//        int[] A = {};
//        int[] B = {1};
//        int m = 0;
//        int n = 1;
//        merge(A, m, B, n);

    }

    public static void merge(int[] A, int m, int[] B, int n) {
        int[] c = new int[m + n];
        if (m > 0) {
            System.arraycopy(A, 0, c, 0, m);
        }
        if (n > 0) {
            System.arraycopy(B, 0, c, m, n);
        }

        Arrays.sort(c);
        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }
    }

    public static void merge2(int[] A, int m, int[] B, int n) {
    }
}
