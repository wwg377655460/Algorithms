package Sort;

import java.time.Clock;
import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Main {

    //函数时间测试
    private static long start;
    private static long end;

    public static void main(String [] args) {
        //数组中元素的个数
        int n = 10000;
        //随机
        Integer arr [] = generateRandomArray(n, 0, n);
        //产生近乎有序的数组
//        Integer arr [] = Utils.generateNearlyOrderedArray(n, 10);
        //深拷贝
        Integer [] arr_new = copyIntArray(arr);
        //深拷贝2
        Integer [] arr_new_change = copyIntArray(arr);

        //选择排序
//        printArray(arr, n, "原数组:");
//        testSort("selectionSort", true, arr, n);
//        arr = Selection.selectionSort(arr, n);
//        testSort("selectionSort", false, arr, n);
//        printArray(arr, n, "排序后:");

        //插入排序
//        printArray(arr_new, n, "原数组:");
        testSort("InsertSort", true, arr_new, n);
        arr_new = Insert.InsertSort(arr_new, n);
        testSort("InsertSort", false, arr_new, n);
//        printArray(arr_new, n, "排序后:");

        //插入排序改进
//        printArray(arr_new_change, n, "原数组:");
        testSort("InsertSort_change", true, arr_new_change, n);
        arr_new_change = Insert.InsertSort(arr_new_change, n);
        testSort("InsertSort_change", false, arr_new_change, n);
//        printArray(arr_new_change, n, "排序后:");

        //冒泡排序改进
//        testSort("bubbleSort", true, arr_new_change, n);
//        arr_new_change = Bubble.bubbleSort(arr_new_change, n);
//        testSort("bubbleSort", false, arr_new_change, n);

        //冒泡排序改进
//        testSort("bubbleSort_change", true, arr, n);
//        arr = Bubble.bubbleSort_change(arr, n);
//        testSort("bubbleSort_change", false, arr, n);

        //希尔排序
        testSort("shellSort", true, arr, n);
        arr = Shell.shellSort(arr, n);
        testSort("shellSort", false, arr, n);

    }

    /***
     * 测试用例的生成
     * @param n 数组元素个数
     * @param rangeL 起始位置（[rangeL, rangeR]）
     * @param rangeR 结束位置
     * @return
     */
    public static Integer [] generateRandomArray(int n, int rangeL, int rangeR) {
        //判断是否满足条件
        assert rangeL <= rangeR;
        Integer [] arr = new Integer[n];
        Random random = new Random();
        for (int i=0; i<arr.length; i++) {
            arr[i] = random.nextInt(rangeR) % (rangeR - rangeL + 1) + rangeL;
        }
        return arr;
    }

    /***
     * 打印数组
     * @param arr 数组对象
     * @param n 数组个数
     * @param str 打印前面的字符
     * @param <T>
     */
    public static <T> void printArray(T [] arr, int n, String str){
        for (int i=0; i<n; i++)
            System.out.print(str + " " + arr[i] + " ");
        System.out.println();
    }

    /**
     * 测试函数的执行时间
     * @param sortName 函数的名称
     * @param flag true时开始执行，false时结束执行
     */
    public static void testSort(String sortName, boolean flag, Integer arr [], int n) {
        if (flag) {
            start = System.currentTimeMillis();
        } else {
            end = System.currentTimeMillis();
            //打印时间
            System.out.println("测试" + sortName + "函数用时:" + (end - start) + "毫秒");
            //判断数组排序正确性
            if (isSorted(arr, n))
                System.out.println("数组排序正确");
            else
                System.out.println("数组排序错误");
        }
    }


    /**
     * 判断排序是否正确，从小到大
     * @param arr
     * @param n
     * @return
     */
    public static boolean isSorted(Integer arr[], int n) {
        for (int i=0; i<n-1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }

    /**
     * 交换数组的元素
     * @param arr
     * @param i
     * @param minIndex
     * @return
     */
    public static Integer[] swap(Integer[] arr, int i, int minIndex) {
        Integer f = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = f;
        return arr;
    }

    public static Integer [] copyIntArray(Integer arr []) {
        Integer[] arr_new = new Integer[arr.length];
        System.arraycopy(arr, 0, arr_new, 0, arr.length);
        return arr_new;
    }
}
