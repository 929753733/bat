/**
 * @author lvyue
 * @since 2021/1/27
 */
public class QuickSoreDemo {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {

        }
    }

    private static int getIndex(int[] arr, int low, int high) {
        int tmp = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= tmp) {
                high--;
            }
            arr[low] = arr[high];
            while (low < high && arr[low] <= tmp) {
                low++;
            }
            arr[high] = arr[low];
        }
        return 0;
    }
}
