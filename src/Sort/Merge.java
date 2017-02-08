package Sort;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Merge {

    /***
     * 归并排序
     * 使用空间多
     * 在数组近乎有序时插入排序效率可能高于归并排序
     *
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] mergeSort(Integer[] arr, int n) {
        mergeSortPart(arr, 0, n-1);
        return arr;
    }

    /**
     * 子函数
     * 对arr[l...r]排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void mergeSortPart(Integer[] arr, int l, int r) {

        if (l >= r)
            return;

        //计算中点位置(l+r)有可能溢出，发生错误
        int mid = (l + r) / 2;
        mergeSortPart(arr, l, mid);
        mergeSortPart(arr, mid + 1, r);
        mergeAll(arr, l, mid, r);
    }

    /**
     * 将两个部分归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void mergeAll(Integer[] arr, int l, int mid, int r) {

        //辅助空间
        Integer aux[] = new Integer[r - l + 1];
        for (int i = l; i <= r; i++)
            aux[i - l] = arr[i];

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }


    /***
     * 归并排序优化
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] mergeSort_change(Integer[] arr, int n) {
        mergeSortPart_change(arr, 0, n - 1);
        return arr;
    }

    /**
     * 子函数
     * 对arr[l...r]排序
     *
     * @param arr
     * @param l
     * @param r
     * @return
     */
    private static void mergeSortPart_change(Integer[] arr, int l, int r) {

//        if (l >= r)
//            return;
        //当数组小时使用插入排序,如果要近乎有序效果好
        if (r - l <= 15) {
            Insert.InsertSort_change(arr, l, r);
            return;
        }

        //计算中点位置(l+r)有可能溢出，发生错误
        int mid = (l + r) / 2;
        mergeSortPart_change(arr, l, mid);
        mergeSortPart_change(arr, mid + 1, r);
        //改进：如果arr[mid] <= arr[mid + 1]表示数组本身就是有序的，因为两个子数组有序,对近乎有序的数组效果好
        if (arr[mid] > arr[mid + 1])
            mergeAll_change(arr, l, mid, r);
    }

    /**
     * 将两个部分归并
     *
     * @param arr
     * @param l
     * @param mid
     * @param r
     */
    private static void mergeAll_change(Integer[] arr, int l, int mid, int r) {

        //辅助空间
        Integer aux[] = new Integer[r - l + 1];
        for (int i = l; i <= r; i++)
            aux[i - l] = arr[i];

        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
        }
    }
}
