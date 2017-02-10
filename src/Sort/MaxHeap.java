package Sort;

/**
 * 普通队列：先进先出，后进先出
 * 优先队列：出队顺序和入队顺序无关，和优先级有关
 * 二叉堆，二叉堆是一颗完全二叉树
 */

import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/9.
 * 堆排序
 */
public class MaxHeap {

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(50);
        System.out.println(maxHeap.size());
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            maxHeap.insert(random.nextInt(100));
        }
//        maxHeap.printHeapTree();
//
//        maxHeap.extractMax();
//        maxHeap.printHeapTree();
        for (int i=0; i<32; i++) {
            System.out.print(maxHeap.extractMax() + " ");
        }

    }

    private Integer[] data;
    //堆元素的数量
    private int count = 0;
    private int capacity;


    //构造函数
    public MaxHeap(int capacity) {
        this.data = new Integer[capacity + 1];
        this.capacity = capacity;
    }

    public MaxHeap(Integer arr [], int n) {
        data = new Integer[n+1];
        capacity = n;
        for (int i=0; i<n; i++) {
            data[i+1] = arr[i];
        }
        count = n;
        //heapify过程
        for (int i=count/2; i>=1; i--) {
            shiftDown(i);
        }
    }

    //对中元素个数
    public int size() {
        return count;
    }

    //堆是否是空的
    public boolean isEmpty() {
        return count == 0;
    }

    //添加元素
    public void insert(Integer item) {
        //保证数组不会越界
        assert count + 1 <= capacity;
        data[count + 1] = item;
        count++;
        shiftUp(count);
    }

    //取出堆的最大值
    public Integer extractMax() {
        assert count > 0;

        Integer ret = data[1];
        //可以将交换优化
        Main.swap(data, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            //判断有没有右孩子
            int j = 2 * k;
            if (j + 1 <= count && data[j + 1] > data[j])
                j += 1;
            if (data[k] >= data[j])
                break;

            Main.swap(data, k, j);
            k = j;
        }
    }

    //构造堆
    private void shiftUp(Integer k) {
        while (k > 1 && data[k / 2] < data[k]) {
            Main.swap(data, k / 2, k);
            k /= 2;
        }
    }

    //打印堆
    public void printHeap() {
        Utils.printArray(data, count, "堆:");
    }

    //打印树形堆
    public void printHeapTree() {
        System.out.println("This Heap's size is " + count);
        if (count > 100) {
            System.out.println("The Heap's size more than 100, please try to use printHeap");
            return;
        }
        int n = count;
        int level = 0;
        int max_level = 0;
        int i = 0;
        int number_per_level = 1;
        while (n > 0) {
            max_level += 1;
            n -= number_per_level;
            number_per_level *= 2;
        }
        n = count;
        number_per_level = 1;
        while (n > 0) {
            level += 1;
            n -= number_per_level;
            for (int j = 1; j < number_per_level + 1 && j + i <= count; j++) {
                System.out.print(makeStringBlock(2 * (max_level - level + 1)) + data[j + i] + makeStringBlock(2 * (max_level - level + 1)));
            }
            i += number_per_level;
            number_per_level *= 2;
            System.out.println();

        }


    }


    private String makeStringBlock(int i) {
        String str = "";
        for (int j = 0; j < i; j++) {
            str += " ";
        }
        return str;
    }

    private String makeStringBlock(int i, int l, int r) {
        String str = "";
        for (int j = l; j < r; j++) {
            str += " ";
        }
        return str;
    }


}
