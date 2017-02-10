package Sort;

import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/9.
 */
public class MaxNum {

    private static Random random = new Random();

    /**
     * 求数组中第num大元素
     * 算法复杂度n
     * n + n/2 + n/4 + n/8 + ... + 1 = 2n
     * @param arr
     * @param n 数组长度
     * @param num 第num大元素
     */
    public static void maxNum(Integer [] arr, int n, int num) {
        quickSort(arr, 0, n-1, num-1);
    }

    private static void quickSort(Integer [] arr, int l, int r, int num) {
        if (l == r) {
            System.out.println("找到第" + (num+1) + "大的元素：" + arr[l]);
            return;
        }
        //partition
        Main.swap(arr, l, random.nextInt(r - l + 1) + l);//交换到最左侧
        Integer v = arr[l];

        int j = l;
        for (int i=l+1; i<=r; i++) {
            if (arr[i] < v) {
                Main.swap(arr, i, j+1);
                j++;
            }
        }
        Main.swap(arr, l, j);
        if (j == num) {
            System.out.println("找到第" + (num+1) + "大的元素：" + v);
            return;
        }else if (j < num){
            quickSort(arr, j + 1, r, num);
        } else {
            quickSort(arr, l, j - 1, num);
        }


    }
}
