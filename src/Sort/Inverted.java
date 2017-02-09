package Sort;

/**
 * Created by wsdevotion on 2017/2/9.
 */
public class Inverted {

    //逆序对的数量
    private static int num = 0;

    public static void main(String [] args) {
        Integer arr [] = new Integer[]{5,4,3,2,1};
        invertedNu_Merge(arr, 5);
    }

    /**
     * 用归并排序方法求逆序对
     *  @param arr
     * @param n
     */
    public static Integer[] invertedNu_Merge(Integer arr[], int n) {
        invertedNu_Merge_Sort(arr, 0, n-1);
        System.out.println("逆序数:" + num);
        return arr;
    }

    private static void invertedNu_Merge_Sort(Integer arr[], int l, int r) {

        if (l >= r)
            return;

        int mid = (l + r) / 2;
        invertedNu_Merge_Sort(arr, l, mid);
        invertedNu_Merge_Sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    private static void merge(Integer[] arr, int l, int mid, int r) {
        //复制数组
        Integer arr_new[] = new Integer[r - l + 1];
        for (int i = l; i <= r; i++)
            arr_new[i - l] = arr[i];

        //归并
        int i = l;
        int j = mid + 1;
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = arr_new[j - l];
                j++;
            } else if (j > r) {
                arr[k] = arr_new[i - l];
                i++;
            } else if (arr_new[i - l] <= arr_new[j - l]) {
                arr[k] = arr_new[i - l];
                i++;
            } else {
                arr[k] = arr_new[j - l];
                num = num + (mid - i + 1);
                j++;
            }
        }
    }
}
