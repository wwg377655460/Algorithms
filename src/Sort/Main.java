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
        Integer arr [] = generateRandomArray(n, 0, n);
        testSort("selectionSort", true, arr, n);
        arr = Selection.selectionSort(arr, n);
        testSort("selectionSort", false, arr, n);
        printArray(arr, n);

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
     * @param <T>
     */
    public static <T> void printArray(T [] arr, int n){
        for (int i=0; i<n; i++)
            System.out.print(arr[i] + " ");
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



    public static boolean isSorted(Integer arr[], int n) {
        for (int i=0; i<n-1; i++) {
            if (arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
}
