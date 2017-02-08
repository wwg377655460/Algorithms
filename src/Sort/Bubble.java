package Sort;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Bubble {

    /***
     * 冒泡排序
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] bubbleSort(Integer arr[], int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] > arr[j])
                    arr = Main.swap(arr, i, j);
            }
        }
        return arr;
    }

    /***
     * 冒泡排序改进
     * 在数组数大的时候速度有改进
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] bubbleSort_change(Integer arr[], int n) {
        boolean flag = true;
        while(flag) {
            for (int i = 0; i < n; i++) {
                flag = false;
                for (int j = i + 1; j < n; j++) {
                    if (arr[i] > arr[j]) {
                        arr = Main.swap(arr, i, j);
                        flag = true;
                    }
                }
            }
        }
        return arr;
    }
}
