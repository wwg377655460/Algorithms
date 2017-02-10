package Sort;

/**
 * Created by wsdevotion on 2017/2/9.
 */
public class HeapSort {

    public static Integer[] heapSort1(Integer[] arr, int n) {

        MaxHeap maxHeap = new MaxHeap(n);
        for (int i = 0; i < n; i++)
            maxHeap.insert(arr[i]);

        for (int i = n - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
        return arr;

    }

    /**
     * 改进
     * 将n个元素逐个插入到一个空堆中，算法复杂度nlogn
     * heapify的过程，算法复杂度n
     *
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] heapSort2(Integer[] arr, int n) {

        MaxHeap maxHeap = new MaxHeap(arr, n);

        for (int i = n - 1; i >= 0; i--)
            arr[i] = maxHeap.extractMax();
        return arr;

    }

    //计数0开始
    public static Integer[] heapSort(Integer[] arr, int n) {

        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for (int i=n-1; i>0; i--) {
            Main.swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }
        return arr;

    }

    //计数0开始
    private static void shiftDown(Integer[] arr, int n, int k) {

        while (2 * k + 1 < n) {
            //判断有没有右孩子
            int j = 2 * k + 1;
            if (j + 1 < n && arr[j + 1] > arr[j])
                j += 1;
            if (arr[k] >= arr[j])
                break;

            Main.swap(arr, k, j);
            k = j;
        }
    }


}
