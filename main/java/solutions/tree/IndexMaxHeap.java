package solutions.tree;

/**
 * Created by hoducust on 2018/9/3 22H 36m .
 */
public class IndexMaxHeap<Item extends Comparable> {

    Item[] data;
    int count;
    int capacity;

    public IndexMaxHeap(int capacity) {
        data = (Item[]) new Comparable[capacity + 1];
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
    public void insert(Item item) {
        if (count + 1 <= capacity) {
            data[count + 1] = item;
            count++;
            shiftUp(count);
        } else {
            throw new ArrayIndexOutOfBoundsException("heap capacity out of bound");
        }
    }

    public Item extractMax() {
        Item result = null;
        if (count > 0) {
            result = data[1];
            swap(data, 1, count--);
            shiftDown(count);
        } else {
            throw new IndexOutOfBoundsException("heap count is enpty");
        }
        return result;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public int size() {
        return count;
    }

    private void shiftUp(int k) {
        while (count != 0 && data[k / 2].compareTo(data[k]) < 0) {
            swap(data, k / 2, k);
            k = k / 2;
        }
    }

    private void shiftDown(int k) {
        while (k * 2 < count) {
            int ks = k * 2;
            if (ks + 1 <= count && data[ks + 1].compareTo(data[ks]) > 0) {
                ks++;
            }
            if (data[k].compareTo(data[ks]) > 0) {
                break;
            }
            swap(data, k, ks);
            k = ks;
        }
    }

    private void swap(Item[] arr, int i, int j) {
        Item temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
