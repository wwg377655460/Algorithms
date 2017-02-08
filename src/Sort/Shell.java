package Sort;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Shell {

    /**
     * 希尔排序
     *
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] shellSort(Integer arr[], int n) {
        int h = 1;
        while (h < n / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            //插入排序
            for (int i = h; i < n; i++) {
                Integer e = arr[i];
                int j;
                for (j = i; j >= h && arr[j-h] > e; j -= h)
                    arr[j] = arr[j-h];
                arr[j] = e;
            }

            h /= 3;
        }
        return arr;
    }
}
