package Sort;

import java.util.Random;

/**
 * Created by wsdevotion on 2017/2/10.
 * 索引堆
 * 交换数组中的元素，如果元素很大效率有很大的问题
 * 0    1   2   3   4   5   6   7   8   9   10
 * index   1   2   3   4   5   6   7   8   9   10   -构建堆
 * data   15  17  19  13  12  11   9  10   14  15
 */
public class IndexHeap {

    public static void main(String[] args) {
        IndexHeap indexHeap = new IndexHeap(50);
        System.out.println(indexHeap.size());
        Random random = new Random();
        for (int i = 0; i < 32; i++) {
            indexHeap.insert(i, random.nextInt(100));
        }


//        maxHeap.printHeapTree();
//
//        maxHeap.extractMax();
//        maxHeap.printHeapTree();
//        for (int i=0; i<32; i++) {
//            System.out.print(indexHeap.extractMax() + " ");
//        }

        indexHeap.printHeap();

        indexHeap.change(2, 100);

        indexHeap.printHeap();

//        for (int i=0; i<32; i++) {
//            System.out.print(indexHeap.extractMax() + " ");
//        }

    }

    private Integer[] data;
    private Integer[] indexes;
    private Integer[] reverse;
    //堆元素的数量
    private int count = 0;
    private int capacity;


    //构造函数
    public IndexHeap(int capacity) {
        this.data = new Integer[capacity + 1];
        this.capacity = capacity;
        this.indexes = new Integer[capacity + 1];
        this.reverse = new Integer[capacity + 1];
        for (int i = 0; i <= capacity; i++) {
            reverse[i] = 0;
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

    //添加元素,i 元素索引,0开始
    public void insert(int i, Integer item) {
        //保证数组不会越界
        assert count + 1 <= capacity;
        assert i + 1 >= 1 && i + 1 <= capacity;

        i += 1;
        data[i] = item;
        indexes[count + 1] = i;
        reverse[i] = count + 1;
        count++;
        shiftUp(count);
    }

    //取出堆的最大值
    public Integer extractMax() {
        assert count > 0;

        Integer ret = data[indexes[1]];
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        //可以将交换优化
        Main.swap(indexes, 1, count);
        count--;
        shiftDown(1);
        return ret;
    }

    //取出堆的最大值索引
    public Integer extractMaxIndex() {
        assert count > 0;

        Integer ret = indexes[1] - 1;
        //可以将交换优化
        Main.swap(indexes, 1, count);
        reverse[indexes[1]] = 1;
        reverse[indexes[count]] = 0;
        count--;
        shiftDown(1);
        return ret;
    }

    public Integer getData(int i) {
        assert contain(i);
        return data[i + 1];
    }

    public void change(int i, Integer item) {

        assert contain(i);
        i += 1;
        data[i] = item;

        //找到indexes[j] = i, j表示data[i]在堆中的位置
//        for (int j = 1; j <= count; j++)
//            if (indexes[j] == i) {
//                shiftUp(j);
//                shiftDown(j);
//                return;
//            }

        int j = reverse[i];
        shiftUp(j);
        shiftDown(j);
    }

    //确保是堆中的元素
    private boolean contain(int i) {
        return reverse[i + 1] == 0;
    }

    private void shiftDown(int k) {

        while (2 * k <= count) {
            //判断有没有右孩子
            int j = 2 * k;
            if (j + 1 <= count && data[indexes[j + 1]] > data[indexes[j]])
                j += 1;
            if (data[indexes[k]] >= data[indexes[j]])
                break;

            Main.swap(indexes, k, j);
            reverse[indexes[k]] = k;
            reverse[indexes[j]] = j;
            k = j;
        }
    }

    //构造堆
    private void shiftUp(Integer k) {
        while (k > 1 && data[indexes[k / 2]] < data[indexes[k]]) {
            Main.swap(indexes, k / 2, k);
            reverse[indexes[k / 2]] = k / 2;
            reverse[indexes[k]] = k;
            k /= 2;
        }
    }

    //打印堆
    public void printHeap() {
        System.out.print("堆:");
        for (int i = 0; i < count; i++) {
            System.out.print(data[indexes[i + 1]] + " ");
        }
        System.out.println();
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
