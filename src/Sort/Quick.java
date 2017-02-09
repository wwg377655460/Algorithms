package Sort;

import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Quick {

    private static Random random = new Random();

    /**
     * 快速排序
     * 在近乎有序的数组进行排序是发生内存溢出
     * 分析:快速排序需要找到一个partition，子数组可能一大一小，近乎有序的数据，产生的递归树可能非常高
     *
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] quickSort(Integer[] arr, int n) {
        quickSort_stack(arr, 0, n - 1);
        return arr;
    }

    public static Integer[] quickSort_change(Integer[] arr, int n) {
        quickSort_stack_change(arr, 0, n - 1);
        return arr;
    }

    /**
     * 双路快排
     * 在多种测试用例排序都有很好的效率
     * @param arr
     * @param n
     * @return
     */
    public static Integer[] quickSort2(Integer[] arr, int n) {
        quickSort_stack2(arr, 0, n - 1);
        return arr;
    }

    private static void quickSort_stack2(Integer[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition2(arr, l, r);
        quickSort_stack2(arr, l, p - 1);
        quickSort_stack2(arr, p + 1, r);
    }

    private static int partition2(Integer[] arr, int l, int r) {
        //partition选择随机

        Main.swap(arr, l, random.nextInt(r - l + 1) + l);//交换到最左侧

        Integer v = arr[l];
        //arr[l+1...i) <= v && arr(j...r] > v
        int i = l + 1, j = r;
        while (true) {
            while (i <= r && arr[i] < v)
                i++;
            while (j >= l + 1 && arr[j] > v)
                j--;
            if (i > j)
                break;
            Main.swap(arr, i, j);
            i++;
            j--;
        }
        Main.swap(arr, l, j);

        return j;
    }


    private static void quickSort_stack_change(Integer[] arr, int l, int r) {

//        if (l >= r)
//            return;
        //数组小时用归并排序
        if (r - l <= 15) {
            Insert.InsertSort_change(arr, l, r);
            return;
        }

        int p = partition_change(arr, l, r);
        quickSort_stack_change(arr, l, p - 1);
        quickSort_stack_change(arr, p + 1, r);
    }

    /**
     * 对arr[l...r]第一个元素e进行一次排序，让元素左侧的元素都比它小，右侧都比它大
     * partition选择随机，可以在近乎有序的数组排序有好的效率，但是在重复值多的数组时还是用时过长
     *
     * @param arr
     * @param l
     * @param r
     * @return e元素的位置
     */
    private static int partition_change(Integer[] arr, int l, int r) {
        //partition选择随机

        Main.swap(arr, l, random.nextInt(r - l + 1) + l);//交换到最左侧

        Integer v = arr[l];
        //arr[l+1...j] < v && arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                arr = Main.swap(arr, j + 1, i);
                j++;
            }
        }

        Main.swap(arr, l, j);
        return j;
    }


    private static void quickSort_stack(Integer[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        quickSort_stack(arr, l, p - 1);
        quickSort_stack(arr, p + 1, r);
    }

    /**
     * 对arr[l...r]第一个元素e进行一次排序，让元素左侧的元素都比它小，右侧都比它大
     *
     * @param arr
     * @param l
     * @param r
     * @return e元素的位置
     */
    private static int partition(Integer[] arr, int l, int r) {
        Integer v = arr[l];
        //arr[l+1...j] < v && arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                arr = Main.swap(arr, j + 1, i);
                j++;
            }
        }

        Main.swap(arr, l, j);
        return j;
    }
}
