package Sort;

import java.util.*;

/**
 * Created by wsdevotion on 2017/2/8.
 */
public class Selection {

    public static void main(String [] args) {

        Integer arr [] = new Integer[]{3,2,4,1,6,4,7,4,6,5};
        Double a[] = new Double[]{10.2,9.1,7.3,7.1,6.2,3.1,4.2,5.1,2.1,1.2};
        Student s[] = new Student[]{new Student("a",11), new Student("b",13), new Student("c",12)};
        arr = selectionSort(arr, 10);
        for (int i=0; i<arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //选择排序
    public static Integer[] selectionSort(Integer arr[], int n) {

        for (int i=0; i<n; i++) {
            //寻找[i, n]区间的最小值
            int minIndex = i;
            for (int j=i+1; j<n; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            arr = swap(arr, i, minIndex);
        }
        return arr;

    }




    public static Integer[] swap(Integer[] arr, int i, int minIndex) {
        int f = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = f;
        return arr;
    }

    public static double[] swap(double[] arr, int i, int minIndex) {
        double f = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = f;
        return arr;
    }

    public static <T> T[] fun1(T...arg){  // 接收可变参数
        return arg ;            // 返回泛型数组
    }
    public static <T> void fun2(T param[]){   // 输出
        System.out.print("接收泛型数组：") ;
        for(T t:param){
            System.out.print(t + "、") ;
        }
    }

}
