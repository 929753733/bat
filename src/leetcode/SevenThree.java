package leetcode;

import java.util.ArrayList;
import java.util.List;

public class SevenThree {

    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        int length1 = matrix.length;
        int length2 = 0;
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        for (int i = 0; i < length1; i++) {
            int[] a = matrix[i];
            length2 = a.length;
            for (int j = 0; j < length2; j++) {
                int b = a[j];
                if (0 == b) {
                    list1.add(i);
                    list2.add(j);
                }
            }
        }
        if (list1.size() > 0) {
            for (int x = 0; x < list1.size(); x++) {
                int a = list1.get(x);
                for (int j = 0; j < length2; j++) {
                    matrix[a][j] = 0;
                }
            }
            for (int y = 0; y < list2.size(); y++) {
                int b = list2.get(y);
                for (int i = 0; i < length1; i++) {
                    matrix[i][b] = 0;
                }
            }
        }
    }
}
