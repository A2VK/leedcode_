package cn.a2vk.solutions.tree;

/**
 * Created by hoducust on 2018/9/3 22H 36m .
 * 最大索引堆
 * 优点：利用索引优化数据间移动的时间及空间成本
 */
public class IndexMaxHeap<Item extends Comparable> {

    private Item[] data;
    private int[] indexes;
    private int count;
    private int capacity;

    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
        indexes = new int[capacity + 1];
        this.capacity = capacity;
        this.count = 0;
    }

    public IndexMaxHeap(Item[] arrs) {
        int length = arrs.length;
        this.capacity = length;
        this.count = length;
        this.data = (Item[]) new Comparable[length + 1];

        while (length-- > 0) {
            data[length + 1] = arrs[length];
        }
        for (int i = count / 2; i >= 1; i++) {
            shiftDown(i);
        }
    }

    // 往堆中添加元素
    public void insert(int index, Item item) {

        if (count + 1 <= capacity && index + 1 >= 1 && index + 1 <= capacity) {
            index += 1;
            data[index] = item;
            indexes[count + 1] = index;
            count++;
            shiftUp(count);
        } else {
            throw new ArrayIndexOutOfBoundsException("heap capacity out of bound");
        }
    }

    /**
     * 取出堆中最大元素，后向下滑动数据操作(满足最大堆性质)
     */
    public Item extractMax() {
        Item result = null;
        if (count > 0) {
            result = data[indexes[1]];
            swapIndexes(indexes, 1, count--);
            shiftDown(1);
        } else {
            throw new IndexOutOfBoundsException("heap count is enpty");
        }
        return result;
    }

    public int extractMaxIndexes() {
        int result = -1;
        if (count > 0) {
            result = indexes[1] - 1;
            swapIndexes(indexes, 1, count--);
            shiftDown(1);
        }
        return result;
    }

    public Item getMax() {
        Item result = null;
        if (count > 0) {
            result = data[indexes[1]];
        }
        return result;
    }

    public void change(int index, Item newItem) {
        index += 1;
        data[index] = newItem;

        for (int i = 1; i <= count; i++) {
            if (indexes[i] == index) {
                shiftUp(i);
                shiftDown(i);
                return;
            }
        }
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    private void shiftUp(int k) {
        while (k > 0 && data[indexes[k / 2]].compareTo(data[indexes[k]]) < 0) {
            swapIndexes(indexes, k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (k * 2 <= count) {
            int ks = k * 2;
            if (ks + 1 <= count && data[indexes[ks + 1]].compareTo(data[indexes[ks]]) > 0) {
                ks++;
            }
            if (data[indexes[k]].compareTo(data[indexes[ks]]) > 0) {
                break;
            }
            swapIndexes(indexes, k, ks);
            k = ks;
        }
    }

    private void swapIndexes(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
