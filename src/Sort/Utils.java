package Sort;

import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Utils {

    /**
     * 生成一个近乎有序的数组
     * @param n 数组个数
     * @param swapTimes 有序数组交换次数
     * @return
     */
    public static Integer [] generateNearlyOrderedArray(int n, int swapTimes) {
        System.out.println("测试用例为近乎有序的数组，长度：" + n + " swapTimes=" + swapTimes);

        Integer [] arr = new Integer[n];
        for (int i=0; i<n; i++)
            arr[i] = i;

        Random random = new Random();
        for (int i=0; i<swapTimes; i++) {
            int posx = random.nextInt(n);
            int posy = random.nextInt(n);
            Main.swap(arr, posx, posy);
        }
        return arr;
    }
}
