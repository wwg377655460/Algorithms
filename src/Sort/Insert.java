package Sort;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Insert {

    /**
     * 插入排序
     * 插入排序可以在第二层循环提前结束
     * @param arr
     * @param n
     */
    public static Integer [] InsertSort(Integer arr [], int n) {
        for (int i=1; i<n; i++) {
            //寻找第i个元素合适的插入位置，>0和前一个元素的位置比较，最后一个比较的位置是j=1的位置，判断是否交换
            for (int j=i; j>0 && arr[j] < arr[j-1]; j--) {
                    arr = Main.swap(arr, j, j-1);
            }
        }
        return arr;
    }

    /**
     * 插入排序改进
     * 交换数组的元素耗时很大，我们将元素i赋值一份，与前面的元素进行判断，如果满足条件（arr[i] < arr[i-1]）前面的元素就占据元素j原来的位置
     * 如果不满足条件，就将元素放在当前判断的位置,结束本次循环
     * 插入排序可以在第二层循环提前结束
     * 插入排序在本身近似有序时速度甚至优于nlogn的算法
     * @param arr
     * @param n
     */
    public static Integer [] InsertSort_change(Integer arr [], int n) {
        for (int i=1; i<n; i++) {
            Integer e = arr[i];
            int j; //保存元素e应该插入的位置
            for (j=i; j>0 && arr[j-1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
        return arr;
    }

    //对arr[l..r]进行排序
    public static void InsertSort_change(Integer arr [], int l, int r) {
        for (int i=l+1; i<=r; i++) {
            Integer e = arr[i];
            int j; //保存元素e应该插入的位置
            for (j=i; j>l && arr[j-1] > e; j--) {
                arr[j] = arr[j-1];
            }
            arr[j] = e;
        }
    }
}
